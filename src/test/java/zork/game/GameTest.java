package zork.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import zork.ZorkOne;

public class GameTest {

	@Test
	public void nullCurrentRoom() {
		Game game = new Game();
		assertNull(game.getCurrentRoom());
	}

	@Test
	public void currentRoom() {
		Game game = new ZorkOne();
		assertEquals("West of House", game.getCurrentRoom());
	}
}
