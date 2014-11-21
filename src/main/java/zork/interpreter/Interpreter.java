package zork.interpreter;

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

		Object token = matcher.find();

		if (!(token instanceof Command)) {
			if (lastCommand == null)
				return new Unknown();

			token = lastCommand;
			matcher = newMatcher(sentence);
		}

		Command command = (Command) token;
		command.setItem((Item) matcher.find());

		lastCommand = command;

		return command;
	}

	private RunAutomatonMatcher newMatcher(String sentence) {
		RunAutomaton automaton = buildAutomaton();
		return automaton.newMatcher(sentence);
	}

	private RunAutomaton buildAutomaton() {
		StringUnionOperations builder = new StringUnionOperations();

		for (Entry<String, Object> entry : dictionary.entrySet())
			builder.add(entry.getValue(), entry.getKey());

		DefaultAutomaton a = new DefaultAutomaton();
		a.setInitialState(builder.complete());
		a.setDeterministic(true);
		a.reduce();
		a.recomputeHashCode();

		return new RunAutomaton(a);
	}

}
