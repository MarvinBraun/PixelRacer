package SingleplayerFahrtSpielen;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

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
		
		JButton btnNewButton = new JButton("Fahren!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(296, 105, 172, 58);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblDeineZeitBetrgt = new JLabel("Deine Zeit betr\u00E4gt: 00:00");
		lblDeineZeitBetrgt.setBounds(296, 187, 172, 14);
		frame.getContentPane().add(lblDeineZeitBetrgt);
		
		JButton btnNewButton_1 = new JButton("Zeit behalten");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(213, 223, 135, 58);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton button = new JButton("Neuer Versuch");
		button.setBounds(425, 223, 135, 58);
		frame.getContentPane().add(button);
		
		JLabel lblAnzahlVerbleibenderVersuche = new JLabel("Anzahl verbleibender Versuche:");
		lblAnzahlVerbleibenderVersuche.setBounds(10, 11, 196, 43);
		frame.getContentPane().add(lblAnzahlVerbleibenderVersuche);
		
		JLabel lblLetzteZeit = new JLabel("Letzte Zeit:");
		lblLetzteZeit.setBounds(10, 60, 196, 43);
		frame.getContentPane().add(lblLetzteZeit);
		
		JLabel lblBestzeitDerStrecke = new JLabel("Bestzeit der Strecke:");
		lblBestzeitDerStrecke.setBounds(10, 114, 196, 43);
		frame.getContentPane().add(lblBestzeitDerStrecke);
		
		JLabel background = new JLabel("");
		background.setBounds(-23, -14, 817, 585);
		frame.getContentPane().add(background);
		
	}
}
