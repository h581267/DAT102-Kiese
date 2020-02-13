package no.hvl.dat102.koe;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.exception.EmptyCollectionException;

//********************************************************************
//
//  Representerer en samling k�, implementert vha en tabell.
    // foran er i posisjon 0.
//********************************************************************

 public class TabellKoe<T> implements KoeADT<T>{
   private final static int STDK = 100;
   private int bak;
   private T[] koe; 

   /******************************************************************
     Oppretter en tom kø med standard st�rrelse.
     ******************************************************************/
   public TabellKoe()   {
     this(STDK);     
   }

   /******************************************************************
     Oppretter en tom kø med kapasitet gitt ved parameter
   ******************************************************************/
   public TabellKoe (int startKapasitet){
      bak = 0;     
      koe = (T[])(new Object[startKapasitet]);
    }

   public void leggTil(T element) {
	   if(koe.length < bak) {
		   utvid();
	   }
	   koe[bak] = element;
	   bak++;
   }
   
   public T slett() throws EmptyCollectionException{
	   
	   if(erTom()) {
			throw new EmptyCollectionException("Køen er tom");
		}
	   
	   T element = koe[0];
	   koe[0] = null;
	   
	   for(int i = 1; i <= bak; i++) {
		   koe[i-1] = koe[i];
	   }
	   koe[bak] = null;
	   bak--;
	   
	   return element; 
   }
   
   public int antall() {
	   return bak; 
   }
   
   public boolean erTom() {
	   return(koe[0] == null);
	   
   }
   
   public T første() {
	   return koe[0];
   }
   
   public void utvid() {
	   T[] ny = ((T[]) new Object[koe.length * 2]);
	   
	   for(int i = 0; i < bak; i++) {
		   ny[i] = koe[i];
	   }
	   
	   koe = ny;
   }
   
   public int getLength() {
	   return koe.length;
   }
   
}//class



