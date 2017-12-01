//@Author Marvin Braun

package MusicHandler;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MusicPlayer {

	public static void audioBackground(){
		
		try {

			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/Resources/music1.wav").getAbsoluteFile());
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.loop(Clip.LOOP_CONTINUOUSLY);  
	        
	    } catch(Exception ex) {
	    	
	        System.out.println("Error with playing sound.");     
	        ex.printStackTrace();
	        
	    }
	}
}
