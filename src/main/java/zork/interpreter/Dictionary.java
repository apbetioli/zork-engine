package zork.interpreter;

import java.util.HashSet;
import java.util.List;

import zork.commands.CommandFactory;
import zork.dungeon.Item;
import zork.dungeon.Map;
import zork.dungeon.Room;

public class Dictionary extends HashSet<String> {

	private static final long serialVersionUID = 4964927938848125605L;

	private CommandFactory commandFactory;
	private Map map;

	public Dictionary(CommandFactory commandFactory, Map map) {
		this.commandFactory = commandFactory;
		this.map = map;

		build();
	}

	private void build() {
		addCommands();
		addItems();
	}

	private void addCommands() {
		for (String command : commandFactory.keySet())
			add(command);
	}

	private void addItems() {
		for (Room room : map.getRooms())
			addItems(room.getItems());
	}

	private void addItems(List<Item> items) {
		for (Item item : items) {

			add(item.getName().trim().toUpperCase());

			for (String synonym : item.getSynonyms())
				add(synonym.trim().toUpperCase());

			addItems(item.getItems());
		}
	}
}