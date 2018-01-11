package FontHandler;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

/**
 * Registriert die zu benutzende Schriftart "pixelmix"
 * @author Marvin Braun
 */
public class FontHandler {
	
	/**
	 * Gibt eine Schriftart des Typs Font zur�ck
	 * @param f bestimmt die Gr��e der Schrift
	 * @return customFont Schriftart des Typs Font
	 */
	public static Font registriereSchriftart(float f)
	{
		Font customFont = null;
		try {
				customFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/Resources/pixelmix.ttf")).deriveFont(f);
				GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
				ge.registerFont(Font.createFont(Font.TRUETYPE_FONT,new File("src/Resources/pixelmix.ttf")));
				
		}
		
		catch(IOException|FontFormatException e)
		{
			System.out.println("Schrift konnte nicht geladen werden");
		}
		
		return customFont;
	}

}
