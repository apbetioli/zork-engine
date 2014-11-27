package zork;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import zork.engine.Engine;
import zork.engine.EngineTest;

public class SpecialCasesTest extends EngineTest {

	@Test
	public void erroComParserLetraPorLetra() {
		Engine zork = new ZorkEngine(new ZorkOne());
		assertEquals("Opening the small mailbox reveals a leaflet.", zork.interact("open box"));
		assertEquals("I don't know the word \"GILOIO\".", zork.interact("giloio"));
	}

	@Test
	public void caseInsensitive() {
		String result = engine.interact("Open MAILbox");

		assertEquals("Opening the small mailbox reveals a leaflet.", result);
	}

}
