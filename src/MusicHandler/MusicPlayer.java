/**
 * Stellt Methoden zur Verfügung um Musik abzuspielen.
 * @author Marvin Braun
 */

package MusicHandler;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

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
	        FloatControl gainControl = 
	        	    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
	        	gainControl.setValue(-20.0f); // Reduce volume by 20 decibels.
	        
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
	        FloatControl gainControl = 
	        	    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
	        	gainControl.setValue(-10.0f); // Reduce volume by 10 decibels.
	        
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
	        FloatControl gainControl = 
	        	    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
	        	gainControl.setValue(-10.0f); // Reduce volume by 10 decibels.
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
	        FloatControl gainControl = 
	        	    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
	        	gainControl.setValue(-10.0f); // Reduce volume by 10 decibels.
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
	        FloatControl gainControl = 
	        	    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
	        	gainControl.setValue(-10.0f); // Reduce volume by 10 decibels.
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
	        FloatControl gainControl = 
	        	    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
	        	gainControl.setValue(-10.0f); // Reduce volume by 10 decibels.
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
