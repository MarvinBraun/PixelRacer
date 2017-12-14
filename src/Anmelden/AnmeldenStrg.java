package Anmelden;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import AccountAnlegen.AccountAnlegenStrg;
import MitarbeiterAnsicht.MitarbeiterAnsichtStrg;
import Nutzer.*;
import Startansicht.StartansichtStrg;

//Autor Daniel Zeller

public class AnmeldenStrg implements ActionListener {
	private static String benutzername;
	private LinkedList<Kunde> kliste;
	private LinkedList<Mitarbeiter> mliste;
	private static Kunde angKunde;
	
	AnmeldenView view1;
	AnmeldenMitarbeiterView view2;
	
	public AnmeldenStrg() {
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
	
	public Boolean pruefeDatenKunden() {
		Kunde k1 = new Kunde();
		k1.setnutzername(view1.getTxtNutzername().getText());
		String pw = new String (view1.getPasswordField().getPassword());
		k1.setpasswort(pw);
		
		kliste = Nutzerverwaltung.gibKundenliste();
		
		for(Kunde temp: kliste) {
			if(k1.getnutzername().equals(temp.getnutzername())) {
				if(k1.getpasswort().equals(temp.getpasswort())) {
					angKunde = temp;
					return true;
				}
			}
		}
		
		return false;
	}
	
	public Boolean pruefeDatenMitarbeiter() {
		Mitarbeiter m1 = new Mitarbeiter();
		m1.setmitarbeiterid(view2.getTxtId().getText());
		String pw = new String (view2.getPwdPasswort().getPassword());
		m1.setpasswort(pw);
		
		mliste = Nutzerverwaltung.gibMitarbeiterliste();
		
		for(Mitarbeiter temp: mliste) {
			if(m1.getmitarbeiterid().equals(temp.getmitarbeiterid())) {
				if(m1.getpasswort().equals(temp.getpasswort())) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== view1.getBtnAnmelden()) {
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
		
		if(e.getSource()== view1.getBtnAccountAnlegen()) {
			AccountAnlegenStrg anlegenstrg = new AccountAnlegenStrg();
		}
		
		if(e.getSource()== view1.getBtnMitarbeiter()) {
			view2.getFrmPixelRacer().setVisible(true);
		}
		
		if(e.getSource()== view2.getBtnAnmelden()) {
			if(pruefeDatenMitarbeiter()) {
				JOptionPane.showMessageDialog(null, "Anmelden erfolgreich!","Super!", JOptionPane.PLAIN_MESSAGE);
				MitarbeiterAnsichtStrg strg = new MitarbeiterAnsichtStrg();
				view2.getFrmPixelRacer().dispose();
			}
			
			else {
				JOptionPane.showMessageDialog(null, "Anmeldedaten Falsch!", "Verstanden", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if(e.getSource()== view2.getBtnAbbrechen()) {
			view2.getFrmPixelRacer().dispose();
			AnmeldenStrg strg = new AnmeldenStrg();
		}
	}
}
