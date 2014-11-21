package zork.commands;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import zork.dungeon.Map;

public class CommandFactoryTest {

	@Test
	public void empty() {
		CommandFactory factory = new CommandFactory();

		assertTrue(factory.isEmpty());
	}

	@Test
	public void registerCommand() {
		CommandFactory factory = new CommandFactory();

		factory.register(new Inventory(new Map()));

		assertTrue(factory.containsKey("inventory"));
		assertTrue(factory.containsKey("INVENTORY"));

		assertNotNull(factory.get("inventory"));
		assertNotNull(factory.get("INVENTORY"));
	}

	@Test
	public void unknownCommand() {

		CommandFactory factory = new CommandFactory();

		factory.register(new Inventory(new Map()));

		assertTrue(factory.get("look").getClass().equals(Unknown.class));
	}

	@Test
	public void emptyCommand() {

		CommandFactory factory = new CommandFactory();

		factory.register(new Empty());

		assertTrue(factory.containsKey("   "));
		assertTrue(factory.get("   ").getClass().equals(Empty.class));
	}

}
