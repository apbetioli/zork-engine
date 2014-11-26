package zork.commands;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import zork.engine.EngineTest;

public class TakeAllTest extends EngineTest {

	@Test
	public void takeAll() {
		String result = engine.interact("take all");

		assertEquals("small mailbox: It is securely anchored.\n", result);
	}

}
