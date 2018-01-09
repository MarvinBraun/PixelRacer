package KartBearbeiten;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.JFileChooser;
import Kart.Kart;
import Kart.Kartverwaltung;
import KartHinzufügen.KartHinzufügenView;

/**
@author Sean Cartner
*/

public class KartBearbeitenStrg implements ActionListener{
	
	private KartBearbeitenView kbv;
	private KartHinzufügenView khv;
	private LinkedList<Kart> kartliste;
	
	public KartBearbeitenStrg() {
		kbv = new KartBearbeitenView();
		ladeKarts();
		kbv.getBtnWeiter().addActionListener(this);
		kbv.getCardPanel().add("Auswahl", kbv.getAuswahlPanel());
		khv = new KartHinzufügenView();
		khv.getLblKartHinzufgen().setText("Kart Bearbeiten");
		khv.getBtnAbbrechen().addActionListener(this);;
		khv.getBtnAuswaehlen().addActionListener(this);
		kbv.getCardPanel().add("Formular", khv);

	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == kbv.getBtnWeiter()) {
			kbv.getCl().show(kbv.getCardPanel(), "Formular");
			ladeKartDaten();
			khv.getTfName().setEditable(false);
		}
		if(e.getSource() == khv.getBtnAbbrechen()) {
			kbv.getCl().show(kbv.getCardPanel(), "Auswahl");
		}
		if(e.getSource() == khv.getBtnAuswaehlen()) {
			//FileChooser aufrufen
			khv.getFc().setFileFilter(khv.getFilter());
			int rueckgabeWert = khv.getFc().showOpenDialog(null);
			if(rueckgabeWert == JFileChooser.APPROVE_OPTION){
				khv.getTfGrafik().setText(khv.getFc().getSelectedFile().getAbsolutePath());
			}
		}
	}
	
	private void ladeKarts() {
		Kartverwaltung kw = new Kartverwaltung();
		kartliste = kw.gibKart();
		
		for(Kart kart: kartliste) {
			kbv.getComboBoxKart().addItem(kart.getKartname());
		}
		
	}
	
	private void ladeKartDaten(){
		String auswahl = (String) kbv.getComboBoxKart().getSelectedItem();
		for(Kart kart: kartliste){
			if(auswahl.equals(kart.getKartname())){
				khv.getTfName().setText(kart.getKartname());
				khv.getTfBeschleunigung().setText(String.valueOf(kart.getBeschleunigung()));
				khv.getTfGeschwindigkeit().setText(String.valueOf(kart.getMaxkmh()));
				khv.getTfPunktzahl().setText(String.valueOf(kart.getPunktewert()));
				if(kart.getPremium().equals("true")){
					khv.getRbPremium().setSelected(true);
				}else if(kart.getPremium().equals("false")){
					khv.getRbFree().setSelected(true);
				}
			}
		}
	}

	public KartBearbeitenView getView() {
		return kbv;
	}
	
}
