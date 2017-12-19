package ProfilKunde;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import Fahrt.Fahrtverwaltung;
import Fahrt.SingleplayerFahrt;
import Nutzer.Nutzerverwaltung;
import ProfilBearbeiten.ProfilBearbeitenStrg;
import Startansicht.StartansichtStrg;
import Strecke.Strecke;

public class AnzeigenProfilKundeStrg implements ActionListener {
	
	Strecke s;
	SingleplayerFahrt sf;
	
	ProfilKundeAnsicht viewKunde;
	String premium;
	
	int counterRang1 =0;
	int counterRang2 =0;
	int counterRang3 =0;
	
		
	
	public AnzeigenProfilKundeStrg() {
		
		viewKunde.btnGetPremium.addActionListener(this);
		viewKunde.btnProfilBearbeiten.addActionListener(this);
		viewKunde.btnZurueck.addActionListener(this);		
		
		ProfilKundeAnsicht viewKunde = new ProfilKundeAnsicht();	
		viewKunde.frmPixelRacer.setVisible(true);
		
		Fahrtverwaltung v1 = new Fahrtverwaltung();
				
		LinkedList<SingleplayerFahrt> fahrten1 = v1.gibSingleplayerFahrtenFürBenutzer(Nutzerverwaltung.getangKunde().getnutzername());
		
		//SetVorname
		viewKunde.getLblSetVorname().setText(Nutzerverwaltung.getangKunde().getnn());
		
		//SetNachname
		viewKunde.getLblSetNachname().setText(Nutzerverwaltung.getangKunde().getvn());
		
		//SetStatus
		if(Nutzerverwaltung.getangKunde().getpremium()=="true") {
			premium ="Premiumkunde";
		}
		else if(Nutzerverwaltung.getangKunde().getpremium()=="false") {
			premium = "Free To Play";
		}
					
		viewKunde.getLblSetStatus().setText(premium);
		
		System.out.println("Gesamt sf:" +fahrten1.size());
		
		//SetPunktestand
		viewKunde.getLblSetPunktestand().setText(Integer.toString((Nutzerverwaltung.getangKunde().getpunkte())));
		
		//SetGesFahrten
		viewKunde.getLblSetGesFahrten().setText(Integer.toString(fahrten1.size()));
				
		// Anzahl erreichte Ränge
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
		if(a.getSource()==viewKunde.btnProfilBearbeiten) {
			ProfilBearbeitenStrg strg = new ProfilBearbeitenStrg();
		}
		if(a.getSource()==viewKunde.btnZurueck) {
			viewKunde.frmPixelRacer.dispose();
			StartansichtStrg strg = new StartansichtStrg();
		}
		
	}

	
	

	
	
	
}
