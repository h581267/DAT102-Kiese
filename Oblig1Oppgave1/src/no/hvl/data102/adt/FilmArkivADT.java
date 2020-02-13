package no.hvl.data102.adt;

import no.hvl.data102.*;

public interface FilmArkivADT {
	
		
		// Returnere en tabell av Filmer FILM[] hentFilmTabell();
	public Film[] hentFilmTabell();
	
		// Legger til en ny Film void leggTilFilm(FILMnyFilm);
	public void leggTilFilm(Film nyFilm);
	
		// Sletter en Filmhvis den fins boolean slettFilm(int filmNr);
	public boolean slettFilm(int filmNr);
	
		// Søker og henter Filmermed en gitt delstrengFilm[] sokTittel(String delstreng);
	public Film[] sokTittel(String delstreng);
	
		// Søker og henter produsenter med en gitt delstrengFilm[] sokProdusent(Stringdelstreng);
	public Film[] sokProdusent(String delstreng);
	
		
		// Henter antall Filmerfor en gitt sjangerint antallSjanger(Sjanger sjanger);}
	public int antallSjanger(Sjanger sjanger);	
	
		// Returnerer antall Filmerint antall();}
	public int antall();
	
		//interface 
	}

