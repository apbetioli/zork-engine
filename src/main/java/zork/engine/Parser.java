package zork.engine;

import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import net.pocorall.automaton.DefaultAutomaton;
import net.pocorall.automaton.RunAutomaton;
import net.pocorall.automaton.RunAutomatonMatcher;
import net.pocorall.automaton.StringUnionOperations;

import org.apache.commons.lang3.StringUtils;

import zork.exceptions.EmptyInputException;
import zork.exceptions.UnknownWordException;
import zork.language.Token;

public class Parser {

	private Dictionary dictionary;

	public Parser(Dictionary dictionary) {
		this.dictionary = dictionary;
	}

	public List<Token> tokenize(String input) {
		RunAutomatonMatcher matcher = newMatcher(input);
		return findAllTokens(matcher);
	}

	private List<Token> findAllTokens(RunAutomatonMatcher matcher) {
		List<Token> tokens = new LinkedList<Token>();

		Token found;
		while ((found = (Token) matcher.find()) != null) {
			verifyUnknownToken(matcher.token(), tokens);
			tokens.add(found);
		}

		verifyUnknownToken(matcher.token(), tokens);

		return tokens;
	}

	private void verifyUnknownToken(String token, List<Token> tokens) {
		if (!StringUtils.isEmpty(token))
			throw new UnknownWordException(token.trim());
	}

	private RunAutomatonMatcher newMatcher(String input) {

		String sentence = input.trim().toUpperCase();

		if (sentence.isEmpty())
			throw new EmptyInputException();

		RunAutomaton automaton = buildAutomaton();
		return automaton.newMatcher(wholeWord(sentence));
	}

	private RunAutomaton buildAutomaton() {
		StringUnionOperations builder = new StringUnionOperations();

		for (Entry<String, Token> entry : dictionary.entrySet())
			builder.add(entry.getValue(), wholeWord(entry.getKey()));

		DefaultAutomaton a = new DefaultAutomaton();
		a.setInitialState(builder.complete());
		a.setDeterministic(true);
		a.reduce();
		a.recomputeHashCode();

		return new RunAutomaton(a);
	}

	private String wholeWord(String sentence) {
		return " " + sentence.replaceAll(" ", "  ") + " ";
	}
}
