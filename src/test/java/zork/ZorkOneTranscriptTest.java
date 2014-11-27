package zork;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import zork.engine.EngineTest;

/**
 * http://steel.lcc.gatech.edu/~marleigh/zork/transcript.html
 */
public class ZorkOneTranscriptTest extends EngineTest {

	String leafletDescription = "(Taken)\n"
			+ "    WELCOME TO ZORK\n\n"
			+ "    ZORK is a game of adventure, danger, and low cunning. In it you will explore some of the most amazing territory ever seen by mortal man.  Hardened adventurers have run screaming from the terrors contained within!\n\n"
			+ "    In ZORK the intrepid explorer delves into the forgotten secrets of a lost labyrinth deep in the bowels of the earth, searching for vast treasures long hidden from prying eyes, treasures guarded by fearsome monsters and diabolical traps!\n\n"
			+ "    No devices should be without one!\n"
			+ "    Zork was created at the MIT Laboratory for Computer Science by Tim Anderson, Marc Blank, Bruce Daniels, and Dave Lebling.  It was inspired by the Adventure game of Crowther and Woods, and the long tradition of fantasy and science fiction games.\n"
			+ "    On-line information may be obtained with the command HELP (synonyms are ABOUT, INFO, HINT, etc.).";

	@Test
	public void transcript() {
		assertThat(engine.interact("open mailbox"), is("Opening the small mailbox reveals a leaflet."));
		assertThat(engine.interact("read leaflet"), is(leafletDescription));
		assertThat(engine.interact("drop leaflet"), is("Dropped."));
		assertThat(engine.interact("go south"), is("South of House\nYou are facing the south side of a white house. There is no door here, and all the windows are boarded."));
	}

}
