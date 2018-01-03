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
public class kaufePremiumAccount extends JFrame implements ActionListener {

	static kaufePremiumAccount kpa;
	PremiumAccountView pav;
	RechnungsübersichtStrg anzr;
	AnzeigenProfilKundeStrg strg;

	/**
	 * Die Methode actionPerformed liest den Button, auf den der Nutzer in der View
	 * klickt, aus und führt den jeweiligen Befehl aus.
	 * 
	 * Das Drücken auf den bestätigen Button führt dazu das der Nutzer weiter zur
	 * Rechnungsübersicht geleitet wird. 
	 * Das Drücken auf Abbrechen bricht den Kaufprozess ab.
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == pav.bestätigen) {
			pav.frame.dispose();
			anzr = new RechnungsübersichtStrg();
		}
		if (e.getSource() == pav.abbrechen) {
			pav.frame.dispose();
			strg = new AnzeigenProfilKundeStrg();
		}
	}
/**
 * Der Konstruktor kaufePremium ruft die PremiumAccountView auf
 * und füllt die Buttons mit der hier definierten Methode actionPerformed.
 * 
 */
	public kaufePremiumAccount() {
		pav = new PremiumAccountView();
		pav.frame.setVisible(true);
		pav.abbrechen.addActionListener(this);
		pav.bestätigen.addActionListener(this);

	}

	public static void main(String[] args) {
		kpa = new kaufePremiumAccount();

	}
}
