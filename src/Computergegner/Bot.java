
package Computergegner;

import Strecke.Strecke;
import Kart.Kart;

/**
 * Die Klasse Bot generiert je nach ausgew�hlter Schwierigkeit eine generierte
 * Zeit aus, die der Computergegner gefahren ist.
 * 
 * @author Ferhat Koca
 *
 */
public class Bot {

	int zeit;

	public int getZeit() {
		return zeit;
	}

	public void setZeit(int zeit) {
		this.zeit = zeit;
	}

	int l�nge;
	int geschwindigkeit;
	int beschleunigung;
	int schwierigkeit;

	/**
	 * Erzeugt ein Objekt der Klasse und simuliert eine Zeit anhand der �bergebenen Werte.
	 * @param streckenl�nge L�nge der Strecke
	 * @param geschwindigkeit Geschwindigkeit des Karts
	 * @param beschleunigung Beschleunigung des Karts
	 * @param schwierigkeit Schwierigkeit der Fahrt
	 */
	
	public Bot(int streckenl�nge, int geschwindigkeit, int beschleunigung, int schwierigkeit) {

		this.l�nge = streckenl�nge;
		this.geschwindigkeit = geschwindigkeit;
		this.beschleunigung = beschleunigung;
		float schwierigkeit2 = 0;

		if (schwierigkeit == 1)
			schwierigkeit2 = (float) (0.9 + (Math.random() * 1.4));
		else if (schwierigkeit == 2)
			schwierigkeit2 = (float) (0.7 + (Math.random() * 1.3));
		else if (schwierigkeit == 3)
			schwierigkeit2 = (float) (0.5 + (Math.random() * 1.2));

		zeit = (int) ((int) (((l�nge / geschwindigkeit) + (geschwindigkeit / beschleunigung)) * schwierigkeit2) * 0.4);

	}

	public static void main(String[] args) {

	}

}
