package it.uniurb.pmo.pmo13.enums.en1;

import java.util.ArrayList;
import java.util.List;

public class UsePerson {
	public static void main(String[] args){
		final ArrayList<Person> list = new ArrayList<>();
		list.add(new Person("Mario","Rossi","Emilia-Romagna"));
		list.add(new Person("Gino","Bianchi","Sicilia"));
		list.add(new Person("Carlo","Verdi","EmiliaRomagna")); 
		// Errore sul nome non intercettabile
		final List<Person> out = Person.fromRegion(list,"Emilia-Romagna");
		System.out.println(list);
		// [[Mario,Rossi,Emilia-Romagna], [Gino,Bianchi,Sicilia], 
		//    [Carlo,Verdi,EmiliaRomagna]]
		System.out.println(out);
		// [[Mario,Rossi,Emilia-Romagna]]
		for (final Person p: list){
			if (p.isIsolano()){
				System.out.println(p);
			}
		}
		// [Gino,Bianchi,Sicilia]
	}
}
