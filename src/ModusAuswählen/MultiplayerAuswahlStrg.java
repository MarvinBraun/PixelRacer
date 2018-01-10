package ModusAuswählen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import SingleplayerFahrt.FahrtErstellenStrg;
import MultiplayerFahrt.FahrtBeitretenStrg;

/**
 * Die Klasse MultiplayerAuswahlStrg steuert die Aktionen, die in der Klasse
 * MultiplayerAuswahlView getätigt werden
 * 
 * @author Ferhat Koca
 *
 */
public class MultiplayerAuswahlStrg implements ActionListener {

	static MultiplayerAuswahlStrg ms;
	MultiplayerAuswahlView mv;

	/**
	 * Die Methode actionPerformed liest den Button aus, auf den der Nutzer inder
	 * View klickt und führt die dazugehörige Methode aus.
	 * 
	 * Der Button "Multiplayer beitreten" lässt den Nutzer einer schon bereits
	 * erstellten Fahrt beitreten.
	 * 
	 * Der Button "Multiplayer erstellen" lässt den Nutzer eine eigene
	 * Multiplayerfahrt erstellen.
	 * 
	 * Der "Zurück"-Button bringt den Nutzer zurück zur ModusauswahlenView.
	 */
	public void actionPerformed(ActionEvent e) {
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
			ModusauswaehlenStrg ma = new ModusauswaehlenStrg();
		}
	}

	/**
	 * Der Konstruktor MultiplayerAuswahlStrg ruft die MultiplayerAuswahlView auf
	 * und gibt jedem Button den dazugehörigen Befehl aus der Methode
	 * actionPerformed.
	 */
	public MultiplayerAuswahlStrg() {
		try {
			mv = new MultiplayerAuswahlView();
		} catch (IOException e) {
			e.getMessage();
		}
		mv.frame.setVisible(true);
		mv.btnbeitreten.addActionListener(this);
		mv.btnerstellen.addActionListener(this);
		mv.btnzurück.addActionListener(this);
		;
	}

	public static void main(String[] args) throws IOException {
		ms = new MultiplayerAuswahlStrg();
	}

}
