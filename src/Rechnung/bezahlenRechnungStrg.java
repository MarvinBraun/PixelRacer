
//author Matthias Westermeyer

package Rechnung;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;

public class bezahlenRechnungStrg extends JFrame implements ActionListener { 

	static bezahlenRechnungStrg bre;


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource == bre.frmBezahlung) {
			bre.frmBezahlung.dispose();
			bezahlenRechnung_ansicht.main(null);
		}
		
		if(e.getSource() == bre.btnNewButton) {
			bre.frmBezahlung.dispose();
			bezahlenRechnung_ansicht bre = new bezahlenRechnung_ansicht();
			
		}
		
		public bezahlenRechnung_ansicht() {
			try {
				bre = new bezahlenRechnung_ansicht();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
			bre.frmBezahlung.setVisible(true);
			bre.btnNewButton.addActionListener(this);
			
		}

		public static void main(String[] args) throws IOException {
			// TODO Auto-generated method stub
			bre = new bezahlenRechnung_ansicht();
		}

	}
