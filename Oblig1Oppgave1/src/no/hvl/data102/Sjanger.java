package no.hvl.data102;

public enum Sjanger {

	ACTION, DRAMA, HISTORY, SciFi;

	public static Sjanger finnSjanger(String navn) {
		Sjanger sjang = null;

		for (Sjanger s : Sjanger.values()) {
			if (s.toString().equals(navn.toUpperCase())) {
				sjang = s;
				break; 				// Slutter for-løkken dersom vi finner en match mellom navn og en sjanger
			}
		}
		return sjang;
	}

}