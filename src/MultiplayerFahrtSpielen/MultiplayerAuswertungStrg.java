package MultiplayerFahrtSpielen;

import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.ListIterator;

import Fahrt.Fahrtverwaltung;
import Fahrt.MultiplayerFahrt;

public class MultiplayerAuswertungStrg {
	MultiplayerAuswertungView view;
	Fahrtverwaltung verwaltung;
	LinkedList<MultiplayerFahrt> fahrten = new LinkedList<MultiplayerFahrt>();
	MultiplayerFahrt fahrt;
	
	public MultiplayerAuswertungStrg(MultiplayerFahrt mf, BufferedImage streckenBild)
	{
		//View initialisieren
		fahrt = mf;
		view = new MultiplayerAuswertungView();
		verwaltung = new Fahrtverwaltung();
		//Fahrten initialisieren
		System.out.println("Es wird gesucht nach: "+mf.getMultiplayerID());
		fahrten = verwaltung.gibMultiplayerFahrtenNachMultiplayerID(mf.getMultiplayerID());	
		ListIterator<MultiplayerFahrt> it = fahrten.listIterator();
		
		view.MultiplayerIdLbl.setText("MultiplayerID: "+ fahrt.getMultiplayerID());
		
		view.frame.setVisible(true);
		
		//Ränge einfügen
		int raenge = 1;
		
		while(it.hasNext()&&raenge<=3)
		{
			fahrt = it.next();
			if(raenge ==1)
			{
				view.lblName1.setText(fahrt.getBenutzername());
				view.lblZeit1.setText(fahrt.getZeit()+"");
			}
			else if(raenge ==2)
			{
				view.lblName2.setText(fahrt.getBenutzername());
				view.lblZeit2.setText(fahrt.getZeit()+"");
			}
			else if(raenge ==3)
			{
				view.lblName3.setText(fahrt.getBenutzername());
				view.lblZeit3.setText(fahrt.getZeit()+"");
			}
			raenge++;
			
		}
		
		
	}

}
