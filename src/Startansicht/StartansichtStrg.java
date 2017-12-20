package Startansicht;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import Anmelden.AnmeldenStrg;
import ModusAuswählen.ModusauswaehlenStrg;
import Nutzer.Nutzerverwaltung;
import ProfilBearbeiten.ProfilBearbeitenStrg;
import ProfilKunde.AnzeigenProfilKundeStrg;
import Strecke.AnzeigenStreckenStrg;

//Autor Daniel Zeller

public class StartansichtStrg implements ActionListener {
	
	Startansicht view1;

	public StartansichtStrg() {
		view1 = new Startansicht();
		view1.getFrmPixelRacer().setVisible(true);
		
		view1.getBtnAbmelden().addActionListener(this);
		view1.getBtnGarage().addActionListener(this);
		view1.getBtnProfil().addActionListener(this);
		view1.getBtnSpielen().addActionListener(this);
		view1.getBtnStreckenbersicht().addActionListener(this);
		
		view1.getLblAnzeige().setText(Nutzerverwaltung.getangKunde().getnutzername() + "  -  " + Nutzerverwaltung.getangKunde().getpunkte());
	}
	
	public static void main(String[] args0){
		StartansichtStrg strg = new StartansichtStrg();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== view1.getBtnAbmelden()) {
			AnmeldenStrg strg = new AnmeldenStrg();
			view1.getFrmPixelRacer().dispose();
		}
		
		if(e.getSource()== view1.getBtnGarage()) {
			
		}
		
		if(e.getSource()== view1.getBtnProfil()) {
			AnzeigenProfilKundeStrg strg = new AnzeigenProfilKundeStrg();
			view1.getFrmPixelRacer().dispose();
		}
		
		if(e.getSource()== view1.getBtnSpielen()) {
			ModusauswaehlenStrg strg = new ModusauswaehlenStrg();
			view1.getFrmPixelRacer().dispose();
		}
		
		if(e.getSource()== view1.getBtnStreckenbersicht()) {
			AnzeigenStreckenStrg strg = new AnzeigenStreckenStrg();
			view1.getFrmPixelRacer().dispose();
		}
	}
	
}