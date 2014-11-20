package zork.interpreter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

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
		commandFactory.register(new Open(new Map()));
	}

	@Test
	public void parseInput() {
		
		String input = "OPEN THE CAR";
		Dictionary dictionary = new Dictionary(commandFactory, new Map());
		Interpreter interpreter = new Interpreter(commandFactory, dictionary);

		Parser lex = interpreter.createParser(input);

		assertTrue(lex.hasMoreTokens());
		assertEquals("OPEN", lex.nextToken());
		assertFalse(lex.hasMoreTokens());
	}

	@Test
	public void analizeEmptyCommand() {

		commandFactory.register(new Empty());
		Dictionary dictionary = new Dictionary(commandFactory, new Zork1Map());
		Interpreter interpreter = new Interpreter(commandFactory, dictionary);

		Command command = interpreter.analize(" ");

		assertEquals(Empty.class, command.getClass());
	}

	@Test
	public void analizeUnknownCommand() {

		Dictionary dictionary = new Dictionary(commandFactory, new Zork1Map());
		Interpreter interpreter = new Interpreter(commandFactory, dictionary);

		Command command = interpreter.analize("ITADAKIMASU");

		assertEquals(Unknown.class, command.getClass());
	}

	@Test
	public void analizeSingleCommand() {
		
		commandFactory.register(new Inventory());
		Dictionary dictionary = new Dictionary(commandFactory, new Zork1Map());
		Interpreter interpreter = new Interpreter(commandFactory, dictionary);

		Command command = interpreter.analize("INVENTORY");

		assertEquals(Inventory.class, command.getClass());
	}

	@Test
	public void analizeCompositeCommand() {
		
		Dictionary dictionary = new Dictionary(commandFactory, new Zork1Map());
		Interpreter interpreter = new Interpreter(commandFactory, dictionary);

		Open command = (Open) interpreter.analize("OPEN MAILBOX");

		assertEquals(Open.class, command.getClass());
	}
}
