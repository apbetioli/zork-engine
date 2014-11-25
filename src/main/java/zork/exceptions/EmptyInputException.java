package zork.exceptions;

public class EmptyInputException extends FreeMoveException {

	private static final long serialVersionUID = 7283598601059051509L;

	public EmptyInputException() {
		super("I beg your pardon?");
	}

}
