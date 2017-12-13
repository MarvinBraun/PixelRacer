package ModusAusw�hlen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import FahrtErstellen.FahrtErstellenStrg;

public class Modusausw�hlenStrg implements ActionListener {

	static Modusausw�hlenStrg ms;
	ModusAusw�hlenView mv;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == mv.btnSingleplayer) {
			FahrtErstellenStrg.main(null);

		}
		if (e.getSource() == mv.btnMultiplayer) {
			MultiplayerAuswahlStrg.main(null);
		}

	}

	public Modusausw�hlenStrg() {
		mv = new ModusAusw�hlenView();
		mv.frame.setVisible(true);
		mv.btnMultiplayer.addActionListener(this);
		mv.btnSingleplayer.addActionListener(this);
	}

	public static void main(String[] args) {
		ms = new Modusausw�hlenStrg();
	}

}
