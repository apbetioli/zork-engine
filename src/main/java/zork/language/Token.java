package zork.language;

import java.util.LinkedList;
import java.util.List;

public abstract class Token {

	private List<Token> args;

	public abstract int getNumberOfArgs();

	public void addArg(Token token) {
		getArgs().add(token);
	}

	public List<Token> getArgs() {
		if (args == null)
			args = new LinkedList<Token>();
		return args;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + (getArgs().isEmpty() ? "" : getArgs());
	}

	@Override
	public Token clone() {
		try {
			return (Token) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(e);
		}
	}
}