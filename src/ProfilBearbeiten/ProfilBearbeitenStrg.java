package ProfilBearbeiten;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Datenbankverwaltung.Datenbankschnittstelle;
import Nutzer.Kunde;
import Nutzer.Nutzerverwaltung;
import ProfilKunde.AnzeigenProfilKundeStrg;

/**
 * Die Klasse ProfilBearbeitenStrg steuert das Bearbeiten eines Profils.
 * Sie verwaltet dabei die grafische Benutzeroberflächen ProfilBearbeitenView und ProfilBearbeitenAttributView.
 * @author Daniel Zeller
 *
 */

public class ProfilBearbeitenStrg implements ActionListener {
	ProfilBearbeitenView view1; //Deklarierung der benötigten Variablen
	ProfilBearbeitenAttributView view2;
	private String auswahl;
	private String neu;
	
	/**
	 * Erzeugt ein neues Objekt der Klasse ProfilBearbeitenStrg und deklariert die entsprechenden Variablen.
	 */
	
	public ProfilBearbeitenStrg() { //Konstruktor
		view1 = new ProfilBearbeitenView();
		view1.getFrmProfilBearbeiten().setVisible(true);
		
		view1.getLblVN().setText(Nutzerverwaltung.getangKunde().getvn()); //Setze den Text des Labels auf die Daten des angemeldeten Kunden
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
		view2.getFrmProfilBearbeiten().setVisible(false);
		
		view2.getBtnAbbrechen().addActionListener(this);
		view2.getBtnFertig().addActionListener(this);
	}
	
	public static void main(String[] args) {
		ProfilBearbeitenStrg strg = new ProfilBearbeitenStrg();
	}
	/**
	 * Überprüft die eingegebenen Daten auf Fehler.
	 * @return Boolean
	 */
	public Boolean DatenPruefen() { //Prüfung der eingegbenen Daten
		if(auswahl.equals("email")) {
			if(neu.length() <= 50 && neu.length() != 0 && neu.contains("@")) {
				return true;
			}
			
			else {
				JOptionPane.showMessageDialog(null,
						"Die Daten der Email sind falsch!\nBeachte das max 50 Zeichen verwendet werden dürfen"
								+ " und ein @ vorhanden sein muss!",
						"Ok", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		
		if(auswahl.equals("nachname")) {
			if(neu.length() <= 20 && neu.length() != 0 && neu.matches("[a-zA-ZäÄöÖüÜß]+")) {
				return true;
			}
			
			else {
				JOptionPane.showMessageDialog(null,
						"Beachte das beim Nachnamen max 20 Zeichen erlaubt sind und auch keine Zahlen "
								+ "oder Sonderzeichen!",
						"Ok", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		
		if(auswahl.equals("passwort")) {
			if(neu.length() <= 20 && neu.length() != 0) {
				return true;
			}
			
			else {
				JOptionPane.showMessageDialog(null,
						"Beachte das höchstens 20 Zeichen beim Passwort benutzt werden dürfen!", "Ok",
						JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		
		return false;
	}
	/**
	 * Speichert die eingegebenen Daten in die Datenbank.
	 */
	public void DatenAktualisieren() { 
		String update = "Update kunde set " + auswahl + " = '" + neu + "' where benutzername = '" + Nutzerverwaltung.getangKunde().getnutzername() + "'";
		Datenbankschnittstelle.executeUpdate(update);
		Datenbankschnittstelle.closeConnections();
	}

	@Override
	public void actionPerformed(ActionEvent e) { //ActionPerformed der Button
		// TODO Auto-generated method stub
		
		if(e.getSource()== view1.getBtnaendernMail()) { //Aufrufen der ProfilBearbeitenAttributView mit Anpassung auf die Email
			view2.getLblAktAnzeige().setText(Nutzerverwaltung.getangKunde().getemail());
			view2.getFrmProfilBearbeiten().setVisible(true);
			auswahl = "email";
		}
		
		if(e.getSource()== view1.getBtnaendernNN()) { //Aufrufen der ProfilBearbeitenAttributView mit Anpassung auf den Nachnamen
			view2.getLblAktAnzeige().setText(Nutzerverwaltung.getangKunde().getnn());
			view2.getFrmProfilBearbeiten().setVisible(true);
			auswahl = "nachname";
		}
		
		if(e.getSource()== view1.getBtnaendernPW()) { //Aufrufen der ProfilBearbeitenAttributView mit Anpassung auf das Passwort
			view2.getLblAktAnzeige().setText("*************");
			view2.getFrmProfilBearbeiten().setVisible(true);
			auswahl = "passwort";
		}
		
		if(e.getSource()== view1.getBtnFertig()) { //Aufrufen des Profils des Kunden
			view1.getFrmProfilBearbeiten().dispose();
			AnzeigenProfilKundeStrg strg = new AnzeigenProfilKundeStrg();
		}
		
		if(e.getSource()== view2.getBtnAbbrechen()) { //Der Vorgang des Änderns wird abgebrochen und die ProfilBearbeitenView wird aufgerufen
			view2.getFrmProfilBearbeiten().dispose();
			ProfilBearbeitenStrg strg = new ProfilBearbeitenStrg();
		}
		
		if(e.getSource()== view2.getBtnFertig()) { //Der Vorgang des Änderns ist fertig, es werden die Daten überprüft und bei richtiger Eingabe aktualisiert
			neu = view2.getTextFieldNeu().getText();
			if(DatenPruefen()) {
				DatenAktualisieren();
				JOptionPane.showMessageDialog(null, "Profil wurde erfolgreich aktualisiert!","Super!", JOptionPane.PLAIN_MESSAGE);
				view2.getFrmProfilBearbeiten().dispose();
				Nutzerverwaltung.aktualisereangKunde();
				ProfilBearbeitenStrg strg = new ProfilBearbeitenStrg();
			}
		}
	}
}
