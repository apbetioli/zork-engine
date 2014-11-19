package zork;

import zork.commands.CloseCommand;
import zork.commands.Command;
import zork.commands.CommandFactory;
import zork.commands.EmptyCommand;
import zork.commands.InventoryCommand;
import zork.commands.LookCommand;
import zork.commands.OpenCommand;
import zork.commands.VersionCommand;
import zork.dungeon.Map;
import zork.interpreter.Interpreter;

public class Game {

	private final Map map;
	private Interpreter interpreter;
	private CommandFactory commandFactory;

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

		interpreter = createInterpreter();
	}

	protected CommandFactory createCommandFactory() {
		return new CommandFactory();
	}

	protected void registerCommands() {
		commandFactory.register(new EmptyCommand());
		commandFactory.register(new InventoryCommand());
		commandFactory.register(new VersionCommand(map));
		commandFactory.register(new OpenCommand());
		commandFactory.register(new CloseCommand());
		commandFactory.register(new LookCommand(map));
	}

	protected Interpreter createInterpreter() {
		return new Interpreter(map, commandFactory);
	}

}
