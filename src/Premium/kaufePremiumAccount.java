//@Author Ferhat Koca
package Premium;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import ProfilKunde.AnzeigenProfilKundeStrg;
import Rechnung.Rechnungs�bersichtStrg;
import Rechnung.anzeigenRechnungStrg;
import Rechnung.anzeigenRechnung_ansicht2;

public class kaufePremiumAccount extends JFrame implements ActionListener {

	static kaufePremiumAccount kpa;
	PremiumAccountView pav;
	Rechnungs�bersichtStrg anzr;
	AnzeigenProfilKundeStrg strg;
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == pav.best�tigen) {
			pav.frame.dispose();
			anzr = new Rechnungs�bersichtStrg();
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
		pav.best�tigen.addActionListener(this);

	}

	public static void main(String[] args) {
		kpa = new kaufePremiumAccount();

	}
}
