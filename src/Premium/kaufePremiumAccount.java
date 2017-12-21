//@Author Ferhat Koca
package Premium;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import ProfilKunde.AnzeigenProfilKundeStrg;
import Rechnung.RechnungsübersichtStrg;
import Rechnung.anzeigenRechnungStrg;
import Rechnung.anzeigenRechnung_ansicht2;

public class kaufePremiumAccount extends JFrame implements ActionListener {

	static kaufePremiumAccount kpa;
	PremiumAccountView pav;
	RechnungsübersichtStrg anzr;
	AnzeigenProfilKundeStrg strg;
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == pav.bestätigen) {
			pav.frame.dispose();
			anzr = new RechnungsübersichtStrg();
		}
		if (e.getSource() == pav.abbrechen) {
			pav.frame.dispose();
			strg = new AnzeigenProfilKundeStrg();
		}
	}

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
