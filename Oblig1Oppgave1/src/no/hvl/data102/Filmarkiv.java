package no.hvl.data102;

import no.hvl.data102.adt.FilmArkivADT;

public class Filmarkiv implements FilmArkivADT {

	private Film[] filmTabell;
	private int antall;
	
	public Filmarkiv() {
		this(10);
	}

	public Filmarkiv(int lengde) {
		filmTabell = new Film[lengde];
		antall = 0;
	}

	public Film[] hentFilmTabell() {
		return filmTabell;
	}

	public void leggTilFilm(Film nyFilm) {
		if(antall >= filmTabell.length) {
			utvidKapasitet();
		}
		filmTabell[antall] = nyFilm;
		antall++;
	}

	public boolean slettFilm(int filmNr) {

		boolean slettet = false;
		int pos = -1;

		for (int i = 0; i < antall; i++) {
			if (filmTabell[i].getNummer() == filmNr) {
				pos = i;
			}
		}
		if (pos != -1) {
			while (pos < antall) {
				filmTabell[pos] = filmTabell[pos + 1];
				pos++;
			}
			antall--;
		} else {
			System.out.println("Filmen finnes ikke i tabellen");
		}

		return slettet;
	}

	public Film[] sokTittel(String delstreng) {
		Film[] ny = new Film[antall];
		int indeks = 0;
		for (int i = 0; i < antall; i++) {
			if (filmTabell[i].getTittel().contains(delstreng)) {
				ny[indeks] = filmTabell[i];
				indeks++;
			}
		}
		return ny;

	}

	public Film[] sokProdusent(String delstreng) {
		Film[] ny = new Film[antall];
		int indeks = 0;
		for (int i = 0; i < antall; i++) {
			if (filmTabell[i].getProdusent().contains(delstreng)) {
				ny[indeks] = filmTabell[i];
				indeks++;
			}
		}
		return ny;
	}

	public int antallSjanger(Sjanger sjanger) {
		int AntF = 0;
		for(int i = 0; i < antall; i++) {
			if(filmTabell[i].getSjanger() == sjanger) {
				AntF++;
			}
		}
		return AntF;
	}

	public int antall() {
		return antall;
	}

	public void skrivUt() {
		for (int i = 0; i < antall; i++) {
			System.out.println(filmTabell[i].toString());
		}
	}
	
	public void utvidKapasitet() {
		Film[] hjelpetabell = new Film[(int) Math.ceil(1.1*filmTabell.length)];
		for(int i = 0; i < filmTabell.length; i++) {
			hjelpetabell[i] = filmTabell[i];
		}
		filmTabell = hjelpetabell;
	}

}
