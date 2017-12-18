package Rechnung;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;


public class speicherRechnungStrg extends JFrame implements ActionListener {
	
	speicherRechnung spr;


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		if(e.getSource == spr.speichern) {
			
			speicherRechnung.main(null);
		}
		
		public speicherRechnungStrg() {
			
			spr = new speicherRechnung();
			spr.getFrmSpeicherrechnung().setVisible(true);
			
		}
		
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == spr.getBtnZurck()){
				spr.dispose();	
				Rechnungsübersicht reüb = new Rechnungsübersicht ();
			}
		}
		
	}

}