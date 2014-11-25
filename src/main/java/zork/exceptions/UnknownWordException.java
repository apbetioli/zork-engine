package zork.exceptions;

public class UnknownWordException extends FreeMoveException {

	private static final long serialVersionUID = -9183485009708840447L;

	public UnknownWordException(String token) {
		super(String.format("I don't know the word \"%s\".", token));
	}

}
