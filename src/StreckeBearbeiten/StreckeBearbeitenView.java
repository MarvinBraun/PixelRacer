package StreckeBearbeiten;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Font;

/**
 * Grafische Benutzeroberfl�che, die dazu dient, dass der Nutzer mittels einer
 * ComboBox eine Strecke zum Bearbeiten ausw�hlen kann. Die Oberfl�che verf�gt
 * �ber das CardLayout, �ber das die KartHinzuf�genView angezeigt werden kann.
 * 
 * @author Sean Cartner
 *
 */
public class StreckeBearbeitenView extends JPanel {

	private JPanel CardPanel;
	private CardLayout cl;
	private JPanel AuswahlPanel;
	private JComboBox comboBoxStecke;
	private JButton btnWeiter;

	/**
	 * Create the panel.
	 */
	public StreckeBearbeitenView() {
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

		comboBoxStecke = new JComboBox();
		comboBoxStecke.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxStecke.setBounds(225, 214, 175, 30);
		AuswahlPanel.add(comboBoxStecke);

		JLabel lblStreckeBearbeiten = new JLabel("Strecke Bearbeiten");
		lblStreckeBearbeiten.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblStreckeBearbeiten.setBounds(78, 30, 205, 30);
		AuswahlPanel.add(lblStreckeBearbeiten);

		JLabel lblWhleHierEin = new JLabel("W\u00E4hle hier eine Strecke aus");
		lblWhleHierEin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblWhleHierEin.setBounds(225, 189, 185, 14);
		AuswahlPanel.add(lblWhleHierEin);

		btnWeiter = new JButton("weiter");
		btnWeiter.setBounds(440, 344, 112, 30);
		btnWeiter.setFont(new Font("Tahoma", Font.PLAIN, 15));
		AuswahlPanel.add(btnWeiter);

	}

	/**
	 * Getter f�r das Panel.
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
	 * Getter f�r das Auswahlpanel.
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
	public JComboBox getComboBoxStrecke() {
		return comboBoxStecke;
	}

	/**
	 * Getter f�r BtnWeiter.
	 * 
	 * @return JButton
	 */
	public JButton getBtnWeiter() {
		return btnWeiter;
	}
}
