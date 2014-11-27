package zork.commands;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import zork.engine.EngineTest;

public class ReadTest extends EngineTest {

	@Test
	public void readLeafletInsideMailboxClosed() {
		String result = engine.interact("read leaflet");

		assertEquals("You can't see any such thing.", result);
	}

	@Test
	public void readMailbox() {
		String result = engine.interact("read mailbox");

		assertEquals("How does one read a small mailbox?", result);
	}

	@Test
	public void readLeafletWithoutTaking() {
		engine.interact("open small mailbox");

		String result = engine.interact("read leaflet");

		assertEquals(
				"(Taken)\n"
						+ "    WELCOME TO ZORK\n\n"
						+ "    ZORK is a game of adventure, danger, and low cunning. In it you will explore some of the most amazing territory ever seen by mortal man.  Hardened adventurers have run screaming from the terrors contained within!\n\n"
						+ "    In ZORK the intrepid explorer delves into the forgotten secrets of a lost labyrinth deep in the bowels of the earth, searching for vast treasures long hidden from prying eyes, treasures guarded by fearsome monsters and diabolical traps!\n\n"
						+ "    No devices should be without one!\n"
						+ "    Zork was created at the MIT Laboratory for Computer Science by Tim Anderson, Marc Blank, Bruce Daniels, and Dave Lebling.  It was inspired by the Adventure game of Crowther and Woods, and the long tradition of fantasy and science fiction games.\n"
						+ "    On-line information may be obtained with the command HELP (synonyms are ABOUT, INFO, HINT, etc.).",
				result);
	}

	@Test
	public void readLeaflet() {
		engine.interact("open small mailbox");
		engine.interact("take leaflet");

		String result = engine.interact("read leaflet");

		assertEquals(
				"    WELCOME TO ZORK\n\n"
						+ "    ZORK is a game of adventure, danger, and low cunning. In it you will explore some of the most amazing territory ever seen by mortal man.  Hardened adventurers have run screaming from the terrors contained within!\n\n"
						+ "    In ZORK the intrepid explorer delves into the forgotten secrets of a lost labyrinth deep in the bowels of the earth, searching for vast treasures long hidden from prying eyes, treasures guarded by fearsome monsters and diabolical traps!\n\n"
						+ "    No devices should be without one!\n"
						+ "    Zork was created at the MIT Laboratory for Computer Science by Tim Anderson, Marc Blank, Bruce Daniels, and Dave Lebling.  It was inspired by the Adventure game of Crowther and Woods, and the long tradition of fantasy and science fiction games.\n"
						+ "    On-line information may be obtained with the command HELP (synonyms are ABOUT, INFO, HINT, etc.).",
				result);
	}

	@Test
	public void read() {
		String result = engine.interact("read");

		assertEquals("What do you want to read?", result);
	}

	@Test
	public void readThenLeaflet() {
		engine.interact("read");

		String result = engine.interact("leaflet");

		assertEquals("You can't see any such thing.", result);
	}
}
