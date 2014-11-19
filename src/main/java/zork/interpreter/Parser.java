package zork.interpreter;

import java.util.Set;
import java.util.StringTokenizer;

public class Parser {

	private StringTokenizer tokenizer;
	private Set<String> dictionary;
	private String nextToken;

	public Parser(Set<String> dictionary, String input) {
		this.dictionary = dictionary;
		tokenizer = new StringTokenizer(input.trim().toUpperCase());
	}

	public boolean hasMoreTokens() {

		if (nextToken != null)
			return true;

		while (tokenizer.hasMoreTokens()) {
			nextToken = tokenizer.nextToken();
			if (dictionary.contains(nextToken))
				return true;
			else
				nextToken = null;
		}

		return false;
	}

	public String nextToken() {
		String token = nextToken;
		nextToken = null;
		return token;
	}
}
