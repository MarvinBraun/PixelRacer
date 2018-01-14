/**
 * Über dieses Paket wird die Anwendung gestartet.
 */
package Main;

import javax.swing.SwingUtilities;

import Anmelden.AnmeldenStrg;
/**
 * Startet die Anwendung
 * @author Marvin Braun
 *
 */
public class StartGame {
	
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
				{
			public void run()
			{
				MusicHandler.MusicPlayer.audioBackground();
				AnmeldenStrg strg = new AnmeldenStrg();
			}
				});
	
	}

}
