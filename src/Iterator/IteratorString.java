
package Iterator;
import java.util.ListIterator;


/**
 * modifizierter ListIterator um die Zeiger-Positionierung des ListIterators zu korrigieren, da sich ein ListIterator sich zwischen den Elementen platziert und
 * sonst doppelte Elemente bei entsprechenden User-Interaktionen (Vor und zurück im Wechsel) zurückgegeben werden.
 * @param <String> String
 * @author Marvin Braun
 * 
 */
public class IteratorString<String>{
	
	 private final ListIterator<String> listIterator;

     private boolean nextWasCalled = false;
     private boolean previousWasCalled = false;

     public IteratorString(ListIterator<String> listIterator) {
         this.listIterator = listIterator;
     }

     /**
      * Springt n+1 oder n+2 Elemente weiter.
      * @return String Ein Objekt der Klasse String.
      */
     public String next() {
         nextWasCalled = true;
         if (previousWasCalled) {
             previousWasCalled = false;
             listIterator.next ();
         }
         return listIterator.next ();
     }

     /**
      * Springt n-1 oder n-2 Elemente weiter.
      * @return String Ein Objekt der Klasse String
      */
     public String previous() {
         if (nextWasCalled) {
             listIterator.previous();
             nextWasCalled = false;
         }
         previousWasCalled = true;
         return listIterator.previous();
     }

 }   
