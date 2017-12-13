package FahrtSpielen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
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

	BufferedImage kartBild;
	BufferedImage streckenBild;
	
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
		
		 kartBild = k.getGrafik();
		streckenBild = strecke.getGrafik(); 

		
		fahrtSpielenView = new FahrtSpielenView(kartBild,streckenBild);
		fahrtSpielenView.fahrenBtn.addActionListener(this);
		
		System.out.println("Registriert");
	
	}

	//Singleplayerfahrt Konstruktor
	
	public FahrtSpielenStrg(MultiplayerFahrt mf, Kart k, Strecke s)
	{
		kart = k;
		strecke = s;
		mf = new MultiplayerFahrt();
	
		fahrtSpielenView = new FahrtSpielenView(kartBild,streckenBild);
		fahrtSpielenView.fahrenBtn.addActionListener(this);
		System.out.println("Registriert");
	
	}
	public FahrtSpielenStrg()
	{
		fahrtSpielenView = new FahrtSpielenView(kartBild,streckenBild);
		fahrtSpielenView.fahrenBtn.addActionListener(this);
		System.out.println("Registriert");
	}
	
	
	public void fahren()
	{
		
		if(versuche>1)
		{
			
			try {
				fahrtSpielenView.fahrenBtn.setVisible(false);
				Thread.sleep(300);
				fahrtSpielenView.fahrenBtn.setVisible(true);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			float schwierigkeit2 = (float) (0.8 +(Math.random() * 1.5)); 
			
			int zeit = (int) ((strecke.getLaenge()/kart.getMaxkmh())+(kart.getMaxkmh()/kart.beschleunigung)*schwierigkeit2);
			System.out.println("Gefahrene Zeit:"+zeit);
			sf.setZeit(zeit);
			versuche--;
			String a = ""+versuche;
			fahrtSpielenView.lblAnzahlVerbleibenderVersuche.setText("Versuche: "+a);
			String b = ""+sf.getZeit();
			fahrtSpielenView.lblLetzteZeit.setText("Zeit: "+b+"s");
			
			zeitBehaltenView = new ZeitBehaltenView(300,200,sf, versuche);	
			zeitBehaltenView.frame.setLocation(300, 300);
			zeitBehaltenView.frame.setVisible(false);
			zeitBehaltenView.frame.setVisible(true);
			zeitBehaltenView.erneutFahrenBtn.addActionListener(this);
			zeitBehaltenView.zeitBehaltenBtn.addActionListener(this);
		}
		
		else if(versuche==1)
		{
			simuliereBotZeiten();
			FahrtAuswertungStrg strg = new FahrtAuswertungStrg(sf,streckenBild);
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
			if(sf.zeit<=zeiten[i])
			{
				System.out.println("Zeiten der Bots:"+zeiten[i]);
			sf.setRang(i+1);
			break;
			}
			else
				sf.setRang(zeiten.length);
			
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
		if(e.getSource()==zeitBehaltenView.zeitBehaltenBtn)
		{
			simuliereBotZeiten();
			FahrtAuswertungStrg strg = new FahrtAuswertungStrg(sf,streckenBild);
			fahrtSpielenView.frame.dispose();
			zeitBehaltenView.frame.dispose();
			
		}
		if(e.getSource()==zeitBehaltenView.erneutFahrenBtn)
		{
			zeitBehaltenView.frame.dispose();
		}
		// TODO Auto-generated method stub
		
	}
	
	

}
