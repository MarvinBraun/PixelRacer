package Startansicht;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import Anmelden.AnmeldenStrg;
import ModusAuswählen.ModusauswählenStrg;

//Autor Daniel Zeller

public class StartansichtStrg implements ActionListener {
	
	Startansicht view1;

	public StartansichtStrg() {
		view1 = new Startansicht();
		view1.frmPixelRacer.setVisible(true);
		
		view1.btnAbmelden.addActionListener(this);
		view1.btnGarage.addActionListener(this);
		view1.btnProfil.addActionListener(this);
		view1.btnSpielen.addActionListener(this);
		view1.btnStreckenbersicht.addActionListener(this);
	}
	
	public static void main(String[] args0){
		StartansichtStrg strg = new StartansichtStrg();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== view1.btnAbmelden) {
			AnmeldenStrg strg = new AnmeldenStrg();
			view1.frmPixelRacer.dispose();
		}
		
		if(e.getSource()== view1.btnGarage) {
			
		}
		
		if(e.getSource()== view1.btnProfil) {
			
		}
		
		if(e.getSource()== view1.btnSpielen) {
			ModusauswählenStrg strg = new ModusauswählenStrg();
			view1.frmPixelRacer.dispose();
		}
		
		if(e.getSource()== view1.btnStreckenbersicht) {
			
		}
	}
	
}