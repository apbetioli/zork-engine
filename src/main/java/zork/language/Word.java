package zork.language;

import java.util.LinkedList;
import java.util.List;

public class Word implements Token {

	private int depth;
	private List<Token> tokens;

	@Override
	public void addToken(Token token) {
		getTokens().add(token);
	}

	@Override
	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public List<Token> getTokens() {
		if (tokens == null)
			tokens = new LinkedList<Token>();
		return tokens;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + (getTokens().isEmpty() ? "" : getTokens());
	}
}