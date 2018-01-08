package KartBearbeiten;

import Kart.Kart;
import Kart.Kartverwaltung;
import KartHinzufügen.KartHinzufügenView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import Anmelden.AnmeldenStrg;


/**
@author Sean Cartner
*/

public class KartBearbeitenStrg implements ActionListener {
	
	private KartBearbeitenView kbv;
	private LinkedList<Kart> kartliste;
	private KartHinzufügenView khv;
	
	public KartBearbeitenStrg() {
		kbv = new KartBearbeitenView();
		kbv.getPanel().setVisible(true);
		ladeKarts();
		kbv.getBtnWeiter().addActionListener(this);
		khv = new KartHinzufügenView();
		kbv.add("Formular", khv);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == kbv.getBtnWeiter()) {
			kbv.getCl().show(kbv, "Formular");
			ladeKartDaten();
		}
	}
	
	private void ladeKarts() {
		Kartverwaltung kw = new Kartverwaltung();
		kartliste = kw.gibKart();
		
		for(Kart kart: kartliste) {
			kbv.getCB().addItem(kart.getKartname());
		}
		
	}
	
	private void ladeKartDaten(){
		String auswahl = (String) kbv.getCB().getSelectedItem();
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
