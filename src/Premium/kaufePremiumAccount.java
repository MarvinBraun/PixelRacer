//@Author Ferhat Koca
package Premium;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import ProfilKunde.AnzeigenProfilKundeStrg;
import Rechnung.RechnungBezahlenStrg;
import Rechnung.Rechnungs�bersichtStrg;
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
	Rechnungs�bersichtStrg anzr;
	AnzeigenProfilKundeStrg strg;

	/**
	 * Die Methode actionPerformed liest den Button, auf den der Nutzer in der View
	 * klickt, aus und f�hrt den jeweiligen Befehl aus.
	 * 
	 * Das Dr�cken auf den best�tigen Button f�hrt dazu das der Nutzer weiter zur
	 * Rechnungs�bersicht geleitet wird. 
	 * Das Dr�cken auf Abbrechen bricht den Kaufprozess ab.
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == pav.best�tigen) {
			pav.frame.dispose();
			RechnungBezahlenStrg strg = new RechnungBezahlenStrg();
		}
		if (e.getSource() == pav.abbrechen) {
			pav.frame.dispose();
			strg = new AnzeigenProfilKundeStrg();
		}
	}
/**
 * Der Konstruktor kaufePremium ruft die PremiumAccountView auf
 * und f�llt die Buttons mit der hier definierten Methode actionPerformed.
 * 
 */
	public kaufePremiumAccount() {
		pav = new PremiumAccountView();
		pav.frame.setVisible(true);
		pav.abbrechen.addActionListener(this);
		pav.best�tigen.addActionListener(this);

	}

	public static void main(String[] args) {
		kpa = new kaufePremiumAccount();

	}
}
