package Strecke;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;


public class Streckenuebersicht implements MouseListener {

	private static JFrame frmPixelRacer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Streckenuebersicht.frmPixelRacer.setVisible(true);
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
	public Streckenuebersicht() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private static void initialize() {
		
		frmPixelRacer = new JFrame();
		frmPixelRacer.setTitle("Pixel Racer - Strecken\u00FCbersicht");
		
		JLabel streckenName1 = new JLabel("Strecke 1");
		JLabel streckenName2 = new JLabel("Strecke 2");
		JLabel streckenName3 = new JLabel("Strecke 3");
		JLabel streckenName4 = new JLabel("Strecke 4");
		
		JLabel streckenBeschreibung1 = new JLabel("Strecke 1 Test");
		JLabel streckenBeschreibung2 = new JLabel("Strecke 2 Test");
		JLabel streckenBeschreibung3 = new JLabel("Strecke 3 Test");
		JLabel streckenBeschreibung4 = new JLabel("Strecke 4 Test");
		
		ImageIcon strecke1 = new ImageIcon("C:\\Users\\Robin\\Desktop\\Bilder Projekt\\Strecken\\300x200\\Rennstrecke1_-_klein.png");
		ImageIcon strecke2 = new ImageIcon("C:\\Users\\Robin\\Desktop\\Bilder Projekt\\Strecken\\300x200\\Rennstrecke2-klein.png");
		ImageIcon strecke3 = new ImageIcon("C:\\Users\\Robin\\Desktop\\Bilder Projekt\\Strecken\\300x200\\Rennstrecke2-klein.png");
		ImageIcon strecke4 = new ImageIcon("C:\\Users\\Robin\\Desktop\\Bilder Projekt\\Strecken\\300x200\\Rennstrecke1_-_klein.png");
		
		frmPixelRacer.setBounds(100, 100, 800, 600);
		frmPixelRacer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPixelRacer.setResizable(false);
		frmPixelRacer.getContentPane().setLayout(new GridLayout(2,2,0,0));
		
		JPanel panelStreckeBild1 = new JPanel();
		frmPixelRacer.getContentPane().add(panelStreckeBild1);
		frmPixelRacer.setVisible(true);
		GridBagLayout gbl_panelStreckeBild1 = new GridBagLayout();
		gbl_panelStreckeBild1.columnWidths = new int[]{400, 0};
		gbl_panelStreckeBild1.rowHeights = new int[]{200, 75, 0};
		gbl_panelStreckeBild1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelStreckeBild1.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelStreckeBild1.setLayout(gbl_panelStreckeBild1);
		JLabel labelStrecke1 = new JLabel("", strecke1, JLabel.CENTER);
		GridBagConstraints gbc_labelStrecke1 = new GridBagConstraints();
		gbc_labelStrecke1.anchor = GridBagConstraints.PAGE_START;
		gbc_labelStrecke1.fill = GridBagConstraints.VERTICAL;
		gbc_labelStrecke1.insets = new Insets(50, 0, 0, 0);
		gbc_labelStrecke1.gridx = 0;
		gbc_labelStrecke1.gridy = 0;
		panelStreckeBild1.add(labelStrecke1, gbc_labelStrecke1);
		
		labelStrecke1.addMouseListener(new MouseAdapter(){
			JFrame frmStreckeProfil = new JFrame();
			@Override
			public void mouseEntered(MouseEvent e){
				
				frmStreckeProfil.setTitle("Test1");
				frmStreckeProfil.setBounds(200, 200, 600, 400);
				frmStreckeProfil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frmStreckeProfil.setVisible(true);
				frmStreckeProfil.setAlwaysOnTop(true);
				}
			@Override
			public void mouseExited(MouseEvent arg0) {
				frmStreckeProfil.dispose();
				
			}
			});
						
		GridBagConstraints gbc_streckenName1 = new GridBagConstraints();
		gbc_streckenName1.anchor = GridBagConstraints.CENTER;
		gbc_streckenName1.insets = new Insets(10, 0, 70, 0);
		gbc_streckenName1.gridx = 0;
		gbc_streckenName1.gridy = 1;
		panelStreckeBild1.add(streckenName1, gbc_streckenName1);
		
		GridBagConstraints gbc_streckenBeschreibung1 = new GridBagConstraints();
		gbc_streckenBeschreibung1.fill = GridBagConstraints.PAGE_END;
		gbc_streckenBeschreibung1.gridx = 0;
		gbc_streckenBeschreibung1.gridy = 1;
		panelStreckeBild1.add(streckenBeschreibung1, gbc_streckenBeschreibung1);
		
		 
		JPanel panelStreckeBild2 = new JPanel();
		frmPixelRacer.getContentPane().add(panelStreckeBild2);
		frmPixelRacer.setVisible(true);
		GridBagLayout gbl_panelStreckeBild2 = new GridBagLayout();
		gbl_panelStreckeBild2.columnWidths = new int[]{400, 0};
		gbl_panelStreckeBild2.rowHeights = new int[]{200, 75, 0};
		gbl_panelStreckeBild2.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelStreckeBild2.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelStreckeBild2.setLayout(gbl_panelStreckeBild2);
		JLabel labelStrecke2 = new JLabel("", strecke2, JLabel.CENTER);
		GridBagConstraints gbc_labelStrecke2 = new GridBagConstraints();
		gbc_labelStrecke2.anchor = GridBagConstraints.PAGE_START;
		gbc_labelStrecke2.fill = GridBagConstraints.VERTICAL;
		gbc_labelStrecke2.insets = new Insets(50, 0, 0, 0);
		gbc_labelStrecke2.gridx = 0;
		gbc_labelStrecke2.gridy = 0;
		panelStreckeBild2.add(labelStrecke2, gbc_labelStrecke2);
				
		GridBagConstraints gbc_streckenName2 = new GridBagConstraints();
		gbc_streckenName2.anchor = GridBagConstraints.CENTER;
		gbc_streckenName2.insets = new Insets(10, 0, 70, 0);
		gbc_streckenName2.gridx = 0;
		gbc_streckenName2.gridy = 1;
		panelStreckeBild2.add(streckenName2, gbc_streckenName2);
				
		GridBagConstraints gbc_streckenBeschreibung2 = new GridBagConstraints();
		gbc_streckenBeschreibung2.fill = GridBagConstraints.PAGE_END;
		gbc_streckenBeschreibung2.gridx = 0;
		gbc_streckenBeschreibung2.gridy = 1;
		panelStreckeBild2.add(streckenBeschreibung2, gbc_streckenBeschreibung2);
		
		
		JPanel panelStreckeBild3 = new JPanel();
		frmPixelRacer.getContentPane().add(panelStreckeBild3);
		frmPixelRacer.setVisible(true);
		GridBagLayout gbl_panelStreckeBild3 = new GridBagLayout();
		gbl_panelStreckeBild3.columnWidths = new int[]{400, 0};
		gbl_panelStreckeBild3.rowHeights = new int[]{200, 75, 0};
		gbl_panelStreckeBild3.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelStreckeBild3.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelStreckeBild3.setLayout(gbl_panelStreckeBild3);
		JLabel labelStrecke3 = new JLabel("", strecke3, JLabel.CENTER);
		GridBagConstraints gbc_labelStrecke3 = new GridBagConstraints();
		gbc_labelStrecke3.anchor = GridBagConstraints.PAGE_START;
		gbc_labelStrecke3.fill = GridBagConstraints.VERTICAL;
		gbc_labelStrecke3.insets = new Insets(50, 0, 0, 0);
		gbc_labelStrecke3.gridx = 0;
		gbc_labelStrecke3.gridy = 0;
		panelStreckeBild3.add(labelStrecke3, gbc_labelStrecke3);
				
		GridBagConstraints gbc_streckenName3 = new GridBagConstraints();
		gbc_streckenName3.anchor = GridBagConstraints.CENTER;
		gbc_streckenName3.insets = new Insets(10, 0, 70, 0);
		gbc_streckenName3.gridx = 0;
		gbc_streckenName3.gridy = 1;
		panelStreckeBild3.add(streckenName3, gbc_streckenName3);
				
		GridBagConstraints gbc_streckenBeschreibung3 = new GridBagConstraints();
		gbc_streckenBeschreibung3.fill = GridBagConstraints.PAGE_END;
		gbc_streckenBeschreibung3.gridx = 0;
		gbc_streckenBeschreibung3.gridy = 1;
		panelStreckeBild3.add(streckenBeschreibung3, gbc_streckenBeschreibung3);
		
		
		JPanel panelStreckeBild4 = new JPanel();
		frmPixelRacer.getContentPane().add(panelStreckeBild4);
		frmPixelRacer.setVisible(true);
		GridBagLayout gbl_panelStreckeBild4 = new GridBagLayout();
		gbl_panelStreckeBild4.columnWidths = new int[]{400, 0};
		gbl_panelStreckeBild4.rowHeights = new int[]{200, 75, 0};
		gbl_panelStreckeBild4.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelStreckeBild4.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelStreckeBild4.setLayout(gbl_panelStreckeBild4);
		JLabel labelStrecke4 = new JLabel("", strecke4, JLabel.CENTER);
		GridBagConstraints gbc_labelStrecke4 = new GridBagConstraints();
		gbc_labelStrecke4.anchor = GridBagConstraints.PAGE_START;
		gbc_labelStrecke4.fill = GridBagConstraints.VERTICAL;
		gbc_labelStrecke4.insets = new Insets(50, 0, 0, 0);
		gbc_labelStrecke4.gridx = 0;
		gbc_labelStrecke4.gridy = 0;
		panelStreckeBild4.add(labelStrecke4, gbc_labelStrecke4);
				
		GridBagConstraints gbc_streckenName4 = new GridBagConstraints();
		gbc_streckenName4.anchor = GridBagConstraints.CENTER;
		gbc_streckenName4.insets = new Insets(10, 0, 70, 0);
		gbc_streckenName4.gridx = 0;
		gbc_streckenName4.gridy = 1;
		panelStreckeBild4.add(streckenName4, gbc_streckenName4);
				
		GridBagConstraints gbc_streckenBeschreibung4 = new GridBagConstraints();
		gbc_streckenBeschreibung4.fill = GridBagConstraints.PAGE_END;
		gbc_streckenBeschreibung4.gridx = 0;
		gbc_streckenBeschreibung4.gridy = 1;
		panelStreckeBild4.add(streckenBeschreibung4, gbc_streckenBeschreibung4);
		
		
	}

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
