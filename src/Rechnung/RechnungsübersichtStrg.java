package Rechnung;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Datenbankverwaltung.Datenbankschnittstelle;



public class RechnungsübersichtStrg implements ActionListener {
	
	
	private String benutzername;
	private int rechnungsbetrag;
	private int rechnungsdatum;
	private String bezahlmethode;
	private String streckenname;
	private String kartname;

	Rechnungsübersicht rues;
			
			
	public RechnungsübersichtStrg() {
			rues = new Rechnungsübersicht();
			rues.getFrmRechnungsbersicht().setVisible(true);
				
			rues.getBtnAnzeigen().addActionListener(this);
			rues.getBtnBezahlen().addActionListener(this);
			rues.getBtnSpeichern().addActionListener(this);
			}
			
			public static void main(String[] args) {
				RechnungsübersichtStrg strg = new RechnungsübersichtStrg();
			}
	
			

			public void InsertIntoKunde() {
			String update = ("insert into rechnung values('" + benutzername + "','" + rechnungsbetrag + "','" + rechnungsdatum
					+ "','" + bezahlmethode + "','false',0,'" + streckenname + "','" + kartname +"')");
			
			Datenbankschnittstelle.executeUpdate(update);
			Datenbankschnittstelle.closeConnections();
		}

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				if (e.getSource() == rues.getBtnAnzeigen()) {
					
					rues.frmRechnungsbersicht.dispose();
					RechnungsübersichtStrg strg = new RechnungsübersichtStrg();		
				}
				if (e.getSource() == rues.getBtnBezahlen()) {
					
					rues.frmRechnungsbersicht.dispose();
					getFrmRechnungsbersicht.setVisible(true);
					
					
				}
				
			
		

	}
	
	
	
	
	
	
	
	
	
	
	

}
