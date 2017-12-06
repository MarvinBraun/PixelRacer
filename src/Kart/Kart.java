//@author Ferhat Koca
package Kart;

import java.awt.image.BufferedImage;

public class Kart {
	public String kartname;
	public int beschleunigung;
	public int maxkmh;
	public String premium;
	public int punktewert;
	public BufferedImage grafik;

	public void setKartname(String kartname) {
		this.kartname = kartname;
	}

	public void setBeschleunigung(int beschleunigung) {
		this.beschleunigung = beschleunigung;
	}

	public void setMaxkmh(int maxkmh) {
		this.maxkmh = maxkmh;
	}

	public void setPremium(String premium) {
		this.premium = premium;
	}

	public void setPunktewert(int punktewert) {
		this.punktewert = punktewert;
	}

	public void setGrafik(BufferedImage grafik) {
		this.grafik = grafik;
	}

	public String getKartname() {
		return kartname;
	}

	public int getBeschleunigung() {
		return beschleunigung;
	}

	public int getMaxkmh() {
		return maxkmh;
	}

	public String getPremium() {
		return premium;
	}

	public int getPunktewert() {
		return punktewert;
	}

	public BufferedImage getGrafik() {
		return grafik;
	}

}
