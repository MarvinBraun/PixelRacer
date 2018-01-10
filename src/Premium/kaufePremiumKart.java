package Premium;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Kart.AnzeigenKartStrg;
import Kart.Kart;
import Kart.Kartuebersicht;
import ProfilKunde.AnzeigenProfilKundeStrg;
import Rechnung.RechnungBezahlenStrg;
import Rechnung.RechnungsübersichtStrg;
import Rechnung.anzeigenRechnungStrg;
import Rechnung.anzeigenRechnung_ansicht2;

/**
 * kaufePremiumKart ist ein Pop-up Fenster, das die grafische Oberfläche PremiumKartView steuert.
 * @author Ferhat Koca
 *
 */
public class kaufePremiumKart extends JFrame implements ActionListener {

	PremiumKartView pkv;
	RechnungsübersichtStrg anzr;
	Kart k; 
	Kartuebersicht viewUebersicht;

	/**
	 * Die Methode actionPerformed liest den Button, auf den der Nutzer in der View
	 * klickt, aus und führt den jeweiligen Befehl aus.
	 * 
	 * Das Drücken auf den bestätigen Button führt dazu das der Nutzer weiter zur
	 * Rechnungsübersicht geleitet wird. Das Drücken auf Abbrechen bricht den
	 * Kaufprozess ab.
	 */
		public void actionPerformed(ActionEvent e) {
		if (e.getSource() == pkv.bestätigen) {
			pkv.frame.dispose();
			viewUebersicht.getFrame().dispose();
			RechnungBezahlenStrg strg = new RechnungBezahlenStrg(k);
			
		}
		if (e.getSource() == pkv.abbrechen) {
			pkv.frame.dispose();
			
		}
	}

	/**
	 * Der Konstruktor erzeugt die Klasse als neues Objekt und deklariert die Variablen.
	 * 
	 */
	public kaufePremiumKart(Kart k, Kartuebersicht viewUebersicht) {
		pkv = new PremiumKartView();
		pkv.frame.setVisible(true);
		pkv.bestätigen.addActionListener(this);
		pkv.abbrechen.addActionListener(this);
		this.k = k;
		this.viewUebersicht = viewUebersicht;
	}

	public static void main(String[] args) {
		
	}
}
