/**
 @author Sean Cartner
*/

package StreckeHinzufügen;

import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import Datenbankverwaltung.Datenbankschnittstelle;

import java.awt.event.ActionEvent;

public class StreckeHinzufügenStrg implements ActionListener {
	
	//Globae Variablen
	private StreckeHinzufügenView stView;
	private String laengeOk = "true";
	private String fehlermeldung = "Folgende Angaben sind zu lang:";
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
		stView.frmPixelRacer.setVisible(true);
		stView.btnAuswhlen.addActionListener(this);
		stView.btnAbsenden.addActionListener(this);
	}

	//Methode, die auf aufgerufen wird, wenn ein Button gedrueckt wird
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==stView.btnAuswhlen){
			//FileChooser aufrufen
			stView.fc.setFileFilter(stView.filter);
			int rueckgabeWert = stView.fc.showOpenDialog(null);
			if(rueckgabeWert == JFileChooser.APPROVE_OPTION){
				stView.textFieldGrafik.setText(stView.fc.getSelectedFile().getAbsolutePath());
			}
		} 
		if(e.getSource() == stView.btnAbsenden){
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
				erstelleStreckeInDB();
				updateKartGrafik();
			}
				}
		}
	}
	
	//Meldung, die erscheint, wenn Formular nicht vollstaendig ausgefuellt ist
	private void formularUnvollständigMeldung(){
		JOptionPane.showMessageDialog(stView.frmPixelRacer,
			    "Alle Felder müssen ausgefüllt sein!", "Formular unvollständig",
			    JOptionPane.WARNING_MESSAGE);
	}
	
	//Meldung, die erscheint, wenn die Eingabe zu einem oder mehreren Feldern zu lang ist
	private void inhaltZuLangMeldung(){
		JOptionPane.showMessageDialog(stView.frmPixelRacer,
			    fehlermeldung, "Inhalt zu lang",
			    JOptionPane.WARNING_MESSAGE);
	}
	
	//Meldung, die erscheint, wenn ein Zahlen-Feld mit sonstigen Zeichen befuellt wird
	public void istKeineZahl(){
		JOptionPane.showMessageDialog(stView.frmPixelRacer,
			   "Länge, Schwierigkeit und Punktzahl müssen eine Zahl sein!", "Keine Zahl",
			    JOptionPane.WARNING_MESSAGE);
	}
	
	//Methode, welche pruefen soll, ob das Formular auch vollstaendig ausgefuellt ist
	private boolean pruefeFormarAufVollständigkeit(){
		if(stView.textFieldName.getText().isEmpty() || stView.textFieldLaenge.getText().isEmpty() || 
				stView.textFieldSchwierigkeit.getText().isEmpty() || stView.textFieldPunktzahl.getText().isEmpty() ||
				stView.textFieldGrafik.getText().isEmpty() || stView.bgStatus.getSelection() == null){
		return false;
		}
		return true;
	}
	
	//Methode, welche die Laenge des Namen-Feldes kontrollieren soll
	private void istNameZuLang(){
		if(stView.textFieldName.getText().length() > 20){
			laengeOk = "false";
			fehlermeldung = fehlermeldung + "  " + "Name";
		}	
	}
	
	//Methode, welche die Laenge des Länge-Feldes kontrollieren soll
	private void istLaengeZuLang(){
		if(stView.textFieldLaenge.getText().length() > 5){
			laengeOk = "false";
			fehlermeldung = fehlermeldung + "  " + "Länge";
		}
	}
	
	//Methode, welche die Laenge des Schwierigkeit-Feldes kontrollieren soll
	private void istSchwierigkeitZuLang(){
		if(stView.textFieldSchwierigkeit.getText().length() > 1){
			laengeOk = "false";
			fehlermeldung = fehlermeldung + "  " + "Schwierigkeit";
		}
	}
	
	//Methode, welche die Laenge des Punktzahl-Feldes kontrollieren soll
	private void istPunktzahlZuLang(){
		if(stView.textFieldPunktzahl.getText().length() > 2){
			laengeOk = "false";
			fehlermeldung = fehlermeldung + "  " + "Punktzahl";
		}
	}
	
	//Methode, in die Datenbank relevanten Variablen aufgrundlage des Formulars deklariert werden
	private void deklariereVariablenVTextfeldern(){
		try {
		name = stView.textFieldName.getText();
		laenge = Integer.parseInt(stView.textFieldLaenge.getText());
		schwierigkeit = Integer.parseInt(stView.textFieldSchwierigkeit.getText());
		punktzahl = Integer.parseInt(stView.textFieldPunktzahl.getText());
		status = stView.rdbtnFree.isSelected()?'f':(stView.rdbtnPremium.isSelected()?'p':' ');
		grafik = new File(stView.textFieldGrafik.getText());
		} catch (NumberFormatException e) {
			istKeineZahl();
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
}
