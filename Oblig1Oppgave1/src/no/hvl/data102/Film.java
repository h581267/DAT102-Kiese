package no.hvl.data102;

public class Film {
	
	private int nummer;
	private String produsent;
	private String tittel;
	private int lanseringsår;
	private String selskap;
	private Enum sjanger;
	
	
	public Film() {
		this(0, "", "", 0, "", null);
	}
	
	
	public Film(int nummer, String produsent, String tittel, int lanseringsår, String selskap, Enum Sjanger) {
		this.nummer = nummer;
		this.produsent = produsent;
		this.tittel = tittel;
		this.lanseringsår = lanseringsår;
		this.selskap = selskap;
		this.sjanger = Sjanger;
	}
	
	public int getNummer() {
		return nummer;
	}
	
	public String getProdusent() {
		return produsent;
	}
	
	public String getTittel() {
		return tittel;
	}
	
	public int getLanseringsår() {
		return lanseringsår;
	}

	public String getSelskap() {
		return selskap;
	}
	
	public Enum getSjanger() {
		return sjanger;
	}

	public void setSelskap(String selskap) {
		this.selskap = selskap;
	}


	public void setSjanger(Enum sjanger) {
		this.sjanger = sjanger;
	}


	public void setNummer(int nummer) {
		this.nummer = nummer;
	}


	public void setProdusent(String produsent) {
		this.produsent = produsent;
	}


	public void setTittel(String tittel) {
		this.tittel = tittel;
	}


	public void setLanseringsår(int lanseringsår) {
		this.lanseringsår = lanseringsår;
	}
	
	public String toString() {
		return "Film: " + nummer + ", " + tittel + "\nProdusent: " + produsent + ", lanseringsår: " + lanseringsår + "\nFirma: " + selskap + ", Sjanger: " + sjanger + "\n";
	}
	
	public static void skrivUtTab(Film[] f) {
		for(int i = 0; i < f.length; i++) {
			if(f[i] != null) {
				System.out.println(f[i].toString());
			}
		}
	}
	

}
