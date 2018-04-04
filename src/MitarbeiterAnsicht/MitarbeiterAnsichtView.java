package MitarbeiterAnsicht;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.Color;

/**
 * Grafische Benutzeroberfläche für die MitarbeiterAnsicht. Auf dem Haupt-JPanel
 * liegen zwei weitere JPanels. Das erste JPanel dient für das Menü. Das zweite
 * JPannel dient als Platzhalter für weitre JPanels, die im Fenster über das
 * CardLayout angezeigt werden sollen.
 * 
 * @author Sean Cartner
 */
public class MitarbeiterAnsichtView extends JFrame {

	private JPanel contentPane;
	private JPanel panelContent;
	private JTree tree;
	private CardLayout cl;

	/**
	 * Create the frame.
	 */
	public MitarbeiterAnsichtView() {

		setTitle("Pixel Racer - Mitarbeiter Men\u00FC");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// JPanel fuer das Menue
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(Color.WHITE);
		panelMenu.setBounds(0, 0, 170, 570);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);

		// Wurzel
		DefaultMutableTreeNode menu = new DefaultMutableTreeNode("Menu");
		// Kategorien
		DefaultMutableTreeNode startansicht = new DefaultMutableTreeNode("Startansicht");
		DefaultMutableTreeNode mitarbeiter = new DefaultMutableTreeNode("Mitarbeiter");
		DefaultMutableTreeNode kart = new DefaultMutableTreeNode("Kart");
		DefaultMutableTreeNode strecke = new DefaultMutableTreeNode("Strecke");
		DefaultMutableTreeNode bezahlart = new DefaultMutableTreeNode("Bezahlart");
		DefaultMutableTreeNode statistik = new DefaultMutableTreeNode("Statistik");
		// MenuPunkte
		DefaultMutableTreeNode start = new DefaultMutableTreeNode("Start");
		DefaultMutableTreeNode mitarbeiterHinzufügen = new DefaultMutableTreeNode("Füge Mitarbeiter hinzu");
		DefaultMutableTreeNode kartHinzufügen = new DefaultMutableTreeNode("Füge Kart hinzu");
		DefaultMutableTreeNode streckeHinzufügen = new DefaultMutableTreeNode("Füge Strecke hinzu");
		DefaultMutableTreeNode bezahlartHinzufügen = new DefaultMutableTreeNode("Füge Bezahlart hinzu");
		DefaultMutableTreeNode kartBearbeiten = new DefaultMutableTreeNode("Bearbeite Kart");
		DefaultMutableTreeNode streckeBearbeiten = new DefaultMutableTreeNode("Bearbeite Strecke");
		DefaultMutableTreeNode mitarbeiterBearbeiten = new DefaultMutableTreeNode("Bearbeite Mitarbeiter");
		DefaultMutableTreeNode allgemein = new DefaultMutableTreeNode("Allgemein");
		// Zuweisung Wurzel - Kategorie
		menu.add(startansicht);
		menu.add(mitarbeiter);
		menu.add(kart);
		menu.add(strecke);
		menu.add(bezahlart);
		menu.add(statistik);
		// Zuweisung Kategorie - MenuPunkt
		startansicht.add(start);
		mitarbeiter.add(mitarbeiterHinzufügen);
		mitarbeiter.add(mitarbeiterBearbeiten);
		kart.add(kartHinzufügen);
		kart.add(kartBearbeiten);
		strecke.add(streckeHinzufügen);
		strecke.add(streckeBearbeiten);
		bezahlart.add(bezahlartHinzufügen);
		statistik.add(allgemein);

		tree = new JTree(menu);
		tree.setBackground(Color.WHITE);
		tree.setRootVisible(false);
		tree.setBounds(10, 30, 160, 541);

		panelMenu.add(tree);

		// Panel fuer das CardLayout
		panelContent = new JPanel();
		panelContent.setBounds(170, 0, 624, 570);
		contentPane.add(panelContent);
		cl = new CardLayout();
		panelContent.setLayout(cl);
	}

	/**
	 * Getter für das Panel panelContent
	 * 
	 * @return JPanel
	 */
	public JPanel getPanelContent() {
		return panelContent;
	}

	/**
	 * Getter für den JTree
	 * 
	 * @return JTree
	 */
	public JTree getTree() {
		return tree;
	}

	/**
	 * Getter für das CardLayout
	 * 
	 * @return CardLayout
	 */
	public CardLayout getCL() {
		return cl;
	}

}
