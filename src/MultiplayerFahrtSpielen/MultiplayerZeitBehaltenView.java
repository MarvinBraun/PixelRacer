package MultiplayerFahrtSpielen;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;

import Fahrt.SingleplayerFahrt;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;

public class MultiplayerZeitBehaltenView {

	private JFrame frame;
	JButton erneutFahrenBtn;
	JButton zeitBehaltenBtn; 
	JLabel lblRundeXZeit;
	JLabel background;
	SingleplayerFahrt f;
	int zeit;
	static int x1;
	static int y2;
	static int zeit2;
	static int versuche2;
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MultiplayerZeitBehaltenView window = new MultiplayerZeitBehaltenView();
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
	public MultiplayerZeitBehaltenView() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBackground(new Color(211, 211, 211));
		frame.setBounds(0,0, 352, 140);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		erneutFahrenBtn = new JButton("Erneut Fahren");
		erneutFahrenBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		erneutFahrenBtn.setFont(new Font("pixelmix", Font.PLAIN, 11));
		erneutFahrenBtn.setBounds(10, 67, 144, 23);
		frame.getContentPane().add(erneutFahrenBtn);
		
		zeitBehaltenBtn = new JButton("Zeit behalten");
		zeitBehaltenBtn.setFont(new Font("pixelmix", Font.PLAIN, 11));
		zeitBehaltenBtn.setBounds(174, 67, 152, 23);
		frame.getContentPane().add(zeitBehaltenBtn);
		
		lblRundeXZeit = new JLabel("Zeit gefahren: "+zeit+"s");
		lblRundeXZeit.setFont(new Font("pixelmix", Font.PLAIN, 13));
		lblRundeXZeit.setBounds(20, 11, 295, 45);
		frame.getContentPane().add(lblRundeXZeit);
		
		background = new JLabel("");
		background.setBounds(0, 0, 336, 101);
		frame.getContentPane().add(background);
		frame.setVisible(true);
	}
}
