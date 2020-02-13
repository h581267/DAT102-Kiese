package no.hvl.dat102.adt;

import static org.junit.Assert.*;
import org.junit.jupiter.api.*;
import org.junit.Test;

import org.junit.Before;

import no.hvl.dat102.exception.EmptyCollectionException;
import no.hvl.dat102.adt.KoeADT;

public abstract class KoeADTTest {


		private KoeADT<Integer> koe;
		
		private Integer e0 = 1;
		private Integer e1 = 2;
		private Integer e2 = 3;
		private Integer e3 = 4;
		private Integer e4 = 5;
		
		protected abstract KoeADT<Integer> reset(); 
		
		
		@Before
		public final void setup() {
			koe = reset();
		}
		

		/**
		 * Test på at en ny koe er tom.
		 */
		@Test
		public final void nyStabelErTom() {
			assertTrue(koe.erTom());
		}

		/**
		 * Test på leggTil and slett.
		 */
		@Test
		public final void leggTilOgSlett() {
			koe.leggTil(e0);
			koe.leggTil(e1);
			koe.leggTil(e2);
			koe.leggTil(e3);

			try {
				assertEquals(e0, koe.slett());
				assertEquals(e1, koe.slett());
				assertEquals(e2, koe.slett());
				assertEquals(e3, koe.slett());
			} catch (EmptyCollectionException e) {
				fail("slett feilet uventet " + e.getMessage());
			}
		}
		
		/**
		 * Test på at en koe med noen elementer ikke er tom.
		 */
		@Test
		public final void erIkkeTomFlereElement() {
			koe.leggTil(e0);
			koe.leggTil(e1);
			assertFalse(koe.erTom());
		}
		
		/**
		 * Test på at en koe med et elementer ikke er tom.
		 */
		@Test
		public final void erIkkeTomEtElement() {
			koe.leggTil(e0);
			assertFalse(koe.erTom());
		}

		/**
		 * Test på at en koe med en legg til og en slett gir null elementer og er tom.
		 */
		@Test
		public final void leggTilslettErTomEn() {
			try {
				koe.leggTil(e0);
				koe.slett();
				assertTrue(koe.erTom());

			} catch (EmptyCollectionException e) {
				fail("leggTil eller slett feilet uventet " + e.getMessage());
			}
		}
		
		/**
		 * Test på at en koe med flere leggtil og slett gir null elementer er tom.
		 */
		@Test
		public final void leggTilslettErTomFler() {
			try {
				koe.leggTil(e0);
				koe.leggTil(e1);
				koe.leggTil(e2);
				koe.slett();
				koe.slett();
				koe.slett();
				assertTrue(koe.erTom());

			} catch (EmptyCollectionException e) {
				fail("leggTil eller slett feilet uventet " + e.getMessage());
			}
		}

		/**
		 * Test på størrelsen
		 */
		@Test
		public final void storrelse() {
			koe.leggTil(e0);
			koe.leggTil(e1);
			koe.leggTil(e2);
			assertEquals(3, koe.antall());
		}
		
		@Test
		public final void førsteTest() {
			koe.leggTil(e0);
			koe.leggTil(e1);
			assertEquals(e0, koe.første());
		}
		
		@Test
		(expected = EmptyCollectionException.class)
		public final void slettFraTomerUnderflowed()
				throws EmptyCollectionException {
			koe.slett();
		}
	}

