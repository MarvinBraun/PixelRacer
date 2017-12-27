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
	
	/* 
	 * Konstruktor: public FahrtAuswertungStrg(SingleplayerFahrt sf, BufferedImage strecke)
	 * Eine Neue FahrtAuswertungStrg wird erzeugt. Dabei wird ein Objekt der Klasse SingleplayerFahrt und ein Objekt der Klasse BufferedImage(Streckenbild) übergeben. 
	 * Ungeachtet dessen, wird im Konstruktor die GUI "view" der Klasse FahrtAuswertungView erzeugt. 
	 * Anhand des ermittelten Ranges wird in einer Switch-Case-Anweisung ermittelt und sichtbar gemacht wieviele Punkte der Spieler gewonnen hat.
	 * Anschließend wird die SingleplayerFahrt an die Datenbank übermittelt und den Nutzer werden die Punkte gutgeschrieben.
	 */
	
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
		
		
		case(1):
			{view.getLblGewonnenPunkte().setText("Gewonnene Punkte: 3");
		a = 3;
			break;
			}
		
		case(2):
			{view.getLblGewonnenPunkte().setText("Gewonnene Punkte: 2");
		a = 2;
		break;
			}
		
		case(3): 
			{view.getLblGewonnenPunkte().setText("Gewonnene Punkte: 1");
		a = 1;
		break;
			}
	
		
	
		
		}
		verwaltung.sendeSingleplayerFahrt(sf);	
		
		Nutzerverwaltung.addpunkte(a);
		
		
		view.getBtnNewButton().addActionListener(this);
		
		
		
		
	
		
		
		
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
