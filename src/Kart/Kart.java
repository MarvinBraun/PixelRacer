package Kart;

public class Kart {
	public String kartname;
	public int beschleunigung;
	public int maxkmh;

	public void setKartname(String kartname) {
		this.kartname = kartname;
	}

	public void setBeschleunigung(int beschleunigung) {
		this.beschleunigung = beschleunigung;
	}

	public void setMaxkmh(int maxkmh) {
		this.maxkmh = maxkmh;
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

}
