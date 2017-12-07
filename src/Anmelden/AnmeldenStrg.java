package Anmelden;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import AccountAnlegen.AccountAnlegenStrg;
import Nutzer.*;
import Startansicht.StartansichtStrg;

public class AnmeldenStrg implements ActionListener {
	private static String benutzername;
	private char[] passwort;
	private LinkedList<Kunde> kliste;
	private LinkedList<Mitarbeiter> mliste;
	
	AnmeldenView view1;
	
	public AnmeldenStrg() {
		view1 = new AnmeldenView();
		view1.frmPixelRacer.setVisible(true);
		
		view1.btnAccountAnlegen.addActionListener(this);
		view1.btnAnmelden.addActionListener(this);
		view1.btnMitarbeiter.addActionListener(this);
	}
	

	public static void main(String[] args) {
		AnmeldenStrg strg = new AnmeldenStrg();
	}
	
	public Boolean pruefeDatenKunden() {
		kliste = Nutzerverwaltung.gibKundenliste();
		benutzername = view1.txtNutzername.getText();
		passwort = view1.passwordField.getPassword();
		String pw = new String(passwort);
		
		if(kliste.equals(benutzername) && kliste.equals(pw)) { //Schwachsinn
			return true;
		}
		
		else {
			return false;
		}
	}
	
	public Boolean pruefeDatenMitarbeiter() {
		return true;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== view1.btnAnmelden) {
			if(pruefeDatenKunden()) {
				JOptionPane.showMessageDialog(null, "Anmelden erfolgreich!","Super!", JOptionPane.PLAIN_MESSAGE);
				StartansichtStrg start = new StartansichtStrg();
			}
			
			else {
				JOptionPane.showMessageDialog(null, "Anmeldedaten Falsch!", "Verstanden", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if(e.getSource()== view1.btnAccountAnlegen) {
			AccountAnlegenStrg anlegenstrg = new AccountAnlegenStrg();
		}
		
		if(e.getSource()== view1.btnMitarbeiter) {
			AnmeldenMitarbeiterView view2 = new AnmeldenMitarbeiterView();
			view2.frmPixelRacer.setVisible(true);
		}
	}

	public static String getAngNutzername() {
		// TODO Auto-generated method stub
		return benutzername;
	}
}
