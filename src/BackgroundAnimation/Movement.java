// @Author Marvin Braun
package BackgroundAnimation;

import java.util.Timer;
import java.util.TimerTask;

public class Movement {
	Timer back;
	int backgroundSpeed=10;
	
	public Movement(int speed)
	{
		back = new Timer();
		back.scheduleAtFixedRate(new TimerTask() {
			 public void run()
			 {
				 if(LabelBackgroundX.backgroundX1>-796)
				 {
					 LabelBackgroundX.backgroundX1-=2;
				 }
				 else
				 {
					 LabelBackgroundX.backgroundX1=+800;
				 }
				 
				 if(LabelBackgroundX.backgroundX2>-796)
				 {
					 LabelBackgroundX.backgroundX2-=2;
				 }
				 else
				 {
					 LabelBackgroundX.backgroundX2=+800;
				 }
			 }
		},0,backgroundSpeed);
		
	}

}
