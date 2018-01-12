/**
 * Stellt Methoden zur Verfügung um Musik abzuspielen.
 * @author Marvin Braun
 */

package MusicHandler;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MusicPlayer {

	/**
	 * Spielt Hintergrundmusik ab.
	 */
	public static void audioBackground(){
		
		try {

			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/Resources/backgroundMusic.wav").getAbsoluteFile());
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.loop(Clip.LOOP_CONTINUOUSLY);  
	        
	    } catch(Exception ex) {
	    	
	        System.out.println("Error with playing sound.");     
	        ex.printStackTrace();
	        
	    }
	}
	
	public static void audioBtn()
	{
		try {

			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/Resources/music1.wav").getAbsoluteFile());
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);

	        
	    } catch(Exception ex) {
	    	
	        System.out.println("Error with playing sound.");     
	        ex.printStackTrace();
		}
	}
	
	public static void startGame()
	{
		try {

			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/Resources/startGame.wav").getAbsoluteFile());
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	        
	    } catch(Exception ex) {
	    	
	        System.out.println("Error with playing sound.");     
	        ex.printStackTrace();
		}
	}
	
	public static void spaceBtn()
	{
		try {

			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/Resources/spaceBtn.wav").getAbsoluteFile());
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	        
	    } catch(Exception ex) {
	    	
	        System.out.println("Error with playing sound.");     
	        ex.printStackTrace();
		}
	}
	public static void forwardBtn()
	{
		try {

			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/Resources/forwardBtn.wav").getAbsoluteFile());
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start(); 
	        
	    } catch(Exception ex) {
	    	
	        System.out.println("Error with playing sound.");     
	        ex.printStackTrace();
		}
	}
	public static void backwardBtn()
	{
		try {

			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/Resources/backwardBtn.wav").getAbsoluteFile());
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	        
	    } catch(Exception ex) {
	    	
	        System.out.println("Error with playing sound.");     
	        ex.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		audioBackground();
	}
}
