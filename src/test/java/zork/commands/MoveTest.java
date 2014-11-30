package zork.commands;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import zork.engine.EngineTest;

public class MoveTest extends EngineTest {

	@Test
	public void moveMailbox() {
		String result = engine.interact("move mailbox");

		assertThat(result, is("You can't move the small mailbox."));
	}

	@Test
	public void moveRug() {
		engine.setCurrentRoom("Living Room");

		String result = engine.interact("move rug");

		assertThat(result, is("With a great effort, the rug is moved to one side of the room, revealing the dusty cover of a closed trap door."));
	}

	@Test
	public void moveLeaflet() {
		engine.interact("open mailbox");

		String result = engine.interact("move leaflet");

		assertThat(result, is("Moving the leaflet reveals nothing."));
	}

	@Test
	public void movePile() {
		engine.setCurrentRoom("Clearing");

		String look = engine.interact("LOOK");

		assertThat(look, is("Clearing\n"
				+ "You are in a clearing, with a forest surrounding you on all sides. A path leads south.\n"
				+ "On the ground is a pile of leaves."));

		String result = engine.interact("move pile");

		assertThat(result, is("Done.\nIn disturbing the pile of leaves, a grating is revealed."));

		look = engine.interact("LOOK");

		assertThat(look, is("Clearing\n"
				+ "You are in a clearing, with a forest surrounding you on all sides. A path leads south.\n"
				+ "There is a grating securely fastened into the ground.\n"
				+ "On the ground is a pile of leaves."));
	}
}
