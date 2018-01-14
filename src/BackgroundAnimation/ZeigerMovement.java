
package BackgroundAnimation;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Bewegt den Zeiger beim Spielen einer Fahrt horizontal.
 * @author Marvin Braun
 *
 */
public class ZeigerMovement{
	Timer back;
	public LabelZeiger zeiger = new LabelZeiger();
	int speed2=1;

	/**
	 * Setzt die Schnelligkeit des Zeigers.
	 * @param speed3 Bestimmt die Schnelligkeit des Zeigers.
	 */
	public void setSpeed(int speed3)
	
	{
		speed2 = speed3;
	}
	
	/**
	 * Erzeugt ein Objekt und definiert die Geschwindigkeit und die Grenzen der Animation.
	 * @param speed Geschwindigkeit des Zeigers
	 */
	public ZeigerMovement(int speed)
	{
		
		back = new Timer();
		back.scheduleAtFixedRate(new TimerTask() {
			 public void run()
			 {
				while(zeiger.backgroundX1<600)
				{
					
					zeiger.backgroundX1+=speed2;
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(zeiger.backgroundX1>=600)
					{
						while(zeiger.backgroundX1>100)
						{
							
							
							zeiger.backgroundX1-=speed2;
							try {
								Thread.sleep(10);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
				 
			 }
		},0,speed);
		
	}



}
