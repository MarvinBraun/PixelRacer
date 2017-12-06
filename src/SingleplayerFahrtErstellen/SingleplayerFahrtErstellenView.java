package SingleplayerFahrtErstellen;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;

import BackgroundAnimation.LabelBackgroundX;
import BackgroundAnimation.Movement;
import MusicHandler.MusicPlayer;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
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
		backward.setContentAreaFilled(false);
		backward.setOpaque(false);
		backward.setIcon(new ImageIcon("C:\\Users\\Marvin\\OneDrive\\PixelRacer\\src\\Resources\\backward.png"));
		backward.setBounds(56, 115,60, 60);
		frame.getContentPane().add(backward);
		
		JButton forward2 = new JButton("");
		forward2.setIcon(new ImageIcon("C:\\Users\\Marvin\\OneDrive\\PixelRacer\\src\\Resources\\forward.png"));
		forward2.setContentAreaFilled(false);
		forward2.setBounds(672, 238, 60, 60);
		frame.getContentPane().add(forward2);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon("C:\\Users\\Marvin\\OneDrive\\PixelRacer\\src\\Resources\\forward.png"));
		button_1.setContentAreaFilled(false);
		button_1.setBounds(526, 347, 60, 60);
		frame.getContentPane().add(button_1);
		
		JButton forward = new JButton("");
		forward.setContentAreaFilled(false);
		forward.setIcon(new ImageIcon("C:\\Users\\Marvin\\OneDrive\\PixelRacer\\src\\Resources\\forward.png"));
		forward.setBounds(672, 115, 60, 60);
		frame.getContentPane().add(forward);
		
		JLabel waehleKart = new JLabel("W\u00E4hle dein Kart:");
		waehleKart.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		waehleKart.setBounds(206, 21, 232, 40);
		frame.getContentPane().add(waehleKart);
		
		JLabel streckeName = new JLabel("Hockenheim");
		streckeName.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		streckeName.setBounds(471, 238, 194, 60);
		frame.getContentPane().add(streckeName);
		
		JLabel kartName = new JLabel("FireBird");
		kartName.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		kartName.setBounds(448, 11, 123, 60);
		frame.getContentPane().add(kartName);
		
		JLabel kartBild = new JLabel("New label");
		kartBild.setIcon(new ImageIcon("C:\\Users\\Marvin\\OneDrive\\PixelRacer\\src\\Resources\\Car1.png"));
		kartBild.setBounds(126, 72, 545, 122);
		frame.getContentPane().add(kartBild);
		
		JButton backward2 = new JButton("");
		backward2.setIcon(new ImageIcon("C:\\Users\\Marvin\\OneDrive\\PixelRacer\\src\\Resources\\backward.png"));
		backward2.setOpaque(false);
		backward2.setContentAreaFilled(false);
		backward2.setBounds(56, 238, 60, 60);
		frame.getContentPane().add(backward2);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon("C:\\Users\\Marvin\\OneDrive\\PixelRacer\\src\\Resources\\backward.png"));
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBounds(229, 347, 60, 60);
		frame.getContentPane().add(button);
		
		JLabel lblWhleDeineStrecke = new JLabel("W\u00E4hle deine Strecke:");
		lblWhleDeineStrecke.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		lblWhleDeineStrecke.setBounds(158, 248, 325, 40);
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
		lblWhleDeineSchwierigkeit.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		lblWhleDeineSchwierigkeit.setBounds(311, 354, 187, 40);
		frame.getContentPane().add(lblWhleDeineSchwierigkeit);
	/*	
		LabelBackgroundX.setBufferedImage("src/Resources/Hintergrund.png");
		background =  new LabelBackgroundX();
		Movement m = new Movement(3);
		background.setOpaque(false);
		background.setBounds(0, 0, 800, 600);
		frame.getContentPane().add(background);
		*/
		
	
	}
}
