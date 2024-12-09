package it.uniurb.pmo.pmo13.enums.en1;

import java.util.ArrayList;
import java.util.List;

public class UsePerson2 {
	public static void main(String[] args){
		final ArrayList<Person2> list = new ArrayList<>();
		list.add(new Person2("Mario","Rossi",Person2.EMILIA_ROMAGNA));
		list.add(new Person2("Gino","Bianchi",3));
		list.add(new Person2("Carlo","Verdi",Person2.EMILIA_ROMAGNA)); 
		// Errore sul nome non intercettabile
		final List<Person2> out = Person2.fromRegion(list,Person2.EMILIA_ROMAGNA);
		System.out.println(list);
		// [[Mario,Rossi,Emilia-Romagna], [Gino,Bianchi,Sicilia], 
		//    [Carlo,Verdi,EmiliaRomagna]]
		System.out.println(out);
		// [[Mario,Rossi,Emilia-Romagna]]
		for (final Person2 p: list){
			if (p.isIsolano()){
				System.out.println(p);
			}
		}
		// [Gino,Bianchi,Sicilia]
	}
}
