/**
 @author Sean Cartner
*/

package StreckeHinzufügen;

import java.awt.event.ActionListener;
import java.io.File;

import javax.activation.MimetypesFileTypeMap;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import Datenbankverwaltung.Datenbankschnittstelle;

import java.awt.event.ActionEvent;

public class StreckeHinzufügenStrg implements ActionListener {
	
	//Globae Variablen
	private StreckeHinzufügenView stView;
	private String laengeOk = "true";
	private String fehlermeldung = "Folgende Angaben sind zu lang:";
	private boolean istKeineZahl = false;
	private String name;
	private String typ;
	private int laenge;
	private int schwierigkeit;
	private int punktzahl;
	private char status;
	private File grafik;
	
	//Konstruktor
	public StreckeHinzufügenStrg(){
		stView = new StreckeHinzufügenView();
		stView.getPanel().setVisible(true);
		stView.getBtnAuswhlen().addActionListener(this);
		stView.getBtnAbsenden().addActionListener(this);
		stView.getBtnAbbrechen().addActionListener(this);
	}

	//Methode, die auf aufgerufen wird, wenn ein Button gedrueckt wird
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==stView.getBtnAuswhlen()){
			//FileChooser aufrufen
			stView.getFileChooser().setFileFilter(stView.getFilter());
			int rueckgabeWert = stView.getFileChooser().showOpenDialog(null);
			if(rueckgabeWert == JFileChooser.APPROVE_OPTION){
				stView.getTfGrafik().setText(stView.getFileChooser().getSelectedFile().getAbsolutePath());
			}
		} 
		if(e.getSource() == stView.getBtnAbsenden()){
			//Daten pruefen und wenn alles Korrekt ist einen neuen Datensatz anlegen
			if(pruefeFormarAufVollständigkeit() == false){
				formularUnvollständigMeldung();
			} else{
			istNameZuLang();
			istLaengeZuLang();
			istSchwierigkeitZuLang();
			istPunktzahlZuLang();
			if(laengeOk == "false"){
				inhaltZuLangMeldung();
				fehlermeldung = "Folgende Angaben sind zu lang:";
				laengeOk = "true";
			} else{
				deklariereVariablenVTextfeldern();
				if(istKeineZahl == true) {
					istKeineZahlMeldung();
					//reset
					istKeineZahl = false;
				}else {
					if(!grafik.exists()) {
						keineDateiGefundenMeldung();
					}else {
						if(IstGrafikPng() == false) {
							nichtPngMeldung();
						}else {
							if(grafik.length() > 256000) {
								grafikZuGrossMeldung();
							}else {
								erstelleStreckeInDB();
								updateKartGrafik();
								leereFormular();
							}
						}
					}
				}

			}
				}
		}
		if(e.getSource() == stView.getBtnAbbrechen()) {
			leereFormular();
		}
	}
	
	//Meldung, die erscheint, wenn Formular nicht vollstaendig ausgefuellt ist
	private void formularUnvollständigMeldung(){
		JOptionPane.showMessageDialog(stView.getPanel(),
			    "Alle Felder müssen ausgefüllt sein!", "Formular unvollständig",
			    JOptionPane.WARNING_MESSAGE);
	}
	
	//Meldung, die erscheint, wenn die Eingabe zu einem oder mehreren Feldern zu lang ist
	private void inhaltZuLangMeldung(){
		JOptionPane.showMessageDialog(stView.getPanel(),
			    fehlermeldung, "Inhalt zu lang",
			    JOptionPane.WARNING_MESSAGE);
	}
	
	//Meldung, die erscheint, wenn ein Zahlen-Feld mit sonstigen Zeichen befuellt wird
	public void istKeineZahlMeldung(){
		JOptionPane.showMessageDialog(stView.getPanel(),
			   "Länge, Schwierigkeit und Punktzahl müssen eine Zahl sein!", "Keine Zahl",
			    JOptionPane.WARNING_MESSAGE);
	}
	
	//Meldung, die erscheint, wenn Grafik nicht existiert
	public void keineDateiGefundenMeldung(){
		JOptionPane.showMessageDialog(stView.getPanel(),
			   "Es wurde keine Datei unter dem angegebenen Pfad gefunden", "Keine Datei gefunden",
			    JOptionPane.WARNING_MESSAGE);
	}
	
	//Meldung, die erscheint, wenn Grafik nicht im png Formart vorliegt
	public void nichtPngMeldung(){
		JOptionPane.showMessageDialog(stView.getPanel(),
			   "Die Grafik muss im Format .png vorliegen", "Grafik liegt nicht im PNG Format vor",
			    JOptionPane.WARNING_MESSAGE);
	}
	
	//Meldung, die erscheint, wenn Grafik zu Gross (in Speicher) ist
	public void grafikZuGrossMeldung(){
		JOptionPane.showMessageDialog(stView.getPanel(),
			   "Die Grafik darf maximal 20kb groß sein", "Grafik zu Groß",
			    JOptionPane.WARNING_MESSAGE);
	}
	
	//Methode, welche pruefen soll, ob das Formular auch vollstaendig ausgefuellt ist
	private boolean pruefeFormarAufVollständigkeit(){
		if(stView.getTfName().getText().isEmpty() || stView.getTfLaenge().getText().isEmpty() || 
				stView.getTfSchwierigkeit().getText().isEmpty() || stView.getTfPunktzahl().getText().isEmpty() ||
				stView.getTfPunktzahl().getText().isEmpty() || stView.getBgStatus().getSelection() == null){
		return false;
		}
		return true;
	}
	
	//Methode, welche die Laenge des Namen-Feldes kontrollieren soll
	private void istNameZuLang(){
		if(stView.getTfName().getText().length() > 20){
			laengeOk = "false";
			fehlermeldung = fehlermeldung + "  " + "Name";
		}	
	}
	
	//Methode, welche die Laenge des Länge-Feldes kontrollieren soll
	private void istLaengeZuLang(){
		if(stView.getTfLaenge().getText().length() > 5){
			laengeOk = "false";
			fehlermeldung = fehlermeldung + "  " + "Länge";
		}
	}
	
	//Methode, welche die Laenge des Schwierigkeit-Feldes kontrollieren soll
	private void istSchwierigkeitZuLang(){
		if(stView.getTfSchwierigkeit().getText().length() > 1){
			laengeOk = "false";
			fehlermeldung = fehlermeldung + "  " + "Schwierigkeit";
		}
	}
	
	//Methode, welche die Laenge des Punktzahl-Feldes kontrollieren soll
	private void istPunktzahlZuLang(){
		if(stView.getTfPunktzahl().getText().length() > 2){
			laengeOk = "false";
			fehlermeldung = fehlermeldung + "  " + "Punktzahl";
		}
	}
	
	//Methode, die kontrolliert, ob die Grafik im png Format vorliegt
	private boolean IstGrafikPng(){    
		MimetypesFileTypeMap mtftp = new MimetypesFileTypeMap();
	    mtftp.addMimeTypes("image png");
	    String mimetype = mtftp.getContentType(grafik);
	    String fileType = mimetype.split("/")[0];
	    return fileType.equalsIgnoreCase(mimetype);
	}
	
	//Methode, in die Datenbank relevanten Variablen aufgrundlage des Formulars deklariert werden
	private void deklariereVariablenVTextfeldern(){
		try {
		name = stView.getTfName().getText();
		laenge = Integer.parseInt(stView.getTfLaenge().getText());
		schwierigkeit = Integer.parseInt(stView.getTfSchwierigkeit().getText());
		punktzahl = Integer.parseInt(stView.getTfPunktzahl().getText());
		status = stView.getRbFree().isSelected()?'f':(stView.getRbPremium().isSelected()?'p':' ');
		grafik = new File(stView.getTfGrafik().getText());
		} catch (NumberFormatException e) {
			istKeineZahl = true;
		}
	}
	
	//Methode, welche eine Strecke in der Datenbank erstellt
	private void erstelleStreckeInDB(){
		if(status == 'p'){
				typ = "true";
		}
		String abfrage = "insert into strecke values('" + name + "','" + laenge + "','" + schwierigkeit + "','" + typ + "'," + punktzahl + ",null)";
		Datenbankschnittstelle.executeQuery(abfrage);
		Datenbankschnittstelle.closeConnections();
	}
	
	//Methode, welche die in der Datenbank erstellte Strecke um eine Grafik ergaenzt
	private void updateKartGrafik(){
		String updateBild = "update strecke set grafik =? where streckenname ='" + name + "'";
		Datenbankschnittstelle.uploadBlob(updateBild,grafik);
		Datenbankschnittstelle.closeConnections();
	}
	
	//Methode, die das Formular leeren soll
	private void leereFormular() {
		stView.getTfName().setText("");
		stView.getTfLaenge().setText("");
		stView.getTfSchwierigkeit().setText("");
		stView.getTfPunktzahl().setText("");
		stView.getTfGrafik().setText("");
		stView.getBgStatus().clearSelection();
	}
	
	//Getter fuer View
	public StreckeHinzufügenView getView() {
		return stView;
	}
}
