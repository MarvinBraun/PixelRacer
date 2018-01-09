//@Author Ferhat Koca
package Premium;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Rechnung.RechnungBezahlenStrg;
import Rechnung.Rechnungs�bersichtStrg;
import Rechnung.anzeigenRechnungStrg;
import Rechnung.anzeigenRechnung_ansicht2;
import Strecke.AnzeigenStreckenStrg;
import Strecke.Strecke;

/**
 * 
 * @author Ferhat Koca
 *
 */
public class kaufePremiumStrecke extends JFrame implements ActionListener {

	PremiumStreckeView psv;
	Rechnungs�bersichtStrg anzr;
	Strecke s;

	/**
	 * Die Methode actionPerformed liest den Button, auf den der Nutzer in der View
	 * klickt, aus und f�hrt den jeweiligen Befehl aus.
	 * 
	 * Das Dr�cken auf den best�tigen Button f�hrt dazu das der Nutzer weiter zur
	 * Rechnungs�bersicht geleitet wird. Das Dr�cken auf Abbrechen bricht den
	 * Kaufprozess ab.
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == psv.best�tigen) {
			RechnungBezahlenStrg strg = new RechnungBezahlenStrg(s) ;
		}
		if (e.getSource() == psv.abbrechen) {
			psv.frame.dispose();
			AnzeigenStreckenStrg strg = new AnzeigenStreckenStrg();
		}
	}
	/**
	 * Der Konstruktor kaufePremiumStrecke ruft die PremiumStreckeView auf und f�llt
	 * die Buttons mit der hier definierten Methode actionPerformed.
	 * 
	 */
	public kaufePremiumStrecke(Strecke s) {
		psv = new PremiumStreckeView();
		psv.frame.setVisible(true);
		psv.best�tigen.addActionListener(this);
		psv.abbrechen.addActionListener(this);
		this.s = s;
	}

	public static void main(String[] args) {
		
	}

}
