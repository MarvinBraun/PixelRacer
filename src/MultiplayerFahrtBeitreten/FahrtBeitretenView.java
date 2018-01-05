package MultiplayerFahrtBeitreten;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;

import BackgroundAnimation.LabelBackgroundX;
import BackgroundAnimation.Movement;
import FahrtSpielen.FahrtSpielenStrg;
import FontHandler.FontHandler;
import Kart.Kart;
import MusicHandler.MusicPlayer;

import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.awt.event.ActionEvent;
/**
 * Grafische Benutzeroberfläche um einer MultiplayerFahrt beizutreten.
 * @author Marvin Braun
 *
 */
public class FahrtBeitretenView {

	private JFrame frame;

	private JLabel background;
	private JButton kartForward;
	private JButton kartBackward;
	private JLabel waehleKart;
	private JLabel kartName;
	private JLabel kartBild;
	private JLabel lblNewLabel;
	private JButton multiplayerBeitretenBtn;
	private JTextField multiplayerID;
	private Movement m;
	
	
	
	
	/**
	 * Main-Methode.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FahrtBeitretenView window = new FahrtBeitretenView();
					window.frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	

	/**
	 * Erstellt und befüllt ein Objekt über die Methode initialize().
	 */
	public FahrtBeitretenView() {
		initialize();
	}

	/**
	 * Initialisiert die Inhalte des JFrames.
	 */
	private void initialize() {
		
		Font customFont30f = FontHandler.registriereSchriftart(30f);
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		
		multiplayerID = new JTextField();
		multiplayerID.setToolTipText("MultiplayerID eingeben");
		multiplayerID.setBounds(119, 245, 186, 60);
		frame.getContentPane().add(multiplayerID);
		multiplayerID.setColumns(10);
		
		
		
		kartBackward = new JButton("");
		kartBackward.setFocusable(false);
		kartBackward.setBorderPainted(true);
		kartBackward.setContentAreaFilled(false);
		kartBackward.setOpaque(false);
		kartBackward.setIcon(new ImageIcon(FahrtBeitretenView.class.getResource("/Resources/backward.png")));
		kartBackward.setBounds(27, 115,60, 60);
		frame.getContentPane().add(kartBackward);
		
		
		kartForward = new JButton("");
		kartForward.setFocusable(false);
		kartForward.setBorderPainted(true);
		kartForward.setContentAreaFilled(false);
		kartForward.setIcon(new ImageIcon(FahrtBeitretenView.class.getResource("/Resources/forward.png")));
		kartForward.setBounds(693, 115, 60, 60);
		frame.getContentPane().add(kartForward);
		
		multiplayerBeitretenBtn = new JButton("Multiplayer Beitreten");
		multiplayerBeitretenBtn.setBounds(392, 245, 280, 60);
		frame.getContentPane().add(multiplayerBeitretenBtn);
		
		kartBild = new JLabel("");
		kartBild.setIcon(new ImageIcon("C:\\Users\\Marvin\\OneDrive\\PixelRacer\\src\\Resources\\Car1.png"));
		kartBild.setBounds(127, 78, 545, 122);
		frame.getContentPane().add(kartBild);
		
		waehleKart = new JLabel("Dein Kart:");
		waehleKart.setFont(customFont30f);
		waehleKart.setBounds(173, 16, 210, 50);
		frame.getContentPane().add(waehleKart);
		
		kartName = new JLabel("FireBird");
		kartName.setFont(customFont30f);
		kartName.setBounds(423, 11, 330, 60);
		frame.getContentPane().add(kartName);
		
				
		m = new Movement(10);
		
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("src/Resources/Hintergrund.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		m.label.setBufferedImage(image,0);
		
		m.label.setOpaque(false);
		m.label.setBounds(0, 0, 800, 600);
		frame.getContentPane().add(m.label);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setVisible(false);
		
			//	lblNewLabel.setIcon(new ImageIcon(SingleplayerFahrtErstellenView.class.getResource("/Resources/Rennstrecke1Klein.png")));
			
			
				
				
				lblNewLabel.setBounds(0, 0, 794, 571);
				frame.getContentPane().add(lblNewLabel);
		frame.setVisible(true);
	

	
	}
	public JFrame getFrame() {
		return frame;
	}





	public void setFrame(JFrame frame) {
		this.frame = frame;
	}





	public JLabel getBackground() {
		return background;
	}





	public void setBackground(JLabel background) {
		this.background = background;
	}





	public JButton getKartForward() {
		return kartForward;
	}





	public void setKartForward(JButton kartForward) {
		this.kartForward = kartForward;
	}





	public JButton getKartBackward() {
		return kartBackward;
	}





	public void setKartBackward(JButton kartBackward) {
		this.kartBackward = kartBackward;
	}





	public JLabel getWaehleKart() {
		return waehleKart;
	}





	public void setWaehleKart(JLabel waehleKart) {
		this.waehleKart = waehleKart;
	}





	public JLabel getKartName() {
		return kartName;
	}





	public void setKartName(JLabel kartName) {
		this.kartName = kartName;
	}





	public JLabel getKartBild() {
		return kartBild;
	}





	public void setKartBild(JLabel kartBild) {
		this.kartBild = kartBild;
	}





	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}





	public void setLblNewLabel(JLabel lblNewLabel) {
		this.lblNewLabel = lblNewLabel;
	}





	public JButton getMultiplayerBeitretenBtn() {
		return multiplayerBeitretenBtn;
	}





	public void setMultiplayerBeitretenBtn(JButton multiplayerBeitretenBtn) {
		this.multiplayerBeitretenBtn = multiplayerBeitretenBtn;
	}





	public JTextField getMultiplayerID() {
		return multiplayerID;
	}





	public void setMultiplayerID(JTextField multiplayerID) {
		this.multiplayerID = multiplayerID;
	}





	public Movement getM() {
		return m;
	}





	public void setM(Movement m) {
		this.m = m;
	}

}
