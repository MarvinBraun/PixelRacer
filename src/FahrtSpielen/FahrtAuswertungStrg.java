package FahrtSpielen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import Fahrt.Fahrtverwaltung;
import Fahrt.SingleplayerFahrt;
import Nutzer.Nutzerverwaltung;
import Startansicht.StartansichtStrg;

public class FahrtAuswertungStrg implements ActionListener {
	private FahrtAuswertung view;
	private Fahrtverwaltung verwaltung  = new Fahrtverwaltung();
	private int a = 0;
	
	public FahrtAuswertungStrg(SingleplayerFahrt sf, BufferedImage strecke)
	{
		
		view = new FahrtAuswertung();
		view.getFrame().setLocationRelativeTo(null);
		view.getLblDeineZeit().setText("Deine Zeit: "+sf.getZeit());
		view.getLblDeinPlatz().setText("Dein Rang: "+sf.getRang());
		ImageIcon streckenBild = new ImageIcon(strecke);
		view.getLblBackground().setIcon(streckenBild);
		
		
		switch(sf.getRang())
		{
		
		
		case(1): view.getLblGewonnenPunkte().setText("Gewonnene Punkte: 3");
		a = 3;
		case(2): view.getLblGewonnenPunkte().setText("Gewonnene Punkte: 2");
		a = 2;
		case(3): view.getLblGewonnenPunkte().setText("Gewonnene Punkte: 1");
		a = 1;
	
		
	
		
		}
		verwaltung.sendeSingleplayerFahrt(sf);	
		
		Nutzerverwaltung.addpunkte(a);
		
		
		view.getBtnNewButton().addActionListener(this);
		
		
		
		
	
		
		
		
	}
	
	public void setFelder()
	{
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==view.getBtnNewButton())
		{
			view.getFrame().dispose();
			StartansichtStrg strg = new StartansichtStrg();
		}
		// TODO Auto-generated method stub
		
	}
	
	
}
