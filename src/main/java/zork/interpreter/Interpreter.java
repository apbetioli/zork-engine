package zork.interpreter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

		Parser parser = parse(input);

		if (parser.hasMoreTokens())
			action = parser.nextToken();

		return commandFactory.get(action);
	}

	protected Set<String> buildDictionary() {
		dictionary = new HashSet<String>();

		for (String command : commandFactory.keySet())
			dictionary.add(command);

		for (Room room : map.getRooms()) {
			List<Item> items = room.getItems();
			for (Item item : items) {
				dictionary.add(item.getName().toUpperCase());
			}
		}

		return dictionary;
	}

	protected Parser parse(String input) {
		return new Parser(dictionary, input);
	}

	protected Set<String> getDictionary() {
		return dictionary;
	}
}
