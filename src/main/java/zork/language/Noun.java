package zork.language;

public abstract class Noun extends Token {

	@Override
	public int getNumberOfArgs() {
		return 0;
	}

	@Override
	public Token clone() {
		return this;
	}
}
