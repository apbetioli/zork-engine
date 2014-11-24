package zork;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ZorkCommandTest extends ZorkOneBaseTest {

	@Test
	public void zork() {
		String result = zork.interact("zork");

		assertEquals("At your service!", result);
	}

}
