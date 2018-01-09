package Rechnung;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Anmelden.AnmeldenStrg;
import Datenbankverwaltung.Datenbankschnittstelle;
import Kart.Kart;
import Nutzer.Nutzerverwaltung;
import Startansicht.StartansichtStrg;
import Strecke.Strecke;

/**
 * Die Klasse RechnungBezahlenStrg steuert das bezahlen einer Rechnung.
 * Sie verwaltet dabei die grafische Benutzeroberfläche RechnungBezahlenView.
 * @author Daniel Zeller
 *
 */

public class RechnungBezahlenStrg implements ActionListener {
	RechnungBezahlenView view1;
	private Strecke s;
	private Kart k;
	private char auswahl;
	
	/**
	 * Wird aufgerufen wenn ein Premiumaccount gekauft wird.
	 */
	public RechnungBezahlenStrg() {
		auswahl = 'p';
		
		view1 = new RechnungBezahlenView();
		view1.getFrmRechnungBezahlen().setVisible(true);
		
		view1.getBtnBezahlen().addActionListener(this);
		view1.getBtnAbbrechen().addActionListener(this);
	}
	/**
	 * Wird aufgerufen wenn ein Kart gekauft wird. Das dabei gekaufte Kart wird übergeben.
	 * @param k2
	 */
	public RechnungBezahlenStrg(Kart k2) {
		auswahl = 'x';
		k = k2;
		s = null;
		
		view1 = new RechnungBezahlenView();
		view1.getFrmRechnungBezahlen().setVisible(true);
		
		view1.getBtnBezahlen().addActionListener(this);
		view1.getBtnAbbrechen().addActionListener(this);
	}
	/**
	 * Wird aufgerufen wenn eine Strecke gekauft wird. Die dabei gekaufte Strecke wird übergeben.
	 * @param k2
	 */
	public RechnungBezahlenStrg(Strecke s2) {
		auswahl = 'x';
		s = s2;
		k = null;
		
		view1 = new RechnungBezahlenView();
		view1.getFrmRechnungBezahlen().setVisible(true);
		
		view1.getBtnBezahlen().addActionListener(this);
		view1.getBtnAbbrechen().addActionListener(this);
	}
	
	public static void main(String[] args) {
		RechnungBezahlenStrg strg = new RechnungBezahlenStrg();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == view1.getBtnAbbrechen()) {
			view1.getFrmRechnungBezahlen().dispose();
			StartansichtStrg strg = new StartansichtStrg();
		}
		
		if(e.getSource() == view1.getBtnBezahlen()) {
			if(auswahl == 'p') {
				String update = "Update kunde set premium = 'true' where benutzername = '" + Nutzerverwaltung.getangKunde().getnutzername() + "'";
				Datenbankschnittstelle.executeUpdate(update);
				Datenbankschnittstelle.closeConnections();
				view1.getFrmRechnungBezahlen().dispose();
				StartansichtStrg strg = new StartansichtStrg();
			}
			
			if(s == null && k != null) {
				Rechnungsverwaltung.sendeKartRechnung(k);
				view1.getFrmRechnungBezahlen().dispose();
				StartansichtStrg strg = new StartansichtStrg();
			}
			
			if(k == null && s != null) {
				Rechnungsverwaltung.sendeStreckenRechnung(s);
				view1.getFrmRechnungBezahlen().dispose();
				StartansichtStrg strg = new StartansichtStrg();
			}
		}
	}

}
