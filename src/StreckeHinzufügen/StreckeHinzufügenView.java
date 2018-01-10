/**
 @author Sean Cartner
*/

package StreckeHinzufügen;

import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.UIManager;


public class StreckeHinzufügenView extends JPanel {

	private JPanel frmPixelRacer;
	private JTextField textFieldName;
	private JTextField textFieldLaenge;
	private JTextField textFieldSchwierigkeit;
	private JTextField textFieldPunktzahl;
	private JTextField textFieldGrafik;
	private JButton btnAuswhlen;
	private JButton btnAbsenden;
	private JButton btnAbbrechen;
	private JRadioButton rdbtnFree;
	private JRadioButton rdbtnPremium;
	private ButtonGroup bgStatus;
	private JFileChooser fc;
	private FileFilter filter;
	private JLabel lblStrecke;




	/**
	 * Create the application.
	 */
	public StreckeHinzufügenView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.out.println(e);
		}
		
		frmPixelRacer = new JPanel();
		setSize(624, 570);
		setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(77, 97, 46, 14);
		add(lblName);
		
		JLabel lblLaenge = new JLabel("Länge:");
		lblLaenge.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLaenge.setBounds(77, 148, 107, 19);
		add(lblLaenge);
		
		JLabel lblSchwierigkeit = new JLabel("Schwierigkeit:");
		lblSchwierigkeit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSchwierigkeit.setBounds(77, 201, 148, 19);
		add(lblSchwierigkeit);
		
		JLabel lblPunktzahl = new JLabel("Punktzahl:");
		lblPunktzahl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPunktzahl.setBounds(78, 256, 89, 14);
		add(lblPunktzahl);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblStatus.setBounds(77, 307, 46, 14);
		add(lblStatus);
		
		textFieldName = new JTextField();
		textFieldName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldName.setColumns(10);
		textFieldName.setBounds(265, 89, 175, 30);
		add(textFieldName);
		
		textFieldLaenge = new JTextField();
		textFieldLaenge.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldLaenge.setBounds(265, 142, 175, 30);
		add(textFieldLaenge);
		textFieldLaenge.setColumns(10);
		
		textFieldSchwierigkeit = new JTextField();
		textFieldSchwierigkeit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldSchwierigkeit.setBounds(265, 195, 175, 30);
		add(textFieldSchwierigkeit);
		textFieldSchwierigkeit.setColumns(10);
		
		textFieldPunktzahl = new JTextField();
		textFieldPunktzahl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldPunktzahl.setBounds(265, 248, 175, 30);
		add(textFieldPunktzahl);
		textFieldPunktzahl.setColumns(10);
		
		rdbtnFree = new JRadioButton("Free");;
		rdbtnFree.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnFree.setBounds(265, 305, 61, 23);
		add(rdbtnFree);
		
		rdbtnPremium = new JRadioButton("Premium");
		rdbtnPremium.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnPremium.setBounds(351, 305, 89, 23);
		add(rdbtnPremium);
		
		bgStatus = new ButtonGroup();
		bgStatus.add(rdbtnFree);
		bgStatus.add(rdbtnPremium);
		
		JLabel lblGrafik = new JLabel("Grafik:");
		lblGrafik.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGrafik.setBounds(77, 358, 46, 19);
		add(lblGrafik);
		
		textFieldGrafik = new JTextField();
		textFieldGrafik.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldGrafik.setBounds(265, 347, 175, 30);
		add(textFieldGrafik);
		textFieldGrafik.setColumns(10);
		
		fc = new JFileChooser();
		filter = new FileNameExtensionFilter("Portable Network Graphics (*.png)", "png");

		btnAuswhlen = new JButton("ausw\u00E4hlen");
		btnAuswhlen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAuswhlen.setBounds(470, 346, 112, 30);
		
		add(btnAuswhlen);
		
		btnAbsenden = new JButton("absenden");
		btnAbsenden.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAbsenden.setBounds(345, 419, 95, 23);
		add(btnAbsenden);
		
		lblStrecke = new JLabel("Strecke Hinzuf\u00FCgen");
		lblStrecke.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblStrecke.setBounds(78, 30, 205, 30);
		add(lblStrecke);
		
		btnAbbrechen = new JButton("abbrechen");
		btnAbbrechen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAbbrechen.setBounds(225, 419, 101, 23);
		add(btnAbbrechen);
		

	}
	
	public JPanel getPanel() {
		return frmPixelRacer;
	}
	
	public JTextField getTfName() {
		return textFieldName;
	}
	
	public JTextField getTfLaenge() {
		return textFieldLaenge;
	}
	
	public JTextField getTfSchwierigkeit() {
		return textFieldSchwierigkeit;
	}
	
	public JTextField getTfPunktzahl() {
		return textFieldPunktzahl;
	}
	
	public JTextField getTfGrafik() {
		return textFieldGrafik;
	}
	
	public JButton getBtnAuswhlen() {
		return btnAuswhlen;
	}
	
	public JButton getBtnAbsenden() {
		return btnAbsenden;
	}
	
	public JButton getBtnAbbrechen() {
		return btnAbbrechen;
	}
	
	public JRadioButton getRbFree() {
		return rdbtnFree;
	}
	
	public JRadioButton getRbPremium() {
		return rdbtnPremium;
	}
	
	public ButtonGroup getBgStatus() {
		return bgStatus;
	}
	
	public JFileChooser getFileChooser() {
		return fc;
	}
	
	public FileFilter getFilter() {
		return filter;
	}

	public JLabel getLblStrecke() {
		return lblStrecke;
	}
	
	
}
