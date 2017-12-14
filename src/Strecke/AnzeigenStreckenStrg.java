package Strecke;


import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

import myIterator.MyIteratorStrecke;
import myIterator.MyIteratorString;


public class AnzeigenStreckenStrg implements ActionListener{

	StreckeDetailView viewDetail;
	Streckenuebersicht viewUebersicht;
	
	Streckenverwaltung verwStrecke;
	
	static LinkedList<Strecke> streckenListe = new LinkedList<Strecke>();
	
	Strecke s;
	
	static MyIteratorStrecke<Strecke> itStrecke;
	static MyIteratorString<String> itString;
	
	BufferedImage streckenbild;
	
	boolean forward = false;
	boolean backward = false;
	
	int counter=-1;
	
	public AnzeigenStreckenStrg(){
		
		viewUebersicht = new Streckenuebersicht();
		
		
		verwStrecke = new Streckenverwaltung();
		streckenListe = verwStrecke.gibStrecke();
		itStrecke = new MyIteratorStrecke(streckenListe.listIterator());
		
		viewUebersicht.streckeBackward.addActionListener(this);
		viewUebersicht.streckeForward.addActionListener(this);
		viewUebersicht.btnDetailView.addActionListener(this);
		
		
		
	
		ladeStrecke();
		
		SwingUtilities.updateComponentTreeUI(viewUebersicht.frame);
		
	
	}
		
	public static void main(String[] args) {
		
		AnzeigenStreckenStrg steuerung = new AnzeigenStreckenStrg();
		
	}
	
	public void ladeStrecke()
	{
		if((s=itStrecke.next())!=null)
		{
			
			BufferedImage newImage= s.getGrafik();
			viewUebersicht.streckeName.setText(s.getStreckenname());
			streckenbild = imageResizer(newImage);
			ImageIcon icon = new ImageIcon(streckenbild);
			viewUebersicht.streckeLbl.setIcon(icon);
								
		}
	}
	
	public void streckeRückwärts()
	{
		if((s=itStrecke.previous())!=null)
		{
			
			BufferedImage newImage= s.getGrafik();
			viewUebersicht.streckeName.setText(s.getStreckenname());
			streckenbild = imageResizer(newImage);
			ImageIcon icon = new ImageIcon(streckenbild);
			viewUebersicht.streckeLbl.setIcon(icon);
						
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
		if(e.getSource()==viewUebersicht.streckeBackward)
		{
			streckeRückwärts();
		}
		if(e.getSource()==viewUebersicht.streckeForward)
		{
			ladeStrecke();
		}
		if(e.getSource()==viewUebersicht.btnDetailView)
		{
			StreckeDetailView viewDeatil= new StreckeDetailView();
			viewDeatil.frame.setVisible(true);
		}
		if(e.getSource()==viewDetail.btnZurueck)
		{
			viewDetail.frame.dispose();
		}
		
	}

	
	
}