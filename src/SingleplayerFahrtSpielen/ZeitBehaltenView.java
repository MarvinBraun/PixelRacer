package SingleplayerFahrtSpielen;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;

public class ZeitBehaltenView {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZeitBehaltenView window = new ZeitBehaltenView();
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
	public ZeitBehaltenView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(new Color(211, 211, 211));
		frame.setBounds(0, 0, 352, 140);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Erneut Fahren");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setFont(new Font("pixelmix", Font.PLAIN, 11));
		btnNewButton.setBounds(10, 67, 144, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Zeit behalten");
		btnNewButton_1.setFont(new Font("pixelmix", Font.PLAIN, 11));
		btnNewButton_1.setBounds(174, 67, 152, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblRundeXZeit = new JLabel("Runde: X, Zeit gefahren:");
		lblRundeXZeit.setFont(new Font("pixelmix", Font.PLAIN, 13));
		lblRundeXZeit.setBounds(20, 11, 295, 45);
		frame.getContentPane().add(lblRundeXZeit);
		
		JLabel background = new JLabel("");
		background.setBounds(0, 0, 336, 101);
		frame.getContentPane().add(background);
		frame.setVisible(true);
	}
}
