package zork;

import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.lang3.StringUtils;

import zork.objects.Item;
import zork.objects.Map;
import zork.objects.Room;

public class Zork implements Game {

	private Map map;

	private Room currentRoom;

	private Verb todo;

	public Zork(Map map) {
		this.map = map;

		currentRoom = map.getRooms().get(0);
	}

	public String interact(String input) {

		input = input.trim().toUpperCase();

		if (input.isEmpty())
			return "I beg your pardon?";

		String output = "That is not a verb I recognize.";

		StringTokenizer tokenizer = new StringTokenizer(input);
		String token = tokenizer.nextToken();

		if (todo != null) {
			try {
				List<Item> items = currentRoom.getItems();
				for (Item item : items) {
					if (item.getName().toUpperCase().contains(token))
						return item.execute(todo);
				}
			} finally {}
		}

		try {
			Verb verb = Verb.valueOf(token);
			output = verb.execute(this);
		} catch (IllegalArgumentException e) {}

		if (tokenizer.hasMoreTokens()) {
			String object = StringUtils.substringAfter(input, token);
			return interact(object);
		}

		return output;

	}

	public String welcome() {
		return map.welcome();
	}

	public String inventory() {
		return "You are empty handed.";
	}

	public String look() {
		return currentRoom.look();
	}

	public String open() {
		todo = Verb.OPEN;
		return "What do you want to open?";
	}
	
	public String close() {
		todo = Verb.CLOSE;
		return "What do you want to close?";
	}
}
