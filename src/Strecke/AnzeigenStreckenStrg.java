/**
 * Stellt alle Klassen zum Verwalten von Strecken zur Verf�gung.
 */
package Strecke;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import Datenbankverwaltung.Datenbankschnittstelle;
import Fahrt.Fahrtverwaltung;
import Fahrt.SingleplayerFahrt;
import Nutzer.Nutzerverwaltung;
import Premium.kaufePremiumStrecke;
import Rechnung.Rechnung;
import Rechnung.Rechnungsverwaltung;
import Startansicht.StartansichtStrg;
import Iterator.IteratorStrecke;
import Iterator.IteratorString;
/**
 * Die Klasse AnzeigenStreckenStrg steuert den Aufruf der Streckendaten und 
 * verwaltet die grafischen Benutzeroberflaechen Streckenuebersicht und StreckeDetailView.
 * 
 * @author Robin Demmler
 *
 */
public class AnzeigenStreckenStrg implements ActionListener{
	/**
	 * Deklarieren benoetigter Variablen & Objekte.
	 */	
	StreckeDetailView viewDetail;
	Streckenuebersicht viewUebersicht;
	
	SingleplayerFahrt sf;
	Rechnung r;
	Strecke s;
	ResultSet rs;
	BufferedImage streckenbild;
	
	Rechnungsverwaltung verwRechnung;
	Streckenverwaltung verwStrecke;
	Fahrtverwaltung verwFahrt;
	
	//LinkedLists fÃƒÂ¼r benÃƒÂ¶tigte Daten instanziieren (Fahrtdaten, Streckendaten & Rechnungsdaten)
	LinkedList<SingleplayerFahrt> singleplayerFahrten = new LinkedList<SingleplayerFahrt>();
	LinkedList<Strecke> streckenListe = new LinkedList<Strecke>();
	LinkedList<Rechnung> rechnungsListe = new LinkedList<Rechnung>();
			
	int counterRang1 =0;
	int counterRang2 =0;
	int counterRang3 =0;
		
	static IteratorStrecke<Strecke> itStrecke;
	static IteratorString<String> itString;
	
	boolean forward = false;
	boolean backward = false;
	/**
	 * 
	 * Konstruktor, der die viewUebersicht aufruft.
	 * 
	 */	
	public AnzeigenStreckenStrg(){
		
		viewUebersicht = new Streckenuebersicht();
		viewUebersicht.getFrmPixelRacer().setLocationRelativeTo(null);
				
		verwFahrt = new Fahrtverwaltung();
		singleplayerFahrten = verwFahrt.gibSingleplayerFahrten();
		
		verwStrecke = new Streckenverwaltung();
		streckenListe = verwStrecke.gibStrecke();
		itStrecke = new IteratorStrecke(streckenListe.listIterator());
		
		verwRechnung = new Rechnungsverwaltung();
		rechnungsListe = verwRechnung.gibStreckenRechnungenfuerBenutzer();
		
		// Hinzufuegen der Action Listener
		viewUebersicht.getStreckeBackward().addActionListener(this);
		viewUebersicht.getStreckeForward().addActionListener(this);
		viewUebersicht.getBtnDetailView().addActionListener(this);
		viewUebersicht.getBtnZurueck().addActionListener(this);
		viewUebersicht.getBtnStreckeKaufen().addActionListener(this);
		
		streckeVorwaerts();
		
		SwingUtilities.updateComponentTreeUI(viewUebersicht.getFrmPixelRacer());
	}
	/**
	 * Main-Methode.
	 */	
	public static void main(String[] args) {
		
		AnzeigenStreckenStrg steuerung = new AnzeigenStreckenStrg();
		
	}
	/**
	 * streckeVorwaerts() prÃƒÂ¼ft ob eine weitere Strecke existiert und aktualisiert dementsprechend die Felder der GUI
	 */	
	public void streckeVorwaerts()
	{
		try {
		if((s=itStrecke.next())!=null)
		{	
									
			BufferedImage newImage= s.getGrafik();
			viewUebersicht.getStreckeName().setText(s.getStreckenname());
			streckenbild = imageResizer(newImage);
			ImageIcon icon = new ImageIcon(streckenbild);
			viewUebersicht.getStreckeLbl().setIcon(icon);
						
			counterRang1 = 0;
			counterRang2 = 0;
			counterRang3 = 0;
			//StreckeDetailView initiieren			
			viewDetail= new StreckeDetailView();
			viewDetail.getFrame().setLocationRelativeTo(null);
			//ActionListener hinzufuegen
			viewDetail.getBtnZurueck().addActionListener(this);
									
			//Streckenlaenge anzeigen lassen
			viewDetail.getLblSetLaenge().setText(Integer.toString(s.getLaenge())+ "m");
			
			// Fahrtenliste zu angemeldetem Nutzer und akuteller Strecke erstellen
			Fahrtverwaltung v = new Fahrtverwaltung();
			LinkedList<SingleplayerFahrt> fahrten = v.gibSingleplayerFahrtenFuerBenutzerUndStrecke(Nutzerverwaltung.getangKunde().getnutzername(),s.getStreckenname());
			viewDetail.getLblSetGesRennen().setText(Integer.toString(fahrten.size()));
					
			// Gesamt gefahrene Strecke fÃƒÂ¼r Singleplayerfahrten anzeigen
			viewDetail.getLblSetGesKm().setText(Integer.toString(fahrten.size()*s.getLaenge())+"m");
					
			// Anzahl der erreichten Platzierungen berrechen und anzeigen
			for(int i =0; i < fahrten.size(); i++) {
				
				sf = fahrten.get(i);
				
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
			viewDetail.getLblSetAnzErster().setText(Integer.toString(counterRang1));
			viewDetail.getLblSetAnzZweiter().setText(Integer.toString(counterRang2));
			viewDetail.getLblSetAnzDritter().setText(Integer.toString(counterRang3));														
		}
		
		//Punktestandpruefung und Label Aktivierung
		if(s.getPunktewert() <= Nutzerverwaltung.getangKunde().getpunkte()) { // Pruefung ist Punktestand Spieler groesser gleich Punktelimit Strecke
			viewUebersicht.getLblStreckePunkteLimit().setVisible(false);
			viewUebersicht.getLblStreckePunkte().setText("Strecke in deinem Besitz!");
			viewUebersicht.getLblStreckePunkte().setVisible(true);
		}
		else if(s.getPunktewert() > Nutzerverwaltung.getangKunde().getpunkte()){ // Pruefung ist Punktestand Spieler kleiner Punktelimit Strecke
			viewUebersicht.getLblStreckePunkte().setVisible(false);
			viewUebersicht.getLblStreckePunkteLimit().setText("Erreiche " + s.getPunktewert() + " Punkte um diese Strecke freizuschalten!");
			viewUebersicht.getLblStreckePunkteLimit().setVisible(true);
		}
		
		//Pruefung Strecke bereits vom Nutzer gekauft? Falls nicht Kauf-Button einblenden
		Rechnungsverwaltung r = new Rechnungsverwaltung();
		LinkedList<Rechnung> rechnungen = r.gibStreckenRechnungenfuerBenutzer();
		
		viewUebersicht.getBtnStreckeKaufen().setVisible(false);
		
		if(s.getPremium().equals("true")){
			viewUebersicht.getLblStreckePunkteLimit().setVisible(false);
			viewUebersicht.getLblStreckePunkte().setVisible(false);
			viewUebersicht.getBtnStreckeKaufen().setVisible(true);
			
		
			Rechnung rechnung = null;
			Iterator<Rechnung> it = rechnungen.iterator();
			while(it.hasNext())
			{
				rechnung = it.next();
				if(s.getStreckenname().equals(rechnung.getStreckenname())) // Streckenname in Rechnungen enthalten? (Wurde bereits erworben?)
						{
					
						viewUebersicht.getBtnStreckeKaufen().setVisible(false);
						viewUebersicht.getLblStreckePunkteLimit().setVisible(false);
						viewUebersicht.getLblStreckePunkte().setVisible(true);
						viewUebersicht.getLblStreckePunkte().setText("Strecke in deinem Besitz!");
						
						}
			}
	}
		
		Datenbankschnittstelle.closeConnections();
					
	}catch(Exception e){
		JOptionPane.showConfirmDialog(null, "Du hast noch keine weiteren Strecken freigeschaltet!", "Keine weiteren Strecken!", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
	} // Exception Handling: Keine weiteren Karts anzuzeigen			
}	
	
	/**
	 * streckeZurueck() prÃƒÂ¼ft ob eine vorherige Strecke existiert und aktualisiert dementsprechend die Felder der GUI
	 */	
	public void streckeZurueck()
	{	try {
		if((s=itStrecke.previous())!=null)
		{			
			BufferedImage newImage= s.getGrafik();
			viewUebersicht.getStreckeName().setText(s.getStreckenname());
			streckenbild = imageResizer(newImage);
			ImageIcon icon = new ImageIcon(streckenbild);
			viewUebersicht.getStreckeLbl().setIcon(icon);
			
			counterRang1 = 0;
			counterRang2 = 0;
			counterRang3 = 0;
			//StreckeDetailView initiieren			
			viewDetail= new StreckeDetailView();
			viewDetail.getFrame().setLocationRelativeTo(null);
			//ActionListener hinzufuegen
			viewDetail.getBtnZurueck().addActionListener(this);
						
			//Streckenlaenge anzeigen lassen
			viewDetail.getLblSetLaenge().setText(Integer.toString(s.getLaenge())+ "m");
			
			// Fahrtenliste zu angemeldetem Nutzer und akuteller Strecke erstellen
			Fahrtverwaltung v = new Fahrtverwaltung();
			LinkedList<SingleplayerFahrt> fahrten = v.gibSingleplayerFahrtenFuerBenutzerUndStrecke("DZeller",s.getStreckenname());
			viewDetail.getLblSetGesRennen().setText(Integer.toString(fahrten.size()));
					
			// Gesamt gefahrene Strecke fÃƒÂ¼r Singleplayerfahrten anzeigen
			viewDetail.getLblSetGesKm().setText(Integer.toString(fahrten.size()*s.getLaenge())+"m");
					
			// Anzahl der erreichten Platzierungen berrechen und anzeigen
			for(int i =0; i < fahrten.size(); i++) {
				
				sf = fahrten.get(i);
				
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
			viewDetail.getLblSetAnzErster().setText(Integer.toString(counterRang1));
			viewDetail.getLblSetAnzZweiter().setText(Integer.toString(counterRang2));
			viewDetail.getLblSetAnzDritter().setText(Integer.toString(counterRang3));	
				
		}
		
		//Punktestandpruefung und Label Aktivierung
				if(s.getPunktewert() <= Nutzerverwaltung.getangKunde().getpunkte() && s.getPremium().equals("false")) { // // Pruefung ist Punktestand Spieler groesser gleich Punktelimit Strecke
					viewUebersicht.getLblStreckePunkteLimit().setVisible(false);
					viewUebersicht.getLblStreckePunkte().setText("Strecke in deinem Besitz!");
					viewUebersicht.getLblStreckePunkte().setVisible(true);
				}
				else if(s.getPunktewert() > Nutzerverwaltung.getangKunde().getpunkte()){ // Pruefung ist Punktestand Spieler kleiner Punktelimit Strecke
					viewUebersicht.getLblStreckePunkte().setVisible(false);
					viewUebersicht.getLblStreckePunkteLimit().setText("Erreiche " + s.getPunktewert() + " Punkte um diese Strecke freizuschalten!");
					viewUebersicht.getLblStreckePunkteLimit().setVisible(true);
				}
		
				
				//Pruefung Strecke bereits vom Nutzer gekauft? Falls nicht Kauf-Button einblenden
				Rechnungsverwaltung r = new Rechnungsverwaltung();
				LinkedList<Rechnung> rechnungen = r.gibStreckenRechnungenfuerBenutzer();
				
				viewUebersicht.getBtnStreckeKaufen().setVisible(false);
				
				if(s.getPremium().equals("true")){
					viewUebersicht.getLblStreckePunkteLimit().setVisible(false);
					viewUebersicht.getLblStreckePunkte().setVisible(false);
					viewUebersicht.getBtnStreckeKaufen().setVisible(true);
					
				
					Rechnung rechnung = null;
					Iterator<Rechnung> it = rechnungen.iterator();
					while(it.hasNext())
					{
						rechnung = it.next();
						if(s.getStreckenname().equals(rechnung.getStreckenname()))
								{
							
								viewUebersicht.getBtnStreckeKaufen().setVisible(false);
								viewUebersicht.getLblStreckePunkteLimit().setVisible(false);
								viewUebersicht.getLblStreckePunkte().setVisible(true);
								viewUebersicht.getLblStreckePunkte().setText("Strecke in deinem Besitz!");
								
								}
					}
									
				}
				
				Datenbankschnittstelle.closeConnections();
	
	}catch(Exception e){
		JOptionPane.showConfirmDialog(null, "Du hast noch keine weiteren Strecken freigeschaltet!", "Keine weiteren Strecken!", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
	} // Exception Handling: Keine weiteren Karts anzuzeigen
}	
	/** 
	 * imageResizer verkleinert ein Objekt des Typs BufferedImage von 800x600 auf 300x200. Die Grafiken werden dabei ÃƒÂ¼ber die Klasse Graphics neu gezeichnet.
	 * @return BufferedImage in der GrÃƒÂ¶ÃƒÅ¸e 300x200.
	 */	
	public static BufferedImage imageResizer(BufferedImage original)
	{
		
		BufferedImage newImage = new BufferedImage(300, 200, BufferedImage.TYPE_INT_RGB);

				Graphics g = newImage.createGraphics();
				g.drawImage(original, 0, 0, 300, 200, null);
				g.dispose();
				return newImage;
	}
	/**
	 * ActionPerformed Event Buttons
	 */
	@Override
	public void actionPerformed(ActionEvent e) { // Aufruf kaufePremiumStrecke-Strg bei Klick von BtnStreckeKaufen
		if(e.getSource()==viewUebersicht.getBtnStreckeKaufen()) {
			kaufePremiumStrecke strg = new kaufePremiumStrecke(s, viewUebersicht);
		}
		if(e.getSource()==viewUebersicht.getBtnZurueck()) { // Aufruf der Startansicht bei Klick von BtnZurueck & schliessen der Views
			MusicHandler.MusicPlayer.backwardBtn();
			viewUebersicht.getFrmPixelRacer().dispose();
			viewDetail.getFrame().dispose();
			StartansichtStrg strg = new StartansichtStrg();
		}
		
		if(e.getSource()==viewDetail.getBtnZurueck()) { // Schliessen der DetailView bei Klick von BtnZurueck
			MusicHandler.MusicPlayer.backwardBtn();
			viewDetail.getFrame().dispose();			
		}
		
		if(e.getSource()==viewUebersicht.getStreckeBackward()) // Schliessen der DetailView & Aufruf streckeZurueck() bei Klick von StreckeBackward 
		{
			MusicHandler.MusicPlayer.backwardBtn();
			viewDetail.getFrame().dispose();
			streckeZurueck();			
		}
		
		if(e.getSource()==viewUebersicht.getStreckeForward()) // Schliessen der DetailView & Aufruf sstreckeVorwaerts() bei Klick von StreckeForward 
		{
			MusicHandler.MusicPlayer.forwardBtn();
			viewDetail.getFrame().dispose();
			streckeVorwaerts();							
		}
		
		if(e.getSource()==viewUebersicht.getBtnDetailView()) // Aufruf der DetailView bei Klick von BtnDetailView
		{		
			MusicHandler.MusicPlayer.startGame();
			viewDetail.getFrame().setVisible(true);		
		}
	}
}


	
