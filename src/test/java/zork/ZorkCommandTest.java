package zork;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ZorkCommandTest extends EngineTest {

	@Test
	public void zork() {
		String result = engine.interact("zork");

		assertEquals("At your service!", result);
	}

}
