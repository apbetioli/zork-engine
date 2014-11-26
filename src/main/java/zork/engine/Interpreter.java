package zork.engine;

import java.util.List;

import zork.commands.Command;
import zork.exceptions.UnknownCommandException;
import zork.language.Token;

public class Interpreter {

	private Parser parser;
	private Command pendingCommand;

	public Interpreter(Dictionary dictionary) {
		this.parser = new Parser(dictionary);
	}

	public Command analize(String input) {

		List<Token> tokens = parser.tokenize(input);

		appendPendingCommand(tokens);

		Token command = buildTree(tokens);

		if (!(command instanceof Command))
			throw new UnknownCommandException();

		System.out.println(command);

		return (Command) command;
	}

	private void appendPendingCommand(List<Token> tokens) {
		if (pendingCommand != null && !(tokens.get(0) instanceof Command))
			tokens.add(0, pendingCommand);
	}

	private Token buildTree(List<Token> tokens) {
		Token node = (Token) tokens.remove(0).clone();
		for (int i = 0; i < node.getNumberOfArgs() && !tokens.isEmpty(); i++)
			node.addArg(buildTree(tokens));
		return node;
	}

	public void setPendingCommand(Command pendingCommand) {
		this.pendingCommand = pendingCommand;
	}

	public void clearPendingCommand() {
		setPendingCommand(null);
	}

}
