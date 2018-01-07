package KartBearbeiten;

import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

/**
@author Sean Cartner
*/

public class KartBearbeitenView extends JPanel {
	private JPanel kartBearbeitenPanel;
	private JComboBox comboBoxKart;
	private JButton btnWeiter;
	private CardLayout cl;
	

	/**
	 * Ezeugung des Panels, welche lediglich für das CardLayout verantwortlich ist.
	 */
	public KartBearbeitenView() {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.out.println(e);
		}
		
		cl = new CardLayout();
		setLayout(cl);
		setSize(624, 570);
		
		/**
		 * Erzeugung des Panels, in dem ein Kart ausgewählt werden kann
		 */
		kartBearbeitenPanel = new JPanel();
		add(kartBearbeitenPanel);
		kartBearbeitenPanel.setSize(624, 570);
		kartBearbeitenPanel.setLayout(null);
		
		comboBoxKart = new JComboBox();
		comboBoxKart.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxKart.setBounds(225, 214, 175, 30);
		kartBearbeitenPanel.add(comboBoxKart);
		
		JLabel lblKartBearbeiten = new JLabel("Kart Bearbeiten");
		lblKartBearbeiten.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblKartBearbeiten.setBounds(78, 30, 175, 30);
		kartBearbeitenPanel.add(lblKartBearbeiten);
		
		JLabel lblWhleHierEin = new JLabel("W\u00E4hle hier ein Kart aus");
		lblWhleHierEin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblWhleHierEin.setBounds(225, 189, 175, 14);
		kartBearbeitenPanel.add(lblWhleHierEin);
		
		btnWeiter = new JButton("weiter");
		btnWeiter.setBounds(440, 344, 112, 30);
		kartBearbeitenPanel.add(btnWeiter);

	}
	
	public JPanel getPanel() {
		return kartBearbeitenPanel;
	}
	
	public CardLayout getCl() {
		return cl;
	}
	
	public JComboBox getCB() {
		return comboBoxKart;
	}
	
	public JButton getBtnWeiter() {
		return btnWeiter;
	}
}
