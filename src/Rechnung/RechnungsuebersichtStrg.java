package Rechnung;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.SwingUtilities;
import Iterator.IteratorString;
import Kart.Kart;
import Nutzer.Nutzerverwaltung;
import ProfilKunde.AnzeigenProfilKundeStrg;
import Startansicht.StartansichtStrg;
import Strecke.Strecke;


public class RechnungsuebersichtStrg implements ActionListener {

	RechnungsuebersichtView viewUebersicht;
	Rechnung r;
	Kart k;
	
	Rechnungsverwaltung rw;


	LinkedList<Rechnung> KartRechnungsListe = new LinkedList<Rechnung>();
	
	public static void main(String[] args) {

		RechnungsuebersichtStrg steuerung = new RechnungsuebersichtStrg();

	}

	public RechnungsuebersichtStrg() {

		viewUebersicht = new RechnungsuebersichtView();
		
		viewUebersicht.getFrame().setLocationRelativeTo(null);
	
		ladeDrop();
		rw = new Rechnungsverwaltung();
		KartRechnungsListe = rw.gibKartRechnungenfuerBenutzer();
		
		viewUebersicht.getBtnanz().addActionListener(this);
		viewUebersicht.getBtnzurück().addActionListener(this);


		SwingUtilities.updateComponentTreeUI(viewUebersicht.getFrame());

	}

	private void ladeDrop() {
		
	KartRechnungsListe =  Rechnungsverwaltung.gibKartRechnungenfuerBenutzer();
	
	JComboBox<Integer> box = viewUebersicht.getDrop();
	
	for(Rechnung r : KartRechnungsListe)
	{
		box.addItem(r.getRechnungsnummer());
	}

	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==viewUebersicht.getBtnanz())
		{
		MusicHandler.MusicPlayer.forwardBtn();
		
		int rechnr = (int) viewUebersicht.getDrop().getSelectedItem();
		
		for(Rechnung r : KartRechnungsListe)
		{
			if(rechnr == r.rechnungsnummer)
			{
				RechnungAnzeigenStrg strg = new RechnungAnzeigenStrg(r);
			
				viewUebersicht.getFrame().dispose();
				break;
			}
				
		}
		
		
		}
		if(e.getSource()==viewUebersicht.getBtnzurück())
		{
			MusicHandler.MusicPlayer.backwardBtn();
			AnzeigenProfilKundeStrg strg = new AnzeigenProfilKundeStrg();
			viewUebersicht.getFrame().dispose();
		}
		// TODO Auto-generated method stub
		
	}
}
