package FahrtSpielen;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.border.LineBorder;

import BackgroundAnimation.LabelBackgroundX;
import BackgroundAnimation.Movement;
import BackgroundAnimation.MovementBackward;
import FahrtErstellen.FahrtErstellenView;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class FahrtSpielenView {

	JFrame frame;
	JLabel lblAnzahlVerbleibenderVersuche;

	JLabel lblLetzteZeit;
	JButton fahrenBtn;
	MovementBackward m;
	Movement m2;
	
	static BufferedImage kartbild;
	static BufferedImage streckenbild;
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FahrtSpielenView window = new FahrtSpielenView(kartbild, streckenbild);
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
	public FahrtSpielenView(BufferedImage kart, BufferedImage strecke) {
		kartbild = kart;
		streckenbild = strecke;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		fahrenBtn = new JButton("Fahren!");
		fahrenBtn.setBackground(new Color(176, 224, 230));
		fahrenBtn.setBorder(new LineBorder(new Color(255, 69, 0), 6));
		fahrenBtn.setFont(new Font("pixelmix", Font.PLAIN, 26));
		fahrenBtn.setBounds(306, 214, 172, 58);
		frame.getContentPane().add(fahrenBtn);
		
		lblAnzahlVerbleibenderVersuche = new JLabel("Versuche: 3");
		lblAnzahlVerbleibenderVersuche.setForeground(Color.RED);
		lblAnzahlVerbleibenderVersuche.setFont(new Font("pixelmix", Font.BOLD, 30));
		lblAnzahlVerbleibenderVersuche.setBounds(22, 21, 272, 33);
		frame.getContentPane().add(lblAnzahlVerbleibenderVersuche);
		
		lblLetzteZeit = new JLabel("Zeit: 0s");
		lblLetzteZeit.setForeground(Color.RED);
		lblLetzteZeit.setFont(new Font("pixelmix", Font.BOLD, 26));
		lblLetzteZeit.setBounds(22, 65, 296, 33);
		frame.getContentPane().add(lblLetzteZeit);
	
		m = new MovementBackward(5);
		m.label.setLocation(0, 0);
		m.label.setSize(200, 200);
		m.label.setBufferedImage(kartbild,400);
		
		m.label.setBounds(0, 0, 200, 200);
		frame.getContentPane().add(m.label);
		

		m2 = new Movement(5);
		m2.label.setLocation(0, 0);
		m2.label.setSize(800, 571);
		m2.label.setBufferedImage(streckenbild,0);
	
		m2.label.setOpaque(false);
		frame.getContentPane().add(m2.label);
		frame.setVisible(true);
		
	}
}
