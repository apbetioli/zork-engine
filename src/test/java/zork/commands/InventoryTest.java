package zork.commands;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import zork.EngineTest;

public class InventoryTest extends EngineTest {

	@Test
	public void i() {
		String result = engine.interact("i");

		assertEquals("You are empty-handed.", result);
	}

	@Test
	public void inventory() {
		String result = engine.interact("inventory");

		assertEquals("You are empty-handed.", result);
	}

}
