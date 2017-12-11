//@Author Ferhat Koca
package Kart;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Kartübersicht {

	private static JFrame frmPixelRacer;
	static JLabel bluethunder;
	static JLabel car2;
	static JLabel firebird;
	static JLabel greenarrow;

	static JLabel bluethunderbeschreibung;
	static JLabel car2beschreibung;
	static JLabel firebirdbeschreibung;
	static JLabel greenarrowbeschreibung;

	static JPanel panelbluethunderbild;
	static JLabel labelbluethunder;

	static JPanel panelcar2bild;
	static JLabel labelcar2;

	static JPanel panelfirebirdbild;
	static JLabel labelfirebird;

	static JPanel panelgreenarrowbild;
	static JLabel labelgreenarrow;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kartübersicht.frmPixelRacer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		initialize();

	}

	/**
	 * Create the application.
	 */
	public Kartübersicht() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private static void initialize() {

		frmPixelRacer = new JFrame();
		frmPixelRacer.setTitle("Pixel Racer - KartÃ¼bersicht");

		bluethunder = new JLabel("Blue Thunder");
		firebird = new JLabel("Firebird");
		greenarrow = new JLabel("Green Arrow");

		bluethunderbeschreibung = new JLabel("Schneller als der Blitz!");
		firebirdbeschreibung = new JLabel("Seine Reifen qualmen vor Hitze....");
		greenarrowbeschreibung = new JLabel("Der Superheld unter den Karts!");

		ImageIcon bild1 = new ImageIcon(
				"C:\\Users\\TH3_H4CK3R_1337\\git\\PixelRacer\\PixelRacer\\src\\Resources\\Blue Thunder.png");
		ImageIcon bild2 = new ImageIcon(
				"C:\\Users\\TH3_H4CK3R_1337\\git\\PixelRacer\\PixelRacer\\src\\Resources\\Green Arrow.png");
		ImageIcon bild3 = new ImageIcon(
				"C:\\Users\\TH3_H4CK3R_1337\\git\\PixelRacer\\PixelRacer\\src\\Resources\\FireBird.png");

		frmPixelRacer.setBounds(100, 100, 800, 600);
		frmPixelRacer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPixelRacer.setResizable(false);
		frmPixelRacer.getContentPane().setLayout(new GridLayout(2, 2, 0, 0));

		
		panelbluethunderbild = new JPanel();
		frmPixelRacer.getContentPane().add(panelbluethunderbild);
		frmPixelRacer.setVisible(true);
		GridBagLayout gbl_panelbluethunderbild = new GridBagLayout();
		gbl_panelbluethunderbild.columnWidths = new int[] { 400, 0 };
		gbl_panelbluethunderbild.rowHeights = new int[] { 200, 75, 0 };
		gbl_panelbluethunderbild.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panelbluethunderbild.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panelbluethunderbild.setLayout(gbl_panelbluethunderbild);
		labelbluethunder = new JLabel("", bild1, JLabel.CENTER);
		GridBagConstraints gbc_labelbluethunder = new GridBagConstraints();
		gbc_labelbluethunder.anchor = GridBagConstraints.PAGE_START;
		gbc_labelbluethunder.fill = GridBagConstraints.VERTICAL;
		gbc_labelbluethunder.insets = new Insets(50, 0, 0, 0);
		gbc_labelbluethunder.gridx = 0;
		gbc_labelbluethunder.gridy = 0;
		panelbluethunderbild.add(labelbluethunder, gbc_labelbluethunder);

		GridBagConstraints gbc_bluethunder = new GridBagConstraints();
		gbc_bluethunder.anchor = GridBagConstraints.CENTER;
		gbc_bluethunder.insets = new Insets(10, 0, 70, 0);
		gbc_bluethunder.gridx = 0;
		gbc_bluethunder.gridy = 1;
		panelbluethunderbild.add(bluethunder, gbc_bluethunder);

		GridBagConstraints gbc_bluethunderbeschreibung = new GridBagConstraints();
		gbc_bluethunderbeschreibung.fill = GridBagConstraints.PAGE_END;
		gbc_bluethunderbeschreibung.gridx = 0;
		gbc_bluethunderbeschreibung.gridy = 1;
		panelbluethunderbild.add(bluethunderbeschreibung, gbc_bluethunderbeschreibung);

		// Green Arrow
		panelgreenarrowbild = new JPanel();
		frmPixelRacer.getContentPane().add(panelgreenarrowbild);
		frmPixelRacer.setVisible(true);
		GridBagLayout gbl_panelgreenarrowbild = new GridBagLayout();
		gbl_panelgreenarrowbild.columnWidths = new int[] { 400, 0 };
		gbl_panelgreenarrowbild.rowHeights = new int[] { 200, 75, 0 };
		gbl_panelgreenarrowbild.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panelgreenarrowbild.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panelgreenarrowbild.setLayout(gbl_panelgreenarrowbild);
		labelgreenarrow = new JLabel("", bild2, JLabel.CENTER);
		GridBagConstraints gbc_labelgreenarrow = new GridBagConstraints();
		gbc_labelgreenarrow.anchor = GridBagConstraints.PAGE_START;
		gbc_labelgreenarrow.fill = GridBagConstraints.VERTICAL;
		gbc_labelgreenarrow.insets = new Insets(50, 0, 0, 0);
		gbc_labelgreenarrow.gridx = 0;
		gbc_labelgreenarrow.gridy = 0;
		panelgreenarrowbild.add(labelgreenarrow, gbc_labelgreenarrow);

		GridBagConstraints gbc_greenarrow = new GridBagConstraints();
		gbc_greenarrow.anchor = GridBagConstraints.CENTER;
		gbc_greenarrow.insets = new Insets(10, 0, 70, 0);
		gbc_greenarrow.gridx = 0;
		gbc_greenarrow.gridy = 1;
		panelgreenarrowbild.add(greenarrow, gbc_greenarrow);

		GridBagConstraints gbc_greenarrowbeschreibung = new GridBagConstraints();
		gbc_greenarrowbeschreibung.fill = GridBagConstraints.PAGE_END;
		gbc_greenarrowbeschreibung.gridx = 0;
		gbc_greenarrowbeschreibung.gridy = 1;
		panelgreenarrowbild.add(greenarrowbeschreibung, gbc_greenarrowbeschreibung);

		// firebird
		panelfirebirdbild = new JPanel();
		frmPixelRacer.getContentPane().add(panelfirebirdbild);
		frmPixelRacer.setVisible(true);
		GridBagLayout gbl_panelfirebirdbild = new GridBagLayout();
		gbl_panelfirebirdbild.columnWidths = new int[] { 400, 0 };
		gbl_panelfirebirdbild.rowHeights = new int[] { 200, 75, 0 };
		gbl_panelfirebirdbild.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panelfirebirdbild.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panelfirebirdbild.setLayout(gbl_panelfirebirdbild);
		labelfirebird = new JLabel("", bild3, JLabel.CENTER);
		GridBagConstraints gbc_labelfirebird = new GridBagConstraints();
		gbc_labelfirebird.anchor = GridBagConstraints.PAGE_START;
		gbc_labelfirebird.fill = GridBagConstraints.VERTICAL;
		gbc_labelfirebird.insets = new Insets(50, 0, 0, 0);
		gbc_labelfirebird.gridx = 0;
		gbc_labelfirebird.gridy = 0;
		panelfirebirdbild.add(labelfirebird, gbc_labelfirebird);

		GridBagConstraints gbc_firebird = new GridBagConstraints();
		gbc_firebird.anchor = GridBagConstraints.CENTER;
		gbc_firebird.insets = new Insets(10, 0, 70, 0);
		gbc_firebird.gridx = 0;
		gbc_firebird.gridy = 1;
		panelfirebirdbild.add(firebird, gbc_firebird);

		GridBagConstraints gbc_firebirdbeschreibung = new GridBagConstraints();
		gbc_firebirdbeschreibung.fill = GridBagConstraints.PAGE_END;
		gbc_firebirdbeschreibung.gridx = 0;
		gbc_firebirdbeschreibung.gridy = 1;
		panelfirebirdbild.add(firebirdbeschreibung, gbc_firebirdbeschreibung);

	}
}
/*
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}


 * labelbluethunder.addMouseListener(new MouseAdapter() { JFrame frmKartProfil =
 * new JFrame();
 * 
 * @Override public void mouseEntered(MouseEvent e) {
 * 
 * frmKartProfil.setTitle("Blue Thunder"); frmKartProfil.setBounds(200, 200,
 * 600, 400); frmKartProfil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 * frmKartProfil.setVisible(true); frmKartProfil.setAlwaysOnTop(true); }
 * 
 * @Override public void mouseExited(MouseEvent arg0) { frmKartProfil.dispose();
 * 
 * } }); labelcar2.addMouseListener(new MouseAdapter() { JFrame frmKartProfil =
 * new JFrame();
 * 
 * @Override public void mouseEntered(MouseEvent e) {
 * 
 * frmKartProfil.setTitle("Little Sister"); frmKartProfil.setBounds(200, 200,
 * 600, 400); frmKartProfil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 * frmKartProfil.setVisible(true); frmKartProfil.setAlwaysOnTop(true); }
 * 
 * @Override public void mouseExited(MouseEvent arg0) { frmKartProfil.dispose();
 * 
 * } });
 */
