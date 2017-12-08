package Anmelden;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import AccountAnlegen.AccountAnlegenStrg;
import Nutzer.*;
import Startansicht.StartansichtStrg;

//Autor Daniel Zeller

public class AnmeldenStrg implements ActionListener {
	private static String benutzername;
	private LinkedList<Kunde> kliste;
	private LinkedList<Mitarbeiter> mliste;
	private static String angbenutzername;
	
	AnmeldenView view1;
	AnmeldenMitarbeiterView view2;
	
	public AnmeldenStrg() {
		view1 = new AnmeldenView();
		view1.frmPixelRacer.setVisible(true);
		
		view1.btnAccountAnlegen.addActionListener(this);
		view1.btnAnmelden.addActionListener(this);
		view1.btnMitarbeiter.addActionListener(this);
		
		view2 = new AnmeldenMitarbeiterView();
		view2.btnAbbrechen.addActionListener(this);
		view2.btnAnmelden.addActionListener(this);
	}
	

	public static void main(String[] args) {
		AnmeldenStrg strg = new AnmeldenStrg();
	}
	
	public Boolean pruefeDatenKunden() {
		Kunde k1 = new Kunde();
		k1.setnutzername(view1.txtNutzername.getText());
		String pw = new String (view1.passwordField.getPassword());
		k1.setpasswort(pw);
		
		kliste = Nutzerverwaltung.gibKundenliste();
		
		for(Kunde temp: kliste) {
			if(k1.getnutzername().equals(temp.getnutzername())) {
				if(k1.getpasswort().equals(temp.getpasswort())) {
					angbenutzername = k1.getnutzername();
					return true;
				}
			}
		}
		
		return false;
	}
	
	public Boolean pruefeDatenMitarbeiter() {
		Mitarbeiter m1 = new Mitarbeiter();
		m1.setmitarbeiterid(view2.txtId.getText());
		String pw = new String (view2.pwdPasswort.getPassword());
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
		if(e.getSource()== view1.btnAnmelden) {
			if(pruefeDatenKunden()) {
				JOptionPane.showMessageDialog(null, "Anmelden erfolgreich!","Super!", JOptionPane.PLAIN_MESSAGE);
				StartansichtStrg start = new StartansichtStrg();
				view1.frmPixelRacer.dispose();
			}
			
			else {
				JOptionPane.showMessageDialog(null, "Anmeldedaten Falsch!", "Verstanden", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if(e.getSource()== view1.btnAccountAnlegen) {
			AccountAnlegenStrg anlegenstrg = new AccountAnlegenStrg();
		}
		
		if(e.getSource()== view1.btnMitarbeiter) {
			view2.frmPixelRacer.setVisible(true);
		}
		
		if(e.getSource()== view2.btnAnmelden) {
			if(pruefeDatenMitarbeiter()) {
				JOptionPane.showMessageDialog(null, "Anmelden erfolgreich!","Super!", JOptionPane.PLAIN_MESSAGE);
				StartansichtStrg start = new StartansichtStrg();
				view1.frmPixelRacer.dispose();
			}
			
			else {
				JOptionPane.showMessageDialog(null, "Anmeldedaten Falsch!", "Verstanden", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if(e.getSource()== view2.btnAbbrechen) {
			view2.frmPixelRacer.dispose();
			AnmeldenStrg strg = new AnmeldenStrg();
		}
	}

	public static String getAngNutzername() {
		// TODO Auto-generated method stub
		return angbenutzername;
	}
}
