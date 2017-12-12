//@Author Ferhat Koca
package Computergegner;

import Strecke.Strecke;
import Kart.Kart;

public class Bot {

	int zeit;
	public int getZeit() {
		return zeit;
	}

	public void setZeit(int zeit) {
		this.zeit = zeit;
	}

	int l‰nge;
	int geschwindigkeit;
	int beschleunigung;

	public Bot(int streckenl‰nge, int geschwindigkeit, int beschleunigung) {
		
		l‰nge = streckenl‰nge;
		this.geschwindigkeit = geschwindigkeit;
		this.beschleunigung = beschleunigung;

		zeit = (int) (((l‰nge / geschwindigkeit) + (geschwindigkeit / beschleunigung)) * Math.random());
	}

	public static void main(String[] args) {
		
		
	}

}
// Stecke = gib l√§nge
// geschw. = gib strecke
// beschl = gib beschl
// beschl = geschw/beschl
// Strecke = gib schwierigkeit

// (Strecke/geschw + beschlZeit)*math.random());
