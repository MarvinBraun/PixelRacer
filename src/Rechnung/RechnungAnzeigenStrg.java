package Rechnung;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import Anmelden.AnmeldenStrg;
import Startansicht.StartansichtStrg;

/**
 * Die Klasse RechnungAnzeigenStrg steuert das anzeigen der einzelnen Rechnungen.
 * Sie verwaltet dabei die grafische Benutzeroberfl�chen Rechnungs�bersicht und anzeigenRechnung_ansicht2.
 * @author Daniel Zeller
 *
 */
public class RechnungAnzeigenStrg implements ActionListener{
	Rechnungs�bersicht view1;
	anzeigenRechnung_ansicht2 view2;
	anzeigenRechnung_ansicht2 view3;
	
	private Rechnung r;
	private LinkedList<Rechnung> rliste;
	
	public RechnungAnzeigenStrg() {
		view1 = new Rechnungs�bersicht();
		view1.getFrmRechnungsbersicht().setVisible(true);
		
		view1.getBtnAnzeigen().addActionListener(this);
		view1.getBtnBezahlen().addActionListener(this);
		view1.getBtnSpeichern().addActionListener(this);
		view1.getBtnZuruck().addActionListener(this);
		
		view2 = new anzeigenRechnung_ansicht2();
		view2.getBtnZuruck().addActionListener(this);
		
		view3 = new anzeigenRechnung_ansicht2();
		view3.getBtnZuruck().addActionListener(this);
	}
	
	public static void main(String[] args) {
		RechnungAnzeigenStrg strg = new RechnungAnzeigenStrg();
	}
	
	/**
	 * Vergleicht die eingegebene Rechnungsnummer mit den Rechnungsnummern des Benutzers f�r die Karts.
	 * @return Boolean
	 */
	public Boolean VergleichRnrKarts() {
		try {
			String rnr = view1.getTextField().getText();
			rliste = Rechnungsverwaltung.gibKartRechnungenfuerBenutzer();
			
			for(Rechnung temp: rliste) {
				String rnrListe = String.valueOf(temp.getRechnungsnummer());
				if(rnr.equals(rnrListe)) {
					r = temp;
					return true;
				}
			}
		}
		
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Die Daten konnten nicht �berpr�ft werden!",null, JOptionPane.ERROR_MESSAGE);
		}
		
		return false;
	}
	/**
	 * Vergleicht die eingegebene Rechnungsnummer mit den Rechnungsnummern des Benutzers f�r die Strecken.
	 * @return Boolean
	 */
	public Boolean VergleichRnrStrecke() {
		try {
			String rnr = view1.getTextField().getText();
			rliste = Rechnungsverwaltung.gibStreckenRechnungenfuerBenutzer();
			
			for(Rechnung temp: rliste) {
				String rnrListe = String.valueOf(temp.getRechnungsnummer());
				if(rnr.equals(rnrListe)) {
					r = temp;
					return true;
				}
			}
		}
		
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Die Daten konnten nicht �berpr�ft werden!",null, JOptionPane.ERROR_MESSAGE);
		}
		
		return false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == view1.getBtnAnzeigen()) {
			if(VergleichRnrKarts()) {
				view2.getLblRechnungsnummer().setText("Rechnungsnummer: " + r.getRechnungsnummer());
				view2.getLblRechnungsdatum().setText("Rechnungsdatum: " + r.getRechnungsdatum());
				view2.getLblBenutzername().setText("Benutzername: " + r.getBenutzername());
				view2.getLblStreckenname_1().setText("Streckenname: " + r.getStreckenname());
				view2.getLblKartname().setText("Kartname: " + r.getKartname());
				view2.getLblPremium().setText("Premium: ");
				view2.getLblBezahlmethode().setText("Bezahlmethode: " + r.getBezahlmethode() );
				view2.getLblRechnungsbetrag().setText("Rechnungsbetrag: " + r.getRechnungsbetrag());
				view2.getFrmRechnungs�bersicht().setVisible(true);
			}
			
			if(VergleichRnrStrecke()){
				view3.getLblRechnungsnummer().setText("Rechnungsnummer: " + r.getRechnungsnummer());
				view3.getLblRechnungsdatum().setText("Rechnungsdatum: " + r.getRechnungsdatum());
				view3.getLblBenutzername().setText("Benutzername: " + r.getBenutzername());
				view3.getLblStreckenname_1().setText("Streckenname: " + r.getStreckenname());
				view3.getLblKartname().setText("Kartname: " + r.getKartname());
				view3.getLblPremium().setText("Premium: ");
				view3.getLblBezahlmethode().setText("Bezahlmethode: " + r.getBezahlmethode() );
				view3.getLblRechnungsbetrag().setText("Rechnungsbetrag: " + r.getRechnungsbetrag());
				view3.getFrmRechnungs�bersicht().setVisible(true);
			}
			
			else {
				JOptionPane.showMessageDialog(null, "Rechnungsnummer exisitiert nicht!", "Ohoh!", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if(e.getSource() == view1.getBtnBezahlen()) {
			
		}
		
		if(e.getSource() == view1.getBtnSpeichern()) {
			
		}
		
		if(e.getSource() == view1.getBtnZuruck()) {
			view1.getFrmRechnungsbersicht().dispose();
			view2.getFrmRechnungs�bersicht().dispose();
			view3.getFrmRechnungs�bersicht().dispose();
			StartansichtStrg strg = new StartansichtStrg();
		}
		
		if(e.getSource() == view2.getBtnZuruck()) {
			view2.getFrmRechnungs�bersicht().dispose();
		}
		
		if(e.getSource() == view3.getBtnZuruck()) {
			view3.getFrmRechnungs�bersicht().dispose();
		}
	}
}
