package Premium;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Kart.AnzeigenKartStrg;
import Rechnung.RechnungBezahlenStrg;
import Rechnung.Rechnungs¸bersichtStrg;
import Rechnung.anzeigenRechnungStrg;
import Rechnung.anzeigenRechnung_ansicht2;
import Strecke.AnzeigenStreckenStrg;
import Strecke.Strecke;
import Strecke.Streckenuebersicht;
import Kart.AnzeigenKartStrg;

/**
 * kaufePremiumStrecke ist ein Pop-up Fenster, das die grafische Oberfl‰che PremiumStreckeView steuert.
 * @author Ferhat Koca
 *
 */
public class kaufePremiumStrecke extends JFrame implements ActionListener {

	PremiumStreckeView psv;
	Rechnungs¸bersichtStrg anzr;
	Strecke s;
	Streckenuebersicht viewUebersicht;

	/**
	 * Die Methode actionPerformed liest den Button, auf den der Nutzer in der View
	 * klickt, aus und f√ºhrt den jeweiligen Befehl aus.
	 * 
	 * Das Dr√ºcken auf den best√§tigen Button f√ºhrt dazu das der Nutzer weiter zur
	 * Rechnungs√ºbersicht geleitet wird. Das Dr√ºcken auf Abbrechen bricht den
	 * Kaufprozess ab.
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == psv.best‰tigen) {
			psv.frame.dispose();
			RechnungBezahlenStrg strg = new RechnungBezahlenStrg(s) ;
			viewUebersicht.getFrame().dispose();
		}
		if (e.getSource() == psv.abbrechen) {
			psv.frame.dispose();
			viewUebersicht.getFrame().dispose();
			AnzeigenStreckenStrg strg = new AnzeigenStreckenStrg();
		}
	}
	/**
	 * Der Konstruktor kaufePremiumStrecke ruft die PremiumStreckeView auf und f√ºllt
	 * die Buttons mit der hier definierten Methode actionPerformed.
	 * 
	 */
	public kaufePremiumStrecke(Strecke s, Streckenuebersicht viewUebersicht) {
		psv = new PremiumStreckeView();
		psv.frame.setVisible(true);
		psv.best‰tigen.addActionListener(this);
		psv.abbrechen.addActionListener(this);
		this.s = s;
		this.viewUebersicht = viewUebersicht;
	}

	public static void main(String[] args) {
		
	}

}
