/**
 @author Sean Cartner
*/

package MitarbeiterAnsicht;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MitarbeiterAnsicht {

	private JFrame frmPixelRacer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MitarbeiterAnsicht window = new MitarbeiterAnsicht();
					window.frmPixelRacer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MitarbeiterAnsicht() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPixelRacer = new JFrame();
		frmPixelRacer.setTitle("Pixel Racer - Mitarbeiter Men\u00FC");
		frmPixelRacer.setResizable(false);
		frmPixelRacer.setSize(800, 600);
		frmPixelRacer.setLocationRelativeTo(null);
		frmPixelRacer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPixelRacer.getContentPane().setLayout(null);
		
		JLabel lblPixelRacer = new JLabel("Pixel Racer - Mitarbeiter Men\u00FC");
		lblPixelRacer.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblPixelRacer.setBounds(169, 88, 461, 33);
		frmPixelRacer.getContentPane().add(lblPixelRacer);
		
		JButton btnFgeKartHinzu = new JButton("Füge Kart hinzu");
		btnFgeKartHinzu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnFgeKartHinzu.setBounds(92, 333, 172, 45);
		frmPixelRacer.getContentPane().add(btnFgeKartHinzu);
		
		JButton btnFgeStreckeHinzu = new JButton("F\u00FCge Strecke hinzu");
		btnFgeStreckeHinzu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnFgeStreckeHinzu.setBounds(296, 333, 172, 45);
		frmPixelRacer.getContentPane().add(btnFgeStreckeHinzu);
		
		JButton btnFgeBezahlartHinzu = new JButton("F\u00FCge Bezahlart hinzu");
		btnFgeBezahlartHinzu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnFgeBezahlartHinzu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFgeBezahlartHinzu.setBounds(500, 333, 172, 45);
		frmPixelRacer.getContentPane().add(btnFgeBezahlartHinzu);
		
		JButton btnAbmelden = new JButton("abmelden");
		btnAbmelden.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAbmelden.setBounds(577, 473, 95, 23);
		frmPixelRacer.getContentPane().add(btnAbmelden);
	}
}
