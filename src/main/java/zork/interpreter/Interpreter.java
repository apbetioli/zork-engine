package zork.interpreter;

import java.util.Iterator;
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
import zork.dungeon.Item;

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

		Iterator<Object> iterator = tokens.iterator();

		if (!iterator.hasNext())
			return new Unknown();

		Object first = iterator.next();

		if (first instanceof Command) {
			lastCommand = (Command) first;
			if (iterator.hasNext())
				lastCommand.setItem((Item) iterator.next());

		} else {

			lastCommand.setItem((Item) first);
		}

		return lastCommand;
	}

	private List<Object> findAllTokens(RunAutomatonMatcher matcher) {
		List<Object> tokens = new LinkedList<Object>();

		Object found;
		while ((found = matcher.find()) != null)
			tokens.add(found);

		return tokens;
	}

	private RunAutomatonMatcher newMatcher(String sentence) {
		RunAutomaton automaton = buildAutomaton();
		return automaton.newMatcher(sentence + " ");
	}

	private RunAutomaton buildAutomaton() {
		StringUnionOperations builder = new StringUnionOperations();

		for (Entry<String, Object> entry : dictionary.entrySet())
			builder.add(entry.getValue(), entry.getKey() + " ");

		DefaultAutomaton a = new DefaultAutomaton();
		a.setInitialState(builder.complete());
		a.setDeterministic(true);
		a.reduce();
		a.recomputeHashCode();

		return new RunAutomaton(a);
	}

}
