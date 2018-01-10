package MultiplayerFahrt;

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
import FontHandler.FontHandler;
import SingleplayerFahrt.FahrtErstellenView;

import java.awt.Color;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class MultiplayerFahrtSpielenView {

	private 	JFrame frame;
	private JLabel lblAnzahlVerbleibenderVersuche;
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
		
		Font customFont26f = FontHandler.registriereSchriftart(26f);
		Font customFont30f = FontHandler.registriereSchriftart(30f);
		Font customFont35f = FontHandler.registriereSchriftart(35f);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		fahrenBtn = new JButton("Fahren!");
		fahrenBtn.setBackground(new Color(176, 224, 230));
		fahrenBtn.setBorder(new LineBorder(new Color(255, 69, 0), 6));
		fahrenBtn.setFont(customFont26f);
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
		zeiger.zeiger.setBufferedImage(image, 0);
		zeiger.zeiger.setVisible(true);
		zeiger.zeiger.setBounds(0,100,800,600);
		zeiger.zeiger.setOpaque(false);
		frame.getContentPane().add(zeiger.zeiger);

		
		balkenLbl = new JLabel("New label");
		balkenLbl.setVisible(false);
		
		bewertungLbl = new JLabel("Druecke Leertaste");
		bewertungLbl.setForeground(Color.RED);
		bewertungLbl.setFont(customFont35f);
		bewertungLbl.setHorizontalAlignment(SwingConstants.CENTER);
		bewertungLbl.setVisible(false);
		bewertungLbl.setBounds(152, 146, 500, 95);
		frame.getContentPane().add(bewertungLbl);
		balkenLbl.setIcon(new ImageIcon(MultiplayerFahrtSpielenView.class.getResource("/Resources/ladeBalken.png")));
		balkenLbl.setBounds(152, 252, 500, 60);
		frame.getContentPane().add(balkenLbl);
		
		lblAnzahlVerbleibenderVersuche = new JLabel("Runden verbleibend: 10");
		lblAnzahlVerbleibenderVersuche.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnzahlVerbleibenderVersuche.setForeground(Color.RED);
		lblAnzahlVerbleibenderVersuche.setFont(customFont30f);
		lblAnzahlVerbleibenderVersuche.setBounds(30, 21, 726, 33);
		frame.getContentPane().add(lblAnzahlVerbleibenderVersuche);
	
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
