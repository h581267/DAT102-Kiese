package no.hvl.data102;

public class Tester {

	public static void main(String[] args) {
		
		Film f1 = new Film(1, "Disney", "Frost 2", 2019, "Disney", Sjanger.DRAMA);
		Film f2 = new Film(2, "Disney", "Star Wars", 2019, "Disney", Sjanger.ACTION);
		Film f3 = new Film(3, "Tromsø internasjonale filmer", "Salmene på kjøkkenet", 2002, "Tromsø internasjonale filmer", Sjanger.DRAMA);
		
		Filmarkiv f = new Filmarkiv();
		f.leggTilFilm(f1);
		f.leggTilFilm(f2);
		f.leggTilFilm(f3);
		f.slettFilm(2);
		
		f.skrivUt();
		
		
		
	}

}
