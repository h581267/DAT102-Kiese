package no.hvl.dat102.kjedet;

import static org.junit.Assert.*;
import org.junit.jupiter.api.*;

import org.junit.Before;
import org.junit.Test;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.adt.KoeADTTest;
import no.hvl.dat102.exception.EmptyCollectionException;
import no.hvl.dat102.koe.KjedetKoe;

public class KjedetKoeTest extends KoeADTTest {

	@Override
	protected KoeADT<Integer> reset(){
		return new KjedetKoe<Integer>();
	}
	
	/**
	 * Forsøk på slett av en tom kø skal gi "underflow excepton" *
	 * 
	 * @throws EmptyCollectionException
	 *             expected exception
	 */

}
