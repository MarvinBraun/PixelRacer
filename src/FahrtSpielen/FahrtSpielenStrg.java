package FahrtSpielen;

import Computergegner.Bot;
import Fahrt.MultiplayerFahrt;
import Fahrt.SingleplayerFahrt;
import Kart.Kart;
import Strecke.Strecke;

public class FahrtSpielenStrg {
	FahrtSpielenView fahrtSpielenView;
	ZeitBehaltenView zeitBehaltenView;
	int versuche = 3;
	int zeit=0;
	Bot[] bots;
	Kart kart;
	Strecke strecke;
	
	
	public FahrtSpielenStrg(SingleplayerFahrt sf, MultiplayerFahrt mf, Kart k, Strecke s)
	{
		kart = k;
		strecke = s;
		//Entscheidung ob ein Single oder MultiplayerSpiel gespielt wird
		
		if(sf!=null)
		{
			sf = new SingleplayerFahrt();
		}
		if(mf!=null)
		{
			mf = new MultiplayerFahrt();
		}
		
		
		
		fahrtSpielenView = new FahrtSpielenView();
	
	}
	
	
	public void fahren()
	{
		if(versuche>0)
		{
			zeit = (int) ((kart.getMaxkmh()/5)*(0.1*kart.beschleunigung)*(Math.random()));
			versuche--;
			String a = ""+versuche;
			fahrtSpielenView.lblAnzahlVerbleibenderVersuche.setText(a);
			String b = ""+zeit;
			fahrtSpielenView.lblLetzteZeit.setText(b);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			zeitBehaltenView = new ZeitBehaltenView(fahrtSpielenView.frame.getX(),fahrtSpielenView.frame.getY(),zeit, versuche);
		}
	}
	
	

}
