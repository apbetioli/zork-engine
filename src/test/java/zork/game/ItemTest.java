package zork.game;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import zork.game.Item;

public class ItemTest {

	@Test
	public void equals() {
		Item a = new Item("A", "aaaa");
		Item b = new Item("A", "cccc");
		Item c = new Item("C", "cccc");
		Item d = new Item(null, "dddd");
		Item e = new Item(null, "eeee");

		assertTrue(a.equals(b));
		assertFalse(b.equals(c));
		assertFalse(c.equals(null));
		assertFalse(c.equals("C"));
		assertFalse(c.equals(d));
		assertFalse(d.equals(a));
		assertTrue(d.equals(e));
	}

}
