/**
 @author Sean Cartner
*/

package KartHinzufügen;

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


public class KartHinzufügenView extends JPanel{

	private JPanel frmPixelRacer;
	private JTextField textFieldName;
	private JTextField textFieldBeschleunigung;
	private JTextField textFieldMaxGeschwindigkeit;
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
	private JLabel lblKartHinzufgen;
	private String labelName;



	/**
	 * Create the application.
	 */
	public KartHinzufügenView() {
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
		
		JLabel lblBeschleunigung = new JLabel("Beschleunigung:");
		lblBeschleunigung.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBeschleunigung.setBounds(77, 148, 107, 19);
		add(lblBeschleunigung);
		
		JLabel lblMaxGeschwindigkeit = new JLabel("MaxGeschwindigkeit:");
		lblMaxGeschwindigkeit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMaxGeschwindigkeit.setBounds(77, 201, 148, 19);
		add(lblMaxGeschwindigkeit);
		
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
		
		textFieldBeschleunigung = new JTextField();
		textFieldBeschleunigung.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldBeschleunigung.setBounds(265, 142, 175, 30);
		add(textFieldBeschleunigung);
		textFieldBeschleunigung.setColumns(10);
		
		textFieldMaxGeschwindigkeit = new JTextField();
		textFieldMaxGeschwindigkeit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldMaxGeschwindigkeit.setBounds(265, 195, 175, 30);
		add(textFieldMaxGeschwindigkeit);
		textFieldMaxGeschwindigkeit.setColumns(10);
		
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
		
		labelName = null;
		lblKartHinzufgen = new JLabel("Kart Hinzuf\u00FCgen");
		lblKartHinzufgen.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblKartHinzufgen.setBounds(78, 30, 175, 30);
		add(lblKartHinzufgen);
		
		btnAbbrechen = new JButton("abbrechen");
		btnAbbrechen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAbbrechen.setBounds(225, 419, 101, 23);
		add(btnAbbrechen);
	}
	
	public JPanel getPanel(){
		return frmPixelRacer;
	}
	
	public JTextField getTfName(){
		return textFieldName;
	}
	
	public JTextField getTfBeschleunigung(){
		return textFieldBeschleunigung;
	}
	
	public JTextField getTfGeschwindigkeit(){
		return textFieldMaxGeschwindigkeit;
	}
	
	public JTextField getTfPunktzahl(){
		return textFieldPunktzahl;
	}
	
	public JTextField getTfGrafik(){
		return textFieldGrafik;
	}
	
	public JButton getBtnAuswaehlen(){
		return btnAuswhlen;
	}
	
	public JButton getBtnAbsenden(){
		return btnAbsenden;
	}
	
	public JButton getBtnAbbrechen(){
		return btnAbbrechen;
	}
	
	public JRadioButton getRbFree(){
		return rdbtnFree;
	}
	
	public JRadioButton getRbPremium(){
		return rdbtnPremium;
	}
	
	public ButtonGroup getBgStatus(){
		return bgStatus;
	}
	
	public JFileChooser getFc(){
		return fc;
	}
	
	public FileFilter getFilter(){
		return filter;
	}

	public JLabel getLblKartHinzufgen() {
		return lblKartHinzufgen;
	}
	
	
	
}
