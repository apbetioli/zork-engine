package zork;

import zork.commands.Close;
import zork.commands.Command;
import zork.commands.CommandFactory;
import zork.commands.Drop;
import zork.commands.DropAll;
import zork.commands.Examine;
import zork.commands.Inventory;
import zork.commands.Look;
import zork.commands.Open;
import zork.commands.Read;
import zork.commands.ScoreCommand;
import zork.commands.Take;
import zork.commands.TakeAll;
import zork.commands.Version;
import zork.dungeon.Game;
import zork.dungeon.Score;
import zork.exceptions.FreeMoveException;
import zork.language.prepositions.The;

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

		Command command = null;

		try {
			command = interpreter.analize(input);

			String result = command.execute();

			interpreter.clearPendingCommand();

			incrementMove();

			return result;

		} catch (FreeMoveException e) {

			interpreter.setPendingCommand(command);

			return e.getMessage();
		}

	}

	private void incrementMove() {
		Score rank = game.getScore();
		rank.setMoves(rank.getMoves() + 1);
	}

	protected void init() {
		commandFactory = createCommandFactory();
		registerCommands();

		dictionary = createDictionary();

		registerPrepositions();

		interpreter = createInterpreter();
	}

	private void registerPrepositions() {
		dictionary.register(new The());
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
		registerCommand(new TakeAll(this));
		registerCommand(new Read(this));
		registerCommand(new ScoreCommand(this));
		registerCommand(new Drop(this));
		registerCommand(new DropAll(this));
		registerCommand(new Examine(this));
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
