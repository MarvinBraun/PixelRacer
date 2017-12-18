/**
 @author Sean Cartner
*/

package KartHinzufügen;

import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import Datenbankverwaltung.Datenbankschnittstelle;

import java.awt.event.ActionEvent;

public class KartHinzufügenStrg implements ActionListener {
	
	//Globae Variablen
	private KartHinzufügenView khView;
	private String laengeOk = "true";
	private String fehlermeldung = "Folgende Angaben sind zu lang:";
	private String name;
	private String typ;
	private int beschleunigung;
	private int maxGeschwindigkeit;
	private int punktzahl;
	private char status;
	private File grafik;
	
	//Konstruktor
	public KartHinzufügenStrg(){
		khView = new KartHinzufügenView();
		khView.getPanel().setVisible(true);
		khView.getBtnAuswaehlen().addActionListener(this);
		khView.getBtnAbsenden().addActionListener(this);
		khView.getBtnAbbrechen().addActionListener(this);
	}
	
	//Methode, die auf aufgerufen wird, wenn ein Button gedrueckt wird
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==khView.getBtnAuswaehlen()){
			//FileChooser aufrufen
			khView.getFc().setFileFilter(khView.getFilter());
			int rueckgabeWert = khView.getFc().showOpenDialog(null);
			if(rueckgabeWert == JFileChooser.APPROVE_OPTION){
				khView.getTfGrafik().setText(khView.getFc().getSelectedFile().getAbsolutePath());
			}
		} 
		if(e.getSource() == khView.getBtnAbsenden()){
			//Daten pruefen und wenn alles Korrekt ist einen neuen Datensatz anlegen
			if(pruefeFormarAufVollständigkeit() == false){
				formularUnvollständigMeldung();
			} else{
			istNameZuLang();
			istBeschleunigungZuLang();
			istMaxGeschwindigkeitZuLang();
			istPunktzahlZuLang();
			if(laengeOk == "false"){
				inhaltZuLangMeldung();
				fehlermeldung = "Folgende Angaben sind zu lang:";
				laengeOk = "true";
			} else{
				deklariereVariablenVTextfeldern();
				erstelleKartInDB();
				updateKartGrafik();
				leereFormular();
			}
				}
		}
		//Soll Formular bei Abbruch leeren
		if(e.getSource() == khView.getBtnAbbrechen()) {
			leereFormular();
		}
	}
	
	//Meldung, die erscheint, wenn Formular nicht vollstaendig ausgefuellt ist
	private void formularUnvollständigMeldung(){
		JOptionPane.showMessageDialog(khView.getPanel(),
			    "Alle Felder müssen ausgefüllt sein!", "Formular unvollständig",
			    JOptionPane.WARNING_MESSAGE);
	}
	
	//Meldung, die erscheint, wenn die Eingabe zu einem oder mehreren Feldern zu lang ist
	private void inhaltZuLangMeldung(){
		JOptionPane.showMessageDialog(khView.getPanel(),
			    fehlermeldung, "Inhalt zu lang",
			    JOptionPane.WARNING_MESSAGE);
	}
	
	//Meldung, die erscheint, wenn ein Zahlen-Feld mit sonstigen Zeichen befuellt wird
	public void istKeineZahl(){
		JOptionPane.showMessageDialog(khView.getPanel(),
			   "Beschleunigung, MaxGeschwindkeit und Punktzahl müssen eine Zahl sein!", "Keine Zahl",
			    JOptionPane.WARNING_MESSAGE);
	}
	
	//Methode, welche pruefen soll, ob das Formular auch vollstaendig ausgefuellt ist
	private boolean pruefeFormarAufVollständigkeit(){
		if(khView.getTfName().getText().isEmpty() || khView.getTfBeschleunigung().getText().isEmpty() || 
				khView.getTfGeschwindigkeit().getText().isEmpty() || khView.getTfPunktzahl().getText().isEmpty() ||
				khView.getTfGrafik().getText().isEmpty() || khView.getBgStatus().getSelection() == null){
		return false;
		}
		return true;
	}
	
	//Methode, welche die Laenge des Namen-Feldes kontrollieren soll
	private void istNameZuLang(){
		if(khView.getTfName().getText().length() > 20){
			laengeOk = "false";
			fehlermeldung = fehlermeldung + "  " + "Name";
		}	
	}
	
	//Methode, welche die Laenge des Beschleunigungs-Feldes kontrollieren soll
	private void istBeschleunigungZuLang(){
		if(khView.getTfBeschleunigung().getText().length() > 8){
			laengeOk = "false";
			fehlermeldung = fehlermeldung + "  " + "Beschleunigung";
		}
	}
	
	//Methode, welche die Laenge des MaxGeschwindigkeit-Feldes kontrollieren soll
	private void istMaxGeschwindigkeitZuLang(){
		if(khView.getTfGeschwindigkeit().getText().length() > 3){
			laengeOk = "false";
			fehlermeldung = fehlermeldung + "  " + "MaxGeschwindigkeit";
		}
	}
	
	//Methode, welche die Laenge des Punktzahl-Feldes kontrollieren soll
	private void istPunktzahlZuLang(){
		if(khView.getTfPunktzahl().getText().length() > 2){
			laengeOk = "false";
			fehlermeldung = fehlermeldung + "  " + "Punktzahl";
		}
	}
	
	//Methode, in die Datenbank relevanten Variablen aufgrundlage des Formulars deklariert werden
	private void deklariereVariablenVTextfeldern(){
		try {
		name = khView.getTfName().getText();
		beschleunigung = Integer.parseInt(khView.getTfBeschleunigung().getText());
		maxGeschwindigkeit = Integer.parseInt(khView.getTfGeschwindigkeit().getText());
		punktzahl = Integer.parseInt(khView.getTfPunktzahl().getText());
		status = khView.getRbFree().isSelected()?'f':(khView.getRbPremium().isSelected()?'p':' ');
		grafik = new File(khView.getTfGrafik().getText());
		} catch (NumberFormatException e) {
			istKeineZahl();
		}
	}
	
	//Methode, welche ein Kart in der Datenbank erstellt
	private void erstelleKartInDB(){
		if(status == 'p'){
				typ = "true";
		}
		String abfrage = "insert into kart values('" + name + "','" + beschleunigung + "','" + maxGeschwindigkeit + "','" + typ + "'," + punktzahl + ",null)";
		Datenbankschnittstelle.executeQuery(abfrage);
		Datenbankschnittstelle.closeConnections();
	}
	
	//Methode, welche das in der Datenbank erstellte Kart um eine Grafik ergaenzt
	private void updateKartGrafik(){
		String updateBild = "update kart set grafik =? where kartname ='" + name + "'";
		Datenbankschnittstelle.uploadBlob(updateBild,grafik);
		Datenbankschnittstelle.closeConnections();
	}
	
	//Methode, die das Formular leeren soll
	private void leereFormular() {
		khView.getTfName().setText(" ");
		khView.getTfBeschleunigung().setText(" ");
		khView.getTfGeschwindigkeit().setText(" ");
		khView.getTfPunktzahl().setText(" ");
		khView.getTfGrafik().setText(" ");
		khView.getBgStatus().clearSelection();
	}
	
	//Getter für die View
	public KartHinzufügenView getView() {
		return khView;
	}
}
