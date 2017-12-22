package MultiplayerFahrtSpielen;

import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

import Fahrt.Fahrtverwaltung;
import Fahrt.MultiplayerFahrt;
import FahrtSpielen.FahrtAuswertung;

public class FahrtAuswertungMultiplayerStrg {
	private FahrtAuswertungMultiplayer view;
	private MultiplayerFahrt mf;
	
	public FahrtAuswertungMultiplayerStrg(MultiplayerFahrt mf, BufferedImage streckenBild)
	{
		this.mf = mf;
		view = new FahrtAuswertungMultiplayer();
		String zeit = "Gefahrene Zeit: "+mf.getZeit();
		view.getLblDeineZeit().setText(zeit);
		ermittleRang();
	}
	
	public void ermittleRang()
	{
		Fahrtverwaltung multi = new Fahrtverwaltung();
		String id = ""+mf.getMultiplayerID();
		LinkedList<MultiplayerFahrt> fahrten = multi.gibMultiplayerFahrtenNachZeit(id);
		if(fahrten.size()>0)
		{
		for (int i = 0; i<fahrten.size();i++)
		{
			if(mf.getZeit()<fahrten.get(i).getZeit())
			{
				int rang = i+1;
				mf.setRang(rang);
				break;
			}
			
		}
		view.getLblDeinPlatz().setText("Dein Rang: "+mf.getRang());
	}
		else {
			view.getLblDeinPlatz().setText("Du bist der erste, der ein Match zu dieser MultiplayerID abgeschlossen hat!");
		}
		
	}
	

	
	

}
