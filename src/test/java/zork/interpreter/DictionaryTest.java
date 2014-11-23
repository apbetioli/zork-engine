package zork.interpreter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import zork.commands.CommandFactory;
import zork.commands.Open;
import zork.dungeon.Item;
import zork.dungeon.Map;
import zork.dungeon.Room;

public class DictionaryTest {

	private CommandFactory commandFactory;

	@Before()
	public void init() {
		commandFactory = new CommandFactory();
	}

	@Test
	public void emptyDictionary() {
		Dictionary dictionary = new Dictionary(commandFactory, new Map());

		assertTrue(dictionary.isEmpty());
	}

	@Test
	public void dictionaryFromCommand() {
		Open open = new Open();
		commandFactory.register(open);

		Dictionary dictionary = new Dictionary(commandFactory, new Map());

		assertTrue(dictionary.containsKey("OPEN"));
		assertEquals(open, dictionary.get("OPEN"));
	}

	@Test
	public void dictionaryFromMap() {
		Item item = new Item("small mailbox", "");

		Room room = new Room("Main", "Main room");
		room.getItems().add(item);

		Map map = new Map();
		map.getRooms().add(room);

		Dictionary dictionary = new Dictionary(commandFactory, map);

		assertTrue(dictionary.containsKey("SMALL MAILBOX"));
		assertEquals(item, dictionary.get("SMALL MAILBOX"));
	}

}
