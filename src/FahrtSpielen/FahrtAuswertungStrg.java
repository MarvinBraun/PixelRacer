package FahrtSpielen;

import Fahrt.Fahrtverwaltung;
import Fahrt.SingleplayerFahrt;

public class FahrtAuswertungStrg {
	FahrtAuswertung view;
	Fahrtverwaltung verwaltung  = new Fahrtverwaltung();
	public FahrtAuswertungStrg(SingleplayerFahrt sf)
	{
		
		view = new FahrtAuswertung();
		view.lblDeineZeit.setText("Deine Zeit:"+sf.getZeit());
		view.lblDeinPlatz.setText("Dein Rang:"+sf.getRang());
		
		
		switch(sf.getRang())
		{
		
		
		case(1): view.lblGewonnenPunkte.setText("Gewonnene Punkte: 3");
		case(2): view.lblGewonnenPunkte.setText("Gewonnene Punkte: 2");
		case(3): view.lblGewonnenPunkte.setText("Gewonnene Punkte: 1");
		
		verwaltung.sendeSingleplayerFahrt(sf);	
		
		
		
		}
		
		
		
		
	
		
		
		
	}
	
	public void setFelder()
	{
		
	}
	
	
}
