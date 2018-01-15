package Rechnung;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

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
		view1.getFrmBezahlung().setVisible(true);
		
		view1.getBtnEinloggen().addActionListener(this);
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
		view1.getFrmBezahlung().setVisible(true);
		
		view1.getBtnEinloggen().addActionListener(this);
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
		view1.getFrmBezahlung().setVisible(true);
		
		view1.getBtnEinloggen().addActionListener(this);
		view1.getBtnAbbrechen().addActionListener(this);
	}
	
	public static void main(String[] args) {
		RechnungBezahlenStrg strg = new RechnungBezahlenStrg();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == view1.getBtnAbbrechen()) {
			MusicHandler.MusicPlayer.backwardBtn();
			view1.getFrmBezahlung().dispose();
			StartansichtStrg strg = new StartansichtStrg();
		}
		
		if(e.getSource() == view1.getBtnEinloggen()) {
			MusicHandler.MusicPlayer.startGame();
			if(auswahl == 'p') {
				try {
					
					String update = "Update kunde set premium = 'true' where benutzername = '" + Nutzerverwaltung.getangKunde().getnutzername() + "'";
					Datenbankschnittstelle.executeUpdate(update);
					Datenbankschnittstelle.closeConnections();
					Nutzerverwaltung.getangKunde().aktualisereangKunde();
					view1.getFrmBezahlung().dispose();
					StartansichtStrg strg = new StartansichtStrg();
				}
				
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Die Daten konnten nicht aktualisiert werden!",null, JOptionPane.ERROR_MESSAGE);
				}
			}
			
			if(s == null && k != null) {
				try {
					Rechnungsverwaltung.sendeKartRechnung(k);
					view1.getFrmBezahlung().dispose();
					StartansichtStrg strg = new StartansichtStrg();
				}
				
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Es konnte nicht auf die Datenbank zugegriffen werden!",null, JOptionPane.ERROR_MESSAGE);
				}
			}
			
			if(k == null && s != null) {
				try {
					Rechnungsverwaltung.sendeStreckenRechnung(s);
					view1.getFrmBezahlung().dispose();
					StartansichtStrg strg = new StartansichtStrg();
				}
				
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Es konnte nicht auf die Datenbank zugegriffen werden!",null, JOptionPane.ERROR_MESSAGE);
				}
				
			}
		}
	}

}
