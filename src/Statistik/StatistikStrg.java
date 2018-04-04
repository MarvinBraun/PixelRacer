package Statistik;

import Nutzer.Nutzerverwaltung;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import Datenbankverwaltung.Datenbankschnittstelle;
import Nutzer.Kunde;


public class StatistikStrg {
	
	private StatistikView view;
	private LinkedList<Kunde> nutzerliste;

	public StatistikStrg() {
		view = new StatistikView();
		Nutzerverwaltung.gibKundenliste().clear();
		nutzerliste = Nutzerverwaltung.gibKundenliste();
		berechneUmsatzUndKuAnzahl();
		gruppieren();
	}
	
	private void berechneUmsatzUndKuAnzahl() {
		//Karts
		ResultSet rs = Datenbankschnittstelle.executeQuery("select count (RECHNUNGSNUMMER) from rechnungkart");
		int i = 0;
		try {
			while (rs.next()) {
				i = rs.getInt(1);
			}
			rs.close();

		} catch (SQLException e) {
			konnteUmsatzNichtBerechnenMeldung();
		}
		Datenbankschnittstelle.closeConnections();
		double kart = i * 4.99;
		kart = Math.round(100.0 * kart) / 100.0;

		//Strecken
		ResultSet rs2 = Datenbankschnittstelle.executeQuery("select count (RECHNUNGSNUMMER) from rechnungstrecke");
		int j = 0;
		try {
			while (rs2.next()) {
				j = rs2.getInt(1);
			}
			rs2.close();

		} catch (SQLException e) {
			konnteUmsatzNichtBerechnenMeldung();
		}
		Datenbankschnittstelle.closeConnections();
		double strecke = j * 4.99;
		strecke = Math.round(100.0 * strecke) / 100.0;
		
		
		//Premiumuser
		int premium = 0;
		for (Kunde ku : nutzerliste) {
			if(ku.getpremium().equals("true")) {
				premium = premium + 1;
			}
		}
		double user = premium * 4.99;
		user = Math.round(100.0 * user) / 100.0;
		
		double ums = kart + strecke + user;
		ums =  Math.round(100.0 * ums) / 100.0;
		String umsatz = String.valueOf(ums) + "€";
		view.getTextFieldUmsatz().setText(umsatz);
		view.getTextFieldPremium().setText(String.valueOf(premium));
		view.getTextFieldMitglieder().setText(String.valueOf(nutzerliste.size()));
	}
	
	private void gruppieren() {
		
		int zehnBisSiebzehn = 0;
		int achtzehnBisFuenfundzwanzig = 0;
		int sechsundzwanzigBisNeunundDreissig = 0;
		int vierzigBisNeunundfuenfzig = 0;
		int ueberSechszig = 0;
		
		for (Kunde ku : nutzerliste) {
			try {
				 String dateStr = ku.getgebdat();
				 DateFormat srcDf = new SimpleDateFormat("dd.MM.yy");
				 Date date = srcDf.parse(dateStr);
				 DateFormat destDf = new SimpleDateFormat("dd;MM;yyyy");
				 dateStr = destDf.format(date);
				 String test = dateStr;
				
				 String[] split;
				 split = test.split(";");
				 int tag = Integer.parseInt(split[0]);
				 int monat = Integer.parseInt(split[1]);
				 int jahr = Integer.parseInt(split[2]);
				 
				LocalDate today = LocalDate.now();
				LocalDate birthday = LocalDate.of(jahr, monat, tag);
				Period p = Period.between(birthday, today);
				
				if(p.getYears() >= 10 && p.getYears() <= 17) {
					zehnBisSiebzehn = zehnBisSiebzehn + 1;
				}
				if(p.getYears() >= 18 && p.getYears() <= 25) {
					achtzehnBisFuenfundzwanzig = achtzehnBisFuenfundzwanzig + 1;
				} 
				if(p.getYears() >= 26 && p.getYears() <= 39) {
					sechsundzwanzigBisNeunundDreissig = sechsundzwanzigBisNeunundDreissig + 1;
				} 
				if(p.getYears() >= 40 && p.getYears() <= 59) {
					vierzigBisNeunundfuenfzig = vierzigBisNeunundfuenfzig + 1;
				} 
				if(p.getYears() >= 60) {
					ueberSechszig = ueberSechszig + 1;
				} 
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
		}
		
		double zehn = (zehnBisSiebzehn * 100.0) /nutzerliste.size();
		zehn = Math.round(100.0 * zehn) / 100.0;
		view.getTextFieldZehn().setText(String.valueOf(zehn));
		
		double achtzehn = (achtzehnBisFuenfundzwanzig * 100.0) /nutzerliste.size();
		achtzehn = Math.round(100.0 * achtzehn) / 100.0;
		view.getTextFieldAchtzehn().setText(String.valueOf(achtzehn));
		
		double sechsundzwanzig = (sechsundzwanzigBisNeunundDreissig * 100.0) /nutzerliste.size();
		sechsundzwanzig = Math.round(100.0 * sechsundzwanzig) / 100.0;
		view.getTextFieldSechsundzwanzig().setText(String.valueOf(sechsundzwanzig));
		
		double vierzig = (vierzigBisNeunundfuenfzig * 100.0) /nutzerliste.size();
		vierzig = Math.round(100.0 * vierzig) / 100.0;
		view.getTextFieldVierzig().setText(String.valueOf(vierzig));
		
		double sechszig = (ueberSechszig * 100.0) /nutzerliste.size();
		sechszig = Math.round(100.0 * sechszig) / 100.0;
		view.getTextField60().setText(String.valueOf(sechszig));
		
	}
	
	private void konnteUmsatzNichtBerechnenMeldung() {
		JOptionPane.showMessageDialog(view.getPanel(),
				"Umsatz konnte aufgrund eines Datenbank Problems nicht berechnet werden", "Datenbankproblem",
				JOptionPane.WARNING_MESSAGE);

	}
	
	public StatistikView getView() {
		return view;
	}
	
}
