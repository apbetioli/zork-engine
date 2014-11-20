package zork.commands;

import static java.util.Arrays.asList;

import java.util.List;

import zork.dungeon.Item;
import zork.dungeon.Map;
import zork.dungeon.Room;

public class Look extends Command {

	private Map map;

	public Look(Map map) {
		this.map = map;
	}

	@Override
	public List<String> getSynonyms() {
		return asList("LOOK", "L");
	}

	@Override
	public String execute() {
		Room room = map.getCurrentRoom();
		
		String look = room.getName() + "\n" + room.getDescription() + "\n";

		for (Item item : room.getItems())
			look += item.getDescription() + "\n";

		return look;
	}

}
