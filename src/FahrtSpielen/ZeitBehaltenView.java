package FahrtSpielen;

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
	JButton erneutFahrenBtn;
	JButton zeitBehaltenBtn; 
	JLabel lblRundeXZeit;
	JLabel background;
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
					ZeitBehaltenView window = new ZeitBehaltenView(x1,y2,zeit2,versuche2);
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
	public ZeitBehaltenView(int x, int y, int zeit, int versuche) {
		initialize(x, y, zeit, versuche);
		x1 = x;
		y2=y;
		zeit2 = zeit;
		versuche2 = versuche;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int x, int y, int zeit, int versuche) {
		
		frame = new JFrame();
		frame.setBackground(new Color(211, 211, 211));
		frame.setBounds(x, y, 352, 140);
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
