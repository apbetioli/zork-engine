package zork.commands.directions;

import static java.util.Arrays.asList;

import java.util.List;

import zork.commands.Command;
import zork.engine.Engine;
import zork.game.Room;

public class East extends Command implements DirectionCommand {

	public East(Engine engine) {
		super(engine);
	}

	@Override
	public List<String> getSynonyms() {
		return asList("E", "EAST");
	}

	@Override
	public String execute() {
		Room currentRoom = engine.getGame().getCurrentRoom();
		String direction = currentRoom.getDirection("E");
		engine.getGame().setCurrentRoom(direction);

		return engine.interact("LOOK");
	}

}