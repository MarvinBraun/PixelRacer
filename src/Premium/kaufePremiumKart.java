//@Author Ferhat Koca
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
 * 
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
		// TODO Auto-generated method stub
		if (e.getSource() == pkv.bestätigen) {
			pkv.frame.dispose();
			try {
			viewUebersicht.getFrame().dispose();
			}catch(NullPointerException a) {
				a.getMessage();
			}
			RechnungBezahlenStrg strg = new RechnungBezahlenStrg(k);
			
		}
		if (e.getSource() == pkv.abbrechen) {
			pkv.frame.dispose();
			
		}
	}

	/**
	 * Der Konstruktor kaufePremiumKart ruft die PremiumKartView auf und füllt
	 * die Buttons mit der hier definierten Methode actionPerformed.
	 * 
	 */
	public kaufePremiumKart(Kart k) {
		pkv = new PremiumKartView();
		pkv.frame.setVisible(true);
		pkv.bestätigen.addActionListener(this);
		pkv.abbrechen.addActionListener(this);
		this.k = k;
	}

	public static void main(String[] args) {
		
	}
}
