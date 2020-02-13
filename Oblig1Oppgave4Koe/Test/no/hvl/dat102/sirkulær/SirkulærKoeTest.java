package no.hvl.dat102.sirkulær;

import static org.junit.Assert.*;
import org.junit.jupiter.api.*;

import org.junit.Before;
import org.junit.Test;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.adt.KoeADTTest;
import no.hvl.dat102.koe.SirkulaerKoe;

public class SirkulærKoeTest extends KoeADTTest {

	@Override
	protected KoeADT<Integer> reset(){
		return new SirkulaerKoe<Integer>();
	}
	
	@Test
	public void utvidTest() {
	SirkulaerKoe utkoe = new SirkulaerKoe(10);
	utkoe.utvid();
	assertEquals(20, utkoe.getLength());
	
	}

}
