package appello5.sol;

public class RoomNotAvailableException extends Exception {

	public RoomNotAvailableException(String msg) {
		super(msg + " is not available");
	}
	
}
