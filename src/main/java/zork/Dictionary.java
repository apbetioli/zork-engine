package zork;

import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

import zork.commands.Command;
import zork.commands.CommandFactory;
import zork.dungeon.Game;
import zork.dungeon.Item;
import zork.dungeon.Room;
import zork.language.Preposition;
import zork.language.Token;

public class Dictionary extends TreeMap<String, Token> {

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
		addItems(game.getGlobalItems());

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
	public Token put(String key, Token value) {
		return super.put(key.trim().toUpperCase(), value);
	}

	public void register(Preposition preposition) {
		for (String synonym : preposition.getSynonyms())
			put(synonym, preposition);
	}
}