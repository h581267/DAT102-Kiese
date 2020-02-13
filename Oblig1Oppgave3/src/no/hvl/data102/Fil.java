package no.hvl.data102;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import no.hvl.data102.*;
import no.hvl.data102.adt.*;

import no.hvl.data102.adt.FilmArkivADT;

/**
 * @author Ole Olsen
 * 
 */
/* Ref: Mughal: Java som f¯rste programmeringssprÂk
 * 
 * En tekstfil bestÂr av tekstlinjer. En tekstlinje bestÂr av en sekvens av 
 * tegn avsluttet med en linejavslutt-streng. Linjeavslutt-strengen er plattformavhengig.
 * 
 * Vi bruker en tegnstr¯m koblet til en bytest¯m. Bytes blir lest fra byte-innstr¯mmen
 * og oversatt til Unicode-tegn av tegn-str¯mmen. Motsatt, Unicode-tegn blir oversatt 
 * til bytes av tegn-utstr¯mmen og blir skrevet ut av bytest¯mmen.
 *  
 */
public class Fil {
/*  
 * OBS! I Menyen der f.eks. lesFrafil brukes, mÂ det vÊre try og catch-blokk.
 * 
 */
	private static final String SKILLE = "#";

	/**
	 * @param filnavn
	 * @return Referansen til Film-arkivet
	 * @throws java.io.IOException
	 */
	public static Filmarkiv lesFraFil(String filnavn)  {
		Filmarkiv filmarkiv = null;
			try {
			/*  1 - FileReader
			 *      Klassen FileReader s¯rger for at byte-innstr¯mmen blir opprettet,
			 *      s¯rger videre for at bytes fra filen blir tolket riktig som tegn 
			 *      i flg. tegnkodingsformatet for plattformen.
			*/    
			 FileReader ansFil = new FileReader(filnavn);
			 			 
            
			/*  2 - BufferedReader
			 *      Definerer et BufferReader-objekt som kobles til FileReader-objektet
			 *      Da nÂr vi metoden readLine() som leser en linje.		  
			 * 			 
			 */
			BufferedReader innfil = new BufferedReader(ansFil);

			// 3 - Leser den f¯rste posten som er antall info-poster
			       
			String linje = innfil.readLine();
			int n = Integer.parseInt(linje);
			filmarkiv = new Filmarkiv();

			// 4 - Les postene, en hel post om gangen
			for (int i = 0; i < n; i++) {
				String post = innfil.readLine();
				String[] felt = post.split(SKILLE);
				int nr = Integer.parseInt(felt[0]);
				String produsent = felt[1];
				String tittel = felt[2];
				int aar = Integer.parseInt(felt[3]);
				String sjStr = felt[4];
				Sjanger sj = Sjanger.finnSjanger(sjStr);
				String selskap = felt[5];

				Film film = new Film(nr, produsent, tittel, aar, selskap, sj);

				filmarkiv.leggTilFilm(film);
			}

			// 4 - Lukk filen
			innfil.close();

		} catch (FileNotFoundException unntak) {// arver fra IOE.. mÂ stÂ f¯rst
			                                    // hvis ikke vil unntaket for IOException skygge
			System.out.println("Finner ikke filen " + filnavn);
		
		} catch (IOException e) {
			System.out.println("Feil ved lesing av fil: " + e);
			
		}
      
	return filmarkiv;
       
	}// metode
	
		
	
	public static void skrivTilFil(FilmArkivADT filma, String filnavn)  {
		try {
			/* 1 - FileWriter
			 *     Definerer et FileWriter-objekt som Âpner filen.
			 *     Byte-str¯m blir opprettet for skriving av bytes til filen.
			 *     Tegn blir lagret i standard tegnkodingsformat for plattformen.
			 *     Hvis utvid er true, vil filen utvides ved  skriving pÂ slutten
			 *     av filen. Hvis utvid er false, vil skrivingen starte i begynnnelsen 
			 *     av filen.			 *     
			 *     Dersom filen ikke eksisterer, vil den bli opprettet. 
			 *     Dersom filen ikke kan Âpnes, vil metoden kaste et unntak av typen IOException.
			 * 
			 */
			FileWriter ansFil = new FileWriter(filnavn, false);

			/* 2 - PrintWriter
			 *     Definerer et PrintWriter-objekt som kobles til FileWriter-objektet.
			 *     PrintWriter-objektet leverer tegn til FileWriter-objektet.
			 *     FileWriter vil gi riktig koding av tegn i bytes  og lagring pÂ fil.
			 *      
			 * 
			 */
			PrintWriter utfil = new PrintWriter(ansFil);
			int antall = filma.antall();
			// 3 - Skriver foerst ut antall ansatt-info-er pÂ f¯rste linje
			utfil.println(antall);
			Film[] tabell = filma.hentFilmTabell();
			for (int i = 0; i < antall; i++) {
				// 3 - Skriver postene, felt for felt
				utfil.print(tabell[i].getNummer());
				utfil.print(SKILLE);
				utfil.print(tabell[i].getProdusent());
				utfil.print(SKILLE);
				utfil.print(tabell[i].getTittel());
				utfil.print(SKILLE);
				utfil.print(tabell[i].getLanseringsår());
				utfil.print(SKILLE);
				utfil.print(tabell[i].getSjanger());
				utfil.print(SKILLE);
				utfil.println(tabell[i].getSelskap());
			} // for
				// 4 - Lukk filen
			utfil.close();
		} // try
		catch (IOException e) {
			System.out.println("Feil pÂ skriving til fil : " + e);
		
		}

	}// metode

}// class
