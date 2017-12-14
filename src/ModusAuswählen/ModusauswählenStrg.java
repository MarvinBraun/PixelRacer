package ModusAusw�hlen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import FahrtErstellen.FahrtErstellenStrg;
import Startansicht.StartansichtStrg;

public class Modusausw�hlenStrg implements ActionListener {

	static Modusausw�hlenStrg ms;
	ModusAusw�hlenView mav;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == mav.btnSingleplayer) {
			mav.frame.dispose();
			FahrtErstellenStrg strg = new FahrtErstellenStrg(1);
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
		if (e.getSource() == mav.btnzur�ck) {
			mav.frame.dispose();
			StartansichtStrg sa = new StartansichtStrg();
		}
	}

	public Modusausw�hlenStrg() {
		mav = new ModusAusw�hlenView();
		mav.frame.setVisible(true);
		mav.btnMultiplayer.addActionListener(this);
		mav.btnSingleplayer.addActionListener(this);
		mav.btnzur�ck.addActionListener(this);

	}

	public static void main(String[] args) {
		ms = new Modusausw�hlenStrg();
	}

}
