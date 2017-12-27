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
	private int spielstand =0;
	
	/* 
	 * Konstruktor: public FahrtSpielenStrg(SingleplayerFahrt sfahrt, Kart k, Strecke s, int schwierigkeit)
	 * Eine Neue FahrtSpielenStrg wird erzeugt. Dabei wird ein Objekt der Klasse SingleplayerFahrt, ein Objekt der Klasse Kart, 
	 * ein Objekt der Klasse Strecke und eine int-Variable (Schwierigkeit) übergeben. Im Konstruktor werden dann die Zeiten der Bots über eine For-Schleife ermittelt und in 
	 * ein int-Array eingetragen. Anschließend wird dieses Array nach den Zeiten sortiert.
	 * Der Konstruktor erzeugt außerdem ein Objekt der Klasse FahrtSpielenView und aktualisiert die entsprechenden Felder.
	 */
	
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
		fahrtSpielenView.getLblAnzahlVerbleibenderVersuche().setText("Verbleibende Runden: 10");
		
		
		fahrtSpielenView.getZeiger().balken.setVisible(false);
		fahrtSpielenView.getFrame().setVisible(true);
		fahrtSpielenView.getFrame().setFocusable(true);
		//KeyAdapter
		fahrtSpielenView.getFrame().setFocusTraversalKeysEnabled(false);
	}

	/* Methode: public void fahren()
	 * Sobald auf den Fahren-Button geklickt wird, wird der Balken, die Bewertung und der Zeiger sichtbar gemacht.
	 * Der Fahren-Button wird entsprechend ausgeblendet. Ein Key-Listener wird über die @Override Annotation eingefügt und ein entsprechendes KeyEvent für die Leertaste gesetzt.
	 * Beim drücken auf die Leertaste wird der X-Wert des Zeigers ausgelesen. 
	 * Bei jedem Drücken der Leertaste wird der "Speed" erhöht (max. bis 6). Die Textfelder werden bei jedem Drücken ebenfalls aktualisiert.
	 * Wenn der X-Wert des Zeigers zwischen 300 und 450 liegt, dann wird auf die Variable "spielstand" +1 addiert, andernfalls wird +2 auf die Variable spielstand addiert. Die Variable ist im Nachgang für die Bewertung der Leistung des Spielers zuständig,
	 * da sie durch die Anzahl der Runden geteilt wird (10). Abschließend (Versuche == 0) wird der dort errechnete Wert mit der errechneten Zeit multipliziert. Über die Methode "setzeRang()" wird der Rang des Spielers
	 * ermittelt. Abschließend wird ein Objet der Klasse FahrtAuswertungStrg aufgerufen und das JFrame der Klasse fahrtSpielenView geschlossen.
	 * 
	 */
	
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
	            	System.out.println(spielstand);
	            	if(speed<6)
	            	speed = speed+speed;
	            	fahrtSpielenView.getZeiger().setSpeed(speed);
	            	versuche--;
	            	String a = ""+versuche;
	            	fahrtSpielenView.getLblAnzahlVerbleibenderVersuche().setText("Runden verbleibend: "+a);
	               
	            	String b = ""+sf.getZeit();
	               	
	               	if(300<record&&record<450)
	               	{
	               		spielstand = spielstand+1;
	               		fahrtSpielenView.getBewertungLbl().setText("Super");
	               	
	               	}
	               	else
	               	{
	               		spielstand = spielstand+2;
	               		fahrtSpielenView.getBewertungLbl().setText("Das geht besser!");
	               	}
	            	}
	            	
	            	
	            	if(versuche == 0)
	            	{
	            		float berechneLeistung = (float) spielstand / 10;
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
	
	/* Methode: public void public void setzeRang()
	 * Die Methode ermittelt den Rang des Spielers in einer For-Schleife. 
	 * Beim Erfüllen der Bedingung if(sf.getZeit()<=zeiten[i]) wird der Rang entsprechend gesetzt.
	 * "sf.setRang(i+1);" der Rang ist immer +1 höher als der Index, da dieser bei 0 beginnt.
	 * Über ein "break;" wird die Schleife an der entsprechenden Stelle beendet.
	 */
	
	public void setzeRang()
	{	
		
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
