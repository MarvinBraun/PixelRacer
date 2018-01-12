package ModusAuswaehlen;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
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
 * Die Klasse MultiplayerAuswahlView fuellt das Fenster mit allen dazugehoerigen
 * Inhalten (Buttons, Textfelder usw.).
 * 
 * @author Ferhat Koca
 *
 */
public class MultiplayerAuswahlView {

	private JFrame frame;
	private JButton btnerstellen;
	private JButton btnbeitreten;
	private JButton btnzurueck;

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
	 * Initialisiert und befuellt die grafische Oberflaeche durch die Methode initialize.
	 * 
	 */
	public MultiplayerAuswahlView() throws IOException {
		initialize();
	}

	/**
	 * Initialisiert das Objekt.
	 * @throws IOException wenn ein Fehler beim fuellen des 
	 * Frames ein Fehler entstanden ist.
	 */
	private void initialize() throws IOException {
		
		Font customFont = FontHandler.registriereSchriftart(12f);
	
		setFrame( new JFrame());
		getFrame().setBounds(100, 100, 800, 600);
		getFrame().setTitle("Multiplayerfahrt auswaehlen");
		getFrame().setResizable(false);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		getFrame().setLocationRelativeTo(null);

		setBtnerstellen( new JButton("Multiplayerfahrt erstellen"));
		getBtnerstellen().setBounds(80, 237, 280, 31);
		getBtnerstellen().setFont(customFont);
		getBtnerstellen().setBorderPainted(false);
		getBtnerstellen().setOpaque(false);
		getBtnerstellen().setBackground(SystemColor.activeCaption);
		getFrame().getContentPane().add(btnerstellen);

		setBtnbeitreten( new JButton("Multiplayerfahrt beitreten"));
		getBtnbeitreten().setBounds(440, 237, 280, 31);
		getBtnbeitreten().setFont(customFont);
		getBtnbeitreten().setBorderPainted(false);
		getBtnbeitreten().setOpaque(false);
		getBtnbeitreten().setBackground(SystemColor.activeCaption);
		getFrame().getContentPane().add(btnbeitreten);

		setBtnzurueck( new JButton("Zurueck"));
		getBtnzurueck().setBounds(325, 289, 150, 31);
		getBtnzurueck().setFont(customFont);
		getBtnzurueck().setBorderPainted(false);
		getBtnzurueck().setOpaque(false);
		getBtnzurueck().setBackground(SystemColor.activeCaption);
		getFrame().getContentPane().add(btnzurueck);

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

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JButton getBtnerstellen() {
		return btnerstellen;
	}

	public void setBtnerstellen(JButton btnerstellen) {
		this.btnerstellen = btnerstellen;
		btnerstellen.setForeground(Color.WHITE);
	}

	public JButton getBtnbeitreten() {
		return btnbeitreten;
	}

	public void setBtnbeitreten(JButton btnbeitreten) {
		this.btnbeitreten = btnbeitreten;
		btnbeitreten.setForeground(Color.WHITE);
	}

	public JButton getBtnzurueck() {
		return btnzurueck;
	}

	public void setBtnzurueck(JButton btnzurueck) {
		this.btnzurueck = btnzurueck;
		btnzurueck.setForeground(Color.WHITE);
	}

}
