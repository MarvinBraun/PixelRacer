package ModusAusw�hlen;

import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;

import BackgroundAnimation.Movement;
import BackgroundAnimation.MovementBackward;

import javax.imageio.ImageIO;
import javax.swing.JButton;

/**
 * Die Klasse ModusauswaehlenView f�llt das Fenster mit allen dazugeh�rigen
 * Inhalten (Buttons, Textfelder usw.).
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
	 * Die main-Methode ruft die Klasse, durch den Konstruktor selber, auf und setzt
	 * das Fenster auf sichtbar.
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
	 * Der Konstruktor f�hrt die Methode initialize aus.
	 * 
	 */
	public ModusauswaehlenView() {
		initialize();
	}

	/**
	 * Die Methode initialize f�llt den Inhalt des Frames.
	 * @throws IOException wenn ein Fehler beim f�llen des 
	 * Frames mit Werten ein Fehler entstanden ist.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setTitle("Modus ausw�hlen");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		btnSingleplayer = new JButton("Singleplayer");
		btnSingleplayer.setBounds(200, 240, 160, 31);
		frame.getContentPane().add(btnSingleplayer);

		btnMultiplayer = new JButton("Multiplayer");
		btnMultiplayer.setBounds(440, 240, 160, 31);
		frame.getContentPane().add(btnMultiplayer);

		btnzurueck = new JButton("Zur�ck");
		btnzurueck.setBounds(325, 289, 150, 31);
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
