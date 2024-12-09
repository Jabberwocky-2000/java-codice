package appello5.sol;

import java.util.*;

/**
 * An interface modelling the weekly calendar of a University programme
 *
 */
public interface CoursesCalendar {
	
	
	/**
	 * Working days of the week
	 */
	enum Day { MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY }
	
	/**
	 * Initialise a calendar specifying the room available to be booked
	 * @param r: room
	 */
	 void initialiseCalendar(Room r);
	 
	/**
	 * Books a lesson
	 * @param d: day
	 * @param r: room
	 * @param slot: Morning (1) or Afternoon (2)
	 * @param course: course name
	 * @param stNumb: number of students who attend the course
	 * @throws NotEnoughAvailableSeatsException if the room has not enough seats compared to the number of students
	 * @throws RoomNotAvailableException if the room is already booked in that slot, in which case no change to booking is done
	 */
	void bookRoom(Day day, Room room, int slot, String course, int stNumb) 
			throws NotEnoughAvailableSeatsException, RoomNotAvailableException;
	
	/**
	 * Yields all booking in a given day and room
	 * @param d: day
	 * @param r: room
	 * @return a set of pairs of slot and course name
	 */
	Set<Pair<Integer,String>> dayRoomSlots(Day d, Room r);
	
	/**
	 * Yields all booking of a course
	 * @param course: the course to inspect
	 * @return a map from Room to set of pairs of day and slots
	 */
	Map<Room, Set<Pair<Day, Integer>>> courseSlots(String course);

}