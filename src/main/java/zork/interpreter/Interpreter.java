package zork.interpreter;

import zork.commands.Command;
import zork.commands.CommandFactory;

public class Interpreter {

	private CommandFactory commandFactory;
	private Dictionary dictionary;

	public Interpreter(CommandFactory commandFactory, Dictionary dictionary) {
		this.commandFactory = commandFactory;
		this.dictionary = dictionary;
	}

	public Command analize(String input) {

		String action = input.trim();

		Parser parser = createParser(input);

		if (parser.hasMoreTokens())
			action = parser.nextToken();

		Command command = commandFactory.get(action);
		command.setParser(parser);

		return command;
	}

	protected Parser createParser(String input) {
		return new Parser(dictionary, input);
	}
}
