// @Author Marvin Braun
package BackgroundAnimation;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Label;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

public class LabelBackgroundX extends JLabel {
	int backgroundX1 = 0;
	int backgroundX2 = +800;
	int backgroundSpeed = 1;

	 File background;
	 BufferedImage ib1;
	 BufferedImage ib2;
	 int y;
	
	public  void setBufferedImage(String s, int y)
	{
		try {
			ib1 = ImageIO.read(new File (s));
			ib2 = ImageIO.read(new File(s));
			this.y = y;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void paintComponent (Graphics g)
	{
		super.paintComponent(g);
		this.setBounds(0,y,800,600);
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g.drawImage(ib1,backgroundX1,0,ib1.getWidth(),ib1.getHeight(),null);
		g.drawImage(ib2,backgroundX2,0,ib1.getWidth(),ib1.getHeight(),null);
		this.setVisible(true);
		repaint();
		
	}
}
