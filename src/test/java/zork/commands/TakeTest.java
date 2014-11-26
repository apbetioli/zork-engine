package zork.commands;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import zork.engine.EngineTest;

public class TakeTest extends EngineTest {

	@Before
	public void openMailbox() {
		engine.interact("open mailbox");
	}

	@Test
	public void take() {
		String result = engine.interact("take");

		assertEquals("What do you want to take?", result);
	}

	@Test
	public void takeLeaflet() {

		String result = engine.interact("take leaflet");

		assertEquals("Taken.", result);
	}

	@Test
	public void getLeaflet() {

		String result = engine.interact("get leaflet");

		assertEquals("Taken.", result);
	}

	@Test
	public void catchLeaflet() {

		String result = engine.interact("catch leaflet");

		assertEquals("Taken.", result);
	}

	@Test
	public void pickupLeaflet() {

		String result = engine.interact("pick up leaflet");

		assertEquals("Taken.", result);
	}

	@Test
	public void takeLeafletTwice() {

		engine.interact("take leaflet");
		String result = engine.interact("take leaflet");

		assertEquals("You already have that!", result);
	}

	@Test
	public void takeLeafletWithoutOpeningTheMailbox() {

		engine.interact("close mailbox");

		String result = engine.interact("take leaflet");

		assertEquals("You can't see any such thing.", result);
	}

	@Test
	public void inventoryWithLeaflet() {

		engine.interact("take leaflet");

		String result = engine.interact("inventory");

		assertEquals("You are carrying:\n" + "  A leaflet\n", result);
	}

	@Test
	public void takeMailbox() {

		String result = engine.interact("take mailbox");

		assertEquals("It is securely anchored.", result);
	}

	@Test
	public void takeDoor() {

		String result = engine.interact("take door");

		assertEquals("An interesting idea...", result); // FIXME RANDOMIZE
	}
}
