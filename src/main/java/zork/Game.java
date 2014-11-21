package zork;

import zork.commands.Close;
import zork.commands.Command;
import zork.commands.CommandFactory;
import zork.commands.Inventory;
import zork.commands.Look;
import zork.commands.Open;
import zork.commands.Read;
import zork.commands.Take;
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
		registerCommand(new Inventory(map));
		registerCommand(new Version(map));
		registerCommand(new Open());
		registerCommand(new Close());
		registerCommand(new Look(map));
		registerCommand(new Take(map));
		registerCommand(new Read());
	}

	protected void registerCommand(Command command) {
		commandFactory.register(command);
	}

	protected Interpreter createInterpreter() {
		return new Interpreter(dictionary);
	}

}
