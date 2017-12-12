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

public class MitarbeiterAnsichtView {

	protected JFrame frmPixelRacer;
	protected JButton btnFgeKartHinzu;
	protected JButton btnFgeStreckeHinzu;
	protected JButton btnFgeBezahlartHinzu;
	protected JButton btnAbmelden;
	
	

	/**
	 * Create the application.
	 */
	public MitarbeiterAnsichtView() {
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
		lblPixelRacer.setBounds(169, 88, 461, 33);
		lblPixelRacer.setFont(new Font("Tahoma", Font.BOLD, 30));
		frmPixelRacer.getContentPane().add(lblPixelRacer);
		
		btnFgeKartHinzu = new JButton("Füge Kart hinzu");
		btnFgeKartHinzu.setBounds(92, 333, 172, 45);
		btnFgeKartHinzu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frmPixelRacer.getContentPane().add(btnFgeKartHinzu);
		
		btnFgeStreckeHinzu = new JButton("F\u00FCge Strecke hinzu");
		btnFgeStreckeHinzu.setBounds(296, 333, 172, 45);
		btnFgeStreckeHinzu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frmPixelRacer.getContentPane().add(btnFgeStreckeHinzu);
		
		btnFgeBezahlartHinzu = new JButton("F\u00FCge Bezahlart hinzu");
		btnFgeBezahlartHinzu.setBounds(500, 333, 172, 45);
		btnFgeBezahlartHinzu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frmPixelRacer.getContentPane().add(btnFgeBezahlartHinzu);
		
		btnAbmelden = new JButton("abmelden");
		btnAbmelden.setBounds(577, 473, 95, 23);
		btnAbmelden.setFont(new Font("Tahoma", Font.PLAIN, 13));
		frmPixelRacer.getContentPane().add(btnAbmelden);
	}
}
