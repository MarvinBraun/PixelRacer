package Rechnung;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
 

public class speicherRechnungStrg extends JFrame implements ActionListener {
	
	static speicherRechnung spr;


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource == spr.frmSpeicherrechnung) {
			spr.frmSpeicherrechnung.dispose();
			speicherRechnung.main(null);
		}
		
		if(e.getSource() == spr.btnZurck) {
			spr.frmSpeicherrechnung.dispose();
			speicherRechnungStrg spr = new speicherRechnungStrg();
			
		}
		
		public speicherRechnungStrg() {
			try {
				spr = new speicherRechnung();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
			spr.frmSpeicherrechnung.setVisible(true);
			spr.btnZurck.addActionListener(this);

		}

		public static void main(String[] args) throws IOException {
			// TODO Auto-generated method stub
			spr = new speicherRechnung();
		}

	}
