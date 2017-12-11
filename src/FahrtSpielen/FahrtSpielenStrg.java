package FahrtSpielen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import Computergegner.Bot;
import Fahrt.MultiplayerFahrt;
import Fahrt.SingleplayerFahrt;
import Kart.Kart;
import Strecke.Strecke;

public class FahrtSpielenStrg implements ActionListener{
	SingleplayerFahrt sf=null;
	MultiplayerFahrt mf=null;
	
	FahrtSpielenView fahrtSpielenView;
	ZeitBehaltenView zeitBehaltenView;
	int versuche = 3;
	int zeit=0;
	int[] zeiten = new int[3];
	int rang;
	Kart kart;
	Strecke strecke;
	int schwierigkeit;
	
	//Singleplayerfahrt Konstruktor
	
	public FahrtSpielenStrg(SingleplayerFahrt sfahrt, Kart k, Strecke s, int schwierigkeit)
	{
		kart = k;
		strecke = s;
		this.sf = sfahrt;
		//Entscheidung ob ein Single oder MultiplayerSpiel gespielt wird
		
		this.schwierigkeit = schwierigkeit;
		
		for(int i = 0; i<zeiten.length;i++)
		{
			Bot b = new Bot(s.getLaenge(),kart.beschleunigung,kart.getMaxkmh(),schwierigkeit);
			zeiten[i] = b.getZeit();
		}
		Arrays.sort(zeiten);
		
		

		
		fahrtSpielenView = new FahrtSpielenView();
		fahrtSpielenView.fahrenBtn.addActionListener(this);
		System.out.println("Registriert");
	
	}

	//Singleplayerfahrt Konstruktor
	
	public FahrtSpielenStrg(MultiplayerFahrt mf, Kart k, Strecke s)
	{
		kart = k;
		strecke = s;
		mf = new MultiplayerFahrt();
	
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
		
		if(versuche>1)
		{
			int zeit =(int) ((kart.getMaxkmh()/5)*(0.1*kart.beschleunigung)*(Math.random() * (2 - 1) + 1));
			System.out.println("Gefahrene Zeit:"+zeit);
			sf.setZeit(zeit);
			versuche--;
			String a = ""+versuche;
			fahrtSpielenView.lblAnzahlVerbleibenderVersuche.setText(a);
			String b = ""+sf.getZeit();
			fahrtSpielenView.lblLetzteZeit.setText(b);
			zeitBehaltenView = new ZeitBehaltenView(fahrtSpielenView.frame.getX(),fahrtSpielenView.frame.getY(),sf, versuche);	
		}
		
		else if(versuche==1)
		{
			simuliereBotZeiten();
		
			FahrtAuswertungStrg strg = new FahrtAuswertungStrg(sf);
			
			fahrtSpielenView.frame.dispose();
		//	FahrtAuswertung fahrtAuswertung = new FahrtAuswertung(sf.getZeit(),sf.getRang());
			
			
		}
		
	}
	
	public void simuliereBotZeiten()
	{	
		int geschwindigkeit = kart.getMaxkmh();
		int beschleunigung = kart.getBeschleunigung();
		int länge = strecke.getLaenge();
		int schwierigkeit = this.schwierigkeit;
		
		for(int i = 0; i<zeiten.length;i++)
		{
			if(zeit<=zeiten[i])
			{
			sf.setRang(i+1);
			break;
			}
			
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
