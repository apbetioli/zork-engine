package zork.commands;

import static java.util.Arrays.asList;
import static zork.commands.Property.OPEN;

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

		String look = lookRoom(room);

		look += lookItems(room.getItems());

		return look;
	}

	private String lookRoom(Room room) {
		return room.getName() + "\n" + room.getDescription() + "\n";
	}

	private String lookItems(List<Item> items) {
		String look = "";
		for (Item item : items) {
			look += item.getDescription() + "\n";
			if (item.is(OPEN)) {
				look += "The " + item.getName() + " contains:\n";
				for (Item sub : item.getItems())
					look += "  " + sub.getDescription() + "\n";
			}
		}
		return look;
	}

}
