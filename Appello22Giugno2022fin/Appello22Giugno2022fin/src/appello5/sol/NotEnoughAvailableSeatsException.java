package appello5.sol;

public class NotEnoughAvailableSeatsException extends Exception {
	
	public NotEnoughAvailableSeatsException(String msg) {
		super(msg + "not large enough");
	}
}
