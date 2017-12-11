package FahrtSpielen;

import Fahrt.SingleplayerFahrt;

public class FahrtAuswertungStrg {
	FahrtAuswertung view;
	
	public FahrtAuswertungStrg(SingleplayerFahrt sf)
	{
		
		view = new FahrtAuswertung();
		view.lblDeineZeit.setText("Deine Zeit:"+sf.getZeit());
		view.lblDeinPlatz.setText("Dein Rang:"+sf.getRang());
		
	}
	
	public void setFelder()
	{
		
	}
	
	
}
