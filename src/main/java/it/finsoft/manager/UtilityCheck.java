package it.finsoft.manager;

public class UtilityCheck{

	/*
	 * Serve solamente a gestire eventuali errori di battitura semplici for ex:
	 * spazi iniziali o finali, spazi intermedi, lettere minuscole
	 * 
	 */
	public String trimToUp(String s) {
		s = s.trim().toUpperCase().replaceAll(" ", "").replaceAll(",", "");
		return s;
	}

	public String toUp(String s){
		s=s.trim().toUpperCase().replaceAll("  ", " ");
		return s;
	}
}
