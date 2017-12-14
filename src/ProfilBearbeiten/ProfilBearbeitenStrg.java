package ProfilBearbeiten;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Datenbankverwaltung.Datenbankschnittstelle;
import Nutzer.Kunde;
import Nutzer.Nutzerverwaltung;

//Autor Daniel Zeller

public class ProfilBearbeitenStrg implements ActionListener {
	ProfilBearbeitenView view1;
	ProfilBearbeitenAttributView view2;
	private String auswahl;
	private String neu;
	
	public ProfilBearbeitenStrg() {
		view1 = new ProfilBearbeitenView();
		view1.getFrmProfilBearbeiten().setVisible(true);
		
		view1.getLblVN().setText(Nutzerverwaltung.getangKunde().getvn());
		view1.getLblNN().setText(Nutzerverwaltung.getangKunde().getnn());
		view1.getLblNutzer().setText(Nutzerverwaltung.getangKunde().getnutzername());
		view1.getLblMail().setText(Nutzerverwaltung.getangKunde().getemail());
		view1.getLblGebDat().setText(Nutzerverwaltung.getangKunde().getgebdat());
		view1.getLblPkt().setText(String.valueOf(Nutzerverwaltung.getangKunde().getpunkte()));
		
		view1.getBtnaendernMail().addActionListener(this);
		view1.getBtnaendernNN().addActionListener(this);
		view1.getBtnaendernPW().addActionListener(this);
		view1.getBtnFertig().addActionListener(this);
		
		
		view2 = new ProfilBearbeitenAttributView();
		
		view2.getBtnAbbrechen().addActionListener(this);
		view2.getBtnFertig().addActionListener(this);
	}
	
	public static void main(String[] args) {
		ProfilBearbeitenStrg strg = new ProfilBearbeitenStrg();
	}
	
	public Boolean DatenPruefen() {
		if(auswahl.equals("email")) {
			if(neu.length() <= 50 && neu.length() != 0) {
				return true;
			}
		}
		
		if(auswahl.equals("nachname")) {
			if(neu.length() <= 20 && neu.length() != 0) {
				return true;
			}
		}
		
		if(auswahl.equals("passwort")) {
			if(neu.length() <= 20 && neu.length() != 0) {
				return true;
			}
		}
		
		return false;
	}
	
	public void DatenAktualisieren() {
		String update = "Update kunde set " + auswahl + " = '" + neu + "' where benutzername = '" + Nutzerverwaltung.getangKunde().getnutzername() + "'";
		Datenbankschnittstelle.executeUpdate(update);
		Datenbankschnittstelle.closeConnections();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()== view1.getBtnaendernMail()) {
			view2.getLblAktAnzeige().setText(Nutzerverwaltung.getangKunde().getemail());
			view2.getFrmProfilBearbeiten().setVisible(true);
			auswahl = "email";
		}
		
		if(e.getSource()== view1.getBtnaendernNN()) {
			view2.getLblAktAnzeige().setText(Nutzerverwaltung.getangKunde().getnn());
			view2.getFrmProfilBearbeiten().setVisible(true);
			auswahl = "nachname";
		}
		
		if(e.getSource()== view1.getBtnaendernPW()) {
			view2.getLblAktAnzeige().setText("*************");
			view2.getFrmProfilBearbeiten().setVisible(true);
			auswahl = "passwort";
		}
		
		if(e.getSource()== view1.getBtnFertig()) {
			view1.getFrmProfilBearbeiten().dispose();
			//neues ProfilStrg
		}
		
		if(e.getSource()== view2.getBtnAbbrechen()) {
			view2.getFrmProfilBearbeiten().dispose();
			ProfilBearbeitenStrg strg = new ProfilBearbeitenStrg();
		}
		
		if(e.getSource()== view2.getBtnFertig()) {
			neu = view2.getTextFieldNeu().getText();
			if(DatenPruefen()) {
				DatenAktualisieren();
				JOptionPane.showMessageDialog(null, "Profil wurde erfolgreich aktualisiert!","Super!", JOptionPane.PLAIN_MESSAGE);
				view2.getFrmProfilBearbeiten().dispose();
				Nutzerverwaltung.aktualisereangKunde();
				ProfilBearbeitenStrg strg = new ProfilBearbeitenStrg();
			}
			
			else {
				JOptionPane.showMessageDialog(null, "Daten entsprechen nicht den Voraussetzungen","Verdammt!", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
