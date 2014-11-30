package zork.commands;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import zork.engine.EngineTest;

public class CloseTest extends EngineTest {

	@Test
	public void close() {
		String result = engine.interact("close");

		assertEquals("What do you want to close?", result);
	}

	@Test
	public void closeMailboxClosed() {
		String result = engine.interact("close mailbox");

		assertEquals("That's already closed.", result);
	}

	@Test
	public void closeMailbox() {
		engine.interact("open mailbox");

		String result = engine.interact("close mailbox");

		assertEquals("Closed.", result);
	}

	@Test
	public void openThenCloseMailboxTwiceThenOpen() {
		engine.interact("open mailbox");

		String result = engine.interact("close mailbox");
		assertEquals("Closed.", result);

		String result2 = engine.interact("close mailbox");
		assertEquals("That's already closed.", result2);

		String result3 = engine.interact("open mailbox");
		assertEquals("Opening the small mailbox reveals a leaflet.", result3);
	}

	@Test
	public void closeDoor() {
		String result = engine.interact("close door");

		assertEquals("That's already closed.", result);
	}

	@Test
	public void closeLeafletInvisible() {
		String result = engine.interact("close leaflet");

		assertEquals("You can't see any leaflet here!", result);
	}

	@Test
	public void closeLeaflet() {
		engine.interact("open box");

		String result = engine.interact("close leaflet");

		assertEquals("You must tell me how to do that to a leaflet.", result);
	}

	@Test
	public void ignorePendingCommand() {
		engine.interact("open");

		String result = engine.interact("close door");

		assertEquals("That's already closed.", result);
	}
}
