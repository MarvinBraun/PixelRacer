// @Author Marvin Braun
package BackgroundAnimation;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

public class ZeigerMovement{
	Timer back;
	public LabelBalken balken = new LabelBalken();
	int speed2=1;

	
	public void setSpeed(int speed3)
	{
		speed2 = speed3;
	}
	public ZeigerMovement(int speed)
	{
		
		back = new Timer();
		back.scheduleAtFixedRate(new TimerTask() {
			 public void run()
			 {
				while(balken.backgroundX1<600)
				{
					
					balken.backgroundX1+=speed2;
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(balken.backgroundX1>=600)
					{
						while(balken.backgroundX1>100)
						{
							
							
							balken.backgroundX1-=speed2;
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
