/**
 @author Sean Cartner
*/

package KartHinzuf�gen;

import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.activation.MimetypesFileTypeMap;
import Datenbankverwaltung.Datenbankschnittstelle;

import java.awt.event.ActionEvent;

public class KartHinzuf�genStrg implements ActionListener {
	
	//Globae Variablen
	private KartHinzuf�genView khView;
	private String laengeOk = "true";
	private String fehlermeldung = "Folgende Angaben sind zu lang:";
	private boolean istKeineZahl = false;
	private String name;
	private String typ;
	private int beschleunigung;
	private int maxGeschwindigkeit;
	private int punktzahl;
	private char status;
	private File grafik;
	
	//Konstruktor
	public KartHinzuf�genStrg(){
		khView = new KartHinzuf�genView();
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
			if(pruefeFormarAufVollst�ndigkeit() == false){
				formularUnvollst�ndigMeldung();
			} else{
			istNameZuLang();
			istBeschleunigungZuLang();
			istMaxGeschwindigkeitZuLang();
			istPunktzahlZuLang();
			if(laengeOk == "false"){
				inhaltZuLangMeldung();
				//reset
				fehlermeldung = "Folgende Angaben sind zu lang:";
				laengeOk = "true";
			} else{
				deklariereVariablenVTextfeldern();
				if(istKeineZahl == true){
					istKeineZahlMeldung();
					//reset
					istKeineZahl = false;
				}else{
					if(!grafik.exists()){
						keineDateiGefundenMeldung();
					}else{
						if(IstGrafikPng() == false){
							nichtPngMeldung();
						}else{
							if(grafik.length() > 20480){
								grafikZuGrossMeldung();
							}else{
								erstelleKartInDB();
								updateKartGrafik();
								leereFormular();
							}
						}
					}
				}
			}
				}
		}
		//Soll Formular bei Abbruch leeren
		if(e.getSource() == khView.getBtnAbbrechen()) {
			leereFormular();
		}
	}
	
	//Meldung, die erscheint, wenn Formular nicht vollstaendig ausgefuellt ist
	private void formularUnvollst�ndigMeldung(){
		JOptionPane.showMessageDialog(khView.getPanel(),
			    "Alle Felder m�ssen ausgef�llt sein!", "Formular unvollst�ndig",
			    JOptionPane.WARNING_MESSAGE);
	}
	
	//Meldung, die erscheint, wenn die Eingabe zu einem oder mehreren Feldern zu lang ist
	private void inhaltZuLangMeldung(){
		JOptionPane.showMessageDialog(khView.getPanel(),
			    fehlermeldung, "Inhalt zu lang",
			    JOptionPane.WARNING_MESSAGE);
	}
	
	//Meldung, die erscheint, wenn ein Zahlen-Feld mit sonstigen Zeichen befuellt wird
	public void istKeineZahlMeldung(){
		JOptionPane.showMessageDialog(khView.getPanel(),
			   "Beschleunigung, MaxGeschwindkeit und Punktzahl m�ssen eine Zahl sein!", "Keine Zahl",
			    JOptionPane.WARNING_MESSAGE);
	}
	
	//Meldung, die erscheint, wenn Grafik nicht existiert
	public void keineDateiGefundenMeldung(){
		JOptionPane.showMessageDialog(khView.getPanel(),
			   "Es wurde keine Datei unter dem angegebenen Pfad gefunden", "Keine Datei gefunden",
			    JOptionPane.WARNING_MESSAGE);
	}
	
	//Meldung, die erscheint, wenn Grafik nicht im png Formart vorliegt
	public void nichtPngMeldung(){
		JOptionPane.showMessageDialog(khView.getPanel(),
			   "Die Grafik muss im Format .png vorliegen", "Grafik liegt nicht im PNG Format vor",
			    JOptionPane.WARNING_MESSAGE);
	}
	
	//Meldung, die erscheint, wenn Grafik zu Gross (in Speicher) ist
	public void grafikZuGrossMeldung(){
		JOptionPane.showMessageDialog(khView.getPanel(),
			   "Die Grafik darf maximal 20kb gro� sein", "Grafik zu Gro�",
			    JOptionPane.WARNING_MESSAGE);
	}
	
	//Methode, welche pruefen soll, ob das Formular auch vollstaendig ausgefuellt ist
	private boolean pruefeFormarAufVollst�ndigkeit(){
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
		name = khView.getTfName().getText();
		beschleunigung = Integer.parseInt(khView.getTfBeschleunigung().getText());
		maxGeschwindigkeit = Integer.parseInt(khView.getTfGeschwindigkeit().getText());
		punktzahl = Integer.parseInt(khView.getTfPunktzahl().getText());
		status = khView.getRbFree().isSelected()?'f':(khView.getRbPremium().isSelected()?'p':' ');
		grafik = new File(khView.getTfGrafik().getText());
		} catch (NumberFormatException e) {
			istKeineZahl = true;
		}
	}
	
	//Methode, welche ein Kart in der Datenbank erstellt
	private void erstelleKartInDB(){
		if(status == 'p'){
				typ = "true";
		} else{
			typ = "false";
		}
		String abfrage = "insert into kart values('" + name + "','" + beschleunigung + "',"
				+ "'" + maxGeschwindigkeit + "','" + typ + "'," + punktzahl + ",null)";
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
		khView.getTfName().setText("");
		khView.getTfBeschleunigung().setText("");
		khView.getTfGeschwindigkeit().setText("");
		khView.getTfPunktzahl().setText("");
		khView.getTfGrafik().setText("");
		khView.getBgStatus().clearSelection();
	}
	
	//Getter f�r die View
	public KartHinzuf�genView getView() {
		return khView;
	}
}
