package Premium;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Kart.AnzeigenKartStrg;
import Kart.Kart;
import Kart.Kartuebersicht;
import ProfilKunde.AnzeigenProfilKundeStrg;
import Rechnung.RechnungBezahlenStrg;
import Rechnung.anzeigenRechnung_ansicht2;

/**
 * kaufePremiumKart ist ein Pop-up Fenster, das die grafische Oberflaeche PremiumKartView steuert.
 * @author Ferhat Koca
 *
 */
public class kaufePremiumKart extends JFrame implements ActionListener {

	PremiumKartView pkv;
	Kart k; 
	Kartuebersicht viewUebersicht;

	/**
	 * Die Methode actionPerformed liest den Button, auf den der Nutzer in der View
	 * klickt, aus und fuehrt den jeweiligen Befehl aus.
	 * 
	 * Das Druecken auf den bestaetigen Button fuehrt dazu das der Nutzer weiter zur
	 * Rechnungsuebersicht geleitet wird. Das Druecken auf Abbrechen bricht den
	 * Kaufprozess ab.
	 */
		public void actionPerformed(ActionEvent e) {
		if (e.getSource() == pkv.getBestaetigen()) {
			pkv.getFrame().dispose();
			viewUebersicht.getFrame().dispose();
			RechnungBezahlenStrg strg = new RechnungBezahlenStrg(k);
			
		}
		if (e.getSource() == pkv.getAbbrechen()) {
			pkv.getFrame().dispose();
			
		}
	}

	/**
	 * Der Konstruktor erzeugt die Klasse als neues Objekt und deklariert die Variablen.
	 * 
	 */
	public kaufePremiumKart(Kart k, Kartuebersicht viewUebersicht) {
		pkv = new PremiumKartView();
		pkv.getFrame().setVisible(true);
		pkv.getBestaetigen().addActionListener(this);
		pkv.getAbbrechen().addActionListener(this);
		this.k = k;
		this.viewUebersicht = viewUebersicht;
	}

	public static void main(String[] args) {
		
	}
}
