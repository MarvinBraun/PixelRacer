package MultiplayerFahrtSpielen;

import Fahrt.MultiplayerFahrt;


public class MultiplayerZeitBehaltenStrg {
	MultiplayerZeitBehaltenView view;
	
	public MultiplayerZeitBehaltenStrg(MultiplayerFahrt mf, int versuche)
	{
		view = new MultiplayerZeitBehaltenView();
		view.lblRundeXZeit.setText("Gefahrene Zeit:"+mf.getZeit()+ "Anzahl Versuche: "+versuche);
		
		
	}

}
