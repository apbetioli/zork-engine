package zork.commands;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import zork.commands.directions.EastTest;
import zork.commands.directions.SouthTest;
import zork.engine.EngineTest;

public class GoTest extends EngineTest {

	@Test
	public void go() {
		String result = engine.interact("go");

		assertEquals("Where do you want to go?", result);
	}

	@Test
	public void goSouth() {
		String result = engine.interact("go south");

		assertEquals(SouthTest.SOUTH_ROOM, result);
	}

	@Test
	public void goEast() {
		engine.interact("go south");
		String result = engine.interact("go east");

		assertEquals(EastTest.BEHIND_HOUSE, result);
	}

	@Test
	public void goUp() {
		String result = engine.interact("go up");

		assertEquals("You can't go that way.", result);
	}

	@Test
	public void goDoor() {
		String result = engine.interact("go door");

		assertEquals("Where do you want to go?", result);
	}
}
