package ModusAuswählen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
			FahrtBeitretenStrg.main(null);
		}
		if (e.getSource() == mv.btnerstellen) {
			mv.frame.dispose();
			FahrtErstellenStrg.main(null);
		}
	}

	public MultiplayerAuswahlStrg() {
		mv = new MultiplayerAuswahlView();
		mv.frame.setVisible(true);
		mv.btnbeitreten.addActionListener(this);
		mv.btnerstellen.addActionListener(this);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ms = new MultiplayerAuswahlStrg();
	}

}
