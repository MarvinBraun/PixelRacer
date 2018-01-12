package StreckeBearbeiten;

import java.util.Comparator;
import Strecke.Strecke;

/**
 * Komperatorklasse, die dazu dient zwei Strecken nach Namen zu sortieren.
 * 
 * @author Sean Cartner
 *
 */
public class StreckenKomperator implements Comparator<Strecke> {

	@Override
	public int compare(Strecke s1, Strecke s2) {
		return s1.getStreckenname().compareTo(s2.getStreckenname());
	}

}
