package zork.commands;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import zork.engine.EngineTest;

public class DropTest extends EngineTest {

	@Before
	public void openMailboxAndTakeLeaflet() {
		engine.interact("open mailbox");
		engine.interact("take leaflet");
	}

	@Test
	public void drop() {

		String result = engine.interact("drop leaflet");

		assertEquals("Dropped.", result);
	}

	@Test
	public void dropLeafletWithoutHavingIt() {

		engine.interact("drop leaflet");

		String result = engine.interact("drop leaflet");

		assertEquals("You don't have the leaflet!", result);
	}

	@Test
	public void leave() {

		String result = engine.interact("leave leaflet");

		assertEquals("Dropped.", result);
	}

	@Test
	public void dropThenLeaflet() {

		engine.interact("drop");

		String result = engine.interact("leaflet");

		assertEquals("Dropped.", result);
	}
}
