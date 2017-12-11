package MultiplayerFahrtSpielen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Fahrt.MultiplayerFahrt;

public class MultiplayerZeitBehaltenStrg implements ActionListener

{
	MultiplayerZeitBehaltenView view;
	MultiplayerFahrt mf;
	public MultiplayerZeitBehaltenStrg(MultiplayerFahrt mf, int versuche)
	{
		this.mf = mf;
		view = new MultiplayerZeitBehaltenView();
		view.lblRundeXZeit.setText("Gefahrene Zeit:"+mf.getZeit()+ "Anzahl Versuche: "+versuche);
		view.zeitBehaltenBtn.addActionListener(this);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==view.zeitBehaltenBtn)
		{
			FahrtAuswertungMultiplayerStrg strg = new FahrtAuswertungMultiplayerStrg(mf);
		}
		
	}

}
