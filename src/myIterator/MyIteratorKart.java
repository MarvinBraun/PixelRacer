//@MarvinBraun
package myIterator;
import java.util.ListIterator;

//modifizierter ListIterator um die Zeiger-Positionierung des ListIterators zu korrigieren.
//mit dem normalen ListIterator würden sonst doppelte Elemente bei entsprechenden User-Interaktionen zurückgegeben werden.

public class MyIteratorKart<Kart>{
	
	 private final ListIterator<Kart> listIterator;

     private boolean nextWasCalled = false;
     private boolean previousWasCalled = false;

     public MyIteratorKart(ListIterator<Kart> listIterator) {
         this.listIterator = listIterator;
     }

     public Kart next() {
         nextWasCalled = true;
         if (previousWasCalled) {
             previousWasCalled = false;
             listIterator.next ();
         }
         return listIterator.next ();
     }

     public Kart previous() {
         if (nextWasCalled) {
             listIterator.previous();
             nextWasCalled = false;
         }
         previousWasCalled = true;
         return listIterator.previous();
     }

 }   
