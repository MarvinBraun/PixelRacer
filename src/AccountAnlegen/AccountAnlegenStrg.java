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
			view1.getFrmPixelRacer().setVisible(true);
			
			view1.getBtnAnlegen().addActionListener(this);
			view1.getBtnAbbrechen().addActionListener(this);
		}
		
		public static void main(String[] args) {
			AccountAnlegenStrg strg = new AccountAnlegenStrg();
		}
		
		public void eingegebeneDatenSpeichern() {
			benutzername = view1.getTxtNutzername().getText();
			pw = new String(view1.getPasswordField().getPassword());
			vn = view1.getTxtVorname().getText();
			nn = view1.getTxtNachname().getText();
			email = view1.getTxtEmail().getText();
			gebdat = view1.getTxtGeburtsdatum().getText();
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
			
			view1.getFrmPixelRacer().dispose();
			AnmeldenStrg strg = new AnmeldenStrg();
		}
	
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()== view1.getBtnAnlegen()) {
				
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
			
			if(e.getSource()== view1.getBtnAbbrechen()) {
				view1.getFrmPixelRacer().dispose();
				AnmeldenStrg strg = new AnmeldenStrg();
			}
	}
}