/**
 @author Sean Cartner
*/

package MitarbeiterAnsicht;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class FunktionNichtVorhandenView extends JPanel {

	/**
	 * Create the panel.
	 */
	public FunktionNichtVorhandenView() {
		setLayout(null);
		setSize(624, 570);
		
		JLabel lblDieseFunktionSteht = new JLabel("Diese Funktion steht aktuell nicht zur Verf\u00FCgung");
		lblDieseFunktionSteht.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDieseFunktionSteht.setBounds(63, 145, 498, 39);
		add(lblDieseFunktionSteht);

	}
}
