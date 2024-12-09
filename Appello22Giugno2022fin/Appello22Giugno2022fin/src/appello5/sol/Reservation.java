package appello5.sol;

import appello5.sol.CoursesCalendar.Day;

public class Reservation {

	private final Day day;
	private final String course;
	private final int slot;
	
	public Reservation(Day d, String c, int s) {
		this.day = d;
		this.course = c;
		this.slot = s;
	}

	public Day getDay() {
		return day;
	}

	public String getCourse() {
		return course;
	}

	public int getSlot() {
		return slot;
	}
	
	
}
