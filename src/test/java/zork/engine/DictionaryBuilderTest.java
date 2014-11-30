package zork.engine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import zork.commands.Open;
import zork.game.Game;
import zork.game.Item;
import zork.game.Room;

public class DictionaryBuilderTest {

	private Game game;
	private Item item;
	private Room room;
	private Engine engine;

	@Before()
	public void init() {
		item = new Item("small mailbox", "");

		room = new Room("Main", "Main room");
		room.getItems().add(item);

		game = new Game();
		game.getRooms().add(room);

		engine = new Engine(game);
	}

	@Test
	public void emptyDictionary() {
		assertTrue(new Dictionary().isEmpty());
		assertTrue(new DictionaryBuilder().build().isEmpty());
	}

	@Test
	public void dictionaryFromCommand() {
		Open open = new Open(engine);

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
