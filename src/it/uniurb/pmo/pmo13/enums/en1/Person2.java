package it.uniurb.pmo.pmo13.enums.en1;

import java.util.*;

public class Person2 {

	public static final int LOMBARDIA = 0;
	public static final int EMILIA_ROMAGNA = 1;
	public static final int SICILIA = 2;
	public static final int SARDEGNA = 3;
	//...

	private final String nome ;
	private final String cognome ;
	private final int regione ;

	public Person2 (String nome , String cognome , int regione ) {
		this.nome = nome ;
		this.cognome = cognome ;
		this.regione = regione ;
	}

	private static String nomeRegione (int regione){
		switch ( regione ){
			case 0: return "Lombardia ";
			case 1: return "Emilia-Romagna ";
			case 2: return "Sicilia";
			case 3: return "Sardegna";
			//...
			default: return "no regione defined";
		}
	}
	public String toString() {
		return "[" + nome + "," + cognome + "," + regione + "]";
	}

	public boolean isIsolano() {
		// Confronto veloce !!
		return ( this.regione == SARDEGNA ||
				this.regione == SICILIA );
	}
	


	public static List<Person2> fromRegion( final Collection<Person2> coll, final int regione){ 
		final List<Person2> list = new ArrayList<>();
		for (final Person2 persona : coll) {
			if (persona.regione  == regione) { // Confronto veloce!
				list.add(persona);
			}
		}
		return list;
	}
}