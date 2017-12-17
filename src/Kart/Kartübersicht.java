//@Author Ferhat Koca
package Kart;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Strecke.Streckenuebersicht;

public class Kartübersicht {

	private JFrame frame;

	JButton kartForward;
	JButton kartBackward;
	JLabel kartLbl;
	JLabel kartName;
	JButton btnDetailView;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kartübersicht window = new Kartübersicht();
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
	public Kartübersicht() {
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

		kartForward = new JButton("");
		kartForward.setBorderPainted(false);
		kartForward.setIcon(new ImageIcon(Streckenuebersicht.class.getResource("/Resources/forward.png")));
		kartForward.setContentAreaFilled(false);
		kartForward.setBounds(712, 238, 60, 60);
		kartForward.setVisible(true);
		frame.getContentPane().add(kartForward);

		kartBackward = new JButton("");
		kartBackward.setBorderPainted(false);
		kartBackward.setIcon(new ImageIcon(Streckenuebersicht.class.getResource("/Resources/backward.png")));
		kartBackward.setOpaque(false);
		kartBackward.setContentAreaFilled(false);
		kartBackward.setBounds(27, 238, 60, 60);
		kartBackward.setVisible(true);
		frame.getContentPane().add(kartBackward);

		kartLbl = new JLabel("", JLabel.CENTER);
		kartLbl.setBounds(247, 144, 300, 200);
		kartLbl.setVisible(true);
		frame.getContentPane().add(kartLbl);

		kartName = new JLabel("Fire Bird", JLabel.CENTER);
		kartName.setFont(new Font("pixelmix", Font.PLAIN, 27));
		kartName.setBounds(296, 355, 215, 60);
		kartName.setVisible(true);
		frame.getContentPane().add(kartName);

		btnDetailView = new JButton("Zeig mir mehr!");
		btnDetailView.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnDetailView.setBounds(282, 428, 229, 35);
		btnDetailView.setVisible(true);
		frame.getContentPane().add(btnDetailView);

	}

}
