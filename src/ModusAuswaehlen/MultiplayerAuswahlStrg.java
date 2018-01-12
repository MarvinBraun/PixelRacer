package ModusAuswaehlen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import SingleplayerFahrt.FahrtErstellenStrg;
import MultiplayerFahrt.FahrtBeitretenStrg;

/**
 * Die Klasse MultiplayerAuswahlStrg steuert die Aktionen, die in der Klasse
 * MultiplayerAuswahlView getaetigt werden.
 * 
 * @author Ferhat Koca
 *
 */
public class MultiplayerAuswahlStrg implements ActionListener {

	static MultiplayerAuswahlStrg ms;
	MultiplayerAuswahlView mv;

	/**
	 * Die Methode actionPerformed liest den Button aus, auf den der Nutzer inder
	 * View klickt und fuehrt die dazugehoerige Methode aus.
	 * 
	 * Der Button "Multiplayer beitreten" laesst den Nutzer einer schon bereits
	 * erstellten Fahrt beitreten.
	 * 
	 * Der Button "Multiplayer erstellen" laesst den Nutzer eine eigene
	 * Multiplayerfahrt erstellen.
	 * 
	 * Der "Zurueck"-Button bringt den Nutzer zurueck zur ModusauswahlenView.
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mv.getBtnbeitreten()) {
			MusicHandler.MusicPlayer.forwardBtn();
			mv.getFrame().dispose();
			FahrtBeitretenStrg fb = new FahrtBeitretenStrg();
		}
		if (e.getSource() == mv.getBtnerstellen()) {
			MusicHandler.MusicPlayer.startGame();
			mv.getFrame().dispose();
			FahrtErstellenStrg strg = new FahrtErstellenStrg(2);
		}
		if (e.getSource() == mv.getBtnzurueck()) {
			MusicHandler.MusicPlayer.backwardBtn();
			mv.getFrame().dispose();
			ModusauswaehlenStrg ma = new ModusauswaehlenStrg();
		}
	}

	/**
	 * Der Konstruktor MultiplayerAuswahlStrg ruft die MultiplayerAuswahlView auf
	 * und gibt jedem Button den dazugehoerigen Befehl aus der Methode
	 * actionPerformed.
	 */
	public MultiplayerAuswahlStrg() {
		try {
			mv = new MultiplayerAuswahlView();
		} catch (IOException e) {
			e.getMessage();
		}
		mv.getFrame().setVisible(true);
		mv.getBtnbeitreten().addActionListener(this);
		mv.getBtnerstellen().addActionListener(this);
		mv.getBtnzurueck().addActionListener(this);
		;
	}

	public static void main(String[] args) throws IOException {
		ms = new MultiplayerAuswahlStrg();
	}

}
