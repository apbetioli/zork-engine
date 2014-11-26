package zork.language;

import static java.util.Arrays.asList;

import java.util.List;

public class Article extends Token {

	@Override
	public int getNumberOfArgs() {
		return 1;
	}

	@Override
	public List<String> getSynonyms() {
		return asList("THE", "A", "AN");
	}

	@Override
	public Token clone() {
		return this;
	}
}
