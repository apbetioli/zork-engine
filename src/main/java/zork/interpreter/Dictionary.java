package zork.interpreter;

import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

import zork.commands.Command;
import zork.commands.CommandFactory;
import zork.dungeon.Item;
import zork.dungeon.Game;
import zork.dungeon.Room;

public class Dictionary extends TreeMap<String, Object> {

	private static final long serialVersionUID = 4964927938848125605L;

	private CommandFactory commandFactory;
	private Game game;

	public Dictionary(CommandFactory commandFactory, Game game) {
		this.commandFactory = commandFactory;
		this.game = game;

		build();
	}

	private void build() {
		addCommands();
		addItems();
	}

	private void addCommands() {
		for (Entry<String, Command> entry : commandFactory.entrySet())
			put(entry.getKey(), entry.getValue());
	}

	private void addItems() {
		for (Room room : game.getRooms())
			addItems(room.getItems());
	}

	private void addItems(List<Item> items) {
		for (Item item : items) {

			put(item.getName(), item);

			for (String synonym : item.getSynonyms())
				put(synonym, item);

			addItems(item.getItems());
		}
	}

	@Override
	public Object put(String key, Object value) {
		return super.put(key.trim().toUpperCase(), value);
	}
}