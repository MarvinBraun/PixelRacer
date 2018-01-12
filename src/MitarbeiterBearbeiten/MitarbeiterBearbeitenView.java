package MitarbeiterBearbeiten;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Font;

/**
 * Grafische Benutzeroberfl�che, die dazu dient, dass der Nutzer mittels einer
 * ComboBox einen Mitarbeiter zum Ausw�hlen ausw�hlen kann. Die Oberfl�che verf�gt �ber das
 * CardLayout, �ber das die MitarbeiterHinzuf�genView angezeigt werden kann.
 * 
 * @author Sean Cartner
 *
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
		CardPanel.setSize(624, 570);

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

	/**
	 * Getter f�r das CardPanel.
	 * 
	 * @return JPanel
	 */
	public JPanel getCardPanel() {
		return CardPanel;
	}

	/**
	 * Getter f�r das CardLayout.
	 * 
	 * @return CardLayout
	 */
	public CardLayout getCl() {
		return cl;
	}

	/**
	 * Getter f�r das AuswahlPanel.
	 * 
	 * @return JPanel
	 */
	public JPanel getAuswahlPanel() {
		return AuswahlPanel;
	}

	/**
	 * Getter f�r die ComboBox.
	 * 
	 * @return JComboBox
	 */
	public JComboBox getComboBoxMitarbeiter() {
		return comboBoxMitarbeiter;
	}

	/**
	 * Getter f�r den BtnWeiter.
	 * 
	 * @return JButton
	 */
	public JButton getBtnWeiter() {
		return btnWeiter;
	}
}
