package FahrtErstellen;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import Fahrt.Fahrtverwaltung;
import Fahrt.MultiplayerFahrt;
import Fahrt.SingleplayerFahrt;
import FahrtSpielen.FahrtSpielenStrg;
import MusicHandler.MusicPlayer;
import Nutzer.Kunde;
import Nutzer.Nutzerverwaltung;
import Strecke.Strecke;
import Strecke.Streckenverwaltung;
import myIterator.MyIteratorKart;
import myIterator.MyIteratorStrecke;
import myIterator.MyIteratorString;
import Kart.*;
import MultiplayerFahrtSpielen.MultiplayerFahrtSpielenStrg;
public class FahrtErstellenStrg implements ActionListener {
	
	//Objekte der Klasse
	FahrtErstellenView view;
	boolean forward = false;
	boolean backward = false;
	
	Kartverwaltung karts;
	Streckenverwaltung strecken;
	Fahrtverwaltung fahrten;
	
	static MyIteratorKart<Kart> itKart;
	static MyIteratorString<String> itString;
	static MyIteratorStrecke<Strecke> itStrecke;
	
	LinkedList<String> schwierigkeiten;
	LinkedList<Kart> kartliste = new LinkedList<Kart>();
	LinkedList<Strecke> streckenliste = new LinkedList<Strecke>();
	LinkedList<SingleplayerFahrt> schwierigkeitsCheck = new LinkedList<SingleplayerFahrt>();
	
	BufferedImage streckenbild;
	int singlemultiplayer;
	
	SingleplayerFahrt sf;
	MultiplayerFahrt mf;
	Kart k;
	Strecke s;
	Kunde kunde;
	int schwierigkeit=1;
	
	

	int counter=-1;
	//Konstruktor
	public FahrtErstellenStrg(int singleMultiplayer) {
		view = new FahrtErstellenView();
		view.frame.setLocationRelativeTo(null);
		singlemultiplayer = singleMultiplayer;
		fahrten = new Fahrtverwaltung();
		kunde = Nutzerverwaltung.getangKunde();
		System.out.println(Nutzerverwaltung.getangKunde().getnutzername());
		
		//Initialisieren der Karts 
		karts = new Kartverwaltung();
		kartliste =karts.gibKart();
		itKart = new MyIteratorKart(kartliste.listIterator());
		ladeKarts();
		
		//Initialisieren der Strecke
		strecken= new Streckenverwaltung();
		streckenliste = strecken.gibStrecke();
		itStrecke = new MyIteratorStrecke(streckenliste.listIterator());
	
		
		//ActionListener
		view.kartForward.addActionListener(this);
		view.kartBackward.addActionListener(this);
		view.streckeBackward.addActionListener(this);
		view.streckeForward.addActionListener(this);
		view.spielenBtn.addActionListener(this);
	

		//Initialisieren des Schwierigkeitsgrades
		//nur f�r Singleplayer
	
		if(singleMultiplayer==1)
		{
			schwierigkeiten = new LinkedList<String>();
			schwierigkeiten.add("Bronze");
			schwierigkeiten.add("Silber");
			schwierigkeiten.add("Gold");
			itString = new MyIteratorString(schwierigkeiten.listIterator());
			
			view.schwierigkeitBtn1.addActionListener(this);
			view.schwierigkeitBtn2.addActionListener(this);
			view.schwierigkeitLbl.setText(itString.next());
			sf = new SingleplayerFahrt();
			sf.setSchwierigkeit("Bronze");
			sf.setBenutzername(kunde.getnutzername());
			
		
		}
		//Initialisieren der MultiplayerID
		// nur f�r Multiplayer
		else
		{
			view.schwierigkeitBtn1.setVisible(false);
			view.schwierigkeitBtn2.setVisible(false);
			view.schwierigkeitLbl.setVisible(false);
			view.multiplayerLbl.setVisible(true);
			mf = new MultiplayerFahrt();
		}
		ladeStrecke();
		SwingUtilities.updateComponentTreeUI(view.frame);
	
		SwingUtilities.updateComponentTreeUI(view.frame);
		
	}
	
	public static void main(String[] args)
	{
		FahrtErstellenStrg strg = new FahrtErstellenStrg(1);
		MusicPlayer.audioBackground();

	}
	
	//Methode um vorw�rts durch die Karts zu scrollen
	public void ladeKarts()
	{
		if((k=itKart.next())!=null)
		{
			System.out.println(k.kartname);
			ImageIcon icon = new ImageIcon(k.grafik);
			view.kartBild.setIcon(icon);
			view.kartName.setText(k.kartname);
		}
	}
	
	public void ladeStrecke()
	{
		if((s=itStrecke.next())!=null)
		{
			
			BufferedImage newImage= s.getGrafik();
			view.streckeName.setText(s.getStreckenname());
			streckenbild = imageResizer(newImage);
			ImageIcon icon = new ImageIcon(streckenbild);
			view.streckeLbl.setIcon(icon);
			itString = new MyIteratorString(schwierigkeiten.listIterator());
			view.schwierigkeitLbl.setText(itString.next());
			
		
		}
	}
	//Methode um r�ckw�rts durch die Karts zu scrollen
	public void kartR�ckw�rts()
	{
		
	
		if((k=itKart.previous())!=null)
		{
			System.out.println(k.kartname);
			ImageIcon icon = new ImageIcon(k.grafik);
			view.kartBild.setIcon(icon);
			view.kartName.setText(k.kartname);
		}
	
	}
	
	public void streckeR�ckw�rts()
	{
		if((s=itStrecke.previous())!=null)
		{
			
			BufferedImage newImage= s.getGrafik();
			view.streckeName.setText(s.getStreckenname());
			streckenbild = imageResizer(newImage);
			ImageIcon icon = new ImageIcon(streckenbild);
			view.streckeLbl.setIcon(icon);
			itString = new MyIteratorString(schwierigkeiten.listIterator());	
			view.schwierigkeitLbl.setText(itString.next());
			
		}
	}
	

	
	
	
	
	
	

	//Methode um Bilddateien (800x600) in kleinere Formate zu �ndern.
	//wird f�r die Anzeige der Strecken genutzt
	public static BufferedImage imageResizer(BufferedImage original)
	{
		
		BufferedImage newImage = new BufferedImage(300, 200, BufferedImage.TYPE_INT_RGB);

				Graphics g = newImage.createGraphics();
				g.drawImage(original, 0, 0, 300, 200, null);
				g.dispose();
				return newImage;
	}
	
	public void schwierigkeitBack()
	{
		String s;
		if((s=itString.previous())!=null)
		{
			view.schwierigkeitLbl.setText(s);
		}
		
		
	}
	
	public void pruefeKarts()
	{
		
	}
	
	public void pruefeStrecke()
	{
		
	}
	
	public boolean pruefeSchwierigkeit(String a)
	{
		schwierigkeitsCheck = fahrten.gibSingleplayerFahrtenF�rBenutzer(kunde.getnutzername(),s.getStreckenname());
		Iterator<SingleplayerFahrt> it = schwierigkeitsCheck.iterator();
		boolean pruefung = false;
		while(it.hasNext())
		{
			SingleplayerFahrt sf;
			String check;
			sf = it.next();
			check = sf.getSchwierigkeit();
			if(a.equals(check) && sf.getRang()==1)
				
			pruefung = true;
			break;
				
		}
		return pruefung;
		
		
		
	}
	public void schwierigkeitVorw�rts()
	{
		String s;
		String pr�fung;
		
		if((s=itString.next())!=null)
		{
			pr�fung = view.schwierigkeitLbl.getText();
			if(pruefeSchwierigkeit(pr�fung)==true)
			view.schwierigkeitLbl.setText(s);
			else
				{System.out.println("Schwierigkeit noch nicht freigeschaltet");
				JOptionPane pane = new JOptionPane();
				pane.setBounds(view.frame.getX()+300,view.frame.getY()+250,200,100);
				pane.showMessageDialog(null, "Schwierigkeit nocht nicht freigeschaltet");
					
				itString.previous();
				}
		}
		
	}
	// WICHTIG NOCH �NDERN DA NAME FESTGESCHRIEBEN
	public void starteSpiel()
	{
		if(singlemultiplayer==1)
		{
		String schwierigkeit1 = view.schwierigkeitLbl.getText();
		if(s.equals("Bronze"))
			schwierigkeit = 1;
		if(s.equals("Silber"))
			schwierigkeit = 2;
		if(s.equals("Gold"))
			schwierigkeit = 3;
		sf.setZeit(0);
		int id = fahrten.gibNeueID(2);
		sf.setSitzungsID(id);
		FahrtSpielenStrg strg = new FahrtSpielenStrg(sf,k,s,schwierigkeit);
		sf.setKartName(k.kartname);
		sf.setStreckenName(s.getStreckenname());
		}
		if(singlemultiplayer==2)
		{
			mf.setZeit(0);
			mf.setRang(0);
			int id = fahrten.gibNeueID(1);
			mf.setSitzungsID(id);
			int multiID = fahrten.gibNeueMultiplayerID(); 
			mf.setMultiplayerID(multiID);
			MultiplayerFahrtSpielenStrg strg = new MultiplayerFahrtSpielenStrg(mf,k,s);
		}
		view.frame.dispose();
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==view.kartForward)
		{
			ladeKarts();
		}
		if(e.getSource()==view.kartBackward)
		{
			kartR�ckw�rts();
			
		}
		if(e.getSource()==view.schwierigkeitBtn1)
		{
			schwierigkeitBack();
		}
		if(e.getSource()==view.schwierigkeitBtn2)
		{
			schwierigkeitVorw�rts();
		}
		if(e.getSource()==view.spielenBtn)
		{
		starteSpiel();
		}
		
		if(e.getSource()==view.streckeBackward)
		{
			streckeR�ckw�rts();
		}
		if(e.getSource()==view.streckeForward)
		{
			ladeStrecke();
		}
		
	}
	
	

	
	
	

}
