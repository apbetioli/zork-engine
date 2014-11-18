package zork.interpreter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import zork.dungeon.Action;
import zork.dungeon.Item;
import zork.dungeon.Map;
import zork.dungeon.Room;

public class Interpreter {

	private Set<String> dictionary;

	public Interpreter(Map map) {
		dictionary = buildDictionary(map);
	}

	public Set<String> buildDictionary(Map map) {
		dictionary = new HashSet<String>();

		List<Action> mapActions = map.getActions();
		for (Action action : mapActions) {
			dictionary.addAll(Arrays.asList(action.getName().toUpperCase().split(" ")));
		}
		
		List<Room> rooms = map.getRooms();
		for (Room room : rooms) {
			List<Item> items = room.getItems();
			for (Item item : items) {
				dictionary.addAll(Arrays.asList(item.getName().toUpperCase().split(" ")));
				List<Action> actions = item.getActions();
				for (Action action : actions) {
					dictionary.addAll(Arrays.asList(action.getName().toUpperCase().split(" ")));
				}
			}
		}

		return dictionary;
	}

	public Parser parse(String input) {
		return new Parser(dictionary, input);
	}

	public Set<String> getDictionary() {
		return dictionary;
	}

}
