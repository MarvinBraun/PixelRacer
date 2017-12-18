//author Matthias Westermeyer

package Rechnung;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Nutzer.Kunde;



public class anzeigenRechnungStrg implements ActionListener{
	
	anzeigenRechnung_ansicht2 view2;
	
	public anzeigenRechnungStrg() {
		
		view2 = new anzeigenRechnung_ansicht2(); 
		view2.frmRechnungsübersicht.setVisible(true);
		
		//view2.lblRechnungsnummer.addActionlistener(this);

		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
	

}
