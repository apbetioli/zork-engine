package zork.commands;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import zork.engine.EngineTest;

public class GoTest extends EngineTest {

	@Test
	public void go() {
		String result = engine.interact("go");

		assertEquals("Where do you want to go?", result);
	}

	@Test
	public void goEast() {
		String result = engine.interact("go east");

		assertEquals("East", result);
	}

	@Test
	public void east() {
		String result = engine.interact("east");

		assertEquals("East", result);
	}

	@Test
	public void e() {
		String result = engine.interact("e");

		assertEquals("East", result);
	}

}
