package zork.commands;

import static java.util.Arrays.asList;

import java.util.List;

import zork.dungeon.Item;
import zork.dungeon.Map;

public class Inventory extends Command {

	private Map map;

	public Inventory(Map map) {
		this.map = map;
	}

	@Override
	public List<String> getSynonyms() {
		return asList("INVENTORY", "I");
	}

	@Override
	public String execute() {

		List<Item> items = map.getInventory();
		if (items.isEmpty())
			return "You are empty-handed.";

		String result = "You are carrying:\n";
		for (Item item : items)
			result += "  " + item.getDescription() + "\n";
		return result;
	}

}
