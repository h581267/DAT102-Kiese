package no.hvl.dat102.koe;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.exception.EmptyCollectionException;

//********************************************************************
// 
//  Representer en samling koe, implementert vha kjedet struktur
//********************************************************************

public class KjedetKoe<T> implements KoeADT<T> {
	private int antall;
	private LinearNode<T> front, bak;

	public KjedetKoe() {
		front = null;
		bak = null;
		antall = 0;
	}

	public void leggTil(T element) {
		LinearNode<T> node = new LinearNode<T>(element);
		LinearNode<T> denne = front;

		if (front == null) {
			front = node;
		}

		else {
			for (int i = 0; i < antall; i++) {
				if (denne.getNeste() == null) {
					denne.setNeste(node);
				} else {
					denne = denne.getNeste();
				}
			}
		}
		antall++;
	}

	// fjerner det elementet som er først i køen
	public T slett() throws EmptyCollectionException {
		if(erTom()) {
			throw new EmptyCollectionException("Køen er tom");
		}
		
		T slettet = front.getElement();
		front = front.getNeste();
		
		antall--;
		
		return slettet;
	}

	// returnerer antall elementer i køen
	public int antall() {
		return antall;
	}

	// Sjekker om køen er tom
	public boolean erTom() {
		return(front == null);
	}
	
	//Returnerer elementet først i køen
	public T første() {
		return front.getElement();
	}
}// class
