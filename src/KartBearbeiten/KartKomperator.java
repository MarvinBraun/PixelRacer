package KartBearbeiten;

import java.util.Comparator;
import Kart.Kart;

/**
 * KomperatorKlasse, die dazu dient zwei Karts nach Namen zu sortieren.
 * 
 * @author Sean Cartner
 *
 */
public class KartKomperator implements Comparator<Kart> {

	public int compare(Kart k1, Kart k2) {
		return k1.getKartname().compareTo(k2.getKartname());
	}

}
