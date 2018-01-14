/**
 * Bildet die Entitäten der Fahrten ab und stellt eine Fahrtverwaltung (Multi-Entität) zur Verfügung um Fahrten zu speichern und abzurufen.
 */
package Fahrt;


/**
 * Klasse der Entität SingleplayerFahrt. Subtyp der Klasse Fahrt.
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
