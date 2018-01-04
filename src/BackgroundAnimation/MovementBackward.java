// @Author Marvin Braun
package BackgroundAnimation;

import java.util.Timer;
import java.util.TimerTask;
/**
 * Bewegt die Bilder der Klasse LabelBackgroundX horizontal (links nach rechts) und erzeugt eine Animation.
 * @author Marvin Braun
 *
 */
public class MovementBackward {
	Timer back;
	
	public LabelBackgroundX label = new LabelBackgroundX();
	/**
	 * Erzeugt ein Objekt und definiert die Geschwindigkeit und die Grenzen der Animation.
	 * @param speed Geschwindigkeit der Animation.
	 */
	public MovementBackward(int speed)
	{
		
		back = new Timer();
		back.scheduleAtFixedRate(new TimerTask() {
			 public void run()
			 {
				 if(label.backgroundX1<796)
				 {
					label.backgroundX1+=2;
				 }
				 else
				 {
					 label.backgroundX1=-800;
				 }
				 
				 if(label.backgroundX2<796)
				 {
					 label.backgroundX2+=2;
				 }
				 else
				 {
					 label.backgroundX2=-800;
				 }
			 }
		},0,speed);
		
	}

}
