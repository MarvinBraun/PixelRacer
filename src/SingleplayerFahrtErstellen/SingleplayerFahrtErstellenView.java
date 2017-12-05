package SingleplayerFahrtErstellen;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;

import MusicHandler.MusicPlayer;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SingleplayerFahrtErstellenView {

	JFrame frame;
	private final JLabel lblNewLabel_1 = new JLabel("");

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
		backward.setBounds(83, 115,60, 60);
		frame.getContentPane().add(backward);
		
		JButton forward = new JButton("");
		forward.setContentAreaFilled(false);
		forward.setIcon(new ImageIcon("C:\\Users\\Marvin\\OneDrive\\PixelRacer\\src\\Resources\\forward.png"));
		forward.setBounds(647, 115, 60, 60);
		frame.getContentPane().add(forward);
		
		JLabel waehleKart = new JLabel("W\u00E4hle dein Kart:");
		waehleKart.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		waehleKart.setBounds(280, 11, 232, 40);
		frame.getContentPane().add(waehleKart);
		
		JLabel streckeName = new JLabel("N\u00FCrnburgring");
		streckeName.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		streckeName.setBounds(318, 415, 194, 60);
		frame.getContentPane().add(streckeName);
		
		JLabel kartName = new JLabel("FireBird");
		kartName.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		kartName.setBounds(345, 188, 123, 60);
		frame.getContentPane().add(kartName);
		
		JLabel kartBild = new JLabel("New label");
		kartBild.setIcon(new ImageIcon("C:\\Users\\Marvin\\OneDrive\\PixelRacer\\src\\Resources\\Car1.png"));
		kartBild.setBounds(126, 72, 545, 122);
		frame.getContentPane().add(kartBild);
		
		JButton backward2 = new JButton("");
		backward2.setIcon(new ImageIcon("C:\\Users\\Marvin\\OneDrive\\PixelRacer\\src\\Resources\\backward.png"));
		backward2.setOpaque(false);
		backward2.setContentAreaFilled(false);
		backward2.setBounds(83, 344, 60, 60);
		frame.getContentPane().add(backward2);
		
		JButton forward2 = new JButton("");
		forward2.setIcon(new ImageIcon("C:\\Users\\Marvin\\OneDrive\\PixelRacer\\src\\Resources\\forward.png"));
		forward2.setContentAreaFilled(false);
		forward2.setBounds(647, 344, 60, 60);
		frame.getContentPane().add(forward2);
		
		JLabel lblWhleDeineStrecke = new JLabel("W\u00E4hle deine Strecke:");
		lblWhleDeineStrecke.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		lblWhleDeineStrecke.setBounds(255, 266, 325, 40);
		frame.getContentPane().add(lblWhleDeineStrecke);
		
		JButton spielenBtn = new JButton("Spielen!");
		spielenBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		spielenBtn.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		spielenBtn.setBackground(SystemColor.activeCaption);
		spielenBtn.setBounds(258, 501, 294, 70);
		frame.getContentPane().add(spielenBtn);
		
		JLabel strecke = new JLabel("");
		strecke.setIcon(new ImageIcon("C:\\Users\\Marvin\\OneDrive\\PixelRacer\\src\\Resources\\map1.png"));
		strecke.setBounds(175, 327, 449, 77);
		frame.getContentPane().add(strecke);
		
		lblNewLabel_1.setOpaque(false);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Marvin\\OneDrive\\PixelRacer\\src\\Resources\\SingleplayerFahrtErstellenGif.gif"));
		lblNewLabel_1.setBounds(0, 0, 794, 571);
		frame.getContentPane().add(lblNewLabel_1);
		
	
	}
}
