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

	private JFrame frame;
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
					MusicPlayer.audio();
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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton backward = new JButton("");
		backward.setContentAreaFilled(false);
		backward.setOpaque(false);
		backward.setIcon(new ImageIcon("C:\\Users\\Marvin\\OneDrive\\PixelRacer\\src\\Resources\\backward.png"));
		backward.setBounds(310, 271,60, 60);
		frame.getContentPane().add(backward);
		
		JButton forward = new JButton("");
		forward.setContentAreaFilled(false);
		forward.setIcon(new ImageIcon("C:\\Users\\Marvin\\OneDrive\\PixelRacer\\src\\Resources\\forward.png"));
		forward.setBounds(795, 271, 60, 60);
		frame.getContentPane().add(forward);
		
		JLabel lblNewLabel = new JLabel("W\u00E4hle dein Kart:");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		lblNewLabel.setBounds(459, 72, 232, 40);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNrnburgring = new JLabel("N\u00FCrnburgring");
		lblNrnburgring.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		lblNrnburgring.setBounds(497, 663, 194, 60);
		frame.getContentPane().add(lblNrnburgring);
		
		JLabel kartName = new JLabel("FireBird");
		kartName.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		kartName.setBounds(524, 271, 123, 60);
		frame.getContentPane().add(kartName);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Marvin\\OneDrive\\PixelRacer\\src\\Resources\\Car1.png"));
		lblNewLabel_3.setBounds(310, 123, 545, 122);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon("C:\\Users\\Marvin\\OneDrive\\PixelRacer\\src\\Resources\\backward.png"));
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBounds(280, 663, 60, 60);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon("C:\\Users\\Marvin\\OneDrive\\PixelRacer\\src\\Resources\\forward.png"));
		button_1.setContentAreaFilled(false);
		button_1.setBounds(849, 663, 60, 60);
		frame.getContentPane().add(button_1);
		
		JLabel lblWhleDeineStrecke = new JLabel("W\u00E4hle deine Strecke:");
		lblWhleDeineStrecke.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		lblWhleDeineStrecke.setBounds(433, 401, 325, 40);
		frame.getContentPane().add(lblWhleDeineStrecke);
		
		JButton btnNewButton = new JButton("Spielen!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setBounds(444, 757, 294, 70);
		frame.getContentPane().add(btnNewButton);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\Marvin\\OneDrive\\PixelRacer\\src\\Resources\\map1.png"));
		label_1.setBounds(310, 452, 545, 200);
		frame.getContentPane().add(label_1);
		
		lblNewLabel_1.setOpaque(false);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Marvin\\OneDrive\\PixelRacer\\src\\Resources\\SingleplayerFahrtErstellenGif.gif"));
		lblNewLabel_1.setBounds(0, 0, 1200, 900);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
