package ModusAuswählen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import FahrtBeitreten.FahrtBeitretenStrg;
import FahrtErstellen.FahrtErstellenStrg;

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
	}

	public MultiplayerAuswahlStrg() throws IOException {
		mv = new MultiplayerAuswahlView();
		mv.frame.setVisible(true);
		mv.btnbeitreten.addActionListener(this);
		mv.btnerstellen.addActionListener(this);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ms = new MultiplayerAuswahlStrg();
	}

}
