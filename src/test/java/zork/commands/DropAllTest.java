package zork.commands;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import zork.EngineTest;

public class DropAllTest extends EngineTest {

	@Test
	public void dropAll() {
		engine.interact("open mailbox");
		engine.interact("take leaflet");

		String result = engine.interact("drop all");

		assertEquals("leaflet: Dropped.\n", result);
	}

	@Test
	public void dropAllWithoutHavingNothing() {

		String result = engine.interact("drop all");

		assertEquals("You are empty-handed.", result);
	}

}
