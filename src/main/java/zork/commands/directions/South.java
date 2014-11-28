package zork.commands.directions;

import static java.util.Arrays.asList;

import java.util.List;

import zork.commands.Command;
import zork.engine.Engine;
import zork.game.Room;

public class South extends Command implements DirectionCommand {

	public South(Engine engine) {
		super(engine);
	}

	@Override
	public List<String> getSynonyms() {
		return asList("SOUTH", "S");
	}

	@Override
	public String execute() {

		Room currentRoom = engine.getGame().getCurrentRoom();
		String direction = currentRoom.getDirection("S");
		engine.getGame().setCurrentRoom(direction);

		return engine.interact("LOOK");
	}
}
