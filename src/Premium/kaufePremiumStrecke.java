//@Author Ferhat Koca
package Premium;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Rechnung.Rechnungs�bersichtStrg;
import Rechnung.anzeigenRechnungStrg;
import Rechnung.anzeigenRechnung_ansicht2;

public class kaufePremiumStrecke extends JFrame implements ActionListener {

	PremiumStreckeView psv;
	Rechnungs�bersichtStrg anzr;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == psv.best�tigen) {
			anzr = new Rechnungs�bersichtStrg();
		}
		if (e.getSource() == psv.abbrechen) {
			psv.frame.dispose();
		}
	}

	public kaufePremiumStrecke() {
		psv = new PremiumStreckeView();
		psv.frame.setVisible(true);
		psv.best�tigen.addActionListener(this);
		psv.abbrechen.addActionListener(this);
	}

	public static void main(String[] args) {
		kaufePremiumStrecke kps = new kaufePremiumStrecke();
	}

}
