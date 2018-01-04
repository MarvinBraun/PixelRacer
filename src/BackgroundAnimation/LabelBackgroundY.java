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
/**
 * Klasse, zuständig für die Visualisierung der Animation in eine vertikale Richtung.
 * @author Marvin Braun
 *
 */
public class LabelBackgroundY extends JLabel {
	int backgroundY1 = 0;
	int backgroundY2 = -600;
	int backgroundSpeed = 1;

	 File background;
	 BufferedImage ib1;
	 BufferedImage ib2;
	 int x;
	
	 /**
	  * Setzt das zu animierende Bild und den X-Wert der Bilder.
	  * @param image Ein Objekt der Klasse BufferedImage
	  * @param x X-Wert der Animation.
	  */
	public  void setBufferedImage(BufferedImage image, int x)
	{
			ib1 = image;
			ib2 = image;
			this.x = x;
		
	}
	
	/**
	 * Zeichnet die Bilder konstant neu auf dem JLabel.
	 */
	public void paintComponent (Graphics g)
	{
		super.paintComponent(g);
		this.setBounds(x,0,800,600);
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g.drawImage(ib1,0,backgroundY1,ib1.getWidth(),ib1.getHeight(),null);
		g.drawImage(ib2,0,backgroundY2,ib1.getWidth(),ib1.getHeight(),null);
		this.setVisible(true);
		repaint();
		
	}
}
