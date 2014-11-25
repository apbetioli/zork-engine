package zork.commands;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import zork.EngineTest;

public class LookTest extends EngineTest {

	@Test
	public void look() {
		String result = engine.interact("look");
		assertEquals("West of House\n"
				+ "This is an open field west of a white house, with a boarded front door.\n"
				+ "There is a small mailbox here.\n", result);
	}

	@Test
	public void l() {
		String result = engine.interact("l");
		assertEquals("West of House\n"
				+ "This is an open field west of a white house, with a boarded front door.\n"
				+ "There is a small mailbox here.\n", result);
	}

	@Test
	public void openMailboxChangesLook() {
		engine.interact("open mailbox");

		String result = engine.interact("look");

		assertEquals("West of House\n"
				+ "This is an open field west of a white house, with a boarded front door.\n"
				+ "There is a small mailbox here.\n"
				+ "The small mailbox contains:\n"
				+ "  A leaflet\n", result);

	}

}
