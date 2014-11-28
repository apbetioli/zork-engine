package zork.commands;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import zork.engine.EngineTest;

public class EnterTest extends EngineTest {

	@Test
	public void enterHouse() {

		String result = engine.interact("enter house");

		assertThat(result, is("I can't see how to get in from here."));
	}

	@Test
	public void enterDoor() {

		String result = engine.interact("enter door");

		assertThat(result, is("You can't go that way."));
	}

	@Test
	public void enterEast() {

		String result = engine.interact("enter door");

		assertThat(result, is("The door is locked, and there is evidently no key."));
	}

	@Test
	public void enterMailbox() {

		String result = engine.interact("enter mailbox");

		// assertThat(result, is("That's not something you can enter."));
		assertThat(result, is("You hit your head against the small mailbox as you attempt this feat."));
	}

}
