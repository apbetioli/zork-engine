package zork;

import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import net.pocorall.automaton.DefaultAutomaton;
import net.pocorall.automaton.RunAutomaton;
import net.pocorall.automaton.RunAutomatonMatcher;
import net.pocorall.automaton.StringUnionOperations;
import zork.commands.Command;
import zork.commands.Empty;
import zork.commands.Unknown;

public class Interpreter {

	private Dictionary dictionary;
	private Command lastCommand;

	public Interpreter(Dictionary dictionary) {
		this.dictionary = dictionary;
	}

	public Command analize(String input) {

		String sentence = input.trim().toUpperCase();

		if (sentence.isEmpty())
			return new Empty();

		RunAutomatonMatcher matcher = newMatcher(sentence);
		List<Object> tokens = findAllTokens(matcher);

		if (tokens.get(0) instanceof Command) {
			Command prototype = (Command) tokens.remove(0);
			lastCommand = prototype.clone();
		} else {
			if (lastCommand == null || lastCommand.isExecuted()) {
				return new Unknown();
			}
		}

		lastCommand.setTokens(tokens);

		return lastCommand;
	}

	protected List<Object> findAllTokens(RunAutomatonMatcher matcher) {
		List<Object> tokens = new LinkedList<Object>();

		Object found;
		while ((found = matcher.find()) != null) {
			String token = matcher.token().trim();
			if (!token.isEmpty())
				tokens.add(token);

			tokens.add(found);
		}
		String token = matcher.token().trim();
		if (!token.isEmpty())
			tokens.add(token);

		return tokens;
	}

	protected RunAutomatonMatcher newMatcher(String sentence) {
		RunAutomaton automaton = buildAutomaton();
		return automaton.newMatcher(wholeWord(sentence));
	}

	private RunAutomaton buildAutomaton() {
		StringUnionOperations builder = new StringUnionOperations();

		for (Entry<String, Object> entry : dictionary.entrySet())
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
