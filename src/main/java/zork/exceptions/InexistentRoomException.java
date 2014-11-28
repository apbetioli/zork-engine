package zork.exceptions;

public class InexistentRoomException extends RuntimeException {

	private static final long serialVersionUID = 2694620538212739090L;

	public InexistentRoomException(String message) {
		super(message);
	}

}
