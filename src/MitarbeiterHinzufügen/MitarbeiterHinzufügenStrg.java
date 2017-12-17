/**
@author Sean Cartner
*/

package MitarbeiterHinzufügen;

import java.awt.event.ActionListener;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import Datenbankverwaltung.Datenbankschnittstelle;

import java.awt.event.ActionEvent;

public class MitarbeiterHinzufügenStrg implements ActionListener {
	
	//Globale Variablen
	private MitarbeiterHinzufügenView mhView;
	private String laengeOk = "true";
	private String fehlermeldung = "Folgende Angaben sind zu lang:";
	private int mitarbeiterID;
	private String vorname;
	private String nachname;
	private String geburtsdatum;
	private String job;
	private String benutzername;
	private String email;
	private String passwort;
	
	//Konstruktor
	public MitarbeiterHinzufügenStrg(){
		mhView = new MitarbeiterHinzufügenView();
		mhView.frmPixelRacer.setVisible(true);
		mhView.btnAbsenden.addActionListener(this);
		mhView.btnAbbrechen.addActionListener(this);
	}
	
	//Methode, die auf aufgerufen wird, wenn ein Button gedrueckt wird
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == mhView.btnAbsenden){
			//Daten pruefen und wenn alles Korrekt ist einen neuen Datensatz anlegen
			if(pruefeFormarAufVollständigkeit() == false){
				formularUnvollständigMeldung();
			} else{
			istVornameZuLang();
			istNachnameZuLang();
			istGeburtsdatumZuLang();
			istJobZuLang();
			istBenutzernameZuLang();
			istEmailZuLang();
			istPasswortZuLang();
			if(laengeOk == "false"){
				inhaltZuLangMeldung();
				fehlermeldung = "Folgende Angaben sind zu lang:";
				laengeOk = "true";
			} else{
				deklariereVariablenVTextfeldern();
				erstelleKartInDB();
				leereFormular();
			}
				}
		}
		//Soll Formular bei Abbruch leeren
		if(e.getSource() == mhView.btnAbbrechen) {
			leereFormular();
		}
	}
	
	//Meldung, die erscheint, wenn Formular nicht vollstaendig ausgefuellt ist
	private void formularUnvollständigMeldung(){
		JOptionPane.showMessageDialog(mhView.frmPixelRacer,
			    "Alle Felder müssen ausgefüllt sein!", "Formular unvollständig",
			    JOptionPane.WARNING_MESSAGE);
	}
	
	//Meldung, die erscheint, wenn die Eingabe zu einem oder mehreren Feldern zu lang ist
	private void inhaltZuLangMeldung(){
		JOptionPane.showMessageDialog(mhView.frmPixelRacer,
			    fehlermeldung, "Inhalt zu lang",
			    JOptionPane.WARNING_MESSAGE);
	}
	
	//Methode, welche pruefen soll, ob das Formular auch vollstaendig ausgefuellt ist
	private boolean pruefeFormarAufVollständigkeit(){
		if(mhView.textFieldVorname.getText().isEmpty() || mhView.textFieldNachname.getText().isEmpty() 
				|| mhView.textFieldGeburtsdatum.getText().isEmpty() || mhView.textFieldJob.getText().isEmpty()
				|| mhView.textFieldBenutzername.getText().isEmpty() || mhView.textFieldEmail.getText().isEmpty()
				|| mhView.passwordField.getPassword().length == 0){
		return false;
		}
		return true;
	}
	
	//Methode, welche die Laenge des Vorname-Feldes kontrollieren soll
	private void istVornameZuLang(){
		if(mhView.textFieldVorname.getText().length() > 20){
			laengeOk = "false";
			fehlermeldung = fehlermeldung + "  " + "Vorname";
		}	
	}
	
	//Methode, welche die Laenge des Nachname-Feldes kontrollieren soll
	private void istNachnameZuLang(){
		if(mhView.textFieldNachname.getText().length() > 20){
			laengeOk = "false";
			fehlermeldung = fehlermeldung + "  " + "Nachname";
		}
	}
	
	//Methode, welche die Laenge des Geburtsdatum-Feldes kontrollieren soll
	private void istGeburtsdatumZuLang(){
		if(mhView.textFieldGeburtsdatum.getText().length() > 8){
			laengeOk = "false";
			fehlermeldung = fehlermeldung + "  " + "Geburtsdatum";
		}
	}
	
	//Methode, welche die Laenge des Job-Feldes kontrollieren soll
	private void istJobZuLang(){
		if(mhView.textFieldJob.getText().length() > 20){
			laengeOk = "false";
			fehlermeldung = fehlermeldung + "  " + "Job";
		}
	}
	
	//Methode, welche die Laenge des Benutzername-Feldes kontrollieren soll
	private void istBenutzernameZuLang(){
		if(mhView.textFieldBenutzername.getText().length() > 20){
			laengeOk = "false";
			fehlermeldung = fehlermeldung + "  " + "Benutzername";
		}
	}
	
	//Methode, welche die Laenge des Email-Feldes kontrollieren soll
	private void istEmailZuLang(){
		if(mhView.textFieldEmail.getText().length() > 50){
			laengeOk = "false";
			fehlermeldung = fehlermeldung + "  " + "Email";
		}
	}
	
	//Methode, welche die Laenge des Passwort-Feldes kontrollieren soll
	private void istPasswortZuLang(){
		if(mhView.passwordField.getPassword().toString().length() > 20){
			laengeOk = "false";
			fehlermeldung = fehlermeldung + "  " + "Job";
		}
	}
	
	//Methode, welche die hoechste MitarbeiterID aus der Datenbank liest und anhand dieser eine neue ID berechnet (+1)
	private int berechneMitarbeiterID() {
		ResultSet rs = Datenbankschnittstelle.executeQuery("select max(mitarbeiterid) from mitarbeiter");
		int i = 0;
		try {
			while(rs.next())
			{
				i = rs.getInt(1);
			}
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Datenbankschnittstelle.closeConnections();
		i = i + 1;
		return i;
	}
	
	//Methode, in die Datenbank relevanten Variablen aufgrundlage des Formulars deklariert werden
	private void deklariereVariablenVTextfeldern(){
		mitarbeiterID = berechneMitarbeiterID();
		vorname = mhView.textFieldVorname.getText();
		nachname = mhView.textFieldNachname.getText();
		geburtsdatum = mhView.textFieldGeburtsdatum.getText();
		job = mhView.textFieldJob.getText();
		benutzername = mhView.textFieldBenutzername.getText();
		email = mhView.textFieldEmail.getText();
		passwort = new String(mhView.passwordField.getPassword());
	}
	
	//Methode, welche ein Mitarbeiter in der Datenbank erstellt
	private void erstelleKartInDB(){

		String abfrage = "insert into mitarbeiter values('" + mitarbeiterID + "', '" + benutzername + 
				"', '" + passwort + "', '" + vorname + "', '" + nachname + "', '" + job + "', '" + email + 
				"', '" + geburtsdatum + "')";
		Datenbankschnittstelle.executeQuery(abfrage);
		Datenbankschnittstelle.closeConnections();
	}
		
	//Methode, die das Formular leeren soll
	private void leereFormular() {
		mhView.textFieldVorname.setText(" ");
		mhView.textFieldNachname.setText(" ");
		mhView.textFieldGeburtsdatum.setText(" ");
		mhView.textFieldJob.setText(" ");
		mhView.textFieldBenutzername.setText(" ");
		mhView.textFieldEmail.setText(" ");
		mhView.passwordField.setText("");
	}
	
	//Getter für die View
	public MitarbeiterHinzufügenView getView() {
		return mhView;
	}
}
