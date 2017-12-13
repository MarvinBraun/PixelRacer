//@author Ferhat Koca
package ModusAusw�hlen;

import java.awt.EventQueue;

import javax.swing.JFrame;

import BackgroundAnimation.Movement;
import BackgroundAnimation.MovementBackward;

import javax.swing.JButton;

public class ModusAusw�hlenView {

	 JFrame frame;

	JButton btnSingleplayer;
	JButton btnMultiplayer;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModusAusw�hlenView window = new ModusAusw�hlenView();
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
	public ModusAusw�hlenView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setTitle("Modus ausw�hlen");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		btnSingleplayer = new JButton("Singleplayer");
		btnSingleplayer.setBounds(178, 241, 187, 31);
		frame.getContentPane().add(btnSingleplayer);
		
		btnMultiplayer = new JButton("Multiplayer");
		btnMultiplayer.setBounds(429, 241, 187, 31);
		frame.getContentPane().add(btnMultiplayer);
		
		MovementBackward m = new MovementBackward(5);
		m.label.setLocation(0, 0);
		m.label.setSize(200, 200);
		m.label.setBufferedImage("src/Resources/car2.png",400);
		
		m.label.setBounds(0, 0, 200, 200);
		frame.getContentPane().add(m.label);
		

		Movement m2 = new Movement(5);
		m2.label.setLocation(0, 0);
		m2.label.setSize(800, 571);
		m2.label.setBufferedImage("src/Resources/hockenheim.png",0);
	
		m2.label.setOpaque(false);
		frame.getContentPane().add(m2.label);
		frame.setVisible(true);
		
	}
}
