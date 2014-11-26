package zork;

import java.util.List;
import java.util.Set;

import zork.commands.Command;
import zork.dungeon.Game;
import zork.dungeon.Item;
import zork.dungeon.Room;
import zork.language.Token;

public class DictionaryBuilder {

	private Dictionary dictionary;

	public DictionaryBuilder() {
		dictionary = new Dictionary();
	}

	public DictionaryBuilder addItems(Game game) {
		addItems(game.getGlobalItems());

		for (Room room : game.getRooms())
			addItems(room.getItems());

		return this;
	}

	public DictionaryBuilder addItems(List<Item> items) {
		for (Item item : items) {

			dictionary.put(item.getName(), item);

			addItem(item);

			addItems(item.getItems());
		}

		return this;
	}

	public DictionaryBuilder addItem(Item item) {
		return addToken(item);
	}

	public DictionaryBuilder addToken(Token token) {
		for (String synonym : token.getSynonyms())
			dictionary.put(synonym, token);

		return this;
	}

	public DictionaryBuilder addCommand(Command command) {
		return addToken(command);
	}

	public DictionaryBuilder addCommands(Set<Command> commands) {
		for (Command command : commands)
			addToken(command);

		return this;
	}

	public Dictionary build() {
		return dictionary;
	}

}
