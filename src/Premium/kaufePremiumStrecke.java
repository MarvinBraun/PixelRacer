package Premium;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Kart.AnzeigenKartStrg;
import Rechnung.RechnungBezahlenStrg;
import Rechnung.anzeigenRechnung_ansicht2;
import Strecke.AnzeigenStreckenStrg;
import Strecke.Strecke;
import Strecke.Streckenuebersicht;
import Kart.AnzeigenKartStrg;

/**
 * kaufePremiumStrecke ist ein Pop-up Fenster, das die grafische Oberflaeche PremiumStreckeView steuert.
 * @author Ferhat Koca
 *
 */
public class kaufePremiumStrecke extends JFrame implements ActionListener {

	PremiumStreckeView psv;
	Strecke s;
	Streckenuebersicht viewUebersicht;

	/**
	 * Die Methode actionPerformed liest den Button, auf den der Nutzer in der View
	 * klickt, aus und führt den jeweiligen Befehl aus.
	 * 
	 * Das Drücken auf den bestätigen Button faehrt dazu das der Nutzer weiter zur
	 * Rechnungsübersicht geleitet wird. Das Druecken auf Abbrechen bricht den
	 * Kaufprozess ab.
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == psv.getBestaetigen()) {
			psv.getFrame().dispose();
			RechnungBezahlenStrg strg = new RechnungBezahlenStrg(s) ;
			viewUebersicht.getFrame().dispose();
		}
		if (e.getSource() == psv.getAbbrechen()) {
			psv.getFrame().dispose();
			viewUebersicht.getFrame().dispose();
			AnzeigenStreckenStrg strg = new AnzeigenStreckenStrg();
		}
	}
	/**
	 * Der Konstruktor kaufePremiumStrecke ruft die PremiumStreckeView auf und füllt
	 * die Buttons mit der hier definierten Methode actionPerformed.
	 * 
	 */
	public kaufePremiumStrecke(Strecke s, Streckenuebersicht viewUebersicht) {
		psv = new PremiumStreckeView();
		psv.getFrame().setVisible(true);
		psv.getBestaetigen().addActionListener(this);
		psv.getAbbrechen().addActionListener(this);
		this.s = s;
		this.viewUebersicht = viewUebersicht;
	}

	public static void main(String[] args) {
		
	}

}
