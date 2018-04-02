package Rechnung;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.SwingUtilities;
import Iterator.IteratorString;
import Kart.Kart;
import Nutzer.Nutzerverwaltung;
import Strecke.Strecke;


public class RechnungsuebersichtStrg implements ActionListener {

	RechnungsuebersichtView viewUebersicht;
	Rechnung r;
	Kart k;
	Strecke s;

	Rechnungsverwaltung rw;


	LinkedList<Rechnung> KartRechnungsListe = new LinkedList<Rechnung>();
	LinkedList<Rechnung> StreckenRechnungsListe = new LinkedList<Rechnung>();
	
	public static void main(String[] args) {

		RechnungsuebersichtStrg steuerung = new RechnungsuebersichtStrg();

	}

	public RechnungsuebersichtStrg() {

		viewUebersicht = new RechnungsuebersichtView();
		viewUebersicht.getFrame().setLocationRelativeTo(null);

		rw = new Rechnungsverwaltung();
		KartRechnungsListe = rw.gibKartRechnungenfuerBenutzer();
		
		viewUebersicht.getBtnanz().addActionListener(this);
		viewUebersicht.getBtnzurück().addActionListener(this);


		SwingUtilities.updateComponentTreeUI(viewUebersicht.getFrame());

	}

	private void ladeDrop() {
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
