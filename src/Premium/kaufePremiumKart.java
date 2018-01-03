//@Author Ferhat Koca
package Premium;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import ProfilKunde.AnzeigenProfilKundeStrg;
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
			anzr = new RechnungsübersichtStrg();
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
	public kaufePremiumKart() {
		pkv = new PremiumKartView();
		pkv.frame.setVisible(true);
		pkv.bestätigen.addActionListener(this);
		pkv.abbrechen.addActionListener(this);
	}

	public static void main(String[] args) {
		kaufePremiumKart pkv = new kaufePremiumKart();
	}
}
