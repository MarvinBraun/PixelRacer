package ModusAuswählen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import FahrtErstellen.FahrtErstellenStrg;

public class ModusauswählenStrg implements ActionListener {

	static ModusauswählenStrg ms;
	ModusAuswählenView mav;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == mav.btnSingleplayer) {
			mav.frame.dispose();
			FahrtErstellenStrg.main(null);
		}
		if (e.getSource() == mav.btnMultiplayer) {
			mav.frame.dispose();
			MultiplayerAuswahlStrg.main(null);

		}

	}

	public ModusauswählenStrg() {
		mav = new ModusAuswählenView();
		mav.frame.setVisible(true);
		mav.btnMultiplayer.addActionListener(this);
		mav.btnSingleplayer.addActionListener(this);

	}

	public static void main(String[] args) {
		ms = new ModusauswählenStrg();
	}

}
