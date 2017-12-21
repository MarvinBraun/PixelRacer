//@Author Ferhat Koca
package ModusAuswählen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import FahrtErstellen.FahrtErstellenStrg;
import Startansicht.StartansichtStrg;
import Nutzer.Kunde;
import Nutzer.Nutzerverwaltung;

public class ModusauswaehlenStrg implements ActionListener {

	static ModusauswaehlenStrg ms;
	static ModusauswaehlenView mav;
	Kunde kunde;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		kunde = Nutzerverwaltung.getangKunde();
		if (e.getSource() == mav.btnSingleplayer) {
			mav.frame.dispose();
			FahrtErstellenStrg strg = new FahrtErstellenStrg(1);
		}

		if (e.getSource() == mav.btnzurueck) {
			mav.frame.dispose();
			StartansichtStrg sa = new StartansichtStrg();
		}

		
			if (e.getSource() == mav.btnMultiplayer) {
				mav.frame.dispose();
				try {
					MultiplayerAuswahlStrg.main(null);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.getMessage();
					System.out.println("Fehler beim Klicken von MultiplayerButton!");
				}
			}
		}
	

	public ModusauswaehlenStrg() {
		mav = new ModusauswaehlenView();
		mav.frame.setVisible(true);
		mav.btnSingleplayer.addActionListener(this);
		mav.btnzurueck.addActionListener(this);
		if (Nutzerverwaltung.getangKunde().getpremium().equals("false")) {
			mav.btnMultiplayer.setEnabled(false);
		} else {
		mav.btnMultiplayer.addActionListener(this);
	}
	}
	public static void main(String[] args) {
		ms = new ModusauswaehlenStrg();
	}

}
