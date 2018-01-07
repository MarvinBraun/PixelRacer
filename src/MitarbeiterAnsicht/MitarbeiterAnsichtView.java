/**
 @author Sean Cartner
*/

package MitarbeiterAnsicht;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.Color;


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
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(Color.WHITE);
		panelMenu.setBounds(0, 0, 170, 570);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		//Wurzel
		DefaultMutableTreeNode menu = new DefaultMutableTreeNode("Menu");
		//Kategorien
		DefaultMutableTreeNode startansicht = new DefaultMutableTreeNode("Startansicht");
		DefaultMutableTreeNode mitarbeiter = new DefaultMutableTreeNode("Mitarbeiter");
		DefaultMutableTreeNode kart = new DefaultMutableTreeNode("Kart");
		DefaultMutableTreeNode strecke = new DefaultMutableTreeNode("Strecke");
		DefaultMutableTreeNode bezahlart = new DefaultMutableTreeNode("Bezahlart");
		//MenuPunkte
		DefaultMutableTreeNode start = new DefaultMutableTreeNode("Start");
		DefaultMutableTreeNode mitarbeiterHinzufügen = new DefaultMutableTreeNode("Füge Mitarbeiter hinzu");
		DefaultMutableTreeNode kartHinzufügen = new DefaultMutableTreeNode("Füge Kart hinzu");
		DefaultMutableTreeNode streckeHinzufügen = new DefaultMutableTreeNode("Füge Strecke hinzu");
		DefaultMutableTreeNode bezahlartHinzufügen = new DefaultMutableTreeNode("Füge Bezahlart hinzu");
		DefaultMutableTreeNode kartBearbeiten = new DefaultMutableTreeNode("Bearbeite Kart");
		// Zuweisung Wurzel - Kategorie
		menu.add(startansicht);
		menu.add(mitarbeiter);
		menu.add(kart);
		menu.add(strecke);
		menu.add(bezahlart);
		//Zuweisung Kategroie - MenuPunkt
		startansicht.add(start);
		mitarbeiter.add(mitarbeiterHinzufügen);
		kart.add(kartHinzufügen);
		kart.add(kartBearbeiten);
		strecke.add(streckeHinzufügen);
		bezahlart.add(bezahlartHinzufügen);
		
		tree = new JTree(menu);
		tree.setBackground(Color.WHITE);
		tree.setRootVisible( false );
		tree.setBounds(10, 30, 160, 541);
		
		panelMenu.add(tree);
		
		panelContent = new JPanel();
		panelContent.setBounds(170, 0, 624, 570);
		contentPane.add(panelContent);
		cl = new CardLayout();
		panelContent.setLayout(cl);
	}
	
	public JPanel getPanelContent() {
		return panelContent;
	}
	
	public JTree getTree() {
		return tree;
	}
	
	public CardLayout getCL() {
		return cl;
	}

}
