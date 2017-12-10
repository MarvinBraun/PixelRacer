package FahrtBeitreten;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;

import BackgroundAnimation.LabelBackgroundX;
import BackgroundAnimation.Movement;
import FahrtSpielen.FahrtSpielenStrg;
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

public class FahrtBeitretenView {

	JFrame frame;
	private JLabel background;
	JButton kartForward;
	JButton kartBackward;
	JLabel waehleKart;
	JLabel kartName;
	JLabel kartBild;
	JLabel lblNewLabel;
	JButton multiplayerBeitretenBtn;
	JTextField multiplayerID;
	
	
	
	
	/**
	 * Launch the application.
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
	 * Create the application.
	 */
	public FahrtBeitretenView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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
		waehleKart.setFont(new Font("pixelmix", Font.PLAIN, 30));
		waehleKart.setBounds(173, 16, 210, 50);
		frame.getContentPane().add(waehleKart);
		
		kartName = new JLabel("FireBird");
		kartName.setFont(new Font("pixelmix", Font.PLAIN, 30));
		kartName.setBounds(423, 11, 330, 60);
		frame.getContentPane().add(kartName);
		
				
		Movement m = new Movement(10);
		
		m.label.setBufferedImage("src/Resources/Hintergrund.png",0);
		
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
}
