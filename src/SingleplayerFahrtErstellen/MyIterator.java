package SingleplayerFahrtErstellen;

import java.util.ListIterator;

public class MyIterator<Kart>{
	
	 private final ListIterator<Kart> listIterator;

     private boolean nextWasCalled = false;
     private boolean previousWasCalled = false;

     public MyIterator(ListIterator<Kart> listIterator) {
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
