package Kart;

public class Kart {
	public String kartname;
	public int beschleunigung;
	public int geschwindigkeit;

	public void setKartname(String kartname) {
		this.kartname = kartname;
	}

	public void setBeschleunigung(int beschleunigung) {
		this.beschleunigung = beschleunigung;
	}

	public void setGeschwindigkeit(int geschwindigkeit) {
		this.geschwindigkeit = geschwindigkeit;
	}

	public String getKartname() {
		return kartname;
	}

	public int getBeschleunigung() {
		return beschleunigung;
	}

	public int getGeschwindigkeit() {
		return geschwindigkeit;
	}

}
