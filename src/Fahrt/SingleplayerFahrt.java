/**
 * Bildet die Entit�ten der Fahrten ab und stellt eine Fahrtverwaltung (Multi-Entit�t) zur Verf�gung um Fahrten zu speichern und abzurufen.
 */
package Fahrt;


/**
 * Klasse der Entit�t SingleplayerFahrt. Subtyp der Klasse Fahrt.
 * @author Marvin Braun
 *
 */
public class SingleplayerFahrt extends Fahrt {

private String schwierigkeit;

public String getSchwierigkeit() {
	return schwierigkeit;
}

public void setSchwierigkeit(String string) {

	schwierigkeit = string;
}

}
