//@MarvinBraun
package myIterator;
import java.util.ListIterator;

//modifizierter ListIterator um die Zeiger-Positionierung des ListIterators zu korrigieren.
//mit dem normalen ListIterator würden sonst doppelte Elemente bei entsprechenden User-Interaktionen zurückgegeben werden.

public class MyIteratorStrecke<Strecke>{
	
	 private final ListIterator<Strecke> listIterator;

     private boolean nextWasCalled = false;
     private boolean previousWasCalled = false;

     public MyIteratorStrecke(ListIterator<Strecke> listIterator) {
         this.listIterator = listIterator;
     }

     public Strecke next() {
         nextWasCalled = true;
         if (previousWasCalled) {
             previousWasCalled = false;
             listIterator.next ();
         }
         return listIterator.next ();
     }

     public Strecke previous() {
         if (nextWasCalled) {
             listIterator.previous();
             nextWasCalled = false;
         }
         previousWasCalled = true;
         return listIterator.previous();
     }

 }   
