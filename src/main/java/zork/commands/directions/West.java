package zork.commands.directions;

import static java.util.Arrays.asList;

import java.util.List;

import zork.commands.Command;
import zork.engine.Engine;
import zork.game.Room;

public class West extends Command implements Direction {

	public West(Engine engine) {
		super(engine);
	}

	@Override
	public List<String> getSynonyms() {
		return asList("W", "WEST");
	}

	@Override
	public String execute() {
		Room currentRoom = engine.getCurrentRoom();
		String direction = currentRoom.getDirection("W");
		engine.setCurrentRoom(direction);

		return engine.interact("LOOK");
	}

}
