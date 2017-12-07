//@MarvinBraun
package FahrtErstellen;
import java.util.ListIterator;

//modifizierter ListIterator um die Zeiger-Positionierung des ListIterators zu korrigieren.
//mit dem normalen ListIterator würden sonst doppelte Elemente bei entsprechenden User-Interaktionen zurückgegeben werden.

public class MyIteratorString<String>{
	
	 private final ListIterator<String> listIterator;

     private boolean nextWasCalled = false;
     private boolean previousWasCalled = false;

     public MyIteratorString(ListIterator<String> listIterator) {
         this.listIterator = listIterator;
     }

     public String next() {
         nextWasCalled = true;
         if (previousWasCalled) {
             previousWasCalled = false;
             listIterator.next ();
         }
         return listIterator.next ();
     }

     public String previous() {
         if (nextWasCalled) {
             listIterator.previous();
             nextWasCalled = false;
         }
         previousWasCalled = true;
         return listIterator.previous();
     }

 }   
