package zork;

import java.util.HashSet;
import java.util.Set;

import zork.commands.Close;
import zork.commands.Command;
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
import zork.language.Article;

public class Engine {

	private final Game game;
	private Interpreter interpreter;

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

	protected void incrementMove() {
		Score score = game.getScore();
		score.setMoves(score.getMoves() + 1);
	}

	protected void init() {
		DictionaryBuilder dictionaryBuilder = createDictionaryBuilder();
		interpreter = createInterpreter(dictionaryBuilder);
	}

	protected DictionaryBuilder createDictionaryBuilder() {
		return new DictionaryBuilder()
				.addItems(game)
				.addToken(new Article())
				.addCommands(defineCommands());
	}

	protected Set<Command> defineCommands() {
		Set<Command> commands = new HashSet<Command>();
		commands.add(new Inventory(this));
		commands.add(new Version(this));
		commands.add(new Open());
		commands.add(new Close());
		commands.add(new Look(this));
		commands.add(new Take(this));
		commands.add(new TakeAll(this));
		commands.add(new Read(this));
		commands.add(new ScoreCommand(this));
		commands.add(new Drop(this));
		commands.add(new DropAll(this));
		commands.add(new Examine(this));
		return commands;
	}

	protected Interpreter createInterpreter(DictionaryBuilder dictionaryBuilder) {
		return new Interpreter(dictionaryBuilder.build());
	}

	public Game getGame() {
		return game;
	}

}
