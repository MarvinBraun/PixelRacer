// @Author Marvin Braun
package BackgroundAnimation;

import java.util.Timer;
import java.util.TimerTask;

public class MovementY {
	Timer back;
	
	public LabelBackgroundY label = new LabelBackgroundY();
	
	public MovementY(int speed)
	{
		
		back = new Timer();
		back.scheduleAtFixedRate(new TimerTask() {
			 public void run()
			 {
				 if(label.backgroundY1<596)
				 {
					label.backgroundY1+=2;
				 }
				 else
				 {
					 label.backgroundY1=-600;
				 }
				 
				 if(label.backgroundY2<595)
				 {
					 label.backgroundY2+=2;
				 }
				 else
				 {
					 label.backgroundY2=-600;
				 }
			 }
		},0,speed);
		
	}

}
