//@Author Ferhat Koca
package Premium;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Rechnung.RechnungsübersichtStrg;
import Rechnung.anzeigenRechnungStrg;
import Rechnung.anzeigenRechnung_ansicht2;

/**
 * 
 * @author Ferhat Koca
 *
 */
public class kaufePremiumStrecke extends JFrame implements ActionListener {

	PremiumStreckeView psv;
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
		if (e.getSource() == psv.bestätigen) {
			anzr = new RechnungsübersichtStrg();
		}
		if (e.getSource() == psv.abbrechen) {
			psv.frame.dispose();
		}
	}
	/**
	 * Der Konstruktor kaufePremiumStrecke ruft die PremiumStreckeView auf und füllt
	 * die Buttons mit der hier definierten Methode actionPerformed.
	 * 
	 */
	public kaufePremiumStrecke() {
		psv = new PremiumStreckeView();
		psv.frame.setVisible(true);
		psv.bestätigen.addActionListener(this);
		psv.abbrechen.addActionListener(this);
	}

	public static void main(String[] args) {
		kaufePremiumStrecke kps = new kaufePremiumStrecke();
	}

}
