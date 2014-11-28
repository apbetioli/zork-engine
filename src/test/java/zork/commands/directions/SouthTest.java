package zork.commands.directions;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import zork.engine.EngineTest;

public class SouthTest extends EngineTest {

	public static final String SOUTH_ROOM = "South of House\nYou are facing the south side of a white house. There is no door here, and all the windows are boarded.";

	@Test
	public void south() {
		String result = engine.interact("south");

		assertEquals(SOUTH_ROOM, result);
	}

	@Test
	public void s() {
		String result = engine.interact("s");

		assertEquals(SOUTH_ROOM, result);
	}

}
