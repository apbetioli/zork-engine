package zork.engine;

import java.util.List;

import zork.commands.Command;
import zork.game.Game;
import zork.game.Item;
import zork.game.Room;
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

	public DictionaryBuilder addCommands(List<Command> commands) {
		for (Command command : commands)
			addToken(command);

		return this;
	}

	public Dictionary build() {
		return dictionary;
	}

}
