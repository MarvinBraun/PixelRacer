package MitarbeiterBearbeiten;

import java.util.Comparator;
import Nutzer.Mitarbeiter;

public class MitarbeiterKomperator implements Comparator<Mitarbeiter>  {

	@Override
	public int compare(Mitarbeiter m1, Mitarbeiter m2) {
		return m1.getmitarbeiterid().compareTo(m2.getmitarbeiterid());
	}

}
