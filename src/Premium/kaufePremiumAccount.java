//@author Ferhat Koca
package Premium;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import Rechnung.anzeigenRechnung_ansicht2;

public class kaufePremiumAccount extends JFrame implements ActionListener {

	PremiumAccountView pav;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == pav.best�tigen) {
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
		pav.best�tigen.addActionListener(this);

	}

	public static void main(String[] args) {
		kaufePremiumAccount kpa = new kaufePremiumAccount();

	}
}
