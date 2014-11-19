package zork.commands;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CommandFactoryTest {

	@Test
	public void empty() {
		CommandFactory factory = new CommandFactory();

		assertTrue(factory.isEmpty());
	}

	@Test
	public void registerCommand() {
		CommandFactory factory = new CommandFactory();

		factory.register(new InventoryCommand());

		assertTrue(factory.containsKey("inventory"));
		assertTrue(factory.containsKey("INVENTORY"));

		assertNotNull(factory.get("inventory"));
		assertNotNull(factory.get("INVENTORY"));
	}

	@Test
	public void unknownCommand() {

		CommandFactory factory = new CommandFactory();

		factory.register(new InventoryCommand());

		assertTrue(factory.get("look").getClass().equals(UnknownCommand.class));
	}
	
	@Test
	public void emptyCommand() {

		CommandFactory factory = new CommandFactory();

		factory.register(new EmptyCommand());

		assertTrue(factory.containsKey("   "));
		assertTrue(factory.get("   ").getClass().equals(EmptyCommand.class));
	}

}
