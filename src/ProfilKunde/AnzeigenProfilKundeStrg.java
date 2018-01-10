package ProfilKunde;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import Fahrt.Fahrtverwaltung;
import Fahrt.SingleplayerFahrt;
import Nutzer.Nutzerverwaltung;
import Premium.kaufePremiumAccount;
import ProfilBearbeiten.ProfilBearbeitenStrg;
import Rechnung.anzeigenRechnungStrg;
import Startansicht.StartansichtStrg;


public class AnzeigenProfilKundeStrg implements ActionListener {
	
	
	SingleplayerFahrt sf;
	
	ProfilKundeAnsicht viewKunde;
	
	int counterRang1 =0;
	int counterRang2 =0;
	int counterRang3 =0;
	
		
	
	public AnzeigenProfilKundeStrg() {
		
		viewKunde = new ProfilKundeAnsicht();
		viewKunde.getFrmPixelRacer().setLocationRelativeTo(null);
		
		viewKunde.btnGetPremium.addActionListener(this);
		viewKunde.btnProfilBearbeiten.addActionListener(this);
		viewKunde.btnRechnungsverw.addActionListener(this);
		viewKunde.btnZurueck.addActionListener(this);		
				
		viewKunde.frmPixelRacer.setVisible(true);
		
		Fahrtverwaltung v1 = new Fahrtverwaltung();
				
		LinkedList<SingleplayerFahrt> fahrten1 = v1.gibSingleplayerFahrtenF�rBenutzer(Nutzerverwaltung.getangKunde().getnutzername());
		
		//SetVorname
		viewKunde.getLblSetVorname().setText(Nutzerverwaltung.getangKunde().getnn());
		
		//SetNachname
		viewKunde.getLblSetNachname().setText(Nutzerverwaltung.getangKunde().getvn());
		
		//SetStatus
		if(Nutzerverwaltung.getangKunde().getpremium().equals("true")) {
			viewKunde.getLblSetStatus().setText("Premiumkunde");
		}
		else if(Nutzerverwaltung.getangKunde().getpremium().equals("false")) {
			viewKunde.getLblSetStatus().setText("Free to Play");
		}
				
		//SetPunktestand
		viewKunde.getLblSetPunktestand().setText(Integer.toString((Nutzerverwaltung.getangKunde().getpunkte())));
		
		//SetGesFahrten
		viewKunde.getLblSetGesFahrten().setText(Integer.toString(fahrten1.size()));
				
		// Anzahl erreichte RÃ¤nge
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
			
	}
		
	public static void main(String[] args) {
	 
		AnzeigenProfilKundeStrg ansichtKunde = new AnzeigenProfilKundeStrg();

	}

	@Override
	public void actionPerformed(ActionEvent a) {
		if(a.getSource()==viewKunde.getBtnRechnungsverw()) {
			anzeigenRechnungStrg rechnung = new anzeigenRechnungStrg();
		}
		if(a.getSource()==viewKunde.getBtnProfilBearbeiten()) {
			ProfilBearbeitenStrg strg = new ProfilBearbeitenStrg();
			viewKunde.getFrmPixelRacer().dispose();
		}
		if(a.getSource()==viewKunde.getBtnZurueck()) {
			StartansichtStrg strg = new StartansichtStrg();
			viewKunde.getFrmPixelRacer().dispose();
		}
		if(a.getSource()==viewKunde.getBtnGetPremium()) {
			kaufePremiumAccount account = new kaufePremiumAccount(viewKunde);
		}
		
	}

	
	

	
	
	
}
