package no.hvl.data102;

import java.util.*;

import no.hvl.data102.adt.FilmArkivADT;
import no.hvl.data102.*;

public class Tekstgrensesnitt {
	// lese opplysningene om en FILM fra tastatur
	
	private Scanner tastatur;
	
	public Tekstgrensesnitt(Scanner tastatur) {
		this.tastatur = tastatur;
	}
	
	public Film lesFilm() {
		int nummer;
		String produsent;
		String tittel;
		int lanseringsår;
		String selskap;
		Sjanger Sjanger = null;

		tastatur = new Scanner(System.in);
		System.out.print("Skriv inn nummer: ");
		nummer = Integer.parseInt(tastatur.nextLine());

		System.out.print("Skriv inn produsent: ");
		produsent = tastatur.nextLine();

		System.out.print("Skriv inn tittel: ");
		tittel = tastatur.nextLine();

		System.out.print("Skriv inn lanseringsår: ");
		lanseringsår = Integer.parseInt(tastatur.nextLine());

		System.out.print("Skriv inn selskap: ");
		selskap = tastatur.nextLine();

		System.out.print("Skriv inn sjanger: ");
		Sjanger = Sjanger.finnSjanger(tastatur.nextLine());

		Film film = new Film(nummer, produsent, tittel, lanseringsår, selskap, Sjanger);
		return film;

	}

	// vise en film med alle opplysninger på skjerm (husk tekst for sjanger)
	public void visFilm(Film film) {
		System.out.println(film.toString());
	}

	// Skrive ut alle Filmer med en spesiell delstreng i tittelen
	public void skrivUtFilmDelstrengITittel(FilmArkivADT filma, String delstreng) {
		Film.skrivUtTab(filma.sokTittel(delstreng));
	}

	// Skriver ut alle Filmer av en produsent / en gruppe
	public void skrivUtFilmProdusent(FilmArkivADT filma, String delstreng) {
		Film.skrivUtTab(filma.sokProdusent(delstreng));
	}

	// Skrive ut en enkel statistikk som inneholder antall Filmer totalt // og hvor
	// mange det er i hver sjanger
	public void skrivUtStatistikk(FilmArkivADT filma) {
		System.out.println("Antall filmer: " + filma.antall());
		
		Sjanger[] tab = Sjanger.values();
		
		for(Sjanger s : tab) {
			System.out.println("Antall filmer i " + s + ": " + filma.antallSjanger(s));
		}
		
	} // ... Ev. andre metoder
}// class
