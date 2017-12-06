package SingleplayerFahrtSpielen;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import SingleplayerFahrtErstellen.SingleplayerFahrtErstellenView;
import java.awt.Font;
import javax.swing.border.LineBorder;

import BackgroundAnimation.LabelBackgroundX;
import BackgroundAnimation.Movement;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class SingleplayerFahrtSpielenView {

	private JFrame frame;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SingleplayerFahrtSpielenView window = new SingleplayerFahrtSpielenView();
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
	public SingleplayerFahrtSpielenView() {
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
		
		JButton fahrenBtn = new JButton("Fahren!");
		fahrenBtn.setBackground(new Color(152, 251, 152));
		fahrenBtn.setBorder(new LineBorder(new Color(255, 69, 0), 6));
		fahrenBtn.setFont(new Font("pixelmix", Font.PLAIN, 22));
		fahrenBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ZeitBehaltenView viewZeit = new ZeitBehaltenView();
			
				
				
			}
		});
		fahrenBtn.setBounds(308, 143, 172, 58);
		frame.getContentPane().add(fahrenBtn);
		
		JLabel lblAnzahlVerbleibenderVersuche = new JLabel("Anzahl verbleibender Versuche:");
		lblAnzahlVerbleibenderVersuche.setForeground(Color.RED);
		lblAnzahlVerbleibenderVersuche.setFont(new Font("pixelmix", Font.PLAIN, 18));
		lblAnzahlVerbleibenderVersuche.setBounds(10, 11, 449, 33);
		frame.getContentPane().add(lblAnzahlVerbleibenderVersuche);
		
		JLabel lblLetzteZeit = new JLabel("Letzte Zeit:");
		lblLetzteZeit.setForeground(Color.RED);
		lblLetzteZeit.setFont(new Font("pixelmix", Font.PLAIN, 18));
		lblLetzteZeit.setBounds(10, 55, 296, 33);
		frame.getContentPane().add(lblLetzteZeit);
		
		JLabel lblBestzeitDerStrecke = new JLabel("Bestzeit der Strecke:");
		lblBestzeitDerStrecke.setForeground(Color.RED);
		lblBestzeitDerStrecke.setFont(new Font("pixelmix", Font.PLAIN, 18));
		lblBestzeitDerStrecke.setBounds(10, 105, 368, 23);
		frame.getContentPane().add(lblBestzeitDerStrecke);
	
		Movement m = new Movement(5);
		m.label.setLocation(0, 0);
		m.label.setSize(800, 571);
		m.label.setBufferedImage("src/Resources/car2.png");
		
		m.label.setBounds(0, 0, 800, 571);
		frame.getContentPane().add(m.label);
		

		Movement m2 = new Movement(5);
		m2.label.setLocation(0, 0);
		m2.label.setSize(800, 571);
		m2.label.setBufferedImage("src/Resources/hockenheim.png");
	
		m2.label.setOpaque(false);
		frame.getContentPane().add(m2.label);
		frame.setVisible(true);
		
	}
}
