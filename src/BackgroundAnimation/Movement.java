// @Author Marvin Braun
package BackgroundAnimation;

import java.util.Timer;
import java.util.TimerTask;

public class Movement {
	Timer back;
	
	public LabelBackgroundX label = new LabelBackgroundX();
	
	public Movement(int speed)
	{
		
		back = new Timer();
		back.scheduleAtFixedRate(new TimerTask() {
			 public void run()
			 {
				 if(label.backgroundX1>-790)
				 {
					label.backgroundX1-=2;
				 }
				 else
				 {
					 label.backgroundX1=+800;
				 }
				 
				 if(label.backgroundX2>-790)
				 {
					 label.backgroundX2-=2;
				 }
				 else
				 {
					 label.backgroundX2=+800;
				 }
			 }
		},0,speed);
		
	}

}
