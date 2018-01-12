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
		
		Font customFont = FontHandler.registriereSchriftart(14f);
		
		setFrame( new JFrame());
		getFrame().setBounds(100, 100, 800, 600);
		getFrame().setTitle("Modus auswaehlen");
		getFrame().setResizable(false);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		getFrame().setLocationRelativeTo(null);

		setBtnSingleplayer (new JButton("Singleplayer"));
		getBtnSingleplayer().setBounds(200, 240, 160, 31);
		getBtnSingleplayer().setFont(customFont);
		getBtnSingleplayer().setBorderPainted(false);
		getBtnSingleplayer().setOpaque(false);
		getBtnSingleplayer().setBackground(SystemColor.activeCaption);
		getFrame().getContentPane().add(btnSingleplayer);

		setBtnMultiplayer(new JButton("Multiplayer"));
		getBtnMultiplayer().setBounds(440, 240, 160, 31);
		getBtnMultiplayer().setFont(customFont);
		getBtnMultiplayer().setBorderPainted(false);
		getBtnMultiplayer().setOpaque(false);
		getBtnMultiplayer().setBackground(SystemColor.activeCaption);
		getFrame().getContentPane().add(btnMultiplayer);

		setBtnzurueck( new JButton("Zurueck"));
		getBtnzurueck().setBounds(325, 289, 150, 31);
		getBtnzurueck().setFont(customFont);
		getBtnzurueck().setBorderPainted(false);
		getBtnzurueck().setOpaque(false);
		getBtnzurueck().setBackground(SystemColor.activeCaption);
		getFrame().getContentPane().add(btnzurueck);

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
