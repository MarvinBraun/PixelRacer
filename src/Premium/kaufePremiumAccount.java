//@author Ferhat Koca
package Premium;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Rechnung.anzeigenRechnung_ansicht2;

public class kaufePremiumAccount extends JFrame implements ActionListener {

	double preis;

	public void setPreis(double preis) {
		this.preis = preis;
	}

	public double getPreis() {
		return preis = 9.99;
	}

	PremiumAccountView pav;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == pav.bestätigen) {
			anzeigenRechnung_ansicht2.main(null);
		}
		if (e.getSource() == pav.abbrechen) {
			System.exit(0);
		}
	}

	public kaufePremiumAccount() {
		pav = new PremiumAccountView();
		pav.frame.setVisible(true);
		pav.abbrechen.addActionListener(this);
		pav.bestätigen.addActionListener(this);

	}

	public static void main(String[] args) {
		kaufePremiumAccount kpa = new kaufePremiumAccount();

	}
}
