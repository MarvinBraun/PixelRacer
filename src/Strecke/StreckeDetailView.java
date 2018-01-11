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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import BackgroundAnimation.Movement;
import FontHandler.FontHandler;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.Color;

/**
 * Grafische Benutzeroberflaeche zur Ansicht der Details und nutzerbezogenen Fahrtdaten einer Strecke. 
 * 
 * @author Robin Demmler
 *
 */

public class StreckeDetailView {
	/**
	 * Deklarieren benoetigter Variablen.
	 */		
	private JFrame frame;
	
	private JLabel lblHintergrund;
	private JLabel lblLaenge;
	private JLabel lblGefahreneRennen;
	private JLabel lblGefahreneKmGesamt;
	private JLabel lblRennenAlsErster;
	private JLabel lblRennenAlsZweiter;
	private JLabel lblRennenAlsDritter;
	
	private JLabel lblSetLaenge;
	private JLabel lblSetGesKm;
	private JLabel lblSetGesRennen;
	private JLabel lblSetAnzErster;
	private JLabel lblSetAnzZweiter;
	private JLabel lblSetAnzDritter;
		
	private JButton btnZurueck; 
	/**
	 * Main-Methode fuehrt GUI aus.
	 */	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StreckeDetailView window = new StreckeDetailView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Konstruktor ruft initialize()-Methode auf.
	 */
	public StreckeDetailView() {
		initialize();
	}
	/**
	 * initialize() Initialisiert das Fenster und die Inhalte des JFrames.
	 */
	private void initialize() {
		
		Font customFont20f = FontHandler.registriereSchriftart(10f); // Laden der Schriftart durch Klasse FontHandler
				
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 450, 300);
		getFrame().setDefaultCloseOperation(getFrame().DO_NOTHING_ON_CLOSE);
		getFrame().setVisible(false);
		getFrame().setResizable(false);
		getFrame().getContentPane().setLayout(null);
				
		setLblLaenge(new JLabel("Streckenlaenge:"));
		getLblLaenge().setBounds(76, 32, 118, 14);
		getLblLaenge().setFont(customFont20f);
		getFrame().getContentPane().add(getLblLaenge());
				
		setLblGefahreneRennen(new JLabel("Gefahrene SP-Rennen:"));
		getLblGefahreneRennen().setBounds(33, 57, 174, 14);
		getLblGefahreneRennen().setFont(customFont20f);
		getFrame().getContentPane().add(getLblGefahreneRennen());
		
		setLblGefahreneKmGesamt(new JLabel("Gefahrene m SP gesamt:"));
		getLblGefahreneKmGesamt().setBounds(20, 82, 174, 14);
		getLblGefahreneKmGesamt().setFont(customFont20f);
		getFrame().getContentPane().add(getLblGefahreneKmGesamt());
		
		setLblRennenAlsErster(new JLabel("Rennen als Erster abgeschlossen"));
		getLblRennenAlsErster().setBounds(153, 132, 265, 14);
		getLblRennenAlsErster().setFont(customFont20f);
		getFrame().getContentPane().add(getLblRennenAlsErster());
		
		setLblRennenAlsZweiter(new JLabel("Rennen als Zweiter abgeschlossen"));
		getLblRennenAlsZweiter().setBounds(153, 157, 265, 14);
		getLblRennenAlsZweiter().setFont(customFont20f);
		getFrame().getContentPane().add(getLblRennenAlsZweiter());
		
		setLblRennenAlsDritter(new JLabel("Rennen als Dritter abgeschlossen"));
		getLblRennenAlsDritter().setBounds(153, 182, 265, 14);
		getLblRennenAlsDritter().setFont(customFont20f);
		getFrame().getContentPane().add(getLblRennenAlsDritter());
		
		setLblSetLaenge(new JLabel("New label"));
		getLblSetLaenge().setBounds(248, 32, 46, 14);
		getLblSetLaenge().setFont(customFont20f);
		getFrame().getContentPane().add(getLblSetLaenge());
		
		setLblSetGesRennen(new JLabel("New label"));
		getLblSetGesRennen().setBounds(248, 57, 46, 14);
		getLblSetGesRennen().setFont(customFont20f);
		getFrame().getContentPane().add(getLblSetGesRennen());
		
		setLblSetGesKm(new JLabel("New label"));
		getLblSetGesKm().setBounds(248, 82, 46, 14);
		getLblSetGesKm().setFont(customFont20f);
		getFrame().getContentPane().add(getLblSetGesKm());
		
		setLblSetAnzErster(new JLabel("New label"));
		getLblSetAnzErster().setBounds(77, 132, 46, 14);
		getLblSetAnzErster().setFont(customFont20f);
		getFrame().getContentPane().add(getLblSetAnzErster());
		
		setLblSetAnzZweiter(new JLabel("New label"));
		getLblSetAnzZweiter().setBounds(77, 157, 46, 14);
		getLblSetAnzZweiter().setFont(customFont20f);
		getFrame().getContentPane().add(getLblSetAnzZweiter());
		
		setLblSetAnzDritter(new JLabel("New label"));
		getLblSetAnzDritter().setBounds(77, 182, 46, 14);
		getLblSetAnzDritter().setFont(customFont20f);
		getFrame().getContentPane().add(getLblSetAnzDritter());
		
		setBtnZurueck(new JButton("Zurueck"));
		getBtnZurueck().setBounds(10, 227, 89, 23);
		getBtnZurueck().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		getBtnZurueck().setFont(customFont20f);
		getBtnZurueck().setBorderPainted(false);
		getBtnZurueck().setOpaque(false);
		getBtnZurueck().setBackground(SystemColor.activeCaption);
		getBtnZurueck().setFocusable(false);
		getFrame().getContentPane().add(getBtnZurueck());
			
		setLblHintergrund(new JLabel(""));
		getLblHintergrund().setVisible(false);		
		getLblHintergrund().setBounds(0, 0, 794, 571);
		getFrame().getContentPane().add(getLblHintergrund());
			
		Movement m = new Movement(10); // Hintergrund-Image dem Hintergurnd-Label zuweisen, Bewegung festlegen & dem Frame hinzufuegen
		
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("src/Resources/Hintergrund.png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	
		m.label.setBufferedImage(image,0);
		m.label.setOpaque(false);
		m.label.setBounds(0, 0, 800, 600);
		getFrame().getContentPane().add(m.label);
	}
	/**
	 * Getter & Setter fuer die verwendeten Variablen 
	 */
	public JLabel getLblHintergrund() {
		return lblHintergrund;
	}

	public void setLblHintergrund(JLabel lblHintergrund) {
		this.lblHintergrund = lblHintergrund;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JLabel getLblLaenge() {
		return lblLaenge;
	}

	public void setLblLaenge(JLabel lblLaenge) {
		this.lblLaenge = lblLaenge;
	}

	public JLabel getLblGefahreneRennen() {
		return lblGefahreneRennen;
	}

	public void setLblGefahreneRennen(JLabel lblGefahreneRennen) {
		this.lblGefahreneRennen = lblGefahreneRennen;
	}

	public JLabel getLblGefahreneKmGesamt() {
		return lblGefahreneKmGesamt;
	}

	public void setLblGefahreneKmGesamt(JLabel lblGefahreneKmGesamt) {
		this.lblGefahreneKmGesamt = lblGefahreneKmGesamt;
	}

	public JLabel getLblRennenAlsErster() {
		return lblRennenAlsErster;
	}

	public void setLblRennenAlsErster(JLabel lblRennenAlsErster) {
		this.lblRennenAlsErster = lblRennenAlsErster;
	}

	public JLabel getLblRennenAlsZweiter() {
		return lblRennenAlsZweiter;
	}

	public void setLblRennenAlsZweiter(JLabel lblRennenAlsZweiter) {
		this.lblRennenAlsZweiter = lblRennenAlsZweiter;
	}

	public JLabel getLblRennenAlsDritter() {
		return lblRennenAlsDritter;
	}

	public void setLblRennenAlsDritter(JLabel lblRennenAlsDritter) {
		this.lblRennenAlsDritter = lblRennenAlsDritter;
	}

	public JLabel getLblSetLaenge() {
		return lblSetLaenge;
	}

	public void setLblSetLaenge(JLabel lblSetLaenge) {
		this.lblSetLaenge = lblSetLaenge;
	}

	public JLabel getLblSetGesKm() {
		return lblSetGesKm;
	}

	public void setLblSetGesKm(JLabel lblSetGesKm) {
		this.lblSetGesKm = lblSetGesKm;
	}

	public JLabel getLblSetGesRennen() {
		return lblSetGesRennen;
	}

	public void setLblSetGesRennen(JLabel lblSetGesRennen) {
		this.lblSetGesRennen = lblSetGesRennen;
	}

	public JLabel getLblSetAnzErster() {
		return lblSetAnzErster;
	}

	public void setLblSetAnzErster(JLabel lblSetAnzErster) {
		this.lblSetAnzErster = lblSetAnzErster;
	}

	public JLabel getLblSetAnzZweiter() {
		return lblSetAnzZweiter;
	}

	public void setLblSetAnzZweiter(JLabel lblSetAnzZweiter) {
		this.lblSetAnzZweiter = lblSetAnzZweiter;
	}

	public JLabel getLblSetAnzDritter() {
		return lblSetAnzDritter;
	}

	public void setLblSetAnzDritter(JLabel lblSetAnzDritter) {
		this.lblSetAnzDritter = lblSetAnzDritter;
	}

	public JButton getBtnZurueck() {
		return btnZurueck;
	}

	public void setBtnZurueck(JButton btnZurueck) {
		this.btnZurueck = btnZurueck;
		btnZurueck.setForeground(Color.RED);
	}
}
