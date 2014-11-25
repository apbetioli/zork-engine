package zork.commands;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import zork.Engine;
import zork.dungeon.Game;
import zork.exceptions.UnknownCommandException;

public class CommandFactoryTest {

	@Test
	public void empty() {
		CommandFactory factory = new CommandFactory();

		assertTrue(factory.isEmpty());
	}

	@Test
	public void registerCommand() {
		CommandFactory factory = new CommandFactory();

		factory.register(new Inventory(new Engine(new Game())));

		assertTrue(factory.containsKey("inventory"));
		assertTrue(factory.containsKey("INVENTORY"));

		assertNotNull(factory.get("inventory"));
		assertNotNull(factory.get("INVENTORY"));
	}

	@Test(expected = UnknownCommandException.class)
	public void unknownCommand() {

		CommandFactory factory = new CommandFactory();

		factory.register(new Inventory(new Engine(new Game())));

		factory.get("look");
	}

}
