package it.uniurb.pmo.pmo13.enums.en1;

import java.util.*;

public class Person {
	private final String nome;
	private final String cognome;
	private final String regione;

	public Person(String nome, String cognome, String regione) {
		this.nome = nome;
		this.cognome = cognome;
		this.regione = regione;
	}

	public String toString() {
		return "[" + nome + "," + cognome + "," + regione + "]";
	}

	public boolean isIsolano() { // Confronto molto lento!!
		return (this.regione.equals("Sardegna") || 
				this.regione.equals("Sicilia"));
	}

	public static List<Person> fromRegion(
			final Collection<Person> coll, 
			final String regione
	) { // nota questa possibile formattazione 
		final List<Person> list = new ArrayList<>();
		for (final Person persona : coll) {
			if (persona.regione.equals(regione)) { // Confronto lento!!
				list.add(persona);
			}
		}
		return list;
	}
}
