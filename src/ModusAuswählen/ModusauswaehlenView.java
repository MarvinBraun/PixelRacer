package ModusAuswählen;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;

import BackgroundAnimation.Movement;
import BackgroundAnimation.MovementBackward;
import FontHandler.FontHandler;

import javax.imageio.ImageIO;
import javax.swing.JButton;

/**
 * ModusauswaehlenView ist die grafische Benutzeroberfläche, die benutzt wird,
 * um dem Nutzer die Auswahl zwischen SingleplayerFahrt und MultiplayerrFahrt
 * anzeigt.
 * 
 * @author Ferhat Koca
 *
 */
public class ModusauswaehlenView {

	JFrame frame;

	JButton btnSingleplayer;
	JButton btnMultiplayer;
	JButton btnzurueck;

	/**
	 * Führt die GUI aus.
	 * 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModusauswaehlenView window = new ModusauswaehlenView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Initialisiert das Objekt und befüllt es über die Methode initialize().
	 * 
	 */
	public ModusauswaehlenView() {
		initialize();
	}

	/**
	 * Initialisiert das Objekt.
	 * 
	 * @throws IOException wenn ein Fehler beim füllen des Frames mit Werten ein Fehler
	 *             		   entstanden ist.
	 */
	private void initialize() {
		
		Font customFont = FontHandler.registriereSchriftart(30f);
		Font customFont22f = FontHandler.registriereSchriftart(22f);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setTitle("Modus auswählen");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		btnSingleplayer = new JButton("Singleplayer");
		btnSingleplayer.setBounds(200, 240, 160, 31);
		btnSingleplayer.setFont(customFont);
		frame.getContentPane().add(btnSingleplayer);

		btnMultiplayer = new JButton("Multiplayer");
		btnMultiplayer.setBounds(440, 240, 160, 31);
		btnMultiplayer.setFont(customFont);
		frame.getContentPane().add(btnMultiplayer);

		btnzurueck = new JButton("Zurück");
		btnzurueck.setBounds(325, 289, 150, 31);
		btnzurueck.setFont(customFont);
		frame.getContentPane().add(btnzurueck);

		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("src/Resources/car2.png"));
		} catch (IOException e) {
			e.getMessage();
			System.out.println("Fehler beim einbeziehen des Bildes!");
		}

		MovementBackward m = new MovementBackward(5);
		m.label.setLocation(0, 0);
		m.label.setSize(200, 200);
		m.label.setBufferedImage(image, 400);

		m.label.setBounds(0, 0, 200, 200);
		frame.getContentPane().add(m.label);

		BufferedImage image2 = null;
		try {
			image2 = ImageIO.read(new File("src/Resources/car2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		MovementBackward m1 = new MovementBackward(5);
		m1.label.setLocation(0, 0);
		m1.label.setSize(800, 600);
		m1.label.setBufferedImage(image2, 400);

		m1.label.setBounds(0, 0, 200, 200);
		frame.getContentPane().add(m1.label);

		BufferedImage image1 = null;
		try {
			image1 = ImageIO.read(new File("src/Resources/hockenheim.png"));
		} catch (IOException io) {
			io.getMessage();
		}
		Movement m2 = new Movement(5);
		m2.label.setLocation(0, 0);
		m2.label.setSize(200, 200);
		m2.label.setBufferedImage(image1, 0);

		m2.label.setOpaque(false);
		frame.getContentPane().add(m2.label);
		frame.setVisible(true);
	}
}
