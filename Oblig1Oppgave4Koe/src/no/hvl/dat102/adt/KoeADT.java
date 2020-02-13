package no.hvl.dat102.adt;

import no.hvl.dat102.exception.EmptyCollectionException;

public interface KoeADT<T> {

	//Legger til et element bakest i køen, utvider hvis behov
	public void leggTil (T element);
	
	//fjerner det elementet som er først i køen
	public T slett() throws EmptyCollectionException;
	
	//returnerer antall elementer i køen
	public int antall();
	
	//returnerer elementet først i køen
	public T første();
	
	//Sjekker om køen er tom
	public boolean erTom();
}
