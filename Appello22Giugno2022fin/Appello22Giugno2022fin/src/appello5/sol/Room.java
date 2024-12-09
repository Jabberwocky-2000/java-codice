package appello5.sol;

public class Room {
	
	private final String roomName;
	private final int capacity;
	protected int availableSeats;
	
	public Room(String n, int c) {
		this.roomName = n;
		this.capacity = c;
		this.availableSeats = this.capacity;
	}
	
	public String getName() {
		return roomName;
	}
	
	public int getAvailableSeats() {
		return availableSeats;
	}

}
