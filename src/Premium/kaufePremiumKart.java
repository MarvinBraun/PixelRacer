//@Author Ferhat Koca
package Premium;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Rechnung.anzeigenRechnung_ansicht2;

public class kaufePremiumKart extends JFrame implements ActionListener {

	PremiumKartView pkv;
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == pkv.bestätigen) {
			anzeigenRechnung_ansicht2.main(null);
		}
		if (e.getSource() == pkv.abbrechen) {
			System.exit(0);
		}
	}
	
	public kaufePremiumKart(){
		pkv = new PremiumKartView();
		pkv.frame.setVisible(true);
		pkv.bestätigen.addActionListener(this);
		pkv.abbrechen.addActionListener(this);
	}
	public static void main(String[] args){
		kaufePremiumKart pkv = new kaufePremiumKart();
	}
}
