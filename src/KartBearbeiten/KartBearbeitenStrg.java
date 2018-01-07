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
		}
	}
	
	private void ladeKarts() {
		Kartverwaltung kw = new Kartverwaltung();
		kartliste = kw.gibKart();
		
		for(Kart kart: kartliste) {
			kbv.getCB().addItem(kart.getKartname());
		}
		
	}
	
	public KartBearbeitenView getView() {
		return kbv;
	}
}
