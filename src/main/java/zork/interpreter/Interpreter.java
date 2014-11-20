package zork.interpreter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.ListUtils;
import org.apache.commons.lang3.StringUtils;

import zork.commands.Command;
import zork.commands.CommandFactory;
import zork.dungeon.Item;
import zork.dungeon.Map;
import zork.dungeon.Room;

public class Interpreter {

	private Map map;
	private CommandFactory commandFactory;
	private Set<String> dictionary;

	public Interpreter(Map map, CommandFactory commandFactory) {
		this.map = map;
		this.commandFactory = commandFactory;

		dictionary = buildDictionary();
	}

	public Command analize(String input) {

		String action = input.trim();

		Parser parser = createParser(input);

		if (parser.hasMoreTokens())
			action = parser.nextToken();

		Command command = commandFactory.get(action);
		command.setParser(parser);

		return command;
	}

	protected Set<String> buildDictionary() {
		dictionary = new HashSet<String>();

		for (String command : commandFactory.keySet())
			dictionary.add(command);

		for (Room room : map.getRooms())
			addItemsToDictionary(room.getItems());

		return dictionary;
	}

	private void addItemsToDictionary(List<Item> items) {
		for (Item item : items) {

			dictionary.add(item.getName().trim().toUpperCase());

			for (String synonym : item.getSynonyms())
				dictionary.add(synonym.trim().toUpperCase());

			addItemsToDictionary(item.getItems());
		}
	}

	protected Parser createParser(String input) {
		return new Parser(dictionary, input);
	}

	protected Set<String> getDictionary() {
		return dictionary;
	}
}
