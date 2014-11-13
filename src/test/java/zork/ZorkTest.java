package zork;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ZorkTest {

	private Zork zork;

	@Before
	public void init() {
		zork = new Zork();
		String start = zork.load("map.json");

		assertEquals(
				"Welcome to ZORK!\n\n"
						+ "West of House\n"
						+ "This is an open field west of a white house, with a boarded front door.\n"
						+ "There is a small mailbox here.\n"
						+ "A rubber mat saying 'Welcome to Zork!' lies by the door.",
				start);
	}

	@Test
	public void notAVerb() {
		String result = zork.interact("notaverb");
		assertEquals("That is not a verb I recognize.", result);
	}

	@Test
	public void look() {
		String result = zork.interact("look");
		assertEquals(
				"West of House\n"
						+ "This is an open field west of a white house, with a boarded front door.\n"
						+ "There is a small mailbox here.\n"
						+ "A rubber mat saying 'Welcome to Zork!' lies by the door.",
				result);
	}

	@Test
	public void hi() {
		String result = zork.interact("hi");
		assertEquals("Nice weather we've been having lately", result);
	}
	
	@Test
	public void hello() {
		String result = zork.interact("hello");
		assertEquals("Nice weather we've been having lately", result);
	}

}
