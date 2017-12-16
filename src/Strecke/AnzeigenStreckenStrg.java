package Strecke;


import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

import Datenbankverwaltung.Datenbankschnittstelle;
import Nutzer.Nutzerverwaltung;
import myIterator.MyIteratorStrecke;
import myIterator.MyIteratorString;


public class AnzeigenStreckenStrg implements ActionListener{

	StreckeDetailView viewDetail;
	Streckenuebersicht viewUebersicht;
	
	Streckenverwaltung verwStrecke;
	
	static LinkedList<Strecke> streckenListe = new LinkedList<Strecke>();
	
	Strecke s;
	ResultSet rs;
	
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
	
	public void setDetailView() throws SQLException {
		
		// auf angemeldeten Nutzer umschreiben
		String abfrageAnzRennen = "SELECT BENUTZERNAME, STRECKENNAME, COUNT(SITZUNGSID)FROM SINGLEPLAYER_FAHRT WHERE BENUTZERNAME = 'DZeller' AND STRECKENNAME = 'Hockenheim' GROUP BY BENUTZERNAME, STRECKENNAME";
		
		System.out.println(abfrageAnzRennen);
		
		StreckeDetailView viewDetail= new StreckeDetailView();
		viewDetail.lblSetLaenge.setText(Integer.toString(s.getLaenge())+ "m");
			
			
		rs = Datenbankschnittstelle.executeQuery(abfrageAnzRennen);
		viewDetail.lblSetGesRennen.setText(Integer.toString(rs.getInt(abfrageAnzRennen)));
			
		viewDetail.frame.setVisible(true);
		rs.close();
		Datenbankschnittstelle.closeConnections();
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
			
			try {
				setDetailView();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			
			
		}
		if(e.getSource()==viewDetail.btnZurueck)
		{
			viewDetail.frame.dispose();
		}
		
	}

	
	
}