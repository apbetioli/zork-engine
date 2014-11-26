package zork.engine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import zork.commands.Open;
import zork.engine.Dictionary;
import zork.engine.DictionaryBuilder;
import zork.game.Game;
import zork.game.Item;
import zork.game.Room;

public class DictionaryBuilderTest {

	private Game game;
	private Item item;
	private Room room;

	@Before()
	public void init() {
		item = new Item("small mailbox", "");

		room = new Room("Main", "Main room");
		room.getItems().add(item);

		game = new Game();
		game.getRooms().add(room);
	}

	@Test
	public void emptyDictionary() {
		assertTrue(new Dictionary().isEmpty());
		assertTrue(new DictionaryBuilder().build().isEmpty());
	}

	@Test
	public void dictionaryFromCommand() {
		Open open = new Open();

		Dictionary dictionary = new DictionaryBuilder()
				.addCommand(open)
				.build();

		assertEquals(open, dictionary.get("OPEN"));
	}

	@Test
	public void builder() {

		Dictionary dictionary = new DictionaryBuilder()
				.addItems(game)
				.build();

		assertEquals(item, dictionary.get("SMALL MAILBOX"));

	}
}
