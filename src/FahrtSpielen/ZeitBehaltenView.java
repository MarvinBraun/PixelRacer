package FahrtSpielen;

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
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class ZeitBehaltenView {

	JFrame frame;
	JButton erneutFahrenBtn;
	JButton zeitBehaltenBtn; 
	JLabel lblRundeXZeit;
	JLabel background;
	static SingleplayerFahrt f;
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
					ZeitBehaltenView window = new ZeitBehaltenView(x1,y2,f,versuche2);
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
	public ZeitBehaltenView(int x, int y, SingleplayerFahrt f, int versuche) {
		initialize();
		x1 = x;
		y2=y;
		zeit2 = f.getZeit();
		lblRundeXZeit.setText("Zeit gefahren: "+zeit2+"s");
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ZeitBehaltenView.class.getResource("/Resources/stopwatch_icon-icons.com_64805.png")));
		lblNewLabel.setBounds(268, 0, 57, 67);
		frame.getContentPane().add(lblNewLabel);
		versuche2 = versuche;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 182, 193));
		frame.setBackground(new Color(211, 211, 211));
		frame.setBounds(100, 100, 354, 136);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(true);
		
		erneutFahrenBtn = new JButton("Erneut Fahren");
		erneutFahrenBtn.setBackground(new Color(176, 224, 230));
		erneutFahrenBtn.setBorderPainted(false);
		erneutFahrenBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		erneutFahrenBtn.setFont(new Font("pixelmix", Font.PLAIN, 12));
		erneutFahrenBtn.setBounds(10, 67, 152, 58);
		frame.getContentPane().add(erneutFahrenBtn);
		
		zeitBehaltenBtn = new JButton("Zeit behalten");
		zeitBehaltenBtn.setBackground(new Color(176, 224, 230));
		zeitBehaltenBtn.setBorderPainted(false);
		zeitBehaltenBtn.setFont(new Font("pixelmix", Font.PLAIN, 12));
		zeitBehaltenBtn.setBounds(185, 67, 159, 58);
		frame.getContentPane().add(zeitBehaltenBtn);
		
		lblRundeXZeit = new JLabel("Zeit gefahren: "+zeit2+"s");
		lblRundeXZeit.setHorizontalAlignment(SwingConstants.CENTER);
		lblRundeXZeit.setFont(new Font("pixelmix", Font.BOLD, 18));
		lblRundeXZeit.setBounds(-16, 11, 315, 45);
		frame.getContentPane().add(lblRundeXZeit);
		
		background = new JLabel("");
		background.setBounds(0, 0, 304, 101);
		frame.getContentPane().add(background);
		frame.setVisible(true);
	}
}
