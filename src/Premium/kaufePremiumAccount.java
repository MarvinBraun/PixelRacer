
package Premium;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import ProfilKunde.AnzeigenProfilKundeStrg;
import ProfilKunde.ProfilKundeAnsicht;
import Rechnung.RechnungBezahlenStrg;
import Rechnung.RechnungsübersichtStrg;
import Rechnung.anzeigenRechnungStrg;
import Rechnung.anzeigenRechnung_ansicht2;

/**
 * kaufePremiumAccount ist ein Pop-up Fenster, das die grafische Oberfläche PremiumAccountView steuert.
 * @author Ferhat Koca
 *
 */
public class kaufePremiumAccount extends JFrame implements ActionListener {

	static kaufePremiumAccount kpa;
	PremiumAccountView pav;
	RechnungsübersichtStrg anzr;
	AnzeigenProfilKundeStrg strg;
	ProfilKundeAnsicht ansicht;

	/**
	 * Die Methode actionPerformed liest den Button, auf den der Nutzer in der View
	 * klickt, aus und führt den jeweiligen Befehl aus.
	 * 
	 * Das Drücken auf den bestätigen Button führt dazu das der Nutzer weiter zur
	 * Rechnungsübersicht geleitet wird. 
	 * Das Drücken auf Abbrechen bricht den Kaufprozess ab.
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == pav.getBestaetigen()) {
			pav.getFrame().dispose();
			RechnungBezahlenStrg strg = new RechnungBezahlenStrg();
			ansicht.getFrmPixelRacer().dispose();
		}
		if (e.getSource() == pav.getAbbrechen()) {
			pav.getFrame().dispose();
			strg = new AnzeigenProfilKundeStrg();
		}
	}
/**
 * Der Konstruktor kaufePremium ruft die PremiumAccountView auf
 * und füllt die Buttons mit der hier definierten Methode actionPerformed.
 * 
 */
	public kaufePremiumAccount(ProfilKundeAnsicht ansicht) {
		this.ansicht = ansicht;
		pav = new PremiumAccountView();
		pav.getFrame().setVisible(true);
		pav.getAbbrechen().addActionListener(this);
		pav.getBestaetigen().addActionListener(this);

	}

	public static void main(String[] args) {
		

	}
}
