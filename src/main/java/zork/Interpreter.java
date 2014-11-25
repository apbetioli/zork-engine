package zork;

import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import net.pocorall.automaton.DefaultAutomaton;
import net.pocorall.automaton.RunAutomaton;
import net.pocorall.automaton.RunAutomatonMatcher;
import net.pocorall.automaton.StringUnionOperations;

import org.apache.commons.lang3.StringUtils;

import zork.commands.Command;
import zork.exceptions.EmptyInputException;
import zork.exceptions.UnknownCommandException;
import zork.exceptions.UnknownWordException;

public class Interpreter {

	private Dictionary dictionary;
	private Command pendingCommand;

	public Interpreter(Dictionary dictionary) {
		this.dictionary = dictionary;
	}

	public Command analize(String input) {

		String sentence = input.trim().toUpperCase();

		if (sentence.isEmpty())
			throw new EmptyInputException();

		RunAutomatonMatcher matcher = newMatcher(sentence);
		List<Object> tokens = findAllTokens(matcher);

		Command command = pendingCommand;

		if (tokens.get(0) instanceof Command)
			command = (Command) tokens.remove(0);

		command.setTokens(tokens);

		return command;
	}

	protected List<Object> findAllTokens(RunAutomatonMatcher matcher) {
		List<Object> tokens = new LinkedList<Object>();

		Object found;
		while ((found = matcher.find()) != null) {

			verifyToken(matcher, tokens);

			tokens.add(found);
		}

		verifyToken(matcher, tokens);

		return tokens;
	}

	private void verifyToken(RunAutomatonMatcher matcher, List<Object> tokens) {
		String token = StringUtils.trimToEmpty(matcher.token());
		if (!token.isEmpty()) {
			if (tokens.isEmpty())
				throw new UnknownCommandException();
			else
				throw new UnknownWordException(token);
		}
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

	public void setPendingCommand(Command lastCommand) {
		this.pendingCommand = lastCommand;
	}

	public void clearPendingCommand() {
		setPendingCommand(null);
	}

}
