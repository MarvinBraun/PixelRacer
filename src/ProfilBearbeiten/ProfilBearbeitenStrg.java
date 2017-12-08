package ProfilBearbeiten;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Nutzer.Kunde;
import Nutzer.Nutzerverwaltung;

//Autor Daniel Zeller

public class ProfilBearbeitenStrg implements ActionListener {
	ProfilBearbeitenView view1;
	ProfilBearbeitenAttributView view2;
	Kunde k1;
	private String auswahl;
	private String neu;
	
	public ProfilBearbeitenStrg() {
		view1 = new ProfilBearbeitenView();
		view1.frmProfilBearbeiten.setVisible(true);
		
		view1.btnaendernMail.addActionListener(this);
		view1.btnaendernNN.addActionListener(this);
		view1.btnaendernPW.addActionListener(this);
		view1.btnFertig.addActionListener(this);
		
		k1 = Nutzerverwaltung.getangKunde();
		
		view2 = new ProfilBearbeitenAttributView();
		
		view2.btnAbbrechen.addActionListener(this);
		view2.btnFertig.addActionListener(this);
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
		String update = "Update kunde set " + auswahl + " = " + neu + " where benutzername = " + k1.getnutzername(); 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()== view1.btnaendernMail) {
			view2.lblAktAnzeige.setText(k1.getemail());
			view2.frmProfilBearbeiten.setVisible(true);
			auswahl = "email";
		}
		
		if(e.getSource()== view1.btnaendernNN) {
			view2.lblAktAnzeige.setText(k1.getnn());
			view2.frmProfilBearbeiten.setVisible(true);
			auswahl = "nachname";
		}
		
		if(e.getSource()== view1.btnaendernPW) {
			view2.lblAktAnzeige.setText("*************");
			view2.frmProfilBearbeiten.setVisible(true);
			auswahl = "passwort";
		}
		
		if(e.getSource()== view1.btnFertig) {
			view1.frmProfilBearbeiten.dispose();
			//neues ProfilStrg
		}
		
		if(e.getSource()== view2.btnAbbrechen) {
			view2.frmProfilBearbeiten.dispose();
			ProfilBearbeitenStrg strg = new ProfilBearbeitenStrg();
		}
		
		if(e.getSource()== view2.btnFertig) {
			neu = view2.textFieldNeu.getText();
			if(DatenPruefen()) {
				DatenAktualisieren();
				JOptionPane.showMessageDialog(null, "Profil wurde erfolgreich aktualisiert!","Super!", JOptionPane.PLAIN_MESSAGE);
				view2.frmProfilBearbeiten.dispose();
				ProfilBearbeitenStrg strg = new ProfilBearbeitenStrg();
			}
			
			else {
				JOptionPane.showMessageDialog(null, "Daten entsprechen nicht den Voraussetzungen","Verdammt!", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
