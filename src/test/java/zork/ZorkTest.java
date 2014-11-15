package zork;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ZorkTest {

	private Zork zork;

	@Before
	public void init() {
		zork = new Zork(new Zork1Map());
	}

	@Test
	public void notAVerb() {
		String result = zork.interact("notaverb");
		assertEquals("That is not a verb I recognize.", result);
	}

	@Test
	public void welcome() {
		String welcome = zork.interact("welcome");
		assertEquals("Welcome to ZORK!\n", welcome);
	}

	@Test
	public void look() {
		String result = zork.interact("look");
		assertEquals(
				"West of House\n"
						+ "This is an open field west of a white house, with a boarded front door.\n"
						+ "There is a small mailbox here.\n"
						+ "A rubber mat saying 'Welcome to Zork!' lies by the door.\n",
				result);
	}

}
