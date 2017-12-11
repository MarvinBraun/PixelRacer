/**
 @author Sean Cartner
*/

package KartHinzuf�gen;

import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;

public class KartHinzuf�genStrg implements ActionListener {
	
	private KartHinzuf�genView khView;
	private String laengeOk = "true";
	private String fehlermeldung = "Folgende Angaben sind zu lang:";
	private String name;
	private int beschleunigung;
	private int maxGeschwindigkeit;
	private int punktzahl;
	private char Status;
	private File grafik;
	
	public KartHinzuf�genStrg(){
		khView = new KartHinzuf�genView();
		khView.frmPixelRacer.setVisible(true);
		khView.btnAuswhlen.addActionListener(this);
		khView.btnAbsenden.addActionListener(this);
	}

	public static void main(String[] args) {
		KartHinzuf�genStrg khStrg = new KartHinzuf�genStrg();
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==khView.btnAuswhlen){
			int rueckgabeWert = khView.fc.showOpenDialog(null);
			if(rueckgabeWert == JFileChooser.APPROVE_OPTION){
				khView.textFieldGrafik.setText(khView.fc.getSelectedFile().getAbsolutePath());
			}
		} 
		if(e.getSource() == khView.btnAbsenden){
			if(pruefeFormarAufVollst�ndigkeit() == false){
				formularUnvollst�ndigMeldung();
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
			}
				}
		}
	}
	
	private void formularUnvollst�ndigMeldung(){
		JOptionPane.showMessageDialog(khView.frmPixelRacer,
			    "Alle Felder m�ssen ausgef�llt sein!", "Formular unvollst�ndig",
			    JOptionPane.WARNING_MESSAGE);
	}
	
	private void inhaltZuLangMeldung(){
		JOptionPane.showMessageDialog(khView.frmPixelRacer,
			    fehlermeldung, "Inhalt zu lang",
			    JOptionPane.WARNING_MESSAGE);
	}
	
	public void istKeineZahl(){
		JOptionPane.showMessageDialog(khView.frmPixelRacer,
			   "Beschleunigung, MaxGeschwindkeit und Punktzahl m�ssen eine Zahl sein!", "Keine Zahl",
			    JOptionPane.WARNING_MESSAGE);
	}
	
	private boolean pruefeFormarAufVollst�ndigkeit(){
		if(khView.textFieldName.getText().isEmpty() || khView.textFieldBeschleunigung.getText().isEmpty() || 
				khView.textFieldMaxGeschwindigkeit.getText().isEmpty() || khView.textFieldPunktzahl.getText().isEmpty() ||
				khView.textFieldGrafik.getText().isEmpty() || khView.bgStatus.getSelection() == null){
		return false;
		}
		return true;
	}
	
	private void istNameZuLang(){
		if(khView.textFieldName.getText().length() > 20){
			laengeOk = "false";
			fehlermeldung = fehlermeldung + "  " + "Name";
		}	
	}
	
	private void istBeschleunigungZuLang(){
		if(khView.textFieldBeschleunigung.getText().length() > 8){
			laengeOk = "false";
			fehlermeldung = fehlermeldung + "  " + "Beschleunigung";
		}
	}
	
	private void istMaxGeschwindigkeitZuLang(){
		if(khView.textFieldMaxGeschwindigkeit.getText().length() > 8){
			laengeOk = "false";
			fehlermeldung = fehlermeldung + "  " + "MaxGeschwindigkeit";
		}
	}
	
	private void istPunktzahlZuLang(){
		if(khView.textFieldPunktzahl.getText().length() > 2){
			laengeOk = "false";
			fehlermeldung = fehlermeldung + "  " + "Punktzahl";
		}
	}
	
	private void deklariereVariablenVTextfeldern(){
		try {
		name = khView.textFieldName.getText();
		beschleunigung = Integer.parseInt(khView.textFieldBeschleunigung.getText());
		maxGeschwindigkeit = Integer.parseInt(khView.textFieldMaxGeschwindigkeit.getText());
		punktzahl = Integer.parseInt(khView.textFieldPunktzahl.getText());
		Status = khView.rdbtnFree.isSelected()?'f':(khView.rdbtnPremium.isSelected()?'p':' ');
		grafik = new File(khView.textFieldGrafik.getText());
		} catch (NumberFormatException e) {
			istKeineZahl();
		}
	}
	
	private void erstelleKartInDB(){
		
	}
}
