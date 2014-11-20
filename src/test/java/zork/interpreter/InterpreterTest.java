package zork.interpreter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
	public void emptyDictionary() {
		Interpreter interpreter = new Interpreter(new Map(), new CommandFactory());

		Set<String> dictionary = interpreter.getDictionary();
		assertTrue(dictionary.isEmpty());
	}

	@Test
	public void dictionaryFromCommand() {
		Interpreter interpreter = new Interpreter(new Map(), commandFactory);

		Set<String> dictionary = interpreter.getDictionary();
		assertTrue(dictionary.contains("OPEN"));
	}
	
	@Test
	public void dictionaryFromMap() {
		Interpreter interpreter = new Interpreter(new Zork1Map(), new CommandFactory());
		
		Set<String> dictionary = interpreter.getDictionary();
		assertTrue(dictionary.contains("SMALL MAILBOX"));
	}

	@Test
	public void parseInput() {
		String input = "OPEN THE CAR";

		Interpreter interpreter = new Interpreter(new Map(), commandFactory);

		Parser lex = interpreter.createParser(input);

		assertTrue(lex.hasMoreTokens());
		assertEquals("OPEN", lex.nextToken());

		assertFalse(lex.hasMoreTokens());
	}
	
	@Test
	public void analizeEmptyCommand() {
		
		commandFactory.register(new Empty());
		
		Interpreter interpreter = new Interpreter(new Zork1Map(), commandFactory);
		
		Command command = interpreter.analize(" ");
		
		assertEquals(Empty.class, command.getClass());
	}

	@Test
	public void analizeUnknownCommand() {
		
		Interpreter interpreter = new Interpreter(new Zork1Map(), commandFactory);
		
		Command command = interpreter.analize("ITADAKIMASU");
		
		assertEquals(Unknown.class, command.getClass());
	}
	
	@Test
	public void analizeSingleCommand() {
		commandFactory.register(new Inventory());
		
		Interpreter interpreter = new Interpreter(new Zork1Map(), commandFactory);
		
		Command command = interpreter.analize("INVENTORY");
		
		assertEquals(Inventory.class, command.getClass());
	}
	
	@Test
	public void analizeCompositeCommand() {
		Interpreter interpreter = new Interpreter(new Zork1Map(), commandFactory);
		
		Open command = (Open) interpreter.analize("OPEN MAILBOX");
		
		assertEquals(Open.class, command.getClass());
	}
}
