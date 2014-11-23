package zork.commands;

import static java.util.Arrays.asList;
import static zork.commands.Property.OPEN;
import static zork.commands.Property.SCENERY;

import java.util.List;

import zork.Game;
import zork.dungeon.Item;
import zork.dungeon.Room;

public class Look extends Command {

	public Look(Game game) {
		super(game);
	}

	@Override
	public List<String> getSynonyms() {
		return asList("LOOK", "L");
	}

	@Override
	public String execute() {
		Room room = game.getMap().getCurrentRoom();

		String look = lookRoom(room);

		look += lookItems(room.getItems());

		return look;
	}

	private String lookRoom(Room room) {
		return String.format("%s\n%s\n", room.getName(), room.getDescription());
	}

	private String lookItems(List<Item> items) {
		String look = "";

		for (Item item : items) {

			if (item.is(SCENERY))
				continue;

			if (item.is(OPEN)) {
				look += String.format("The %s contains:\n", item.getName());

				for (Item sub : item.getItems())
					look += String.format("  A %s\n", sub.getName());
			}

		}
		return look;
	}

}
