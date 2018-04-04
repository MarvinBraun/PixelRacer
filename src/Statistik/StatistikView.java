package Statistik;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

/**
 * Grafische Beutzeroberfläche in Form eines Formulars für den Vorgang
 * HinzufügenStrecke.
 * 
 * @author Sean
 *
 */
public class StatistikView extends JPanel {

	private JPanel frmPixelRacer;
	private JTextField textFieldUmsatz;
	private JTextField textFieldMitglieder;
	private JLabel lblStatistik;
	private JTextField textFieldPremium;
	private final JSeparator separator = new JSeparator();
	private JTextField textFieldZehn;
	private JTextField textFieldSechsundzwanzig;
	private JTextField textFieldVierzig;
	private JTextField textFieldAchtzehn;
	private JTextField textField60;

	/**
	 * Create the application.
	 */
	public StatistikView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPixelRacer = new JPanel();
		setSize(624, 570);
		setLayout(null);

		JLabel lblUmsatz = new JLabel("Umsatz:");
		lblUmsatz.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUmsatz.setBounds(78, 122, 62, 14);
		add(lblUmsatz);

		JLabel lblMitglieder = new JLabel("Mitglieder:");
		lblMitglieder.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMitglieder.setBounds(78, 160, 107, 19);
		add(lblMitglieder);

		textFieldUmsatz = new JTextField();
		textFieldUmsatz.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldUmsatz.setEditable(false);
		textFieldUmsatz.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldUmsatz.setColumns(10);
		textFieldUmsatz.setBounds(184, 115, 87, 30);
		add(textFieldUmsatz);

		textFieldMitglieder = new JTextField();
		textFieldMitglieder.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldMitglieder.setEditable(false);
		textFieldMitglieder.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldMitglieder.setBounds(184, 155, 87, 30);
		add(textFieldMitglieder);
		textFieldMitglieder.setColumns(10);

		lblStatistik = new JLabel("Allgemein");
		lblStatistik.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblStatistik.setBounds(78, 30, 205, 30);
		add(lblStatistik);
		
		JLabel labelPremium = new JLabel("davon Premium:");
		labelPremium.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelPremium.setBounds(318, 164, 107, 19);
		add(labelPremium);
		
		textFieldPremium = new JTextField();
		textFieldPremium.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldPremium.setEditable(false);
		textFieldPremium.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldPremium.setColumns(10);
		textFieldPremium.setBounds(461, 155, 87, 30);
		add(textFieldPremium);
		separator.setBounds(78, 244, 470, 31);
		add(separator);
		
		JLabel lblAnteilMitgliederJe = new JLabel("Anteil Mitglieder je Altergruppe in Prozent");
		lblAnteilMitgliederJe.setBounds(78, 251, 262, 14);
		add(lblAnteilMitgliederJe);
		
		JLabel labelzehn = new JLabel("10 bis 17");
		labelzehn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelzehn.setBounds(78, 317, 62, 14);
		add(labelzehn);
		
		JLabel lblSechsundzwanzig = new JLabel("26 bis 39");
		lblSechsundzwanzig.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSechsundzwanzig.setBounds(78, 355, 107, 19);
		add(lblSechsundzwanzig);
		
		textFieldZehn = new JTextField();
		textFieldZehn.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldZehn.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldZehn.setEditable(false);
		textFieldZehn.setColumns(10);
		textFieldZehn.setBounds(184, 310, 87, 30);
		add(textFieldZehn);
		
		textFieldSechsundzwanzig = new JTextField();
		textFieldSechsundzwanzig.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldSechsundzwanzig.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldSechsundzwanzig.setEditable(false);
		textFieldSechsundzwanzig.setColumns(10);
		textFieldSechsundzwanzig.setBounds(184, 350, 87, 30);
		add(textFieldSechsundzwanzig);
		
		JLabel lblNeununddreizig = new JLabel("40 bis 59");
		lblNeununddreizig.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNeununddreizig.setBounds(318, 359, 107, 19);
		add(lblNeununddreizig);
		
		textFieldVierzig = new JTextField();
		textFieldVierzig.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldVierzig.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldVierzig.setEditable(false);
		textFieldVierzig.setColumns(10);
		textFieldVierzig.setBounds(461, 350, 87, 30);
		add(textFieldVierzig);
		
		JLabel lblAchtzehn = new JLabel("18 bis 25");
		lblAchtzehn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAchtzehn.setBounds(318, 319, 107, 19);
		add(lblAchtzehn);
		
		textFieldAchtzehn = new JTextField();
		textFieldAchtzehn.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldAchtzehn.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldAchtzehn.setEditable(false);
		textFieldAchtzehn.setColumns(10);
		textFieldAchtzehn.setBounds(461, 310, 87, 30);
		add(textFieldAchtzehn);
		
		JLabel lblSechszig = new JLabel("\u00FCber 60");
		lblSechszig.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSechszig.setBounds(78, 395, 107, 19);
		add(lblSechszig);
		
		textField60 = new JTextField();
		textField60.setHorizontalAlignment(SwingConstants.CENTER);
		textField60.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField60.setEditable(false);
		textField60.setColumns(10);
		textField60.setBounds(184, 390, 87, 30);
		add(textField60);

	}

	/**
	 * Getter für das JPanel.
	 * 
	 * @return JPanel
	 */
	public JPanel getPanel() {
		return frmPixelRacer;
	}
	
	public JTextField getTextFieldUmsatz() {
		return textFieldUmsatz;
	}

	public JTextField getTextFieldPremium() {
		return textFieldPremium;
	}

	public JTextField getTextFieldMitglieder() {
		return textFieldMitglieder;
	}

	public JTextField getTextFieldZehn() {
		return textFieldZehn;
	}

	public JTextField getTextFieldSechsundzwanzig() {
		return textFieldSechsundzwanzig;
	}

	public JTextField getTextFieldVierzig() {
		return textFieldVierzig;
	}

	public JTextField getTextFieldAchtzehn() {
		return textFieldAchtzehn;
	}

	public JTextField getTextField60() {
		return textField60;
	}
	
	
}
