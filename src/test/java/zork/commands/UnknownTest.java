package zork.commands;

import static org.junit.Assert.*;

import org.junit.Test;

public class UnknownTest {

	@Test
	public void unknownHasNoSynonyms() {
		Command u = new Unknown();
		
		assertTrue(u.getSynonyms().isEmpty());
	}

}
