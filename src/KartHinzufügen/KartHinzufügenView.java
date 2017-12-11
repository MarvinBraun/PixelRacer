/**
 @author Sean Cartner
*/

package KartHinzufügen;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.UIManager;


public class KartHinzufügenView {

	protected JFrame frmPixelRacer;
	protected JTextField textFieldName;
	protected JTextField textFieldBeschleunigung;
	protected JTextField textFieldMaxGeschwindigkeit;
	protected JTextField textFieldPunktzahl;
	protected JTextField textFieldGrafik;
	protected JButton btnAuswhlen;
	protected JButton btnAbsenden;
	protected JRadioButton rdbtnFree;
	protected JRadioButton rdbtnPremium;
	protected ButtonGroup bgStatus;
	protected JFileChooser fc;

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
		
		frmPixelRacer = new JFrame();
		frmPixelRacer.setTitle("Pixel Racer - F\u00FCge Kart hinzu");
		frmPixelRacer.setResizable(false);
		frmPixelRacer.setSize(800, 600);
		frmPixelRacer.setLocationRelativeTo(null);
		frmPixelRacer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPixelRacer.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(194, 91, 46, 14);
		frmPixelRacer.getContentPane().add(lblName);
		
		JLabel lblBeschleunigung = new JLabel("Beschleunigung:");
		lblBeschleunigung.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBeschleunigung.setBounds(194, 142, 107, 19);
		frmPixelRacer.getContentPane().add(lblBeschleunigung);
		
		JLabel lblMaxGeschwindigkeit = new JLabel("MaxGeschwindigkeit:");
		lblMaxGeschwindigkeit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMaxGeschwindigkeit.setBounds(194, 195, 148, 19);
		frmPixelRacer.getContentPane().add(lblMaxGeschwindigkeit);
		
		JLabel lblPunktzahl = new JLabel("Punktzahl:");
		lblPunktzahl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPunktzahl.setBounds(195, 250, 89, 14);
		frmPixelRacer.getContentPane().add(lblPunktzahl);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblStatus.setBounds(194, 301, 46, 14);
		frmPixelRacer.getContentPane().add(lblStatus);
		
		textFieldName = new JTextField();
		textFieldName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldName.setColumns(10);
		textFieldName.setBounds(382, 83, 175, 30);
		frmPixelRacer.getContentPane().add(textFieldName);
		
		textFieldBeschleunigung = new JTextField();
		textFieldBeschleunigung.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldBeschleunigung.setBounds(382, 136, 175, 30);
		frmPixelRacer.getContentPane().add(textFieldBeschleunigung);
		textFieldBeschleunigung.setColumns(10);
		
		textFieldMaxGeschwindigkeit = new JTextField();
		textFieldMaxGeschwindigkeit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldMaxGeschwindigkeit.setBounds(382, 189, 175, 30);
		frmPixelRacer.getContentPane().add(textFieldMaxGeschwindigkeit);
		textFieldMaxGeschwindigkeit.setColumns(10);
		
		textFieldPunktzahl = new JTextField();
		textFieldPunktzahl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldPunktzahl.setBounds(382, 242, 175, 30);
		frmPixelRacer.getContentPane().add(textFieldPunktzahl);
		textFieldPunktzahl.setColumns(10);
		
		rdbtnFree = new JRadioButton("Free");;
		rdbtnFree.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnFree.setBounds(382, 299, 61, 23);
		frmPixelRacer.getContentPane().add(rdbtnFree);
		
		rdbtnPremium = new JRadioButton("Premium");
		rdbtnPremium.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnPremium.setBounds(468, 299, 89, 23);
		frmPixelRacer.getContentPane().add(rdbtnPremium);
		
		bgStatus = new ButtonGroup();
		bgStatus.add(rdbtnFree);
		bgStatus.add(rdbtnPremium);
		
		JLabel lblGrafik = new JLabel("Grafik:");
		lblGrafik.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGrafik.setBounds(194, 352, 46, 19);
		frmPixelRacer.getContentPane().add(lblGrafik);
		
		textFieldGrafik = new JTextField();
		textFieldGrafik.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldGrafik.setBounds(382, 341, 175, 30);
		frmPixelRacer.getContentPane().add(textFieldGrafik);
		textFieldGrafik.setColumns(10);
		
		fc = new JFileChooser();

		btnAuswhlen = new JButton("ausw\u00E4hlen");
		btnAuswhlen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAuswhlen.setBounds(586, 341, 112, 30);
		
		frmPixelRacer.getContentPane().add(btnAuswhlen);
		
		btnAbsenden = new JButton("absenden");
		btnAbsenden.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAbsenden.setBounds(450, 413, 107, 23);
		frmPixelRacer.getContentPane().add(btnAbsenden);
	}
}
