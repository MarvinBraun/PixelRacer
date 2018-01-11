
package myIterator;
import java.util.ListIterator;

/**
 * modifizierter ListIterator um die Zeiger-Positionierung des ListIterators zu korrigieren, da sich ein ListIterator sich zwischen den Elementen platziert und
 *  sonst doppelte Elemente bei entsprechenden User-Interaktionen (Vor und zurück im Wechsel) zurückgegeben werden.
 * @param <Strecke>
 * @author Marvin Braun
 * 
 */
public class IteratorStrecke<Strecke>{
	
	 private final ListIterator<Strecke> listIterator;

     private boolean nextWasCalled = false;
     private boolean previousWasCalled = false;

     public IteratorStrecke(ListIterator<Strecke> listIterator) {
         this.listIterator = listIterator;
     }

     /**
      * Springt n+1 oder n+2 Elemente weiter.
      * @return Strecke Ein Objekt der Klasse Strecke.
      */
     public Strecke next() {
         nextWasCalled = true;
         if (previousWasCalled) {
             previousWasCalled = false;
             listIterator.next ();
         }
         return listIterator.next ();
     }
     
     /**
      * Springt n-1 oder n-2 Elemente weiter.
      * @return Strecke Ein Objekt der Klasse Strecke.
      */

     public Strecke previous() {
         if (nextWasCalled) {
             listIterator.previous();
             nextWasCalled = false;
         }
         previousWasCalled = true;
         return listIterator.previous();
     }

 }   
