package FahrtSpielen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Computergegner.Bot;
import Fahrt.MultiplayerFahrt;
import Fahrt.SingleplayerFahrt;
import Kart.Kart;
import Strecke.Strecke;

public class FahrtSpielenStrg implements ActionListener{
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
		fahrtSpielenView.fahrenBtn.addActionListener(this);
		System.out.println("Registriert");
	
	}
	public FahrtSpielenStrg()
	{
		fahrtSpielenView = new FahrtSpielenView();
		fahrtSpielenView.fahrenBtn.addActionListener(this);
		System.out.println("Registriert");
	}
	
	
	public void fahren()
	{
		
		if(versuche>0)
		{
			zeit = (int) ((kart.getMaxkmh()/5)*(0.1*kart.beschleunigung)*(Math.random() * (2 - 1) + 1));
			versuche--;
			String a = ""+versuche;
			fahrtSpielenView.lblAnzahlVerbleibenderVersuche.setText(a);
			String b = ""+zeit;
			fahrtSpielenView.lblLetzteZeit.setText(b);
		
			zeitBehaltenView = new ZeitBehaltenView(fahrtSpielenView.frame.getX(),fahrtSpielenView.frame.getY(),zeit, versuche);
			
		}
	}
	public static void main(String[] args)
	{
		FahrtSpielenStrg strg = new FahrtSpielenStrg();
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