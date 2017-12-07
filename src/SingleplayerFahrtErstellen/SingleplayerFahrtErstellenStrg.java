package SingleplayerFahrtErstellen;

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
import javax.swing.SwingUtilities;

import Fahrt.SingleplayerFahrt;
import MusicHandler.MusicPlayer;

import Kart.*;
public class SingleplayerFahrtErstellenStrg implements ActionListener {
	SingleplayerFahrt fahrt;
	SingleplayerFahrtErstellenView view;
	Kart previous;
	boolean forward = false;
	boolean backward = false;
	static Kart k;
	static Kart previousKart;

	
	Kartverwaltung karts;
	static MyIterator<Kart> it;
	static LinkedList<Kart> kartliste = new LinkedList<Kart>();
	


	public SingleplayerFahrtErstellenStrg() {
		fahrt = new SingleplayerFahrt();
		view = new SingleplayerFahrtErstellenView();
	
		karts = new Kartverwaltung();
		kartliste =karts.gibKart();
		it = new MyIterator(kartliste.listIterator());
		
		System.out.println(kartliste.size());
		view.kartForward.addActionListener(this);
		view.kartBackward.addActionListener(this);
	
		//ladeKarts();
		previous = kartliste.get(0);
		
		// test image resizer
		
		BufferedImage image;
		try {
			image = ImageIO.read(new File("src/Resources/hockenheim.png"));
		
		BufferedImage newImage = imageResizer(image);
		ImageIcon icon = new ImageIcon(newImage);
		view.streckeLbl.setIcon(icon);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		SwingUtilities.updateComponentTreeUI(view.frame);
	

		
	}
	
	public static void main(String[] args)
	{
		SingleplayerFahrtErstellenStrg strg = new SingleplayerFahrtErstellenStrg();
		MusicPlayer.audioBackground();

	}
	public void ladeKarts()
	{
		if((k=it.next())!=null)
		{
			System.out.println(k.kartname);
			ImageIcon icon = new ImageIcon(k.grafik);
			view.kartBild.setIcon(icon);
			view.kartName.setText(k.kartname);
		
			previousKart = k;
		}
	}
	
	public void kartBackwards()
	{
		
	
		if((k=it.previous())!=null)
		{
			
			System.out.println(k.kartname);
			ImageIcon icon = new ImageIcon(k.grafik);
			view.kartBild.setIcon(icon);
			view.kartName.setText(k.kartname);
			previousKart = k;
		}
	
	}
	

	
	public static BufferedImage imageResizer(BufferedImage original)
	{
		
		BufferedImage newImage = new BufferedImage(300, 200, BufferedImage.TYPE_INT_RGB);

				Graphics g = newImage.createGraphics();
				g.drawImage(original, 0, 0, 300, 200, null);
				g.dispose();
				return newImage;
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
			kartBackwards();
			
		}
		
	}
	
	

	
	
	

}
