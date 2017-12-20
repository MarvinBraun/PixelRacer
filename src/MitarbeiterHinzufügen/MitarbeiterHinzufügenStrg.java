/**
@author Sean Cartner
*/

package MitarbeiterHinzufügen;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import Datenbankverwaltung.Datenbankschnittstelle;

import java.awt.event.ActionEvent;

public class MitarbeiterHinzufügenStrg implements ActionListener {
	
	//Globale Variablen
	private MitarbeiterHinzufügenView mhView;
	private String laengeOk = "true";
	private String fehlermeldung = "Folgende Angaben sind zu lang:";
	private boolean datumGueltig = true;
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
		mhView.getPanel().setVisible(true);
		mhView.getBtnAbsenden().addActionListener(this);
		mhView.getBtnAbbrechen().addActionListener(this);
	}
	
	//Methode, die auf aufgerufen wird, wenn ein Button gedrueckt wird
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == mhView.getBtnAbsenden()){
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
				istDatumGueltig();
				if(datumGueltig == false) {
					datumUngueltigMeldung();
					//reset
					datumGueltig = true;
				}else {
					erstelleMitarbeiterInDB();
					leereFormular();
				}
			}
				}
		}
		//Soll Formular bei Abbruch leeren
		if(e.getSource() == mhView.getBtnAbbrechen()) {
			leereFormular();
		}
	}
	
	//Meldung, die erscheint, wenn Formular nicht vollstaendig ausgefuellt ist
	private void formularUnvollständigMeldung(){
		JOptionPane.showMessageDialog(mhView.getPanel(),
			    "Alle Felder müssen ausgefüllt sein!", "Formular unvollständig",
			    JOptionPane.WARNING_MESSAGE);
	}
	
	//Meldung, die erscheint, wenn die Eingabe zu einem oder mehreren Feldern zu lang ist
	private void inhaltZuLangMeldung(){
		JOptionPane.showMessageDialog(mhView.getPanel(),
			    fehlermeldung, "Inhalt zu lang",
			    JOptionPane.WARNING_MESSAGE);
	}
	
	
	//Meldung, die erscheint, wenn ein ungueltiges Datum eingegebn wuude
	private void datumUngueltigMeldung(){
		JOptionPane.showMessageDialog(mhView.getPanel(),
			    "Das Datum muss im Format DD.MM.YY vorliegen", "Datum ungültig",
			    JOptionPane.WARNING_MESSAGE);
	}
	
	//Methode, welche pruefen soll, ob das Formular auch vollstaendig ausgefuellt ist
	private boolean pruefeFormarAufVollständigkeit(){
		if(mhView.getTfVorname().getText().isEmpty() || mhView.getTfNachname().getText().isEmpty() 
				|| mhView.getTfGeburtsdatum().getText().isEmpty() || mhView.getTfJob().getText().isEmpty()
				|| mhView.getTfBenutzername().getText().isEmpty() || mhView.getTfEmail().getText().isEmpty()
				|| mhView.getPfPasswort().getPassword().length == 0){
		return false;
		}
		return true;
	}
	
	//Methode, welche die Laenge des Vorname-Feldes kontrollieren soll
	private void istVornameZuLang(){
		if(mhView.getTfVorname().getText().length() > 20){
			laengeOk = "false";
			fehlermeldung = fehlermeldung + "  " + "Vorname";
		}	
	}
	
	//Methode, welche die Laenge des Nachname-Feldes kontrollieren soll
	private void istNachnameZuLang(){
		if(mhView.getTfNachname().getText().length() > 20){
			laengeOk = "false";
			fehlermeldung = fehlermeldung + "  " + "Nachname";
		}
	}
	
	//Methode, welche die Laenge des Geburtsdatum-Feldes kontrollieren soll
	private void istGeburtsdatumZuLang(){
		if(mhView.getTfGeburtsdatum().getText().length() > 8){
			laengeOk = "false";
			fehlermeldung = fehlermeldung + "  " + "Geburtsdatum";
		}
	}
	
	//Methode, welche die Laenge des Job-Feldes kontrollieren soll
	private void istJobZuLang(){
		if(mhView.getTfJob().getText().length() > 20){
			laengeOk = "false";
			fehlermeldung = fehlermeldung + "  " + "Job";
		}
	}
	
	//Methode, welche die Laenge des Benutzername-Feldes kontrollieren soll
	private void istBenutzernameZuLang(){
		if(mhView.getTfBenutzername().getText().length() > 20){
			laengeOk = "false";
			fehlermeldung = fehlermeldung + "  " + "Benutzername";
		}
	}
	
	//Methode, welche die Laenge des Email-Feldes kontrollieren soll
	private void istEmailZuLang(){
		if(mhView.getTfEmail().getText().length() > 50){
			laengeOk = "false";
			fehlermeldung = fehlermeldung + "  " + "Email";
		}
	}
	
	//Methode, welche die Laenge des Passwort-Feldes kontrollieren soll
	private void istPasswortZuLang(){
		if(mhView.getPfPasswort().getPassword().length > 20){
			laengeOk = "false";
			fehlermeldung = fehlermeldung + "  " + "Passwort";
		}
	}
	
	//Methode, die kontrolliert, ob das Datum im richtigen Format eingegeben wurde
	private void istDatumGueltig() {
		Date date = null;
		try {
		    DateFormat format = new SimpleDateFormat("dd.MM.yy");
		    format.setLenient(false);
		    date = format.parse(geburtsdatum);
		} catch (ParseException e) { 
		    datumGueltig = false;
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
		vorname = mhView.getTfVorname().getText();
		nachname = mhView.getTfNachname().getText();
		geburtsdatum = mhView.getTfGeburtsdatum().getText();
		job = mhView.getTfJob().getText();
		benutzername = mhView.getTfBenutzername().getText();
		email = mhView.getTfEmail().getText();
		passwort = new String(mhView.getPfPasswort().getPassword());
	}
	
	//Methode, welche ein Mitarbeiter in der Datenbank erstellt
	private void erstelleMitarbeiterInDB(){

		String abfrage = "insert into mitarbeiter values('" + mitarbeiterID + "', '" + benutzername + 
				"', '" + passwort + "', '" + vorname + "', '" + nachname + "', '" + job + "', '" + email + 
				"', '" + geburtsdatum + "')";
		Datenbankschnittstelle.executeQuery(abfrage);
		Datenbankschnittstelle.closeConnections();
	}
		
	//Methode, die das Formular leeren soll
	private void leereFormular() {
		mhView.getTfVorname().setText("");
		mhView.getTfNachname().setText("");
		mhView.getTfGeburtsdatum().setText("");
		mhView.getTfJob().setText("");
		mhView.getTfBenutzername().setText("");
		mhView.getTfEmail().setText("");
		mhView.getPfPasswort().setText("");
	}
	
	//Getter für die View
	public MitarbeiterHinzufügenView getView() {
		return mhView;
	}
}
