package Strecke;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.image.BufferedImage;
import javax.swing.*;



public class Streckenuebersicht {

	JFrame frame;
	JButton streckeForward;
	JButton streckeBackward;
	JLabel streckeName;
	JLabel streckeLbl;
	JLabel lblNewLabel;
	JButton btnDetailView;
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Streckenuebersicht window = new Streckenuebersicht();
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
	public Streckenuebersicht() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		
		streckeForward = new JButton("");
		streckeForward.setBorderPainted(false);
		streckeForward.setIcon(new ImageIcon(Streckenuebersicht.class.getResource("/Resources/forward.png")));
		streckeForward.setContentAreaFilled(false);
		streckeForward.setBounds(712, 238, 60, 60);
		streckeForward.setVisible(true);
		frame.getContentPane().add(streckeForward);
		
		streckeBackward = new JButton("");
		streckeBackward.setBorderPainted(false);
		streckeBackward.setIcon(new ImageIcon(Streckenuebersicht.class.getResource("/Resources/backward.png")));
		streckeBackward.setOpaque(false);
		streckeBackward.setContentAreaFilled(false);
		streckeBackward.setBounds(27, 238, 60, 60);
		streckeBackward.setVisible(true);
		frame.getContentPane().add(streckeBackward);
		
		streckeLbl = new JLabel("", JLabel.CENTER);
		streckeLbl.setBounds(247, 144, 300, 200);
		streckeLbl.setVisible(true);
		frame.getContentPane().add(streckeLbl);
		
		
		streckeName = new JLabel("Hockenheim", JLabel.CENTER);
		streckeName.setFont(new Font("pixelmix", Font.PLAIN, 27));
		streckeName.setBounds(296, 355, 215, 60);
		streckeName.setVisible(true);
		frame.getContentPane().add(streckeName);
		
		btnDetailView = new JButton("Zeig mir mehr!");
		btnDetailView.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnDetailView.setBounds(282, 428, 229, 35);
		btnDetailView.setVisible(true);
		frame.getContentPane().add(btnDetailView);
		
				
	
	}
}
