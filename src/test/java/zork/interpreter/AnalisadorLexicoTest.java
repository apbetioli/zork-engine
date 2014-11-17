package zork.interpreter;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class AnalisadorLexicoTest {

	private Set<String> dictionary = new HashSet<String>();

	@Before
	public void init() {
		dictionary.add("OPEN");
		dictionary.add("SMALL");
		dictionary.add("MAILBOX");
	}

	@Test
	public void containsAll() {
		String input = "OPEN MAILBOX";

		AnalisadorLexico lex = new AnalisadorLexico(dictionary, input);

		assertTrue(lex.hasMoreTokens());
		assertEquals("OPEN", lex.nextToken());

		assertTrue(lex.hasMoreTokens());
		assertEquals("MAILBOX", lex.nextToken());

		assertFalse(lex.hasMoreTokens());
	}

	@Test
	public void ignoreSomeInput() {
		String input = "I WANT TO OPEN THE SMALL MAILBOX";

		AnalisadorLexico lex = new AnalisadorLexico(dictionary, input);

		assertTrue(lex.hasMoreTokens());
		assertEquals("OPEN", lex.nextToken());

		assertTrue(lex.hasMoreTokens());
		assertEquals("SMALL", lex.nextToken());

		assertTrue(lex.hasMoreTokens());
		assertEquals("MAILBOX", lex.nextToken());

		assertFalse(lex.hasMoreTokens());
	}
	
	@Test
	public void doesNotContain() {
		String input = "FLY";
		
		AnalisadorLexico lex = new AnalisadorLexico(dictionary, input);
		
		assertFalse(lex.hasMoreTokens());
		assertNull(lex.nextToken());
	}

}
