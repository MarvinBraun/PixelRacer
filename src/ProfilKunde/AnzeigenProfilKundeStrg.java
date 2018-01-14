/**
 * Stellt alle Klassen zum Anzeigen eines Profils zur Verfügung.
 */
package ProfilKunde;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import Fahrt.Fahrtverwaltung;
import Fahrt.SingleplayerFahrt;
import Nutzer.Nutzerverwaltung;
import Premium.kaufePremiumAccount;
import ProfilBearbeiten.ProfilBearbeitenStrg;
import Rechnung.RechnungAnzeigenStrg;
import Startansicht.StartansichtStrg;

/**
 * Die Klasse AnzeigenProfilKundeStrg steuert den Aufruf des Spielerprofil und 
 * verwaltet die grafische Benutzeroberflaeche ProfilKundeAnsicht.
 * 
 * @author Robin Demmler
 *
 */

public class AnzeigenProfilKundeStrg implements ActionListener {
	/**
	 * Deklarieren benoetigter Variablen und Objekte.
	 */	
	SingleplayerFahrt sf;
	
	ProfilKundeAnsicht viewKunde;
	
	int counterRang1 =0;
	int counterRang2 =0;
	int counterRang3 =0;
	/**
	 * 
	 * Konstruktor, der die viewKunde aufruft und die entsprechenden Komponenten mit Daten versorgt.
	 * 
	 */	
	public AnzeigenProfilKundeStrg() {
		
		try {			
		viewKunde = new ProfilKundeAnsicht();
		viewKunde.getFrmPixelRacer().setLocationRelativeTo(null);
		
		// Hinzufuegen der Action Listener
		viewKunde.getBtnGetPremium().addActionListener(this);
		viewKunde.getBtnProfilBearbeiten().addActionListener(this);
		viewKunde.getBtnRechnungsverw().addActionListener(this);
		viewKunde.getBtnZurueck().addActionListener(this);		
			
		Fahrtverwaltung v1 = new Fahrtverwaltung();
				
		LinkedList<SingleplayerFahrt> fahrten1 = v1.gibSingleplayerFahrtenFuerBenutzer(Nutzerverwaltung.getangKunde().getnutzername());
		
		//Vorname des aktuell angemeldeten Nutzer setzen
		viewKunde.getLblSetVorname().setText(Nutzerverwaltung.getangKunde().getvn());
		
		//Nachname des aktuell angemeldeten Nutzer setzen
		viewKunde.getLblSetNachname().setText(Nutzerverwaltung.getangKunde().getnn());
		
		//Account-Status des aktuell angemeldeten Nutzer setzen
		if(Nutzerverwaltung.getangKunde().getpremium().equals("true")) {
			viewKunde.getLblSetStatus().setText("Premiumkunde");
		}
		else if(Nutzerverwaltung.getangKunde().getpremium().equals("false")) {
			viewKunde.getLblSetStatus().setText("Free to Play");
		}				
		//Punktestand des aktuell angemeldeten Nutzer setzen
		viewKunde.getLblSetPunktestand().setText(Integer.toString((Nutzerverwaltung.getangKunde().getpunkte())));
		
		//Gesamte SinglePlayer-Fahrten des aktuell angemeldeten Nutzer setzen
		viewKunde.getLblSetGesFahrten().setText(Integer.toString(fahrten1.size()));
				
		//Anzahl bereits erreichte Platzierungen des aktuell angemeldeten Nutzers berrechnen und setzen
		for(int i =0; i < fahrten1.size(); i++) {
			
			sf = fahrten1.get(i);
			
			if(sf.getRang()==1) {
			counterRang1 ++; 
			}
			if(sf.getRang()==2) {
				counterRang2 ++; 
			}
			if(sf.getRang()==3) {
				counterRang3 ++; 
			}
		}
		
		viewKunde.getLblSetAlsErster().setText(Integer.toString(counterRang1));
		viewKunde.getLblSetAlsZweiter().setText(Integer.toString(counterRang2));
		viewKunde.getLblSetAlsDritter().setText(Integer.toString(counterRang3));
			
		//Button Premium kaufen ausblenden wenn angemeldeter Nutzer bereits Premiumkunde
		if(Nutzerverwaltung.getangKunde().getpremium().equals("true")) {
			viewKunde.getBtnGetPremium().setVisible(false);
		}		
		}catch(Exception e) {
			JOptionPane.showConfirmDialog(null, "Fehler beim laden der Daten des angemeldeten Spielers, Bitte an den Support wenden!", "Fehler bei Datenverarbeitung!", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
		} // Exception Handling
	}
	/**
	 * Main-Methode.
	 */
	public static void main(String[] args) {
	 
		AnzeigenProfilKundeStrg ansichtKunde = new AnzeigenProfilKundeStrg();

	}
	/**
	 * ActionPerformed Event Buttons
	 */
	@Override
	public void actionPerformed(ActionEvent a) {
		if(a.getSource()==viewKunde.getBtnRechnungsverw()) { // Aufruf der Rechnungsverwaltung bei Klick von BtnRechnungsverw
			MusicHandler.MusicPlayer.forwardBtn();
			RechnungAnzeigenStrg rechnung = new RechnungAnzeigenStrg();
		}
		if(a.getSource()==viewKunde.getBtnProfilBearbeiten()) { // Aufruf der ProfilBearbeitenStrg bei Klick von BtnProfilBearbeiten & schliessen des Profils
			MusicHandler.MusicPlayer.forwardBtn();
			ProfilBearbeitenStrg strg = new ProfilBearbeitenStrg();
			viewKunde.getFrmPixelRacer().dispose();
		}
		if(a.getSource()==viewKunde.getBtnZurueck()) {  // Aufruf der Startansicht bei Klick von BtnZurueck & schliessen des Profils
			MusicHandler.MusicPlayer.backwardBtn();
			StartansichtStrg strg = new StartansichtStrg();
			viewKunde.getFrmPixelRacer().dispose();
		}
		if(a.getSource()==viewKunde.getBtnGetPremium()) { // Aufruf der kaufePremium-Account-Strg bei Klick von BtnGetPremium 
			MusicHandler.MusicPlayer.startGame();
			kaufePremiumAccount account = new kaufePremiumAccount(viewKunde);
		}
		
	}

	
	

	
	
	
}
