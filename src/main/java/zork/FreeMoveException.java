package zork;

/**
 * When thrown it doesn't count as a valid move
 */
public class FreeMoveException extends Exception {

	private static final long serialVersionUID = -1121866210704731857L;

	public FreeMoveException(String msg) {
		super(msg);
	}

}
