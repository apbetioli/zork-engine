package zork.interpreter;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import zork.Zork1Map;
import zork.commands.Command;
import zork.commands.CommandFactory;
import zork.commands.Empty;
import zork.commands.Inventory;
import zork.commands.Open;
import zork.commands.Unknown;
import zork.dungeon.Map;

public class InterpreterTest {

	private CommandFactory commandFactory;

	@Before()
	public void init() {
		commandFactory = new CommandFactory();
		commandFactory.register(new Open());
	}

	@Test
	public void analizeEmptyCommand() {

		commandFactory.register(new Empty());
		Dictionary dictionary = new Dictionary(commandFactory, new Zork1Map());
		Interpreter interpreter = new Interpreter(dictionary);

		Command command = interpreter.analize(" ");

		assertEquals(Empty.class, command.getClass());
	}

	@Test
	public void analizeUnknownCommand() {

		Dictionary dictionary = new Dictionary(commandFactory, new Zork1Map());
		Interpreter interpreter = new Interpreter(dictionary);

		Command command = interpreter.analize("ITADAKIMASU");

		assertEquals(Unknown.class, command.getClass());
	}

	@Test
	public void analizeSingleCommand() {

		commandFactory.register(new Inventory(new Map()));
		Dictionary dictionary = new Dictionary(commandFactory, new Zork1Map());
		Interpreter interpreter = new Interpreter(dictionary);

		Command command = interpreter.analize("INVENTORY");

		assertEquals(Inventory.class, command.getClass());
	}

	@Test
	public void analizeCompositeCommand() {

		Dictionary dictionary = new Dictionary(commandFactory, new Zork1Map());
		Interpreter interpreter = new Interpreter(dictionary);

		Open command = (Open) interpreter.analize("OPEN MAILBOX");

		assertEquals(Open.class, command.getClass());
	}
}
