package Rechnung;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import BackgroundAnimation.Movement;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

/**
 * 
 * @author Daniel Zeller
 *
 */

public class RechnungBezahlenView {

	private JFrame frmRechnungBezahlen;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lblPaypal;
	private JLabel lblEmail;
	private JLabel lblPasswort;
	private JButton btnBezahlen;
	private JButton btnAbbrechen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RechnungBezahlenView window = new RechnungBezahlenView();
					window.frmRechnungBezahlen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RechnungBezahlenView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRechnungBezahlen = new JFrame();
		frmRechnungBezahlen.setTitle("Rechnung bezahlen");
		frmRechnungBezahlen.setResizable(false);
		frmRechnungBezahlen.setBounds(100, 100, 800, 600);
		frmRechnungBezahlen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRechnungBezahlen.getContentPane().setLayout(null);
		
		lblPaypal = new JLabel("PayPal");
		lblPaypal.setBounds(310, 52, 46, 14);
		frmRechnungBezahlen.getContentPane().add(lblPaypal);
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(310, 116, 46, 14);
		frmRechnungBezahlen.getContentPane().add(lblEmail);
		
		textField = new JTextField();
		textField.setBounds(310, 160, 183, 20);
		frmRechnungBezahlen.getContentPane().add(textField);
		textField.setColumns(10);
		
		lblPasswort = new JLabel("Passwort");
		lblPasswort.setBounds(310, 207, 155, 14);
		frmRechnungBezahlen.getContentPane().add(lblPasswort);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(310, 242, 183, 20);
		frmRechnungBezahlen.getContentPane().add(passwordField);
		
		btnBezahlen = new JButton("Bezahlen");
		btnBezahlen.setBounds(267, 359, 89, 23);
		btnBezahlen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frmRechnungBezahlen.getContentPane().add(btnBezahlen);
		
		
		btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.setBounds(413, 359, 132, 23);
		btnAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frmRechnungBezahlen.getContentPane().add(btnAbbrechen);
		
		Movement m = new Movement(10);
		
		BufferedImage image = null;
		try {
			URL url = getClass().getResource("/Resources/Hintergrund.png");
			image = ImageIO.read(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		m.label.setBufferedImage(image,0);
		
		m.label.setOpaque(false);
		m.label.setBounds(0, 0, 800, 600);
		frmRechnungBezahlen.getContentPane().add(m.label);
		frmRechnungBezahlen.setVisible(true);
	}

	public JFrame getFrmRechnungBezahlen() {
		return frmRechnungBezahlen;
	}

	public void setFrmRechnungBezahlen(JFrame frmRechnungBezahlen) {
		this.frmRechnungBezahlen = frmRechnungBezahlen;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	public JLabel getLblPaypal() {
		return lblPaypal;
	}

	public void setLblPaypal(JLabel lblPaypal) {
		this.lblPaypal = lblPaypal;
	}

	public JLabel getLblEmail() {
		return lblEmail;
	}

	public void setLblEmail(JLabel lblEmail) {
		this.lblEmail = lblEmail;
	}

	public JLabel getLblPasswort() {
		return lblPasswort;
	}

	public void setLblPasswort(JLabel lblPasswort) {
		this.lblPasswort = lblPasswort;
	}

	public JButton getBtnBezahlen() {
		return btnBezahlen;
	}

	public void setBtnBezahlen(JButton btnBezahlen) {
		this.btnBezahlen = btnBezahlen;
	}

	public JButton getBtnAbbrechen() {
		return btnAbbrechen;
	}

	public void setBtnAbbrechen(JButton btnAbbrechen) {
		this.btnAbbrechen = btnAbbrechen;
	}
}
