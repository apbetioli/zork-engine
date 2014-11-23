package zork.commands;

import static java.util.Arrays.asList;
import static zork.commands.Property.FIXED;
import static zork.commands.Property.OPEN;
import static zork.commands.Property.TAKEABLE;

import java.util.List;

import zork.Game;
import zork.dungeon.Item;
import zork.dungeon.Room;

public class Take extends Command {

	public Take(Game game) {
		super(game);
	}

	@Override
	public List<String> getSynonyms() {
		return asList("TAKE", "GET", "CATCH", "PICK UP");
	}

	@Override
	public String execute() {

		if (item.is(FIXED))
			return "It is securely anchored.";

		if (!item.is(TAKEABLE))
			return "An interesting idea...";

		if (!itemIsVisibleFrom(item, game.getMap().getCurrentRoom()))
			return "You can't see any such thing.";

		game.getMap().getInventory().add(item);

		return "Taken.";
	}

	private boolean itemIsVisibleFrom(Item item, Room currentRoom) {

		List<Item> items = currentRoom.getItems();

		return itemIsVisibleFrom(item, items);
	}

	private boolean itemIsVisibleFrom(Item item, List<Item> items) {
		for (Item other : items) {
			if (item.getName().equals(other.getName()))
				return true;

			if (other.is(OPEN) && itemIsVisibleFrom(item, other.getItems()))
				return true;
		}

		return false;
	}
}
