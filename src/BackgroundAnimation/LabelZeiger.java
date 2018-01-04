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
 * Klasse, zuständig für die Visualisierung der Animation des Zeigers im Spiel.
 * @author Marvin Braun
 *
 */
public class LabelZeiger extends JLabel {
	public int backgroundX1 = 100;
	int backgroundSpeed= 1;
	 File zeigerBild;
	 BufferedImage ib1;
	 int y;

	 /**
	  * setzt die beiden BufferedImages ib1 und ib2.
	  * @param image BufferedImage
	  * @param y int-Variable, falls das Bild an einen bestimmten Y-Wert gesetzt werden soll.
	  */
	public  void setBufferedImage(BufferedImage image, int y)
	{
			ib1 = image;		
		this.y = y;
	}
	
	/**
	 * Zeichnet die Bilder konstant neu auf dem JLabel.
	 */
	public void paintComponent (Graphics g)
	{
		super.paintComponent(g);
		this.setBounds(0,y,800,600);
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	
		g.drawImage(ib1,backgroundX1,300,ib1.getWidth(),ib1.getHeight(),null);
	
		this.setVisible(true);
		repaint();
		
	}
}
