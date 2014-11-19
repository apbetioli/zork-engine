package zork.interpreter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class ParserTest {

	@Test
	public void emptyDictionary() {
		Set<String> dictionary = new HashSet<String>();

		String input = "HELLO WORLD OF INTERACTIVE FICTION";
		Parser parser = new Parser(dictionary, input);

		assertFalse(parser.hasMoreTokens());
		assertNull(parser.nextToken());
	}

	@Test
	public void emptyInputString() {
		Set<String> dictionary = new HashSet<String>();
		dictionary.add("WORLD");
		dictionary.add("FICTION");

		String input = "";
		Parser parser = new Parser(dictionary, input);

		assertFalse(parser.hasMoreTokens());
		assertNull(parser.nextToken());
	}
	
	@Test
	public void parseText() {
		Set<String> dictionary = new HashSet<String>();
		dictionary.add("WORLD");
		dictionary.add("FICTION");

		String input = "HELLO WORLD OF INTERACTIVE FICTION";
		Parser parser = new Parser(dictionary, input);

		assertTrue(parser.hasMoreTokens());
		assertEquals("WORLD", parser.nextToken());

		assertTrue(parser.hasMoreTokens());
		assertEquals("FICTION", parser.nextToken());

		assertFalse(parser.hasMoreTokens());
		assertNull(parser.nextToken());
	}

	@Test
	public void parseLowerCaseText() {
		Set<String> dictionary = new HashSet<String>();
		dictionary.add("WORLD");
		dictionary.add("FICTION");

		String input = "hello world of interactive fiction";
		Parser parser = new Parser(dictionary, input);

		assertTrue(parser.hasMoreTokens());
		assertEquals("WORLD", parser.nextToken());

		assertTrue(parser.hasMoreTokens());
		assertEquals("FICTION", parser.nextToken());

		assertFalse(parser.hasMoreTokens());
		assertNull(parser.nextToken());
	}

	@Test
	public void hasMoreTokensDoesNotConsume() {
		Set<String> dictionary = new HashSet<String>();
		dictionary.add("WORLD");
		dictionary.add("FICTION");

		String input = "hello world of interactive fiction";
		Parser parser = new Parser(dictionary, input);

		assertTrue(parser.hasMoreTokens());
		assertTrue(parser.hasMoreTokens());
		assertTrue(parser.hasMoreTokens());
		assertTrue(parser.hasMoreTokens());
		assertTrue(parser.hasMoreTokens());
		assertEquals("WORLD", parser.nextToken());
	}
}
