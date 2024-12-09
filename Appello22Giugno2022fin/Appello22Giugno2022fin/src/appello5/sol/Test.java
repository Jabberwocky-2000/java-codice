package appello5.sol;

import static org.junit.Assert.*;

import static appello5.sol.CoursesCalendar.Day.*;

import java.util.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

import appello5.sol.CoursesCalendar.Day;

public class Test {
	
	/*
	 * Implementare l'interfaccia CoursesCalendar data tramite una classe CoursesCalendarImpl con costruttore senza argomenti.
	 * Modella il gestore di un orario settimanale delle lezioni, con un metodo per fare una prenotazione, e metodi
	 * per estrarre informazioni.
	 * Il commento al codice di CoursesCalendar, e i metodi di test qui sotto costituiscono la necessaria spiegazione del 
	 * problema.
	 * I test il cui nome comincia con 'optional' sono considerati opzionali ai fini della possibilità di correggere
	 * l'esercizio -- anche se concorrono alla definizione del punteggio.
	 * Si tolga il commento ai test..
	 */

	Room r1 = new Room("Lab Von Neumann", 40);
	Room r2 = new Room("Turing", 80);
	Room r3 =new Room("Olivetti", 80);
	CoursesCalendar cc = new CoursesCalendarImpl();
	
	
	@org.junit.Test
	public void testInitialisation() {
		// inizializzazionee del calendario sulle tre aule pt 0.5
		
		cc.initialiseCalendar(r1);
		cc.initialiseCalendar(r2);
		cc.initialiseCalendar(r3);
		
		assertTrue(cc.dayRoomSlots(MONDAY, r1).isEmpty());
		assertTrue(cc.dayRoomSlots(TUESDAY, r1).isEmpty());
		assertTrue(cc.dayRoomSlots(WEDNESDAY, r2).isEmpty());
		assertTrue(cc.dayRoomSlots(THURSDAY, r2).isEmpty());
		assertTrue(cc.dayRoomSlots(FRIDAY, r3).isEmpty());
		
	}
	
	@org.junit.Test
	public void testBasicBooking() {  
		// prenotazione quasi standard per PMO and SISOP pt 1.5 
		try {
			cc.bookRoom(MONDAY, r3, 1, "PMO",45);
			cc.bookRoom(TUESDAY, r1, 1, "PMO",20);
			cc.bookRoom(TUESDAY, r1, 2, "PMO",20);
			cc.bookRoom(WEDNESDAY,r2, 1, "SISOP",45);
			cc.bookRoom(THURSDAY,r1, 1, "SISOP",20);
			cc.bookRoom(THURSDAY,r1, 2, "SISOP",20);
		} catch(Exception ex) {}
	
		// prenotazioni in Olivetti al lunedì
		Set<Pair<Integer,String>> set = cc.dayRoomSlots(MONDAY, r3);
		assertEquals(set.size(),1);
		assertTrue(set.contains(new Pair<>(1,"PMO")));
		
		// nessuna in Lab Von Neumann al lunedì
		assertEquals(cc.dayRoomSlots(MONDAY, r1).size(),0);

		// prenotazioni di SISOP: quali in Lab Von Neumann?
		Set<Pair<Day, Integer>> set2 = cc.courseSlots("SISOP").get(r1);
		assertEquals(set2.size(),2);
		
		// prenotazioni di PMO: quando e dove?
		Map<Room, Set<Pair<Day, Integer>>>  m = cc.courseSlots("PMO");
		assertEquals(m.keySet().size(),2);
		assertTrue(m.keySet().contains(r1));
		assertTrue(m.keySet().contains(r3));
		assertEquals(m.get(r3).size(),1);
		assertTrue(m.get(r3).contains(new Pair<>(MONDAY,1)));
		assertTrue(m.get(r1).contains(new Pair<>(TUESDAY,1)));
		assertTrue(m.get(r1).contains(new Pair<>(TUESDAY,2)));
		
	}

	@org.junit.Test
    public void testException() {
		
		try {
			cc.bookRoom(MONDAY, r3, 1, "PMO",45);
		} catch(Exception ex) {}
		
		// prenotazioni su aule troppo pocco capienti pt 0.5
		assertThrows(NotEnoughAvailableSeatsException.class, () -> cc.bookRoom(FRIDAY, r1, 1, "PMO",45));
		// prenotazioni su aule già prenotate pt 0.5
		assertThrows(RoomNotAvailableException.class, () -> cc.bookRoom(MONDAY, r3, 1, "PMO",45));
		
    }
	
	
	
}
