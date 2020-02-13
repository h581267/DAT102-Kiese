package no.hvl.data102;

import no.hvl.data102.adt.*;
import java.util.*;
import javax.swing.JOptionPane;
import no.hvl.data102.Fil;

public class Meny {

	private Tekstgrensesnitt tekstgr;
	private FilmArkivADT filma;
	private boolean stopp;
	private Scanner tastatur;

	public Meny(FilmArkivADT filma) {

		tekstgr = new Tekstgrensesnitt(tastatur);
		this.filma = filma;
		tastatur = new Scanner(System.in);

	}

	public void start() {
		
		stopp = false;
		
		System.out.println("Ønsker du å lage et nytt arkiv (1) eller fortsette på et eksisterende (2)?");
		int verdi = Integer.parseInt(tastatur.nextLine());
		
		if(verdi == 2) {
			
			System.out.print("Skriv inn filnavn: ");
			String filnavn = tastatur.nextLine();
			filma = Fil.lesFraFil(filnavn);
			
			while (!stopp) {
				action(tastatur);
			}
			
			Fil.skrivTilFil(filma, filnavn);
		}
		
		else {
			System.out.print("Skriv inn filnavn: ");
			String filnavn = tastatur.nextLine();
			while (!stopp) {
				action(tastatur);
			}
			Fil.skrivTilFil(filma, filnavn);
		}

	}

	public void action(Scanner tastatur) {

		
		
		System.out.println("1.Legg til\n2.Søk tittel\n3.Søk Produsent\n4.Skriv ut statistikk\n5.Legg til fil\n6.Avslutt og lagre");
		System.out.println("Skriv inn hva du ønsker å gjøre: ");
		int a = Integer.parseInt(tastatur.nextLine());
		

		switch (a) {
		case 1:
			filma.leggTilFilm(tekstgr.lesFilm());
			action(tastatur);
			break;
		case 2:
			System.out.println("Skriv inn søkeord til tittel: ");
			tekstgr.skrivUtFilmDelstrengITittel(filma, tastatur.nextLine());
			action(tastatur);
			break;
		case 3:
			System.out.println("Skriv inn søkeord til produsent: ");
			tekstgr.skrivUtFilmProdusent(filma, tastatur.nextLine());
			action(tastatur);
			break;
		case 4:
			tekstgr.skrivUtStatistikk(filma);
			action(tastatur);
			break;
		case 5:
			System.out.println("Skriv inn filnavn: ");
			Fil.skrivTilFil(filma, tastatur.nextLine());
			action(tastatur);
			break;
		case 6:
			stopp = true; tastatur.close();
			
			break;
		default:
			JOptionPane.showMessageDialog(null, "Uglydig verdi");
			action(tastatur);
			break;

		}

	}
	
}
