package Strecke;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;
import BackgroundAnimation.Movement;
import FontHandler.FontHandler;
import java.awt.Color;

/**
 * Grafische Benutzeroberflaeche zur Uebersicht der Strecken. 
 * 
 * @author Robin Demmler
 *
 */

public class Streckenuebersicht {
	/**
	 * Deklarieren benoetigter Variablen.
	 */	
	private JFrame frmPixelRacer;
	
	private JButton streckeForward;
	private JButton streckeBackward;
	
	private JButton btnDetailView;
	private JButton btnZurueck;
	private JButton btnStreckeKaufen;
	
	private JLabel streckeName;
	private JLabel streckeLbl;
	private JLabel lblHintergrund;
	private JLabel lblNewLabel;
	private JLabel lblStreckePunkte;
	private JLabel lblStreckePunkteLimit;
	
	/**
	 * Main-Methode fuehrt GUI aus.
	 */	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Streckenuebersicht window = new Streckenuebersicht();
					window.frmPixelRacer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Konstruktor ruft initialize()-Methode auf.
	 */
	public Streckenuebersicht() {
		initialize();
	}
	/**
	 * initialize() Initialisiert das Fenster und die Inhalte des JFrames.
	 */
	private void initialize() {
		
		Font customFont15f = FontHandler.registriereSchriftart(15f); // Laden der Schriftart durch Klasse FontHandler
		Font customFont30f = FontHandler.registriereSchriftart(30f); 
		
		setFrmPixelRacer(new JFrame());
		getFrmPixelRacer().setTitle("Pixel Racer - Strecken\u00FCbersicht");
		getFrmPixelRacer().setBounds(100, 100, 800, 600);
		getFrmPixelRacer().setDefaultCloseOperation(getFrmPixelRacer().DO_NOTHING_ON_CLOSE);
		getFrmPixelRacer().setVisible(true);
		getFrmPixelRacer().setResizable(false);
		getFrmPixelRacer().getContentPane().setLayout(null);
		getFrmPixelRacer().addWindowListener(new WindowAdapter() {

			  @Override
			  public void windowClosing(WindowEvent we)
			  { 
				  int result = JOptionPane.showConfirmDialog(null,"Moechten sie Pixcel Racer wirklich schliessen?", "Pixcel Racer schliessen?", JOptionPane.YES_NO_OPTION);
				  switch(result) {
				  case JOptionPane.YES_OPTION:
					  System.exit(0);
				  case JOptionPane.NO_OPTION:
					  
				  }
			  }
			});
		
		setStreckeForward(new JButton(""));
		getStreckeForward().setBorderPainted(false);
		getStreckeForward().setIcon(new ImageIcon(Streckenuebersicht.class.getResource("/Resources/forward.png")));
		getStreckeForward().setContentAreaFilled(false);
		getStreckeForward().setBounds(712, 238, 60, 60);
		getStreckeForward().setVisible(true);
		getFrmPixelRacer().getContentPane().add(getStreckeForward());
		
		setStreckeBackward(new JButton(""));
		getStreckeBackward().setBorderPainted(false);
		getStreckeBackward().setIcon(new ImageIcon(Streckenuebersicht.class.getResource("/Resources/backward.png")));
		getStreckeBackward().setOpaque(false);
		getStreckeBackward().setContentAreaFilled(false);
		getStreckeBackward().setBounds(27, 238, 60, 60);
		getStreckeBackward().setVisible(true);
		getFrmPixelRacer().getContentPane().add(getStreckeBackward());
		
		setStreckeLbl(new JLabel("", JLabel.CENTER));
		getStreckeLbl().setBounds(247, 144, 300, 200);
		getStreckeLbl().setVisible(true);
		getFrmPixelRacer().getContentPane().add(getStreckeLbl());
		
		
		setStreckeName(new JLabel("Hockenheim", JLabel.CENTER));
		getStreckeName().setFont(customFont30f);
		getStreckeName().setBounds(239, 355, 308, 60);
		getStreckeName().setVisible(true);
		getFrmPixelRacer().getContentPane().add(getStreckeName());
		
		setBtnDetailView(new JButton("Zeig mir mehr!"));
		getBtnDetailView().setFont(customFont15f);
		getBtnDetailView().setBounds(282, 428, 229, 35);
		getBtnDetailView().setVisible(true);
		getBtnDetailView().setBorderPainted(false);
		getBtnDetailView().setOpaque(false);
		getBtnDetailView().setBackground(SystemColor.activeCaption);
		getBtnDetailView().setFocusable(false);
		getBtnDetailView().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
			
			}
		});		
		getFrmPixelRacer().getContentPane().add(getBtnDetailView());
		
		setLblStreckePunkte(new JLabel("New label"));
		getLblStreckePunkte().setVisible(false);
		getLblStreckePunkte().setFont(customFont15f);
		getLblStreckePunkte().setBounds(268, 474, 265, 65);
		getFrmPixelRacer().getContentPane().add(getLblStreckePunkte());
		
		setLblStreckePunkteLimit(new JLabel("New label"));
		getLblStreckePunkteLimit().setVisible(false);
		getLblStreckePunkteLimit().setFont(customFont15f);
		getLblStreckePunkteLimit().setBounds(150, 456, 549, 76);
		getFrmPixelRacer().getContentPane().add(getLblStreckePunkteLimit());
		
		setBtnZurueck(new JButton("Zurueck"));
		getBtnZurueck().setFont(customFont15f);
		getBtnZurueck().setBounds(27, 510, 113, 29);
		getBtnZurueck().setBorderPainted(false);
		getBtnZurueck().setOpaque(false);
		getBtnZurueck().setBackground(SystemColor.activeCaption);
		getBtnZurueck().setFocusable(false);
		getBtnZurueck().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		getFrmPixelRacer().getContentPane().add(getBtnZurueck());
		
		setBtnStreckeKaufen(new JButton("Strecke kaufen!"));
		getBtnStreckeKaufen().setVisible(true);
		getBtnStreckeKaufen().setFont(customFont15f);
		getBtnStreckeKaufen().setBounds(543, 428, 229, 33);
		getBtnStreckeKaufen().setBorderPainted(false);
		getBtnStreckeKaufen().setOpaque(false);
		getBtnStreckeKaufen().setBackground(SystemColor.activeCaption);
		getBtnStreckeKaufen().setFocusable(false);
		getBtnStreckeKaufen().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		getFrmPixelRacer().getContentPane().add(getBtnStreckeKaufen());
		
		setLblHintergrund(new JLabel(""));
		getLblHintergrund().setBounds(0, 0, 794, 571);
		getFrmPixelRacer().getContentPane().add(getLblHintergrund());
					
		Movement m = new Movement(10); // Hintergrund-Image dem Hintergurnd-Label zuweisen, Bewegung festlegen & dem Frame hinzufuegen
		
		BufferedImage image = null;
		try {
			URL url = getClass().getResource("/Resources/Hintergrund.png");
			image = ImageIO.read(url);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		m.label.setBufferedImage(image,0);
		
		m.label.setOpaque(false);
		m.label.setBounds(0, 0, 800, 600);
		getFrmPixelRacer().getContentPane().add(m.label);
				
	}

	public JFrame getFrmPixelRacer() {
		return frmPixelRacer;
	}

	public void setFrmPixelRacer(JFrame frmPixelRacer) {
		this.frmPixelRacer = frmPixelRacer;
	}

	public JLabel getLblHintergrund() {
		return lblHintergrund;
	}

	public void setLblHintergrund(JLabel lblHintergrund) {
		this.lblHintergrund = lblHintergrund;
	}

	public JButton getBtnStreckeKaufen() {
		return btnStreckeKaufen;
	}

	public void setBtnStreckeKaufen(JButton btnStreckeKaufen) {
		this.btnStreckeKaufen = btnStreckeKaufen;
	}

	public JFrame getFrame() {
		return frmPixelRacer;
	}

	public void setFrame(JFrame frame) {
		this.frmPixelRacer = frame;
	}

	public JButton getStreckeForward() {
		return streckeForward;
	}

	public void setStreckeForward(JButton streckeForward) {
		this.streckeForward = streckeForward;
	}

	public JButton getStreckeBackward() {
		return streckeBackward;
	}

	public void setStreckeBackward(JButton streckeBackward) {
		this.streckeBackward = streckeBackward;
	}

	public JLabel getStreckeName() {
		return streckeName;
	}

	public void setStreckeName(JLabel streckeName) {
		this.streckeName = streckeName;
	}

	public JLabel getStreckeLbl() {
		return streckeLbl;
	}

	public void setStreckeLbl(JLabel streckeLbl) {
		this.streckeLbl = streckeLbl;
	}

	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}

	public void setLblNewLabel(JLabel lblNewLabel) {
		this.lblNewLabel = lblNewLabel;
	}

	public JButton getBtnDetailView() {
		return btnDetailView;
	}

	public void setBtnDetailView(JButton btnDetailView) {
		this.btnDetailView = btnDetailView;
		btnDetailView.setForeground(Color.RED);
	}
	public JLabel getLblStreckePunkte() {
		return lblStreckePunkte;
	}

	public void setLblStreckePunkte(JLabel lblStreckePunkte) {
		this.lblStreckePunkte = lblStreckePunkte;
	}
	
	public JLabel getLblStreckePunkteLimit() {
		return lblStreckePunkteLimit;
	}

	public void setLblStreckePunkteLimit(JLabel lblStreckePunkteLimit) {
		this.lblStreckePunkteLimit = lblStreckePunkteLimit;
	}
	public JButton getBtnZurueck() {
		return btnZurueck;
	}

	public void setBtnZurueck(JButton btnZurueck) {
		this.btnZurueck = btnZurueck;
		btnZurueck.setForeground(Color.RED);
	}
}
