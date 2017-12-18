package FahrtSpielen;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import BackgroundAnimation.Movement;
import BackgroundAnimation.MovementY;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class FahrtAuswertung {

	JFrame frame;
	JButton btnNewButton;
	JLabel lblDeinPlatz;
	JLabel lblNewLabel ;
	JLabel lblDeineZeit;
	JLabel lblGewonnenPunkte;
	JLabel lblBackground;
	JLabel lblConfetti;
	MovementY m;
	
	
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
		
		btnNewButton = new JButton("Weiter");
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(new Color(60, 179, 113));
		btnNewButton.setBorder(null);
		btnNewButton.setFont(new Font("pixelmix", Font.BOLD, 34));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(226, 477, 325, 67);
		frame.getContentPane().add(btnNewButton);
		
		lblDeinPlatz = new JLabel("Dein Platz: ");
		lblDeinPlatz.setForeground(Color.RED);
		lblDeinPlatz.setFont(new Font("Dialog", Font.BOLD, 30));
		lblDeinPlatz.setBounds(10, 0, 399, 112);
		frame.getContentPane().add(lblDeinPlatz);
		
		lblDeineZeit = new JLabel("Deine Zeit: ");
		lblDeineZeit.setForeground(Color.RED);
		lblDeineZeit.setFont(new Font("Dialog", Font.BOLD, 30));
		lblDeineZeit.setBounds(10, 87, 345, 112);
		frame.getContentPane().add(lblDeineZeit);
		
		lblGewonnenPunkte = new JLabel("Gewonnene Punkte: ");
		lblGewonnenPunkte.setForeground(Color.RED);
		lblGewonnenPunkte.setFont(new Font("Dialog", Font.BOLD, 30));
		lblGewonnenPunkte.setBounds(10, 171, 399, 124);
		frame.getContentPane().add(lblGewonnenPunkte);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FahrtAuswertung.class.getResource("/Resources/trophae.png")));
		lblNewLabel.setBounds(285, 266, 198, 200);
		frame.getContentPane().add(lblNewLabel);
		
		lblConfetti = new JLabel("");
		lblConfetti.setBounds(0, 0, 784, 561);
		frame.getContentPane().add(lblConfetti);
		
		m = new MovementY(13);
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("src/Resources/konfetti.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		m.label.setBufferedImage(image,0);
		m.label.setOpaque(false);
		m.label.setBounds(100, 100, 800, 600);
		m.label.setVisible(true);
		
		frame.getContentPane().add(m.label);
		
		lblBackground = new JLabel("");
		lblBackground.setBounds(0, 0, 784, 561);
		frame.getContentPane().add(lblBackground);
		
		
		frame.setVisible(true);
		
	
	}

}
