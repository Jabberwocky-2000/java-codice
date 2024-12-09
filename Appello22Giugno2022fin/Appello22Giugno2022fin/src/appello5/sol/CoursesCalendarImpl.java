package appello5.sol;

import java.util.HashMap;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class CoursesCalendarImpl implements CoursesCalendar{


	
	private Map<Room, Set<Reservation>> reservations = new HashMap<>();

	public void initialiseCalendar(Room r) {
		if(!reservations.containsKey(r)){
			reservations.put(r, new HashSet<>());
		}
	}

	
	public void bookRoom(Day day, Room room, int slot, String course, int stNumb) 
			throws NotEnoughAvailableSeatsException, RoomNotAvailableException{
		
		if(room.getAvailableSeats() < stNumb) {
			throw new NotEnoughAvailableSeatsException("Room " + room);
		}
		if(!reservations.containsKey(room)) {
			initialiseCalendar(room);
		}
		Set<Reservation> r = reservations.get(room);
		for(Reservation res:r) {
			if (res.getDay() == day && res.getSlot() == slot) {
				throw new RoomNotAvailableException("Room " + room);
			}
		}
		r.add(new Reservation(day, course, slot));
		reservations.put(room, r);
	}

	
	public Set<Pair<Integer, String>> dayRoomSlots(Day day, Room room) {
		
		// SOLUZIONE senza stream
		/*Set<Pair<Integer, String>> s = new HashSet<>();
		Set<Reservation> r = reservations.get(room);
		for(Reservation res:r) {
			if (res.getDay() == day) {
				s.add(new Pair<>(res.getSlot(),res.getCourse()));
			}
		}*/
		
		// SOLUZIONE con stream
		return reservations.get(room)
			.stream()
			.filter(res -> res.getDay() == day)
			.map(el -> new Pair<>(el.getSlot(),el.getCourse()))
			.collect(Collectors.toSet());
		
	}

	
	
	@Override
	public Map<Room, Set<Pair<Day, Integer>>> courseSlots(String course) {
		
		Iterator<Entry<Room, Set<Reservation>>> it = reservations.entrySet().iterator();
		Map<Room, Set<Pair<Day, Integer>>> m = new HashMap<>();
	    while (it.hasNext()) {
	    	 Map.Entry<Room, Set<Reservation>> e = (Map.Entry)it.next();
	    	 Set<Reservation> r = (Set<Reservation>)e.getValue();
	    	 Set<Pair<Day, Integer>> s = new HashSet<>();
	    	 for(Reservation res : r) {
	    		 if(res.getCourse().equals(course)) {
	    			 s.add(new Pair<Day, Integer>(res.getDay(), res.getSlot()));
	    			 m.put((Room)e.getKey(), s);
	    		 }
	    	 }
	    }
	    return m;
	    
	}

}
