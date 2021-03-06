package ModusAuswaehlen;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.swing.JFrame;

import BackgroundAnimation.Movement;
import BackgroundAnimation.MovementBackward;
import FontHandler.FontHandler;

import javax.imageio.ImageIO;
import javax.swing.JButton;

/**
 * ModusauswaehlenView ist die grafische Benutzeroberflaeche, die benutzt wird,
 * um dem Nutzer die Auswahl zwischen SingleplayerFahrt und MultiplayerrFahrt
 * anzeigt.
 * 
 * @author Ferhat Koca
 *
 */
public class ModusauswaehlenView {

	private JFrame frame;

	private JButton btnSingleplayer;
	private JButton btnMultiplayer;
	private JButton btnzurueck;

	/**
	 * Fuehrt die GUI aus.
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
	 * Initialisiert das Objekt und befuellt es ueber die Methode initialize().
	 * 
	 */
	public ModusauswaehlenView() {
		initialize();
	}

	/**
	 * Initialisiert das Objekt.
	 * 
	 * @throws IOException wenn ein Fehler beim fuellen des Frames mit Werten ein Fehler
	 *             		   entstanden ist.
	 */
	private void initialize() {
		
		Font customFont = FontHandler.registriereSchriftart(30f);
		
		setFrame( new JFrame());
		getFrame().setBounds(100, 100, 800, 600);
		getFrame().setTitle("Modusauswahl");
		getFrame().setResizable(false);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		getFrame().setLocationRelativeTo(null);

		setBtnSingleplayer (new JButton("Singleplayer"));
		getBtnSingleplayer().setBounds(70, 240, 295, 31);
		getBtnSingleplayer().setFont(customFont);
		getBtnSingleplayer().setFocusable(false);
		getBtnSingleplayer().setBorderPainted(false);
		getBtnSingleplayer().setOpaque(false);
		getBtnSingleplayer().setBackground(SystemColor.activeCaption);
		getFrame().getContentPane().add(btnSingleplayer);

		setBtnMultiplayer(new JButton("Multiplayer"));
		getBtnMultiplayer().setBounds(435, 240, 295, 31);
		getBtnMultiplayer().setFont(customFont);
		getBtnMultiplayer().setFocusable(false);
		getBtnMultiplayer().setBorderPainted(false);
		getBtnMultiplayer().setOpaque(false);
		getBtnMultiplayer().setBackground(SystemColor.activeCaption);
		getFrame().getContentPane().add(btnMultiplayer);

		setBtnzurueck( new JButton("Zurueck"));
		getBtnzurueck().setBounds(300, 289, 200, 31);
		getBtnzurueck().setFont(customFont);
		getBtnzurueck().setFocusable(false);
		getBtnzurueck().setBorderPainted(false);
		getBtnzurueck().setOpaque(false);
		getBtnzurueck().setBackground(SystemColor.activeCaption);
		getFrame().getContentPane().add(btnzurueck);

		
		
		BufferedImage image = null;
		try {
			URL url = getClass().getResource("/Resources/car2.png");
			image = ImageIO.read(url);
		} catch (IOException e) {
			e.getMessage();
			 ;
		}

		MovementBackward m = new MovementBackward(5);
		m.label.setLocation(0, 0);
		m.label.setSize(200, 200);
		m.label.setBufferedImage(image, 400);

		m.label.setBounds(0, 0, 200, 200);
		frame.getContentPane().add(m.label);

		BufferedImage image2 = null;
		try {
			URL url1 = getClass().getResource("/Resources/car2.png");
			image2 = ImageIO.read(url1);
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
			URL url2 = getClass().getResource("/Resources/hockenheim.png");
			image1 = ImageIO.read(url2);
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

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JButton getBtnSingleplayer() {
		return btnSingleplayer;
	}

	public void setBtnSingleplayer(JButton btnSingleplayer) {
		this.btnSingleplayer = btnSingleplayer;
		btnSingleplayer.setForeground(Color.WHITE);
	}

	public JButton getBtnMultiplayer() {
		return btnMultiplayer;
	}

	public void setBtnMultiplayer(JButton btnMultiplayer) {
		this.btnMultiplayer = btnMultiplayer;
		btnMultiplayer.setForeground(Color.WHITE);
	}

	public JButton getBtnzurueck() {
		return btnzurueck;
	}

	public void setBtnzurueck(JButton btnzurueck) {
		this.btnzurueck = btnzurueck;
		btnzurueck.setForeground(Color.WHITE);
	}
	
}
