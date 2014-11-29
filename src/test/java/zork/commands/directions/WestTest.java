package zork.commands.directions;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import zork.engine.EngineTest;

public class WestTest extends EngineTest {

	private static final String FOREST = "Forest\nThis is a forest, with trees in all directions. To the east, there appears to be sunlight.";

	@Test
	public void w() {
		String result = engine.interact("w");

		assertEquals(FOREST, result);
	}

	@Test
	public void west() {
		String result = engine.interact("west");

		assertEquals(FOREST, result);

	}

}
