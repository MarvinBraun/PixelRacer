/**
 * Stellt alle Klassen zum Anmelden zur Verfügung.
 */
package Anmelden;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import AccountAnlegen.AccountAnlegenStrg;
import MitarbeiterAnsicht.MitarbeiterAnsichtStrg;
import Nutzer.*;
import Startansicht.StartansichtStrg;

/**
 * Die Klasse AnmeldenStrg steuert das Anmelden eines Nutzer.
 * Sie verwaltet dabei die grafischen Benutzeroberflächen AnmeldenView und AnmeldenMitarbeiterView.
 * @author Daniel
 *
 */

public class AnmeldenStrg implements ActionListener {
	private LinkedList<Kunde> kliste; //Deklaration der benötigten Variablen
	private LinkedList<Mitarbeiter> mliste;
	private static Kunde angKunde;
	
	AnmeldenView view1;
	AnmeldenMitarbeiterView view2;
	
	public AnmeldenStrg() { //Konstruktor
		
		view1 = new AnmeldenView();
		view1.getFrmPixelRacer().setVisible(true);
		
		view1.getBtnAccountAnlegen().addActionListener(this);
		view1.getBtnAnmelden().addActionListener(this);
		view1.getBtnMitarbeiter().addActionListener(this);
		
		view2 = new AnmeldenMitarbeiterView();
		view2.getBtnAbbrechen().addActionListener(this);
		view2.getBtnAnmelden().addActionListener(this);
	}
	

	public static void main(String[] args) {
		AnmeldenStrg strg = new AnmeldenStrg();
	}
	
	/**
	 * Die eingegebenen Daten werden überprüft und mit den Daten aus der Datenbank verglichen.
	 * Dabei wird eine LinkedList durchgegangen, die alle Kundendaten aus der Datenbank enthält.
	 * @return Boolean
	 */
	public Boolean pruefeDatenKunden() { 
		try {
			Kunde k1 = new Kunde();
			k1.setnutzername(view1.getTxtNutzername().getText());
			String pw = new String (view1.getPasswordField().getPassword());
			k1.setpasswort(pw);
			
			kliste = Nutzerverwaltung.gibKundenliste(); //Jeder Kunde aus der Datenbank
			
			for(Kunde temp: kliste) { //Überprüfung auf Gleichheit
				if(k1.getnutzername().equals(temp.getnutzername())) {
					if(k1.getpasswort().equals(temp.getpasswort())) {
						angKunde = temp;
						return true;
					}
				}
			}
		}
		
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Die Daten konnten nicht überprüft werden!",null, JOptionPane.ERROR_MESSAGE);
		}
		
		return false;
	}
	
	/**
	 * Die eingegebenen Daten werden überprüft und mit den Daten aus der Datenbank verglichen.
	 * Dabei wird eine LinkedList durchgegangen, die alle Mitarbeiterdaten aus der Datenbank enthält.
	 * @return Boolean
	 */
	public Boolean pruefeDatenMitarbeiter() { //Prüfung auf Übereinstimmung der eingegebenen Daten mit den in der Datenbank hinterlegten Anmeldedaten
		try {
			Mitarbeiter m1 = new Mitarbeiter();
			m1.setmitarbeiterid(view2.getTxtId().getText());
			String pw = new String (view2.getPwdPasswort().getPassword());
			m1.setpasswort(pw);
			
			mliste = Nutzerverwaltung.gibMitarbeiterliste(); //Jeder Mitarbeiter aus der Datenbank
			
			for(Mitarbeiter temp: mliste) { //Überprüfung auf Gleichheit
				if(m1.getmitarbeiterid().equals(temp.getmitarbeiterid())) {
					if(m1.getpasswort().equals(temp.getpasswort())) {
						return true;
					}
				}
			}
		}
		
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Die Daten konnten nicht überprüft werden!",null, JOptionPane.ERROR_MESSAGE);
		}
		
		return false;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) { //ActionPerformed der Button
		if(e.getSource()== view1.getBtnAnmelden()) { //Überprüfung der Anmeldedaten und eventuelles Aufrufen der Startansicht
			if(pruefeDatenKunden()) {
				JOptionPane.showMessageDialog(null, "Anmelden erfolgreich!","Super!", JOptionPane.PLAIN_MESSAGE);
				Nutzerverwaltung.setangKunde(angKunde);
				StartansichtStrg start = new StartansichtStrg();
				view1.getFrmPixelRacer().dispose();
			}
			
			else {
				JOptionPane.showMessageDialog(null, "Anmeldedaten Falsch!", "Verstanden", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if(e.getSource()== view1.getBtnAccountAnlegen()) { //AccountAnlegenStrg wird aufgerufen
			MusicHandler.MusicPlayer.forwardBtn();
			AccountAnlegenStrg anlegenstrg = new AccountAnlegenStrg();
		}
		
		if(e.getSource()== view1.getBtnMitarbeiter()) { //Mitarbeiterlogin wird aufgerufen
			view2.getFrmPixelRacer().setVisible(true);
		}
		
		if(e.getSource()== view2.getBtnAnmelden()) { //Überprüfung der Anmeldedaten und eventuelles Aufrufen der Mitarbeiteransicht
			if(pruefeDatenMitarbeiter()) {
				MusicHandler.MusicPlayer.forwardBtn();
				JOptionPane.showMessageDialog(null, "Anmelden erfolgreich!","Super!", JOptionPane.PLAIN_MESSAGE);
				MitarbeiterAnsichtStrg strg = new MitarbeiterAnsichtStrg();
				view2.getFrmPixelRacer().dispose();
			}
			
			else {
				JOptionPane.showMessageDialog(null, "Anmeldedaten Falsch!", "Verstanden", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if(e.getSource()== view2.getBtnAbbrechen()) { //Abbruch des Mitarbeiterlogins, erneutes Aufrufen des Kundenanmeldenfenster
			MusicHandler.MusicPlayer.forwardBtn();
			view2.getFrmPixelRacer().dispose();
			AnmeldenStrg strg = new AnmeldenStrg();
		}
	}
}
