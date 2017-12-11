package MultiplayerFahrtSpielen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import Computergegner.Bot;
import Fahrt.MultiplayerFahrt;
import Fahrt.SingleplayerFahrt;
import FahrtSpielen.FahrtSpielenView;
import FahrtSpielen.ZeitBehaltenView;
import Kart.Kart;
import Strecke.Strecke;

public class MultiplayerFahrtSpielenStrg implements ActionListener{
	MultiplayerFahrt mf=null;
	
	MultiplayerFahrtSpielenView fahrtSpielenView;
	MultiplayerZeitBehaltenStrg zeitBehaltenView;
	int versuche = 3;
	int zeit=0;
	int rang;
	Kart kart;
	Strecke strecke;
	

	//Singleplayerfahrt Konstruktor
	
	public MultiplayerFahrtSpielenStrg(MultiplayerFahrt mf, Kart k, Strecke s)
	{
		kart = k;
		strecke = s;
		this.mf = mf;
	
		fahrtSpielenView = new MultiplayerFahrtSpielenView();
		fahrtSpielenView.fahrenBtn.addActionListener(this);
		System.out.println("Registriert");
	
	}
	
	
	public void fahren()
	{
		
		if(versuche>1)
		{
			int zeit =(int) ((kart.getMaxkmh()/5)*(0.1*kart.beschleunigung)*(Math.random() * (2 - 1) + 1));
			System.out.println("Gefahrene Zeit:"+zeit);
			mf.setZeit(zeit);
			versuche--;
			String a = ""+versuche;
			fahrtSpielenView.lblAnzahlVerbleibenderVersuche.setText(a);
			String b = ""+mf.getZeit();
			fahrtSpielenView.lblLetzteZeit.setText(b);
			zeitBehaltenView = new MultiplayerZeitBehaltenStrg(mf, versuche);	
		}
		
		else if(versuche==1)
		{
			FahrtAuswertungMultiplayerStrg auswertung = new FahrtAuswertungMultiplayerStrg(mf);
		}
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==fahrtSpielenView.fahrenBtn)
		{
			System.out.println("Hallo");
			fahren();
		}
		// TODO Auto-generated method stub
		
	}
	
	

}
