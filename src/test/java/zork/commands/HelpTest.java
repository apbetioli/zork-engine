package zork.commands;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import zork.engine.EngineTest;

public class HelpTest extends EngineTest {

	@Test
	public void help() {
		String result = engine.interact("help");

		assertTrue(result, result.startsWith("Useful commands:"));
	}

	@Test
	public void about() {
		String result = engine.interact("about");

		assertTrue(result, result.startsWith("Useful commands:"));
	}

	@Test
	public void info() {
		String result = engine.interact("info");

		assertTrue(result, result.startsWith("Useful commands:"));
	}

	@Test
	public void hint() {
		String result = engine.interact("hint");

		assertTrue(result, result.startsWith("Useful commands:"));
	}

}
