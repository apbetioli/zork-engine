package zork.language;


public abstract class Verb extends Token {

	@Override
	public int getNumberOfArgs() {
		return 1;
	}

}
