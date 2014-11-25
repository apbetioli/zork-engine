package zork.commands;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import zork.EngineTest;

public class ExamineTest extends EngineTest {

	@Test
	public void examineLeaflet() {
		String result = engine.interact("examine leaflet");

		assertEquals("You can't see any such thing.", result);
	}

	@Test
	public void examineDoor() {
		String result = engine.interact("examine door");

		assertEquals("The door is closed.", result);
	}

	@Test
	public void examineHouse() {
		String result = engine.interact("examine house");

		assertEquals(
				"The house is a beautiful colonial house which is painted white. It is clear that the owners must have been extremely wealthy.",
				result);
	}

	@Test
	public void examineGround() {
		String result = engine.interact("examine ground");

		assertEquals("There's nothing special about the ground.", result);
	}

	@Test
	public void examineMe() {
		String result = engine.interact("examine me");

		assertEquals("That's difficult unless your eyes are prehensile.", result);
	}

	@Test
	public void lookAtMe() {
		String result = engine.interact("look at me");

		assertEquals("That's difficult unless your eyes are prehensile.", result);
	}

	@Test
	public void examineSky() {
		String result = engine.interact("examine sky");

		assertEquals("I don't know the word \"SKY\".", result);
	}
}