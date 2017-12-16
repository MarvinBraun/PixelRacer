/**
 @author Sean Cartner
*/

package MitarbeiterAnsicht;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

public class StartView extends JPanel {
	
	protected JButton btnAbmelden;

	/**
	 * Create the panel.
	 */
	public StartView() {
		setLayout(null);
		setSize(624, 570);
		
		JLabel lblPixelRacer = new JLabel("Pixel Racer - Mitarbeiter Men\u00FC");
		lblPixelRacer.setBounds(82, 55, 461, 33);
		lblPixelRacer.setFont(new Font("Tahoma", Font.BOLD, 30));
		add(lblPixelRacer);
		
		btnAbmelden = new JButton("abmelden");
		btnAbmelden.setBounds(438, 509, 105, 23);
		add(btnAbmelden);

	}
}
