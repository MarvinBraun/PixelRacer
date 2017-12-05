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
	static int backgroundX1 = 0;
	static int backgroundX2 = -800;
	static int backgroundSpeed = 1;
	
	static File background;
	
	public static void setBufferedImage(String s)
	{
		background = new File(s);
	}
	
	public void paintComponent (Graphics g)
	{
		super.paintComponent(g);
		this.setBounds(0,0,800,600);
		BufferedImage ib1 = null;
		BufferedImage ib2 = null;
		
		try {
			ib1 = ImageIO.read(background);
			ib2 = ImageIO.read(background);
		}
		catch (IOException e)
		{
			System.out.println("Bild konnte nicht geladen werden");
			e.printStackTrace();
		}
		
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g.drawImage(ib1,backgroundX1,0,800,600,null);
		g.drawImage(ib1,backgroundX2,0,800,600,null);
		this.setVisible(true);
		repaint();
		
	}
}
