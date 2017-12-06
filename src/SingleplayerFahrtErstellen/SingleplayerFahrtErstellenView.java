package SingleplayerFahrtErstellen;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;

import BackgroundAnimation.LabelBackgroundX;
import BackgroundAnimation.Movement;
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
import java.awt.event.ActionEvent;

public class SingleplayerFahrtErstellenView {

	JFrame frame;
	private JLabel background;

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
		
		JButton backward = new JButton("");
		backward.setBorderPainted(false);
		backward.setContentAreaFilled(false);
		backward.setOpaque(false);
		backward.setIcon(new ImageIcon("C:\\Users\\Marvin\\OneDrive\\PixelRacer\\src\\Resources\\backward.png"));
		backward.setBounds(56, 115,60, 60);
		frame.getContentPane().add(backward);
		
		JButton forward2 = new JButton("");
		forward2.setBorderPainted(false);
		forward2.setIcon(new ImageIcon("C:\\Users\\Marvin\\OneDrive\\PixelRacer\\src\\Resources\\forward.png"));
		forward2.setContentAreaFilled(false);
		forward2.setBounds(672, 238, 60, 60);
		frame.getContentPane().add(forward2);
		
		JButton button_1 = new JButton("");
		button_1.setBorderPainted(false);
		button_1.setIcon(new ImageIcon("C:\\Users\\Marvin\\OneDrive\\PixelRacer\\src\\Resources\\forward.png"));
		button_1.setContentAreaFilled(false);
		button_1.setBounds(504, 500, 60, 60);
		frame.getContentPane().add(button_1);
		
		JButton forward = new JButton("");
		forward.setBorderPainted(false);
		forward.setContentAreaFilled(false);
		forward.setIcon(new ImageIcon("C:\\Users\\Marvin\\OneDrive\\PixelRacer\\src\\Resources\\forward.png"));
		forward.setBounds(672, 115, 60, 60);
		frame.getContentPane().add(forward);
		
		JLabel waehleKart = new JLabel("Dein Kart:");
		waehleKart.setFont(new Font("pixelmix", Font.PLAIN, 30));
		waehleKart.setBounds(184, 16, 210, 50);
		frame.getContentPane().add(waehleKart);
		
		JLabel streckeName = new JLabel("Hockenheim");
		streckeName.setFont(new Font("pixelmix", Font.PLAIN, 25));
		streckeName.setBounds(439, 238, 194, 60);
		frame.getContentPane().add(streckeName);
		
		JLabel kartName = new JLabel("FireBird");
		kartName.setFont(new Font("pixelmix", Font.PLAIN, 30));
		kartName.setBounds(404, 11, 259, 60);
		frame.getContentPane().add(kartName);
		
		JLabel kartBild = new JLabel("New label");
		kartBild.setIcon(new ImageIcon("C:\\Users\\Marvin\\OneDrive\\PixelRacer\\src\\Resources\\Car1.png"));
		kartBild.setBounds(126, 72, 545, 122);
		frame.getContentPane().add(kartBild);
		
		JButton backward2 = new JButton("");
		backward2.setBorderPainted(false);
		backward2.setIcon(new ImageIcon("C:\\Users\\Marvin\\OneDrive\\PixelRacer\\src\\Resources\\backward.png"));
		backward2.setOpaque(false);
		backward2.setContentAreaFilled(false);
		backward2.setBounds(56, 238, 60, 60);
		frame.getContentPane().add(backward2);
		
		JButton button = new JButton("");
		button.setBorderPainted(false);
		button.setIcon(new ImageIcon("C:\\Users\\Marvin\\OneDrive\\PixelRacer\\src\\Resources\\backward.png"));
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBounds(143, 500, 60, 60);
		frame.getContentPane().add(button);
		
		JLabel lblWhleDeineStrecke = new JLabel("Deine Strecke:");
		lblWhleDeineStrecke.setFont(new Font("pixelmix", Font.PLAIN, 30));
		lblWhleDeineStrecke.setBounds(126, 246, 303, 40);
		frame.getContentPane().add(lblWhleDeineStrecke);
		
		JButton spielenBtn = new JButton("Spielen!");
		spielenBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		spielenBtn.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		spielenBtn.setBackground(SystemColor.activeCaption);
		spielenBtn.setBounds(574, 501, 210, 59);
		frame.getContentPane().add(spielenBtn);
		
		JLabel lblWhleDeineSchwierigkeit = new JLabel("Schwierigkeit");
		lblWhleDeineSchwierigkeit.setFont(new Font("pixelmix", Font.PLAIN, 25));
		lblWhleDeineSchwierigkeit.setBounds(244, 510, 233, 40);
		frame.getContentPane().add(lblWhleDeineSchwierigkeit);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(SingleplayerFahrtErstellenView.class.getResource("/Resources/Rennstrecke1Klein.png")));
	
	
		
		
			lblNewLabel.setBounds(244, 297, 303, 177);
			frame.getContentPane().add(lblNewLabel);
		
		
	
		LabelBackgroundX.setBufferedImage("src/Resources/Hintergrund.png");
		background =  new LabelBackgroundX();
		Movement m = new Movement(3);
		background.setOpaque(false);
		background.setBounds(0, 0, 800, 600);
		frame.getContentPane().add(background);
		

	
	}
}
