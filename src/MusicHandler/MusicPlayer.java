
package MusicHandler;

import java.io.File;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
/**
 * Stellt Methoden zur Verfügung um Musik abzuspielen.
 * @author Marvin Braun
 *
 */
public class MusicPlayer {

	/**
	 * Spielt Hintergrundmusik ab.
	 */
	public static void audioBackground(){
		
		try {

			URL url = MusicPlayer.class.getResource("/Resources/backgroundMusic.wav");
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.loop(Clip.LOOP_CONTINUOUSLY);  
	        FloatControl gainControl = 
	        	    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
	        	gainControl.setValue(-20.0f); // Reduce volume by 20 decibels.
	        
	    } catch(Exception ex) {
	    	
	         ;     
	        ex.printStackTrace();
	        
	    }
	}
	/**
	 * Spielt einen Sound ab.
	 */
	public static void startGame()
	{
		try {
			URL url = MusicPlayer.class.getResource("/Resources/startGame.wav");
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	        FloatControl gainControl = 
	        	    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
	        	gainControl.setValue(-10.0f); // Reduce volume by 10 decibels.
	    } catch(Exception ex) {
	    	
	         ;     
	        ex.printStackTrace();
		}
	}
	
	/**
	 * Spielt einen Sound ab
	 */
	public static void spaceBtn()
	{
		try {
			URL url = MusicPlayer.class.getResource("/Resources/spaceBtn.wav");
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	        FloatControl gainControl = 
	        	    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
	        	gainControl.setValue(-10.0f); // Reduce volume by 10 decibels.
	    } catch(Exception ex) {
	    	
	         ;     
	        ex.printStackTrace();
		}
	}
	
	/**
	 * Spielt einen Sound ab
	 */
	public static void forwardBtn()
	{
		try {
			URL url = MusicPlayer.class.getResource("/Resources/forwardBtn.wav");
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start(); 
	        FloatControl gainControl = 
	        	    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
	        	gainControl.setValue(-10.0f); // Reduce volume by 10 decibels.
	    } catch(Exception ex) {
	    	
	         ;     
	        ex.printStackTrace();
		}
	}
	
	/**
	 * Spielt einen Sound ab
	 */
	public static void backwardBtn()
	{
		try {
			URL url = MusicPlayer.class.getResource("/Resources/backwardBtn.wav");
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	        FloatControl gainControl = 
	        	    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
	        	gainControl.setValue(-10.0f); // Reduce volume by 10 decibels.
	    } catch(Exception ex) {
	    	
	         ;     
	        ex.printStackTrace();
		}
	}

}
