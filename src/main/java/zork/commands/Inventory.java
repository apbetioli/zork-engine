package zork.commands;

import static java.util.Arrays.asList;

import java.util.List;

import zork.Game;
import zork.dungeon.Item;

public class Inventory extends Command {

	public Inventory(Game game) {
		super(game);
	}

	@Override
	public List<String> getSynonyms() {
		return asList("INVENTORY", "I");
	}

	@Override
	public String execute() {

		List<Item> items = game.getMap().getInventory();
		if (items.isEmpty())
			return "You are empty-handed.";

		String result = "You are carrying:\n";

		for (Item item : items)
			result += String.format("  A %s\n", item.getName());

		return result;
	}

}
