package no.hvl.data102;

import no.hvl.data102.adt.*;

public class KlientFilmArkiv {

	public static void main(String[] args) {

		FilmArkivADT filma = new Filmarkiv();
		Meny meny = new Meny(filma);
		

		meny.start();
	}
}
