package Startansicht;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import Anmelden.AnmeldenStrg;
import Kart.AnzeigenKartStrg;
import ModusAuswählen.ModusauswaehlenStrg;
import Nutzer.Nutzerverwaltung;
import ProfilBearbeiten.ProfilBearbeitenStrg;
import ProfilKunde.AnzeigenProfilKundeStrg;
import Rechnung.RechnungAnzeigenStrg;
import Strecke.AnzeigenStreckenStrg;

/**
 * Die Klasse StartansichtStrg steuert die Startansicht. Sie verwaltet dabei die grafische Benutzeroberfläche (Startansicht).
 * @author Daniel Zeller
 *
 */

public class StartansichtStrg implements ActionListener {
	
	Startansicht view1; //Deklarierung der StartansichtView
	/**
	 * Erzeugt ein neues Objekt der Klasse StartansichtStrg und deklariert die entsprechenden Variablen.
	 */
	public StartansichtStrg() { //Konstruktor
		view1 = new Startansicht();
		view1.getFrmPixelRacer().setVisible(true);
		
		view1.getBtnAbmelden().addActionListener(this); //Setzen der ActionListener zu der View
		view1.getBtnGarage().addActionListener(this);
		view1.getBtnProfil().addActionListener(this);
		view1.getBtnSpielen().addActionListener(this);
		view1.getBtnStreckenbersicht().addActionListener(this);
		
		view1.getLblAnzeige().setText(Nutzerverwaltung.getangKunde().getnutzername() + "  -  " + Nutzerverwaltung.getangKunde().getpunkte()); //Anzeige des Benutzernamens und der Punkte des angemeldeten Nutzers oben rechts
	}
	
	public static void main(String[] args0){ //Main
		StartansichtStrg strg = new StartansichtStrg();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) { //ActionPerformed der Buttons
		// TODO Auto-generated method stub
		if(e.getSource()== view1.getBtnAbmelden()) { //Abmeldung des Nutzers
			AnmeldenStrg strg = new AnmeldenStrg();
			view1.getFrmPixelRacer().dispose();
		}
		
		if(e.getSource()== view1.getBtnGarage()) { //Anzeigen der verschiedenen Karts
			AnzeigenKartStrg strg = new AnzeigenKartStrg();
			view1.getFrmPixelRacer().dispose();
		}
		
		if(e.getSource()== view1.getBtnProfil()) { //Anzeigen des Profils des Kunden
			AnzeigenProfilKundeStrg strg = new AnzeigenProfilKundeStrg(); 
			view1.getFrmPixelRacer().dispose();
		}
		
		if(e.getSource()== view1.getBtnSpielen()) { //Button um zur Erstellung einer Fahrt zu gelangen
			ModusauswaehlenStrg strg = new ModusauswaehlenStrg();
			view1.getFrmPixelRacer().dispose();
		}
		
		if(e.getSource()== view1.getBtnStreckenbersicht()) {//Anzeige der verschiedenen Strecken
			AnzeigenStreckenStrg strg = new AnzeigenStreckenStrg();
			view1.getFrmPixelRacer().dispose();
		}
	}
	
}