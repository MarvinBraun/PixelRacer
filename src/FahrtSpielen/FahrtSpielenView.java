package FahrtSpielen;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.border.LineBorder;

import BackgroundAnimation.LabelBackgroundX;
import BackgroundAnimation.Movement;
import BackgroundAnimation.MovementBackward;
import BackgroundAnimation.ZeigerMovement;
import FahrtErstellen.FahrtErstellenView;

import java.awt.Color;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class FahrtSpielenView {

	private JFrame frame;
	private JLabel lblAnzahlVerbleibenderVersuche;

	private JLabel lblLetzteZeit;
	private JButton fahrenBtn;
	private MovementBackward m;
	private Movement m2;
	private ZeigerMovement zeiger;
	private JLabel balkenLbl;
	
	private static BufferedImage kartbild;
	private static BufferedImage streckenbild;
	private JLabel bewertungLbl;
	
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FahrtSpielenView window = new FahrtSpielenView(kartbild, streckenbild);
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FahrtSpielenView(BufferedImage kart, BufferedImage strecke) {
		kartbild = kart;
		streckenbild = strecke;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 800, 600);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().setResizable(false);
		getFrame().getContentPane().setLayout(null);
		getFrame().setLocationRelativeTo(null);
		
		setFahrenBtn(new JButton("Fahren!"));
		getFahrenBtn().setBackground(new Color(176, 224, 230));
		getFahrenBtn().setBorder(new LineBorder(new Color(255, 69, 0), 6));
		getFahrenBtn().setFont(new Font("pixelmix", Font.PLAIN, 26));
		getFahrenBtn().setBounds(305, 111, 172, 58);
		getFrame().getContentPane().add(getFahrenBtn());
		
		getFrame().setVisible(true);
		getFrame().setFocusable(true);
		getFrame().setFocusTraversalKeysEnabled(false);
		
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("src/Resources/zeiger.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setZeiger(new ZeigerMovement(1));
		getZeiger().balken.setBufferedImage(image, 0);
		getZeiger().balken.setVisible(true);
		getZeiger().balken.setBounds(0,100,800,600);
		getZeiger().balken.setOpaque(false);
		getFrame().getContentPane().add(getZeiger().balken);

		
		setBalkenLbl(new JLabel("New label"));
		getBalkenLbl().setVisible(false);
		
		setBewertungLbl(new JLabel("Druecke Leertaste"));
		getBewertungLbl().setForeground(Color.RED);
		getBewertungLbl().setFont(new Font("pixelmix", Font.BOLD, 35));
		getBewertungLbl().setHorizontalAlignment(SwingConstants.CENTER);
		getBewertungLbl().setVisible(false);
		getBewertungLbl().setBounds(152, 146, 500, 95);
		getFrame().getContentPane().add(getBewertungLbl());
		getBalkenLbl().setIcon(new ImageIcon(FahrtSpielenView.class.getResource("/Resources/ladeBalken.png")));
		getBalkenLbl().setBounds(152, 252, 500, 60);
		getFrame().getContentPane().add(getBalkenLbl());
		
		setLblAnzahlVerbleibenderVersuche(new JLabel("Runden verbleibend: 5"));
		getLblAnzahlVerbleibenderVersuche().setForeground(Color.RED);
		getLblAnzahlVerbleibenderVersuche().setFont(new Font("pixelmix", Font.BOLD, 30));
		getLblAnzahlVerbleibenderVersuche().setBounds(22, 21, 505, 33);
		getFrame().getContentPane().add(getLblAnzahlVerbleibenderVersuche());
		
		setLblLetzteZeit(new JLabel("Zeit verbleibend:"));
		getLblLetzteZeit().setForeground(Color.RED);
		getLblLetzteZeit().setFont(new Font("pixelmix", Font.BOLD, 30));
		getLblLetzteZeit().setBounds(22, 65, 485, 33);
		getFrame().getContentPane().add(getLblLetzteZeit());
	
		m = new MovementBackward(5);
		m.label.setLocation(0, 0);
		m.label.setSize(200, 200);
		m.label.setBufferedImage(kartbild,400);
		
		m.label.setBounds(0, 0, 200, 200);
		getFrame().getContentPane().add(m.label);
		

		m2 = new Movement(5);
		m2.label.setLocation(0, 0);
		m2.label.setSize(800, 571);
		m2.label.setBufferedImage(streckenbild,0);
	
		m2.label.setOpaque(false);
		getFrame().getContentPane().add(m2.label);
		getFrame().setVisible(true);
		
	}

	public JButton getFahrenBtn() {
		return fahrenBtn;
	}

	public void setFahrenBtn(JButton fahrenBtn) {
		this.fahrenBtn = fahrenBtn;
	}

	public ZeigerMovement getZeiger() {
		return zeiger;
	}

	public void setZeiger(ZeigerMovement zeiger) {
		this.zeiger = zeiger;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JLabel getBalkenLbl() {
		return balkenLbl;
	}

	public void setBalkenLbl(JLabel balkenLbl) {
		this.balkenLbl = balkenLbl;
	}

	public JLabel getBewertungLbl() {
		return bewertungLbl;
	}

	public void setBewertungLbl(JLabel bewertungLbl) {
		this.bewertungLbl = bewertungLbl;
	}

	public JLabel getLblAnzahlVerbleibenderVersuche() {
		return lblAnzahlVerbleibenderVersuche;
	}

	public void setLblAnzahlVerbleibenderVersuche(JLabel lblAnzahlVerbleibenderVersuche) {
		this.lblAnzahlVerbleibenderVersuche = lblAnzahlVerbleibenderVersuche;
	}

	public JLabel getLblLetzteZeit() {
		return lblLetzteZeit;
	}

	public void setLblLetzteZeit(JLabel lblLetzteZeit) {
		this.lblLetzteZeit = lblLetzteZeit;
	}
}
