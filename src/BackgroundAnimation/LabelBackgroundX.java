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
 * Klasse, zuständig für das Zeichnen einer Animation in eine horizontale Richtung.
 * @author Marvin Braun
 *
 */

public class LabelBackgroundX extends JLabel {
	int backgroundX1 = 0;
	int backgroundX2 = +800;
	int backgroundSpeed = 1;

	 File background;
	 BufferedImage ib1;
	 BufferedImage ib2;
	 int y;
	
	 /**
	  * setzt die beiden BufferedImages ib1 und ib2.
	  * @param image BufferedImage
	  * @param y int-Variable, falls das Bild an einen bestimmten Y-Wert gesetzt werden soll.
	  */
	public  void setBufferedImage(BufferedImage image, int y)
	{
			ib1 = image;
			ib2 = image;
			this.y = y;
		
	}
	 /**
	  * Methode zeichnet die beiden Bilder konstant neu. Aktualisierungen der X/Y-Koordinaten werden sofort umgesetzt.
	  */
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
