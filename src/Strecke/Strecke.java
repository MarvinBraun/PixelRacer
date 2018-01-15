package Strecke;

import java.awt.image.BufferedImage;
/**
 * Die Klasse Strecke speichert die relevanten Daten der Strecke ab und stellt
 * die benoetigten Getter & Setter zur Verfuegung.
 * @author Robin Demmler
 *
 */
public class Strecke {
	
	private String streckenname;
	private int laenge;
	private int schwierigkeit;
	private String premium = "false";
	private int punktewert;
	private BufferedImage grafik;

	public String getStreckenname() {
		return streckenname;
	}
	public void setStreckenname(String streckenname) {
		this.streckenname = streckenname;
	}
	public void setLaenge(int laenge) {
		this.laenge = laenge;
	}
	public int getLaenge() {
		return laenge;
	}
	public int getSchwierigkeit() {
		return schwierigkeit;
	}
	public void setSchwierigkeit(int schwierigkeit) {
		this.schwierigkeit = schwierigkeit;
	}
	public String getPremium() {
		return premium;
	}
	public void setPremium(String string) {
		this.premium = string;
	}
	public int getPunktewert() {
		return punktewert;
	}
	public void setPunktewert(int punktewert) {
		this.punktewert = punktewert;
	}
	public BufferedImage getGrafik() {
		return grafik;
	}
	public void setGrafik(BufferedImage grafik) {
		this.grafik = grafik;
	}
	
	
}
