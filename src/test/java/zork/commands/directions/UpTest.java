package zork.commands.directions;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import zork.engine.EngineTest;

public class UpTest extends EngineTest {

	@Test
	public void u() {
		String result = engine.interact("u");

		assertEquals("You can't go that way.", result);
	}

	@Test
	public void up() {
		String result = engine.interact("u");

		assertEquals("You can't go that way.", result);
	}

}
