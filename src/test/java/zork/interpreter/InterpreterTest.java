package zork.interpreter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;

import zork.Zork1Map;
import zork.interpreter.Interpreter;
import zork.interpreter.Parser;

public class InterpreterTest {

	@Test
	public void initializeDictionary() {
		Interpreter interpreter = new Interpreter(new Zork1Map());

		Set<String> dictionary = interpreter.getDictionary();
		assertTrue(dictionary.contains("OPEN"));
		assertTrue(dictionary.contains("SMALL"));
		assertTrue(dictionary.contains("MAILBOX"));

	}

	@Test
	public void ignoreSomeInput() {
		String input = "OPEN THE SMALL MAILBOX";

		Interpreter interpreter = new Interpreter(new Zork1Map());

		Parser lex = interpreter.parse(input);

		assertTrue(lex.hasMoreTokens());
		assertEquals("OPEN", lex.nextToken());

		assertTrue(lex.hasMoreTokens());
		assertEquals("SMALL", lex.nextToken());

		assertTrue(lex.hasMoreTokens());
		assertEquals("MAILBOX", lex.nextToken());

		assertFalse(lex.hasMoreTokens());
	}

}
