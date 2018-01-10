package ModusAusw�hlen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import SingleplayerFahrt.FahrtErstellenStrg;
import MultiplayerFahrt.FahrtBeitretenStrg;

/**
 * Die Klasse MultiplayerAuswahlStrg steuert die Aktionen, die in der Klasse
 * MultiplayerAuswahlView get�tigt werden
 * 
 * @author Ferhat Koca
 *
 */
public class MultiplayerAuswahlStrg implements ActionListener {

	static MultiplayerAuswahlStrg ms;
	MultiplayerAuswahlView mv;

	/**
	 * Die Methode actionPerformed liest den Button aus, auf den der Nutzer inder
	 * View klickt und f�hrt die dazugeh�rige Methode aus.
	 * 
	 * Der Button "Multiplayer beitreten" l�sst den Nutzer einer schon bereits
	 * erstellten Fahrt beitreten.
	 * 
	 * Der Button "Multiplayer erstellen" l�sst den Nutzer eine eigene
	 * Multiplayerfahrt erstellen.
	 * 
	 * Der "Zur�ck"-Button bringt den Nutzer zur�ck zur ModusauswahlenView.
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
		if (e.getSource() == mv.btnzur�ck) {
			mv.frame.dispose();
			ModusauswaehlenStrg ma = new ModusauswaehlenStrg();
		}
	}

	/**
	 * Der Konstruktor MultiplayerAuswahlStrg ruft die MultiplayerAuswahlView auf
	 * und gibt jedem Button den dazugeh�rigen Befehl aus der Methode
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
		mv.btnzur�ck.addActionListener(this);
		;
	}

	public static void main(String[] args) throws IOException {
		ms = new MultiplayerAuswahlStrg();
	}

}
