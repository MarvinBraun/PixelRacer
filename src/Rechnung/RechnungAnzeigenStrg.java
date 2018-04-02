package Rechnung;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import Anmelden.AnmeldenStrg;
import Startansicht.StartansichtStrg;

/**
 * Die Klasse RechnungAnzeigenStrg steuert das anzeigen der einzelnen Rechnungen.
 * Sie verwaltet dabei die grafische Benutzeroberflächen Rechnungsübersicht und RechnungAnzeigenView.
 * @author Daniel Zeller
 *
 */
public class RechnungAnzeigenStrg implements ActionListener{

	RechnungAnzeigenView view;
	Rechnung r;
	
	public RechnungAnzeigenStrg() {

	}
	
	public static void main(String[] args) {
		RechnungAnzeigenStrg strg = new RechnungAnzeigenStrg();
	}
	
	public void actionPerformed(ActionEvent e) {
	
}
}