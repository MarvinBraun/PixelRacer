package Rechnung;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import Anmelden.AnmeldenStrg;
import Kart.Kart;
import Startansicht.StartansichtStrg;
import Strecke.Strecke;

/**
 * Die Klasse RechnungAnzeigenStrg steuert das anzeigen der einzelnen Rechnungen.
 * Sie verwaltet dabei die grafische Benutzeroberflächen Rechnungsübersicht und RechnungAnzeigenView.
 * @author Daniel Zeller
 *
 */
public class RechnungAnzeigenStrg implements ActionListener{

	RechnungAnzeigenView view;
	static Rechnung r;
	Kart k;
	Strecke s;
	
	
	public RechnungAnzeigenStrg(Rechnung r) {
		
		view = new RechnungAnzeigenView();
		view.getFrame().setLocationRelativeTo(null);
		
		ladeDaten();
		
	}
	
	public static void main(String[] args) {
		
		RechnungAnzeigenStrg steuerung = new RechnungAnzeigenStrg(r);
	}
	
	private void ladeDaten(){
		
	}
	
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource() == view.getBtnZuruck()){
			MusicHandler.MusicPlayer.forwardBtn();
			RechnungsuebersichtStrg strg = new RechnungsuebersichtStrg();
			view.getFrame().dispose();
		}
}
}