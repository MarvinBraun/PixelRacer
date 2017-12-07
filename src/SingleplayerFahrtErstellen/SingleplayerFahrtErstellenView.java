package SingleplayerFahrtErstellen;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;

import BackgroundAnimation.LabelBackgroundX;
import BackgroundAnimation.Movement;
import Kart.Kart;
import MusicHandler.MusicPlayer;
import SingleplayerFahrtSpielen.SingleplayerFahrtSpielenStrg;

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

public class SingleplayerFahrtErstellenView {

	JFrame frame;
	private JLabel background;
	JButton kartForward;
	JButton kartBackward;
	JButton forward2;
	JButton button_1;
	JLabel waehleKart;
	JLabel streckeName;
	JLabel kartName;
	JLabel kartBild;
	JButton backward2;
	JButton button;
	JLabel lblWhleDeineStrecke;
	JButton spielenBtn;
	JLabel lblWhleDeineSchwierigkeit;
	JLabel lblNewLabel;
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SingleplayerFahrtErstellenView window = new SingleplayerFahrtErstellenView();
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
	public SingleplayerFahrtErstellenView() {
		initialize();
		System.out.println("Test2");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		
		kartBackward = new JButton("");
		kartBackward.setBorderPainted(false);
		kartBackward.setContentAreaFilled(false);
		kartBackward.setOpaque(false);
		kartBackward.setIcon(new ImageIcon(SingleplayerFahrtErstellenView.class.getResource("/Resources/backward.png")));
		kartBackward.setBounds(27, 115,60, 60);
		frame.getContentPane().add(kartBackward);
		
		forward2 = new JButton("");
		forward2.setBorderPainted(false);
		forward2.setIcon(new ImageIcon(SingleplayerFahrtErstellenView.class.getResource("/Resources/forward.png")));
		forward2.setContentAreaFilled(false);
		forward2.setBounds(643, 238, 60, 60);
		frame.getContentPane().add(forward2);
		
		button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_1.setBorderPainted(false);
		button_1.setIcon(new ImageIcon(SingleplayerFahrtErstellenView.class.getResource("/Resources/forward.png")));
		button_1.setContentAreaFilled(false);
		button_1.setBounds(280, 489, 60, 60);
		frame.getContentPane().add(button_1);
		
		backward2 = new JButton("");
		backward2.setBorderPainted(false);
		backward2.setIcon(new ImageIcon(SingleplayerFahrtErstellenView.class.getResource("/Resources/backward.png")));
		backward2.setOpaque(false);
		backward2.setContentAreaFilled(false);
		backward2.setBounds(27, 238, 60, 60);
		frame.getContentPane().add(backward2);
		
		button = new JButton("");
		button.setBorderPainted(false);
		button.setIcon(new ImageIcon(SingleplayerFahrtErstellenView.class.getResource("/Resources/backward.png")));
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBounds(39, 489, 60, 60);
		frame.getContentPane().add(button);
		
		spielenBtn = new JButton("Spielen!");
		spielenBtn.setBorderPainted(false);
		spielenBtn.setOpaque(false);
		spielenBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SingleplayerFahrtSpielenStrg strg = new 	SingleplayerFahrtSpielenStrg();
				frame.dispose();
			}
		});
		spielenBtn.setFont(new Font("pixelmix", Font.PLAIN, 30));
		spielenBtn.setBackground(SystemColor.activeCaption);
		spielenBtn.setBounds(435, 468, 210, 59);
		frame.getContentPane().add(spielenBtn);
		
		kartForward = new JButton("");
		kartForward.setBorderPainted(false);
		kartForward.setContentAreaFilled(false);
		kartForward.setIcon(new ImageIcon(SingleplayerFahrtErstellenView.class.getResource("/Resources/forward.png")));
		kartForward.setBounds(643, 115, 60, 60);
		frame.getContentPane().add(kartForward);
		
		waehleKart = new JLabel("Dein Kart:");
		waehleKart.setFont(new Font("pixelmix", Font.PLAIN, 30));
		waehleKart.setBounds(184, 16, 210, 50);
		frame.getContentPane().add(waehleKart);
		
		streckeName = new JLabel("Hockenheim");
		streckeName.setFont(new Font("pixelmix", Font.PLAIN, 27));
		streckeName.setBounds(404, 238, 215, 60);
		frame.getContentPane().add(streckeName);
		
		kartName = new JLabel("FireBird");
		kartName.setFont(new Font("pixelmix", Font.PLAIN, 30));
		kartName.setBounds(404, 11, 259, 60);
		frame.getContentPane().add(kartName);
		
		kartBild = new JLabel("");
		kartBild.setIcon(new ImageIcon("C:\\Users\\Marvin\\OneDrive\\PixelRacer\\src\\Resources\\Car1.png"));
		kartBild.setBounds(88, 69, 545, 122);
		frame.getContentPane().add(kartBild);
		
		lblWhleDeineStrecke = new JLabel("Deine Strecke:");
		lblWhleDeineStrecke.setFont(new Font("pixelmix", Font.PLAIN, 30));
		lblWhleDeineStrecke.setBounds(102, 246, 303, 40);
		frame.getContentPane().add(lblWhleDeineStrecke);
		
		lblWhleDeineSchwierigkeit = new JLabel("Schwierigkeit");
		lblWhleDeineSchwierigkeit.setFont(new Font("pixelmix", Font.PLAIN, 25));
		lblWhleDeineSchwierigkeit.setBounds(107, 493, 233, 40);
		frame.getContentPane().add(lblWhleDeineSchwierigkeit);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(SingleplayerFahrtErstellenView.class.getResource("/Resources/hockenheim.png")));
	//	lblNewLabel.setIcon(new ImageIcon(SingleplayerFahrtErstellenView.class.getResource("/Resources/Rennstrecke1Klein.png")));
	
	
		
		
		lblNewLabel.setBounds(212, 290, 303, 177);
		frame.getContentPane().add(lblNewLabel);
		
		Movement m = new Movement(10);
		
		m.label.setBufferedImage("src/Resources/Hintergrund.png");
		
		m.label.setOpaque(false);
		m.label.setBounds(0, 0, 800, 600);
		frame.getContentPane().add(m.label);
		

	
	}
}
