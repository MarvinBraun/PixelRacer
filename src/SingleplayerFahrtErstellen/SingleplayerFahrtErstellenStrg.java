package SingleplayerFahrtErstellen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.ImageIcon;

import Fahrt.SingleplayerFahrt;
import MusicHandler.MusicPlayer;

import Kart.*;
public class SingleplayerFahrtErstellenStrg implements ActionListener {
	SingleplayerFahrt fahrt;
	SingleplayerFahrtErstellenView view;

	
	Kartverwaltung karts;
	Iterator<Kart> it;
	LinkedList<Kart> kartliste = new LinkedList<Kart>();

	public SingleplayerFahrtErstellenStrg() {
		fahrt = new SingleplayerFahrt();
		view = new SingleplayerFahrtErstellenView();
	
		
		
		karts = new Kartverwaltung();
		kartliste =karts.gibKart();
		it = kartliste.iterator();
		System.out.println(kartliste.size());
		view.kartForward.addActionListener(this);
		try {
			Thread.sleep(400);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		view.frame.setVisible(true);
		

	}
	
	public static void main(String[] args)
	{
		SingleplayerFahrtErstellenStrg strg = new SingleplayerFahrtErstellenStrg();
		MusicPlayer.audioBackground();

	}
	public void ladeKarts()
	{
		Kart k  = null;
		if(it.hasNext()==true)
		{
			k = it.next();
			System.out.println(k.kartname);
			ImageIcon icon = new ImageIcon(k.grafik);
			view.kartBild.setIcon(icon);
			view.kartName.setText(k.kartname);
		
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==view.kartForward)
		{
			System.out.println("funkt");
			ladeKarts();
		}
		
	}
	
	

	
	
	

}
