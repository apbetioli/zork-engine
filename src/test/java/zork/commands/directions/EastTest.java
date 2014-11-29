package zork.commands.directions;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import zork.engine.EngineTest;

public class EastTest extends EngineTest {

	public static final String BEHIND_HOUSE = "Behind House\nYou are behind the white house. A path leads into the forest to the east. In one corner of the house there is a small window which is slightly ajar.";

	@Test
	public void e() {
		String result = engine.interact("e");

		assertEquals("The door is locked, and there is evidently no key.", result);

		assertEquals("West of House", engine.getGame().getCurrentRoom());
	}

	@Test
	public void east() {
		engine.interact("S");
		String result = engine.interact("east");

		assertEquals(BEHIND_HOUSE, result);

		assertEquals("Behind House", engine.getGame().getCurrentRoom());

	}

}
