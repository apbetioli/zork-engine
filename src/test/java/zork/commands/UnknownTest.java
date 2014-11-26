package zork.commands;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import zork.engine.EngineTest;

public class UnknownTest extends EngineTest {

	@Test
	public void notAVerb() {
		String result = engine.interact("notaverb");

		assertEquals("That is not a verb I recognize.", result);
	}

	@Test
	public void unknown() {
		String result = engine.interact("debug door");

		assertEquals("That is not a verb I recognize.", result);
	}
}
