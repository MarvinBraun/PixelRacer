/**
 * Über dieses Paket wird die Anwendung gestartet.
 */
package Main;

import Anmelden.AnmeldenStrg;
/**
 * Startet die Anwendung
 * @author Marvin Braun
 *
 */
public class StartGame {
	
	public static void main(String[] args)
	{
		MusicHandler.MusicPlayer.audioBackground();
		AnmeldenStrg strg = new AnmeldenStrg();
	}

}
