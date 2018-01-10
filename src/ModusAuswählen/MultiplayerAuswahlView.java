package ModusAusw�hlen;

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
 * Die Klasse MultiplayerAuswahlView f�llt das Fenster mit allen dazugeh�rigen
 * Inhalten (Buttons, Textfelder usw.).
 * 
 * @author Ferhat Koca
 *
 */
public class MultiplayerAuswahlView {

	JFrame frame;
	JButton btnerstellen;
	JButton btnbeitreten;
	JButton btnzur�ck;

	/**
	 * Die main-Methode ruft die Klasse, durch den Konstruktor selber, auf und setzt
	 * das Fenster auf sichtbar.
	 * 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MultiplayerAuswahlView window = new MultiplayerAuswahlView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Initialisiert und bef�llt die grafische Oberfl�che durch die Methode initialize.
	 * 
	 */
	public MultiplayerAuswahlView() throws IOException {
		initialize();
	}

	/**
	 * Initialisiert das Objekt.
	 * @throws IOException wenn ein Fehler beim f�llen des 
	 * Frames ein Fehler entstanden ist.
	 */
	private void initialize() throws IOException {
		
		Font customFont = FontHandler.registriereSchriftart(30f);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setTitle("Multiplayerfahrt ausw�hlen");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		btnerstellen = new JButton("Multiplayerfahrt erstellen");
		btnerstellen.setBounds(80, 237, 280, 31);
		btnerstellen.setFont(customFont);
		frame.getContentPane().add(btnerstellen);

		btnbeitreten = new JButton("Multiplayerfahrt beitreten");
		btnbeitreten.setBounds(440, 237, 280, 31);
		btnbeitreten.setFont(customFont);
		frame.getContentPane().add(btnbeitreten);

		btnzur�ck = new JButton("Zur�ck");
		btnzur�ck.setBounds(325, 289, 150, 31);
		btnzur�ck.setFont(customFont);
		frame.getContentPane().add(btnzur�ck);

		BufferedImage image2 = null;
		try {
			image2 = ImageIO.read(new File("src/Resources/car2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		MovementBackward m = new MovementBackward(5);
		m.label.setLocation(0, 0);
		m.label.setSize(800, 600);
		m.label.setBufferedImage(image2, 400);

		m.label.setBounds(0, 0, 200, 200);
		frame.getContentPane().add(m.label);

		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("src/Resources/hockenheim.png"));
		} catch (IOException io) {
			io.getMessage();
		}
		Movement m2 = new Movement(5);
		m2.label.setLocation(0, 0);
		m2.label.setSize(200, 200);
		m2.label.setBufferedImage(image, 0);

		m2.label.setOpaque(false);
		frame.getContentPane().add(m2.label);
		frame.setVisible(true);

	}

}
