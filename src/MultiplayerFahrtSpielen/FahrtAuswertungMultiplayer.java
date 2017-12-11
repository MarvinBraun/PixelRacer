package MultiplayerFahrtSpielen;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class FahrtAuswertungMultiplayer {

	private JFrame frame;
	JButton bestätigenBtn;
	JLabel lblDeinPlatz;
	JLabel lblDeineZeit;
	JLabel lblGewonnenPunkte;
	JLabel lblNewLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FahrtAuswertungMultiplayer window = new FahrtAuswertungMultiplayer();
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
	public FahrtAuswertungMultiplayer() {
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
		
		bestätigenBtn = new JButton("Bestätigen");
	
		bestätigenBtn.setBounds(291, 483, 192, 67);
		frame.getContentPane().add(bestätigenBtn);
		
		lblDeinPlatz = new JLabel("Dein Platz:");
		lblDeinPlatz.setBounds(291, 11, 142, 41);
		frame.getContentPane().add(lblDeinPlatz);
		
		lblDeineZeit = new JLabel("Deine Zeit:");
		lblDeineZeit.setBounds(291, 60, 142, 34);
		frame.getContentPane().add(lblDeineZeit);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Marvin\\OneDrive\\PixelRacer\\src\\Resources\\podest.png"));
		lblNewLabel.setBounds(193, 266, 404, 200);
		frame.getContentPane().add(lblNewLabel);
		frame.setVisible(true);
	}

}
