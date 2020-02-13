package no.hvl.data102;

import no.hvl.data102.adt.FilmArkivADT;
import no.hvl.data102.*;

public class Filmarkiv implements FilmArkivADT {

	private int antall;
	private LinearNode<Film> start;

	public Filmarkiv() {
		antall = 0;
		start = null;
	}

	public Film[] hentFilmTabell() {
		Film[] nyTab = new Film[antall];
		LinearNode<Film> temp = start;

		for (int i = 0; i < antall; i++) {
			nyTab[i] = temp.getElement();
			temp = temp.getNeste();
		}

		return nyTab;
	}

	public void leggTilFilm(Film nyFilm) {

		LinearNode<Film> node = new LinearNode(nyFilm);

		if (start == null) {
			start = node;
		} else {
			node.setNeste(start);
			start = node;
		}

		antall++;

	}

	public boolean slettFilm(int filmNr) {
		boolean slettet = false;
		LinearNode<Film> tempStart = start;

		if (start.getElement().getNummer() == filmNr) {
			start = start.getNeste();
			antall--;
			slettet = true;
		}

		while (!slettet && tempStart.getNeste() != null) {

			if (tempStart.getNeste().getElement().getNummer() == filmNr) {
				tempStart.setNeste(tempStart.getNeste().getNeste());
				antall--;
				slettet = true;
			}
			tempStart = tempStart.getNeste();
		}

		return slettet;
	}

	public Film[] sokTittel(String delstreng) {
		Film[] ny = new Film[antall];
		LinearNode<Film> temp = start;
		int indeks = 0;
		for (int i = 0; i < antall; i++) {
			if (temp.getElement().getTittel().contains(delstreng)) {
				ny[indeks] = temp.getElement();
				indeks++;
			}
			temp = temp.getNeste();
		}
		return ny;
	}

	public Film[] sokProdusent(String delstreng) {
		Film[] ny = new Film[antall];
		LinearNode<Film> temp = start;
		int indeks = 0;
		for (int i = 0; i < antall; i++) {
			if (temp.getElement().getProdusent().contains(delstreng)) {
				ny[indeks] = temp.getElement();
				indeks++;
			}
			temp = temp.getNeste();
		}
		return ny;
	}

	public int antallSjanger(Sjanger sjanger) {
		LinearNode<Film> temp = start;
		int AntF = 0;
		for (int i = 0; i < antall; i++) {
			if (temp.getElement().getSjanger() == sjanger) {
				AntF++;
			}
			temp = temp.getNeste();
		}
		return AntF;
	}

	public int antall() {
		return antall;
	}

	public void skrivUt() {
		LinearNode<Film> temp = start;
		for (int i = 0; i < antall; i++) {
			System.out.println(temp.getElement().toString());
			temp = temp.getNeste();
		}
	}

}
