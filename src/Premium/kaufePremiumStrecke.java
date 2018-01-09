//@Author Ferhat Koca
package Premium;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Rechnung.RechnungBezahlenStrg;
import Rechnung.RechnungsübersichtStrg;
import Rechnung.anzeigenRechnungStrg;
import Rechnung.anzeigenRechnung_ansicht2;
import Strecke.Strecke;

/**
 * 
 * @author Ferhat Koca
 *
 */
public class kaufePremiumStrecke extends JFrame implements ActionListener {

	PremiumStreckeView psv;
	RechnungsübersichtStrg anzr;
	Strecke s;

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
			RechnungBezahlenStrg strg = new RechnungBezahlenStrg(s) ;
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
	public kaufePremiumStrecke(Strecke s) {
		psv = new PremiumStreckeView();
		psv.frame.setVisible(true);
		psv.bestätigen.addActionListener(this);
		psv.abbrechen.addActionListener(this);
		this.s = s;
	}

	public static void main(String[] args) {
		
	}

}
