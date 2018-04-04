package Rechnung;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import Anmelden.AnmeldenStrg;
import Kart.Kart;
import Startansicht.StartansichtStrg;
import Strecke.Strecke;
import oracle.sql.DATE;

/**
 * Die Klasse RechnungAnzeigenStrg steuert das anzeigen der einzelnen Rechnungen.
 * Sie verwaltet dabei die grafische Benutzeroberflächen Rechnungsübersicht und RechnungAnzeigenView.
 * @author Daniel Zeller
 *
 */
public class RechnungAnzeigenStrg implements ActionListener{

	RechnungAnzeigenView view;
	Rechnung r;
	Kart k;
	Strecke s;
	
	
	public RechnungAnzeigenStrg(Rechnung r) {
		
		view = new RechnungAnzeigenView();
		view.getFrame().setLocationRelativeTo(null);
		view.getBtnZuruck().addActionListener(this);
		ladeDaten(r);
		
	}
	
	public static void main(String[] args) {
		
	
	}
	
	private void ladeDaten(Rechnung r){
		
		view.getLblBenutzernamefeld().setText(r.benutzername);
		view.getLblRechnungsnummerfeld().setText(Integer.toString(r.getRechnungsnummer()));
		view.getLblKartnamefeld().setText(r.getKartname());
		view.getLblRechnungsdatumfeld().setText(r.getRechnungsdatum());
		view.getLblBezahlmethodefeld().setText(r.getBezahlmethode());
		view.getLblRechnungsbetragfeld().setText(Integer.toString(r.rechnungsbetrag));
		
	
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource() == view.getBtnZuruck()){
			MusicHandler.MusicPlayer.forwardBtn();
			RechnungsuebersichtStrg strg = new RechnungsuebersichtStrg();
			view.getFrame().dispose();
		}
}
}