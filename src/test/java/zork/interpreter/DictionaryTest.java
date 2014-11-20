package zork.interpreter;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import zork.Zork1Map;
import zork.commands.CommandFactory;
import zork.commands.Open;
import zork.dungeon.Map;

public class DictionaryTest {

	private CommandFactory commandFactory;

	@Before()
	public void init() {
		commandFactory = new CommandFactory();
	}
	
	@Test
	public void emptyDictionary() {
		Dictionary dictionary = new Dictionary(commandFactory, new Map());

		assertTrue(dictionary.isEmpty());
	}
	
	@Test
	public void dictionaryFromCommand() {
		commandFactory.register(new Open(new Map()));
		
		Dictionary dictionary = new Dictionary(commandFactory, new Map());

		assertTrue(dictionary.contains("OPEN"));
	}
	
	@Test
	public void dictionaryFromMap() {
		Dictionary dictionary = new Dictionary(new CommandFactory(), new Zork1Map());
		
		assertTrue(dictionary.contains("SMALL MAILBOX"));
	}


}
