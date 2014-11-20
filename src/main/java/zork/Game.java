package zork;

import zork.commands.Close;
import zork.commands.Command;
import zork.commands.CommandFactory;
import zork.commands.Empty;
import zork.commands.Inventory;
import zork.commands.Look;
import zork.commands.Open;
import zork.commands.Version;
import zork.dungeon.Map;
import zork.interpreter.Dictionary;
import zork.interpreter.Interpreter;

public class Game {

	private final Map map;
	private Interpreter interpreter;
	private CommandFactory commandFactory;
	private Dictionary dictionary;

	public Game(Map map) {
		this.map = map;

		init();
	}

	public String interact(String input) {

		Command command = interpreter.analize(input);

		return command.execute();

	}

	protected void init() {
		commandFactory = createCommandFactory();
		registerCommands();

		dictionary = createDictionary();

		interpreter = createInterpreter();
	}

	private Dictionary createDictionary() {
		return new Dictionary(commandFactory, map);
	}

	protected CommandFactory createCommandFactory() {
		return new CommandFactory();
	}

	protected void registerCommands() {
		commandFactory.register(new Empty());
		commandFactory.register(new Inventory());
		commandFactory.register(new Version(map));
		commandFactory.register(new Open(map));
		commandFactory.register(new Close());
		commandFactory.register(new Look(map));
	}

	protected Interpreter createInterpreter() {
		return new Interpreter(commandFactory, dictionary);
	}

}
