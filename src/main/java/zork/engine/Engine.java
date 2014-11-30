package zork.engine;

import java.util.LinkedList;
import java.util.List;

import zork.commands.Close;
import zork.commands.Command;
import zork.commands.Drop;
import zork.commands.DropAll;
import zork.commands.Enter;
import zork.commands.Examine;
import zork.commands.Go;
import zork.commands.Help;
import zork.commands.Inventory;
import zork.commands.Look;
import zork.commands.Move;
import zork.commands.Open;
import zork.commands.Read;
import zork.commands.Score;
import zork.commands.Take;
import zork.commands.TakeAll;
import zork.commands.Version;
import zork.commands.directions.East;
import zork.commands.directions.South;
import zork.commands.directions.Up;
import zork.commands.directions.West;
import zork.exceptions.FreeMoveException;
import zork.exceptions.InexistentRoomException;
import zork.game.Game;
import zork.game.Room;
import zork.game.Stats;
import zork.language.Article;
import zork.util.UpperCaseKeyTreeMap;

public class Engine {

	private final Game game;
	private UpperCaseKeyTreeMap<Room> roomMap;

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

		} catch (InexistentRoomException e) {

			return e.getMessage();
		}

	}

	protected void incrementMove() {
		Stats stats = game.getStats();
		stats.setMoves(stats.getMoves() + 1);
	}

	private UpperCaseKeyTreeMap<Room> createRoomMap(Game game) {
		UpperCaseKeyTreeMap<Room> roomMap = new UpperCaseKeyTreeMap<Room>();

		for (Room room : game.getRooms())
			roomMap.put(room.getName(), room);

		return roomMap;
	}

	protected void init() {
		roomMap = createRoomMap(game);
		DictionaryBuilder dictionaryBuilder = createDictionaryBuilder();
		interpreter = createInterpreter(dictionaryBuilder);
	}

	protected DictionaryBuilder createDictionaryBuilder() {
		return new DictionaryBuilder()
				.addItems(game)
				.addToken(new Article())
				.addCommands(defineCommands());
	}

	protected List<Command> defineCommands() {
		List<Command> commands = new LinkedList<Command>();
		commands.add(new Inventory(this));
		commands.add(new Version(this));
		commands.add(new Open(this));
		commands.add(new Close(this));
		commands.add(new Look(this));
		commands.add(new Take(this));
		commands.add(new TakeAll(this));
		commands.add(new Read(this));
		commands.add(new Score(this));
		commands.add(new Drop(this));
		commands.add(new DropAll(this));
		commands.add(new Examine(this));
		commands.add(new Help(this));
		commands.add(new Go(this));
		commands.add(new East(this));
		commands.add(new South(this));
		commands.add(new Up(this));
		commands.add(new Enter(this));
		commands.add(new West(this));
		commands.add(new Move(this));
		return commands;
	}

	protected Interpreter createInterpreter(DictionaryBuilder dictionaryBuilder) {
		return new Interpreter(dictionaryBuilder.build());
	}

	public Game getGame() {
		return game;
	}

	public UpperCaseKeyTreeMap<Room> getRoomMap() {
		return roomMap;
	}

	public Room getCurrentRoom() {
		return getRoomMap().get(game.getCurrentRoom());
	}

	public void setCurrentRoom(String currentRoom) {

		if (currentRoom == null)
			throw new InexistentRoomException("You can't go that way.");

		if (!getRoomMap().containsKey(currentRoom))
			throw new InexistentRoomException(currentRoom);

		game.setCurrentRoom(currentRoom);
	}

}
