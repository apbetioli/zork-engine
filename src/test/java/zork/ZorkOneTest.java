package zork;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ZorkOneTest extends EngineTest {

	@Test
	public void erroComParserLetraPorLetra() {
		Engine zork = new ZorkEngine(new ZorkOne());
		assertEquals("Opening the small mailbox reveals a leaflet.", zork.interact("open box"));
		assertEquals("That is not a verb I recognize.", zork.interact("giloio"));
	}

	@Test
	public void caseInsensitive() {
		String result = engine.interact("Open MAILbox");

		assertEquals("Opening the small mailbox reveals a leaflet.", result);
	}
}
