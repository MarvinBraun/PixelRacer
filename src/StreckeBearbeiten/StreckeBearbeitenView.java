package StreckeBearbeiten;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Font;

/**
@author Sean Cartner
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
		CardPanel.setSize(624,570);
		
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

	public JComboBox getComboBoxStrecke() {
		return comboBoxStecke;
	}

	public JButton getBtnWeiter() {
		return btnWeiter;
	}
}
