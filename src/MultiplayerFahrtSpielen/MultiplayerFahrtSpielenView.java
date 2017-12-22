package MultiplayerFahrtSpielen;

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

public class MultiplayerFahrtSpielenView {

	private 	JFrame frame;
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
					MultiplayerFahrtSpielenView window = new MultiplayerFahrtSpielenView(kartbild, streckenbild);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MultiplayerFahrtSpielenView(BufferedImage kart, BufferedImage strecke) {
		kartbild = kart;
		streckenbild = strecke;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		fahrenBtn = new JButton("Fahren!");
		fahrenBtn.setBackground(new Color(176, 224, 230));
		fahrenBtn.setBorder(new LineBorder(new Color(255, 69, 0), 6));
		fahrenBtn.setFont(new Font("pixelmix", Font.PLAIN, 26));
		fahrenBtn.setBounds(305, 98, 172, 58);
		frame.getContentPane().add(fahrenBtn);
		
		frame.setVisible(true);
		frame.setFocusable(true);
		frame.setFocusTraversalKeysEnabled(false);
		
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("src/Resources/zeiger.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		zeiger = new ZeigerMovement(1);
		zeiger.balken.setBufferedImage(image, 0);
		zeiger.balken.setVisible(true);
		zeiger.balken.setBounds(0,100,800,600);
		zeiger.balken.setOpaque(false);
		frame.getContentPane().add(zeiger.balken);

		
		balkenLbl = new JLabel("New label");
		balkenLbl.setVisible(false);
		
		bewertungLbl = new JLabel("Druecke Leertaste");
		bewertungLbl.setForeground(Color.RED);
		bewertungLbl.setFont(new Font("pixelmix", Font.BOLD, 35));
		bewertungLbl.setHorizontalAlignment(SwingConstants.CENTER);
		bewertungLbl.setVisible(false);
		bewertungLbl.setBounds(152, 146, 500, 95);
		frame.getContentPane().add(bewertungLbl);
		balkenLbl.setIcon(new ImageIcon(MultiplayerFahrtSpielenView.class.getResource("/Resources/ladeBalken.png")));
		balkenLbl.setBounds(152, 252, 500, 60);
		frame.getContentPane().add(balkenLbl);
		
		lblAnzahlVerbleibenderVersuche = new JLabel("Runden verbleibend: 5");
		lblAnzahlVerbleibenderVersuche.setForeground(Color.RED);
		lblAnzahlVerbleibenderVersuche.setFont(new Font("pixelmix", Font.BOLD, 30));
		lblAnzahlVerbleibenderVersuche.setBounds(22, 21, 381, 33);
		frame.getContentPane().add(lblAnzahlVerbleibenderVersuche);
		
		lblLetzteZeit = new JLabel("Zeit: 0s");
		lblLetzteZeit.setForeground(Color.RED);
		lblLetzteZeit.setFont(new Font("Dialog", Font.BOLD, 30));
		lblLetzteZeit.setBounds(22, 65, 296, 33);
		frame.getContentPane().add(lblLetzteZeit);
	
		m = new MovementBackward(5);
		m.label.setLocation(0, 0);
		m.label.setSize(200, 200);
		m.label.setBufferedImage(kartbild,400);
		
		m.label.setBounds(0, 0, 200, 200);
		frame.getContentPane().add(m.label);
		

		m2 = new Movement(5);
		m2.label.setLocation(0, 0);
		m2.label.setSize(800, 571);
		m2.label.setBufferedImage(streckenbild,0);
	
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

	public JButton getFahrenBtn() {
		return fahrenBtn;
	}

	public void setFahrenBtn(JButton fahrenBtn) {
		this.fahrenBtn = fahrenBtn;
	}

	public MovementBackward getM() {
		return m;
	}

	public void setM(MovementBackward m) {
		this.m = m;
	}

	public Movement getM2() {
		return m2;
	}

	public void setM2(Movement m2) {
		this.m2 = m2;
	}

	public ZeigerMovement getZeiger() {
		return zeiger;
	}

	public void setZeiger(ZeigerMovement zeiger) {
		this.zeiger = zeiger;
	}

	public JLabel getBalkenLbl() {
		return balkenLbl;
	}

	public void setBalkenLbl(JLabel balkenLbl) {
		this.balkenLbl = balkenLbl;
	}

	public static BufferedImage getKartbild() {
		return kartbild;
	}

	public static void setKartbild(BufferedImage kartbild) {
		MultiplayerFahrtSpielenView.kartbild = kartbild;
	}

	public static BufferedImage getStreckenbild() {
		return streckenbild;
	}

	public static void setStreckenbild(BufferedImage streckenbild) {
		MultiplayerFahrtSpielenView.streckenbild = streckenbild;
	}

	public JLabel getBewertungLbl() {
		return bewertungLbl;
	}

	public void setBewertungLbl(JLabel bewertungLbl) {
		this.bewertungLbl = bewertungLbl;
	}
}
