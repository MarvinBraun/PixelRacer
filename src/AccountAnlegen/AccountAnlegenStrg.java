package AccountAnlegen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.Charset;

import javax.swing.JOptionPane;

import Anmelden.AnmeldenStrg;
import Datenbankverwaltung.Datenbankschnittstelle;

//Autor Daniel Zeller

public class AccountAnlegenStrg implements ActionListener{
	private String benutzername;
	private String vn;
	private String nn;
	private String gebdat;
	private String email;
	private String pw;
	
	AccountAnlegenView view1;
	
	public AccountAnlegenStrg() {
			view1 = new AccountAnlegenView();
			view1.frmPixelRacer.setVisible(true);
			
			view1.btnAnlegen.addActionListener(this);
			view1.btnAbbrechen.addActionListener(this);
		}
		
		public static void main(String[] args) {
			AccountAnlegenStrg strg = new AccountAnlegenStrg();
		}
		
		public void eingegebeneDatenSpeichern() {
			benutzername = view1.txtNutzername.getText();
			pw = new String(view1.passwordField.getPassword());
			vn = view1.txtVorname.getText();
			nn = view1.txtNachname.getText();
			email = view1.txtEmail.getText();
			gebdat = view1.txtGeburtsdatum.getText();
		}
		
		public Boolean DatenPruefen() {
			if(benutzername.length() <=20 && benutzername.length() != 0) {
				if(pw.length() <=20 && pw.length() != 0) {
					if(vn.length() <=20 && vn.length() != 0) {
						if(nn.length() <=20 && nn.length() != 0) {
							if(gebdat.length() <=8 && gebdat.length() != 0) {
								if(email.length() <=50 && email.length() != 0) {
									return true;
								}
								
								else {
									return false;
								}
							}
							
							else {
								return false;
							}
						}
						
						else {
							return false;
						}
					}
					
					else {
						return false;
					}
				}
				
				else {
					return false;
				}
			}
			
			else {
				return false;
			}
		}
		
		public void InsertIntoKunde() {
			String update = ("insert into kunde values('" + benutzername + "','" + pw + "','" + vn
					+ "','" + nn + "','false',0,'" + gebdat + "','" + email +"')");
			
			Datenbankschnittstelle.executeUpdate(update);
			Datenbankschnittstelle.closeConnections();
			
			view1.frmPixelRacer.dispose();
			AnmeldenStrg strg = new AnmeldenStrg();
		}
	
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()== view1.btnAnlegen) {
				
				eingegebeneDatenSpeichern();
				if(DatenPruefen()) {
					InsertIntoKunde();
					JOptionPane.showMessageDialog(null, "Der Account wurde erfolgreich angelegt!","Viel Spaß!", JOptionPane.ERROR_MESSAGE);
				}
				
				else {
					JOptionPane.showMessageDialog(null, "Manche der eingegebenen Daten stimmen nicht mit den Anforderungen überein!", 
							"Ok", JOptionPane.ERROR_MESSAGE);
				}
			}
			
			if(e.getSource()== view1.btnAbbrechen) {
				view1.frmPixelRacer.dispose();
				AnmeldenStrg strg = new AnmeldenStrg();
			}
	}
}