package no.hvl.dat102.koe;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.exception.EmptyCollectionException;

public class SirkulaerKoe<T> implements KoeADT<T> {

	private final static int STDK = 100;
	private int foran, bak, antall;
	private T[] koe;

	public SirkulaerKoe() {
		this(STDK);
	}

	public SirkulaerKoe(int startKapasitet) {
		foran = bak = antall = 0;
		koe = ((T[]) (new Object[startKapasitet]));
	}

	public void leggTil(T element) {
		
		if(antall >= koe.length) {
			utvid();
		}
		
		koe[bak] = element;
		antall++;
		bak++;
		bak = bak % koe.length;
	}

	public T slett() throws EmptyCollectionException {

		if(erTom()) {
			throw new EmptyCollectionException("Køen er tom");
		}
		
		T slettet = koe[foran];
		koe[foran] = null;
		antall--;
		foran++;

		return slettet;
	}

	public int antall() {
		return antall;
	}

	public boolean erTom() {

		return (foran == bak);
	}

	public void utvid() {
		T[] ny = ((T[]) new Object[koe.length * 2]);
		int j = 0;
		
		for (int i = foran; i < antall + foran; i++) {
			ny[j] = koe[i%koe.length];
			j++;
		}
		koe = ny;
		foran = 0;
		bak = antall;
	}
	
	public int getLength() {
		return koe.length;
	}
	
	public T første() {
		return koe[foran];
	}

}// class
