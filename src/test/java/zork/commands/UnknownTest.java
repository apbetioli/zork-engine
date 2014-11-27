package zork.commands;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import zork.engine.EngineTest;

public class UnknownTest extends EngineTest {

	@Test
	public void unknownWord() {
		String result = engine.interact("debug dadada");

		assertEquals("I don't know the word \"DEBUG  DADADA\".", result);
	}

	@Test
	public void unknownCommand() {
		String result = engine.interact("door");

		assertEquals("That is not a verb I recognize.", result);
	}
}
