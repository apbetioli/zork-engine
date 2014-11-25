package zork.commands;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import zork.EngineTest;

public class EmptyTest extends EngineTest {

	@Test
	public void pardon() {
		String result = engine.interact(" ");

		assertEquals("I beg your pardon?", result);
	}

}
