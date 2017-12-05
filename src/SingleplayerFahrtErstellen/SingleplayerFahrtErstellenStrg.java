package SingleplayerFahrtErstellen;

import Fahrt.SingleplayerFahrt;
import MusicHandler.MusicPlayer;

public class SingleplayerFahrtErstellenStrg {
	SingleplayerFahrt fahrt;
	SingleplayerFahrtErstellenView view;
	
	public SingleplayerFahrtErstellenStrg() {
		fahrt = new SingleplayerFahrt();
		view = new SingleplayerFahrtErstellenView();
		view.frame.setVisible(true);
	
	}
	
	public static void main(String[] args)
	{
		SingleplayerFahrtErstellenStrg strg = new SingleplayerFahrtErstellenStrg();
		MusicPlayer.audioBackground();

	}
	
	
	

}
