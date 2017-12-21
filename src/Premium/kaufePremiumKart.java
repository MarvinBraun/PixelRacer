//@Author Ferhat Koca
package Premium;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import ProfilKunde.AnzeigenProfilKundeStrg;
import Rechnung.RechnungsübersichtStrg;
import Rechnung.anzeigenRechnungStrg;
import Rechnung.anzeigenRechnung_ansicht2;

public class kaufePremiumKart extends JFrame implements ActionListener {

	PremiumKartView pkv;
	RechnungsübersichtStrg anzr;

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
