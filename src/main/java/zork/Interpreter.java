package zork;

import java.util.Iterator;
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
import zork.language.Token;

public class Interpreter {

	private Dictionary dictionary;
	private Command pendingCommand;

	public Interpreter(Dictionary dictionary) {
		this.dictionary = dictionary;
	}

	public Command analize(String input) {

		RunAutomatonMatcher matcher = newMatcher(input);
		List<Token> tokens = findAllTokens(matcher);

		Command command = pendingCommand;

		if (tokens.get(0) instanceof Command)
			command = ((Command) tokens.remove(0)).clone();

		command = (Command) buildTree(tokens.iterator(), command);

		System.out.println(command);

		return command;
	}

	private Token buildTree(Iterator<Token> iterator, Token node) {
		for (int i = 0; i < node.getDepth() && iterator.hasNext(); i++)
			node.addToken(buildTree(iterator, iterator.next()));
		return node;
	}

	protected List<Token> findAllTokens(RunAutomatonMatcher matcher) {
		List<Token> tokens = new LinkedList<Token>();

		Token found;
		while ((found = (Token) matcher.find()) != null) {
			verifyToken(matcher.token(), tokens);
			tokens.add(found);
		}

		verifyToken(matcher.token(), tokens);

		return tokens;
	}

	private void verifyToken(String word, List<Token> tokens) {
		if (!StringUtils.isEmpty(word)) {
			if (tokens.isEmpty())
				throw new UnknownCommandException();
			else
				throw new UnknownWordException(word.trim());
		}
	}

	protected RunAutomatonMatcher newMatcher(String input) {

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

	public void setPendingCommand(Command pendingCommand) {
		this.pendingCommand = pendingCommand;
	}

	public void clearPendingCommand() {
		setPendingCommand(null);
	}

}
