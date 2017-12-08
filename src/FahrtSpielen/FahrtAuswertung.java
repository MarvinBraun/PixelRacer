package FahrtSpielen;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class FahrtAuswertung {

	private JFrame frame;

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
		
		JButton btnNewButton = new JButton("Bestätigen");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(291, 483, 192, 67);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblDeinPlatz = new JLabel("Dein Platz:");
		lblDeinPlatz.setBounds(291, 11, 142, 41);
		frame.getContentPane().add(lblDeinPlatz);
		
		JLabel lblDeineZeit = new JLabel("Deine Zeit:");
		lblDeineZeit.setBounds(291, 60, 142, 34);
		frame.getContentPane().add(lblDeineZeit);
		
		JLabel lblGewonnenPunkte = new JLabel("Gewonnen Punkte:");
		lblGewonnenPunkte.setBounds(291, 108, 142, 41);
		frame.getContentPane().add(lblGewonnenPunkte);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Marvin\\OneDrive\\PixelRacer\\src\\Resources\\podest.png"));
		lblNewLabel.setBounds(193, 266, 404, 200);
		frame.getContentPane().add(lblNewLabel);
	}

}
