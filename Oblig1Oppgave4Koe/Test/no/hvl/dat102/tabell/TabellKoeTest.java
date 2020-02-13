package no.hvl.dat102.tabell;

import static org.junit.Assert.*;
import org.junit.jupiter.api.*;

import org.junit.Before;
import org.junit.Test;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.adt.KoeADTTest;
import no.hvl.dat102.exception.EmptyCollectionException;
import no.hvl.dat102.koe.TabellKoe;

public class TabellKoeTest extends KoeADTTest{

	@Override
	protected KoeADT<Integer> reset(){
		return new TabellKoe<Integer>();
	}
	
	@Test
	public void utvidTest() {
	TabellKoe utkoe = new TabellKoe(10);
	utkoe.utvid();
	assertEquals(20, utkoe.getLength());
	
	}

}

