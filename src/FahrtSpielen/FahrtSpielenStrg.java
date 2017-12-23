package FahrtSpielen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Arrays;

import Computergegner.Bot;
import Fahrt.MultiplayerFahrt;
import Fahrt.SingleplayerFahrt;
import Kart.Kart;
import Strecke.Strecke;

public class FahrtSpielenStrg implements ActionListener{
	private SingleplayerFahrt sf=null;
	private MultiplayerFahrt mf=null;
	
	private FahrtSpielenView fahrtSpielenView;

	private int versuche = 10;

	private BufferedImage kartBild;
	private BufferedImage streckenBild;
	
	private int[] zeiten = new int[3];
	private int rang;
	private Kart kart;
	private Strecke strecke;
	private int schwierigkeit;
	private int speed = 1;
	private int wert =0;
	
	//Singleplayerfahrt Konstruktor
	
	public FahrtSpielenStrg(SingleplayerFahrt sfahrt, Kart k, Strecke s, int schwierigkeit)
	{
		kart = k;
		strecke = s;
		this.sf = sfahrt;
		System.out.println(sf.getBenutzername());
	
		
		this.schwierigkeit = schwierigkeit;
		
		for(int i = 0; i<zeiten.length;i++)
		{
			Bot b = new Bot(s.getLaenge(),kart.getBeschleunigung(),kart.getMaxkmh(),schwierigkeit);
			zeiten[i] = b.getZeit();
		}
		Arrays.sort(zeiten);
		
		 kartBild = k.getGrafik();
		streckenBild = strecke.getGrafik(); 

		
		fahrtSpielenView = new FahrtSpielenView(kartBild,streckenBild);
		fahrtSpielenView.getFahrenBtn().addActionListener(this);
		fahrtSpielenView.getLblAnzahlVerbleibenderVersuche().setText("Anzahl verbleibender Runden: 10");
		
		//KeyAdapter
		fahrtSpielenView.getZeiger().balken.setVisible(false);
		fahrtSpielenView.getFrame().setVisible(true);
		fahrtSpielenView.getFrame().setFocusable(true);
		fahrtSpielenView.getFrame().setFocusTraversalKeysEnabled(false);
		
		
		System.out.println("Registriert");
	
	}

	//Singleplayerfahrt Konstruktor
	
	public FahrtSpielenStrg()
	{
		fahrtSpielenView = new FahrtSpielenView(kartBild,streckenBild);
		fahrtSpielenView.getFahrenBtn().addActionListener(this);
		System.out.println("Registriert");
	}
	
	
	public void fahren()
	{
		
		fahrtSpielenView.getFahrenBtn().setVisible(false);
		fahrtSpielenView.getZeiger().balken.setVisible(true);
		fahrtSpielenView.getBalkenLbl().setVisible(true);
		fahrtSpielenView.getBewertungLbl().setVisible(true);
		fahrtSpielenView.getFrame().addKeyListener(new KeyAdapter() 
		{
	         @Override
	         public void keyPressed(KeyEvent e) {
	            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
	            	if( versuche>=0)
	            	{ 
	            	
	          	int record = fahrtSpielenView.getZeiger().balken.backgroundX1;
	            //	wert = wert + record;
	            	System.out.println(wert);
	            	if(speed<6)
	            	speed = speed+speed;
	            	fahrtSpielenView.getZeiger().setSpeed(speed);
	            	versuche--;
	            	String a = ""+versuche;
	            	fahrtSpielenView.getLblAnzahlVerbleibenderVersuche().setText("Runden verbleibend: "+a);
	               
	            	String b = ""+sf.getZeit();
	               	
	               	if(350<record&&record<450)
	               	{
	               		wert = wert+1;
	               		fahrtSpielenView.getBewertungLbl().setText("Super");
	               	
	               	}
	               	else
	               	{
	               		wert = wert+2;
	               		fahrtSpielenView.getBewertungLbl().setText("Mittelmaß");
	               	}
	               	
	               	
	               	
	            	}
	            	
	            	
	            	if(versuche == 0)
	            	{
	            		float berechneLeistung = (float) wert / 10;
	            		System.out.println("Alter Wert: "+berechneLeistung);
	            		if(berechneLeistung<1)
	            		{
	            			berechneLeistung = (float) 1/berechneLeistung;
	            		}
	            	
	            		
	            		System.out.println(berechneLeistung);
	            		
	            		
	            		float schwierigkeit2 = (float) (0.8 +(Math.random() * 1.5)); 
	        			
	        			int zeit = (int) ((int) ((strecke.getLaenge()/kart.getMaxkmh())+(kart.getMaxkmh()/kart.getBeschleunigung())*schwierigkeit2)*berechneLeistung);
	        			System.out.println("Zeit"+zeit);
	        			sf.setZeit(zeit);
	        			versuche--;
	        			
	        			simuliereBotZeiten();
	        			FahrtAuswertungStrg strg = new FahrtAuswertungStrg(sf,streckenBild);
	        			fahrtSpielenView.getFrame().dispose();
	
	            	}
	            }
	         }
	      });
	

		
	}
	
	public void simuliereBotZeiten()
	{	
		int geschwindigkeit = kart.getMaxkmh();
		int beschleunigung = kart.getBeschleunigung();
		int länge = strecke.getLaenge();
		int schwierigkeit = this.schwierigkeit;
		
		for(int i = 0; i<zeiten.length;i++)
		{
			if(sf.getZeit()<=zeiten[i])
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
		
		if(e.getSource()==fahrtSpielenView.getFahrenBtn())
		{
			System.out.println("Hallo");
			fahren();
		}
		
		// TODO Auto-generated method stub
		
	}
	
	

}
