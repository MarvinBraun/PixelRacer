package MitarbeiterBearbeiten;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Font;

/**
@author Sean Cartner
*/

public class MitarbeiterBearbeitenView extends JPanel {

	private JPanel CardPanel;
	private CardLayout cl;
	private JPanel AuswahlPanel;
	private JComboBox comboBoxMitarbeiter;
	private JButton btnWeiter;
	
	/**
	 * Create the panel.
	 */
	public MitarbeiterBearbeitenView() {
		setLayout(null);
		setSize(624, 570);
		
		CardPanel = new JPanel();
		CardPanel.setBounds(0, 0, 624, 570);
		add(CardPanel);
		cl = new CardLayout();
		CardPanel.setLayout(cl);
		CardPanel.setSize(624,570);
		
		AuswahlPanel = new JPanel();
		AuswahlPanel.setSize(624, 570);
		AuswahlPanel.setLayout(null);
		
		comboBoxMitarbeiter = new JComboBox();
		comboBoxMitarbeiter.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxMitarbeiter.setBounds(225, 214, 175, 30);
		AuswahlPanel.add(comboBoxMitarbeiter);
		
		JLabel lblMitarbeiterBearbeiten = new JLabel("Mitarbeiter Bearbeiten");
		lblMitarbeiterBearbeiten.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMitarbeiterBearbeiten.setBounds(78, 30, 237, 30);
		AuswahlPanel.add(lblMitarbeiterBearbeiten);
		
		JLabel lblWhleHierEin = new JLabel("W\u00E4hle hier einen Mitarbeiter aus");
		lblWhleHierEin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblWhleHierEin.setBounds(204, 189, 208, 14);
		AuswahlPanel.add(lblWhleHierEin);
		
		btnWeiter = new JButton("weiter");
		btnWeiter.setBounds(440, 344, 112, 30);
		AuswahlPanel.add(btnWeiter);
		
		
	}

	public JPanel getCardPanel() {
		return CardPanel;
	}

	public CardLayout getCl() {
		return cl;
	}

	public JPanel getAuswahlPanel() {
		return AuswahlPanel;
	}

	public JComboBox getComboBoxMitarbeiter() {
		return comboBoxMitarbeiter;
	}

	public JButton getBtnWeiter() {
		return btnWeiter;
	}
}
