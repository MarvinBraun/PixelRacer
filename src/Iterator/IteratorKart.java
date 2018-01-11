//@MarvinBraun
package myIterator;
import java.util.ListIterator;

/**
 * modifizierter ListIterator um die Zeiger-Positionierung des ListIterators zu korrigieren, da sich ein ListIterator sich zwischen den Elementen platziert und
 *  sonst doppelte Elemente bei entsprechenden User-Interaktionen (Vor und zurück im Wechsel) zurückgegeben werden.
 * @param <Kart>
 * @author Marvin Braun
 * 
 */

public class IteratorKart<Kart>{
	
	 private final ListIterator<Kart> listIterator;

     private boolean nextWasCalled = false;
     private boolean previousWasCalled = false;

     public IteratorKart(ListIterator<Kart> listIterator) {
         this.listIterator = listIterator;
     }

     /**
      * Springt n+1 oder n+2 Elemente weiter.
      * @return Kart Ein Objekt der Klasse Kart.
      */
     
     public Kart next() {
         nextWasCalled = true;
         if (previousWasCalled) {
             previousWasCalled = false;
             listIterator.next();
         }
         return listIterator.next();
     }
     
     /**
      * Springt n-1 oder n-2 Elemente weiter.
      * @return Kart Ein Objekt der Klasse Kart.
      */

     public Kart previous() {
         if (nextWasCalled) {
             listIterator.previous();
             nextWasCalled = false;
         }
         previousWasCalled = true;
         return listIterator.previous();
     }

 }   
