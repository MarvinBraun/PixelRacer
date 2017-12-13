package FahrtSpielen;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class FahrtAuswertung {

	private JFrame frame;
	JButton btnNewButton;
	JLabel lblDeinPlatz;
	JLabel lblNewLabel ;
	JLabel lblDeineZeit;
	JLabel lblGewonnenPunkte;
	private JLabel lblBackground;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FahrtAuswertung window = new FahrtAuswertung();
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
	public FahrtAuswertung() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnNewButton = new JButton("Bestätigen");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(291, 483, 192, 67);
		frame.getContentPane().add(btnNewButton);
		
		lblDeinPlatz = new JLabel("Dein Platz:");
		lblDeinPlatz.setFont(new Font("pixelmix", Font.BOLD, 18));
		lblDeinPlatz.setBounds(145, 60, 212, 73);
		frame.getContentPane().add(lblDeinPlatz);
		
		lblDeineZeit = new JLabel("Deine Zeit:");
		lblDeineZeit.setFont(new Font("pixelmix", Font.BOLD, 18));
		lblDeineZeit.setBounds(431, 60, 234, 73);
		frame.getContentPane().add(lblDeineZeit);
		
		lblGewonnenPunkte = new JLabel("Gewonnene Punkte:");
		lblGewonnenPunkte.setFont(new Font("pixelmix", Font.BOLD, 18));
		lblGewonnenPunkte.setBounds(51, 163, 254, 81);
		frame.getContentPane().add(lblGewonnenPunkte);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Marvin\\OneDrive\\PixelRacer\\src\\Resources\\podest.png"));
		lblNewLabel.setBounds(193, 266, 404, 200);
		frame.getContentPane().add(lblNewLabel);
		
		lblBackground = new JLabel("");
		lblBackground.setBounds(0, 0, 784, 561);
		frame.getContentPane().add(lblBackground);
		frame.setVisible(true);
	}

}
