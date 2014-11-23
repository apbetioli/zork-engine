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
import zork.dungeon.Game;
import zork.interpreter.Dictionary;
import zork.interpreter.Interpreter;

public class Engine {

	private final Game game;
	private Interpreter interpreter;
	private CommandFactory commandFactory;
	private Dictionary dictionary;

	public Engine(Game game) {
		this.game = game;

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
		return new Dictionary(commandFactory, game);
	}

	protected CommandFactory createCommandFactory() {
		return new CommandFactory();
	}

	protected void registerCommands() {
		registerCommand(new Inventory(this));
		registerCommand(new Version(this));
		registerCommand(new Open());
		registerCommand(new Close());
		registerCommand(new Look(this));
		registerCommand(new Take(this));
		registerCommand(new Read(this));
	}

	protected void registerCommand(Command command) {
		commandFactory.register(command);
	}

	protected Interpreter createInterpreter() {
		return new Interpreter(dictionary);
	}

	public Game getGame() {
		return game;
	}

}
