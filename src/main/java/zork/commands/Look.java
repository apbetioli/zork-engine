package zork.commands;

import static java.util.Arrays.asList;
import static zork.game.Property.OPEN;
import static zork.game.Property.SCENERY;

import java.util.List;

import zork.engine.Engine;
import zork.game.Item;
import zork.game.Room;

public class Look extends Command {

	public Look(Engine engine) {
		super(engine);
	}

	@Override
	public List<String> getSynonyms() {
		return asList("LOOK", "L");
	}

	@Override
	public String execute() {
		Room room = engine.getGame().getCurrentRoom();

		String look = lookRoom(room);

		look += lookItems(room.getItems());

		return look;
	}

	private String lookRoom(Room room) {
		return String.format("%s\n%s", room.getName(), room.getDescription());
	}

	private String lookItems(List<Item> items) {
		String look = "";

		for (Item item : items) {

			if (item.is(SCENERY))
				continue;

			if (item.is(OPEN)) {
				look += String.format("\nThe %s contains:", item.getName());

				for (Item sub : item.getItems())
					look += String.format("\n  A %s", sub.getName());
			}

		}

		return look;
	}

}
