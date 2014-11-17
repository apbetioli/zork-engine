package zork.interpreter;

import java.util.Set;
import java.util.StringTokenizer;

public class AnalisadorLexico {

	private StringTokenizer tokenizer;
	private Set<String> dictionary;
	private String nextToken;

	public AnalisadorLexico(Set<String> dictionary, String input) {
		this.dictionary = dictionary;
		tokenizer = new StringTokenizer(input);
	}

	public boolean hasMoreTokens() {

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
		return nextToken;
	}

}
