//@Author Ferhat Koca
package Premium;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Rechnung.anzeigenRechnung_ansicht2;

public class kaufePremiumStrecke extends JFrame implements ActionListener {
	
	PremiumStreckeView psv;
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == psv.bestätigen ){
			anzeigenRechnung_ansicht2.main(null);
		}if(e.getSource() == psv.abbrechen){
			System.exit(0);
		}
	}

	public kaufePremiumStrecke() {
		psv = new PremiumStreckeView();
		psv.frame.setVisible(true);
		psv.bestätigen.addActionListener(this);
		psv.abbrechen.addActionListener(this);
	}

	public static void main(String[] args) {
		kaufePremiumStrecke kps = new kaufePremiumStrecke();
	}

}
