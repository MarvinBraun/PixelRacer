package StreckeBearbeiten;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.JFileChooser;
import Strecke.Strecke;
import Strecke.Streckenverwaltung;
import StreckeHinzufügen.StreckeHinzufügenView;

/**
@author Sean Cartner
*/

public class StreckeBearbeitenStrg implements ActionListener{
	
	private StreckeBearbeitenView sbv;
	private StreckeHinzufügenView shv;
	private LinkedList<Strecke> streckenliste;
	
	public StreckeBearbeitenStrg() {
		sbv = new StreckeBearbeitenView();
		ladeStrecken();
		sbv.getBtnWeiter().addActionListener(this);
		sbv.getCardPanel().add("Auswahl", sbv.getAuswahlPanel());
		shv = new StreckeHinzufügenView();
		shv.getLblStrecke().setText("Strecke Bearbeiten");
		shv.getBtnAbbrechen().addActionListener(this);;
		shv.getBtnAuswhlen().addActionListener(this);
		shv.getBtnAbsenden().addActionListener(this);
		sbv.getCardPanel().add("Formular", shv);

	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == sbv.getBtnWeiter()) {
			sbv.getCl().show(sbv.getCardPanel(), "Formular");
			ladeStreckenDaten();
			shv.getTfName().setEditable(false);
		}
		if(e.getSource() == shv.getBtnAbbrechen()) {
			sbv.getCl().show(sbv.getCardPanel(), "Auswahl");
		}
		if(e.getSource() == shv.getBtnAuswhlen()) {
			//FileChooser aufrufen
			shv.getFileChooser().setFileFilter(shv.getFilter());
			int rueckgabeWert = shv.getFileChooser().showOpenDialog(null);
			if(rueckgabeWert == JFileChooser.APPROVE_OPTION){
				shv.getTfGrafik().setText(shv.getFileChooser().getSelectedFile().getAbsolutePath());
			}
		}
	}
	
	private void ladeStrecken() {
		Streckenverwaltung sw = new Streckenverwaltung();
		streckenliste = sw.gibStrecke();
		
		for(Strecke strecke: streckenliste) {
			sbv.getComboBoxStrecke().addItem(strecke.getStreckenname());
		}
		
	}
	
	private void ladeStreckenDaten(){
		String auswahl = (String) sbv.getComboBoxStrecke().getSelectedItem();
		for(Strecke strecke: streckenliste){
			if(auswahl.equals(strecke.getStreckenname())){
				shv.getTfName().setText(strecke.getStreckenname());
				shv.getTfLaenge().setText(String.valueOf(strecke.getLaenge()));
				shv.getTfSchwierigkeit().setText(String.valueOf(strecke.getSchwierigkeit()));
				shv.getTfPunktzahl().setText(String.valueOf(strecke.getPunktewert()));
				if(strecke.getPremium().equals("true")){
					shv.getRbPremium().setSelected(true);
				}else if(strecke.getPremium().equals("false")){
					shv.getRbFree().setSelected(true);
				}
			}
		}
	}

	public StreckeBearbeitenView getView() {
		return sbv;
	}
	
}
