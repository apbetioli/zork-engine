package zork.exceptions;

public class UnknownCommandException extends FreeMoveException {

	private static final long serialVersionUID = -8292053516335794790L;

	public UnknownCommandException() {
		super("That is not a verb I recognize.");
	}

}
