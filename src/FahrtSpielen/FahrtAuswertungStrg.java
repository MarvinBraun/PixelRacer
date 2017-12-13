package FahrtSpielen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import Fahrt.Fahrtverwaltung;
import Fahrt.SingleplayerFahrt;
import Startansicht.StartansichtStrg;

public class FahrtAuswertungStrg implements ActionListener {
	FahrtAuswertung view;
	Fahrtverwaltung verwaltung  = new Fahrtverwaltung();
	public FahrtAuswertungStrg(SingleplayerFahrt sf, BufferedImage strecke)
	{
		
		view = new FahrtAuswertung();
		view.lblDeineZeit.setText("Deine Zeit: "+sf.getZeit());
		view.lblDeinPlatz.setText("Dein Rang: "+sf.getRang());
		ImageIcon streckenBild = new ImageIcon(strecke);
		view.lblBackground.setIcon(streckenBild);
		
		
		switch(sf.getRang())
		{
		
		
		case(1): view.lblGewonnenPunkte.setText("Gewonnene Punkte: 3");
		case(2): view.lblGewonnenPunkte.setText("Gewonnene Punkte: 2");
		case(3): view.lblGewonnenPunkte.setText("Gewonnene Punkte: 1");
		
		verwaltung.sendeSingleplayerFahrt(sf);	
		
		
		
		}
		
		view.btnNewButton.addActionListener(this);
		
		
		
		
	
		
		
		
	}
	
	public void setFelder()
	{
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==view.btnNewButton)
		{
			view.frame.dispose();
			StartansichtStrg strg = new StartansichtStrg();
		}
		// TODO Auto-generated method stub
		
	}
	
	
}
