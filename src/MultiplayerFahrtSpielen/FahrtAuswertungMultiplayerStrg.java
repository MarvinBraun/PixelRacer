package MultiplayerFahrtSpielen;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

import Fahrt.Fahrtverwaltung;
import Fahrt.MultiplayerFahrt;
import FahrtSpielen.FahrtAuswertung;

public class FahrtAuswertungMultiplayerStrg {
	FahrtAuswertungMultiplayer view;
	MultiplayerFahrt mf;
	
	public FahrtAuswertungMultiplayerStrg(MultiplayerFahrt mf)
	{
		this.mf = mf;
		view = new FahrtAuswertungMultiplayer();
		String zeit = "Gefahrene Zeit: "+mf.getZeit();
		view.lblDeineZeit.setText(zeit);
		
	}
	
	public void ermittleRang()
	{
		Fahrtverwaltung multi = new Fahrtverwaltung();
		LinkedList<MultiplayerFahrt> fahrten = multi.gibMultiplayerFahrten();
		
		for(int i = 0; i<fahrten.size();i++)
		{
			if(fahrten.get(i).getMultiplayerID()!=mf.getMultiplayerID())
			{
				fahrten.remove(i);
			}
		}
		 Collections.sort(fahrten, new Comparator<MultiplayerFahrt>() {
		     @Override
		     public int compare(String o1, String o2) {
		         return Collator.getInstance().compare(o1, o2);
		     }

			@Override
			public int compare(MultiplayerFahrt arg0, MultiplayerFahrt arg1) {
				// TODO Auto-generated method stub
				return Collator.getInstance().compare()
			}
		 });
		
		
	
		
		for (int i = 0; i<fahrten.size();i++)
		{
			if(mf.getZeit()<)
		}
	}
	
	

}
