package KartBearbeiten;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Font;

/**
 * Grafische Benutzeroberfläche, die dazu dient, dass der Nutzer mittels einer
 * ComboBox ein Kart auswählen kann. Die Oberfläche verfügt über das CardLayout,
 * über das die KartHinzufügenView angezeigt werden kann.
 * 
 * @author Sean Cartner
 */

public class KartBearbeitenView extends JPanel {

	private JPanel CardPanel;
	private CardLayout cl;
	private JPanel AuswahlPanel;
	private JComboBox comboBoxKart;
	private JButton btnWeiter;

	/**
	 * Create the panel.
	 */
	public KartBearbeitenView() {
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

		comboBoxKart = new JComboBox();
		comboBoxKart.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxKart.setBounds(225, 214, 175, 30);
		AuswahlPanel.add(comboBoxKart);

		JLabel lblKartBearbeiten = new JLabel("Kart Bearbeiten");
		lblKartBearbeiten.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblKartBearbeiten.setBounds(78, 30, 175, 30);
		AuswahlPanel.add(lblKartBearbeiten);

		JLabel lblWhleHierEin = new JLabel("W\u00E4hle hier ein Kart aus");
		lblWhleHierEin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblWhleHierEin.setBounds(225, 189, 175, 14);
		AuswahlPanel.add(lblWhleHierEin);

		btnWeiter = new JButton("weiter");
		btnWeiter.setBounds(440, 344, 112, 30);
		AuswahlPanel.add(btnWeiter);

	}

	/**
	 * Getter für das CardPanel.
	 * 
	 * @return JPanel
	 */
	public JPanel getCardPanel() {
		return CardPanel;
	}

	/**
	 * Getter für das CardLayout.
	 * 
	 * @return CardLayout
	 */
	public CardLayout getCl() {
		return cl;
	}

	/**
	 * Getter für das AuswahlPanel.
	 * 
	 * @return JPanel
	 */
	public JPanel getAuswahlPanel() {
		return AuswahlPanel;
	}

	/**
	 * Getter für die ComboBox.
	 * 
	 * @return JComboBox
	 */
	public JComboBox getComboBoxKart() {
		return comboBoxKart;
	}

	/**
	 * Getter für den Button BtnWeiter.
	 * 
	 * @return
	 */
	public JButton getBtnWeiter() {
		return btnWeiter;
	}
}
