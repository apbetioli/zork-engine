package zork.commands;

import org.junit.Test;

public class EmptyTest {

	@Test(expected = IllegalStateException.class)
	public void emptyHasNoSynonyms() {
		Command u = new Empty();

		u.getSynonyms();
	}

}
