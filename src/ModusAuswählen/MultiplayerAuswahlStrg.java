//@Author Ferhat Koca
package ModusAuswählen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import FahrtErstellen.FahrtErstellenStrg;
import MultiplayerFahrtSpielen.FahrtBeitretenStrg;

public class MultiplayerAuswahlStrg implements ActionListener {

	static MultiplayerAuswahlStrg ms;
	MultiplayerAuswahlView mv;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == mv.btnbeitreten) {
			mv.frame.dispose();
			FahrtBeitretenStrg fb = new FahrtBeitretenStrg();
		}
		if (e.getSource() == mv.btnerstellen) {
			mv.frame.dispose();
			FahrtErstellenStrg strg = new FahrtErstellenStrg(2);
		}
		if (e.getSource() == mv.btnzurück) {
			mv.frame.dispose();
			ModusauswählenStrg ma = new ModusauswählenStrg();
		}
	}

	public MultiplayerAuswahlStrg() {
		try {
			mv = new MultiplayerAuswahlView();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		mv.frame.setVisible(true);
		mv.btnbeitreten.addActionListener(this);
		mv.btnerstellen.addActionListener(this);
		mv.btnzurück.addActionListener(this);
		;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ms = new MultiplayerAuswahlStrg();
	}

}
