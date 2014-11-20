package zork;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class ZorkTest {

	private Game zork;

	@Before
	public void init() {
		zork = new Zork(new Zork1Map());
	}
	
	@Test
	public void pardon() {
		String result = zork.interact(" ");
		
		assertEquals("I beg your pardon?", result);
	}

	@Test
	public void notAVerb() {
		String result = zork.interact("notaverb");
		
		assertEquals("That is not a verb I recognize.", result);
	}

	@Test
	public void version() {
		String version = zork.interact("version");
		
		assertEquals("ZORK I: The Great Underground Empire\n"
				+ "Copyright (c) 1981, 1982, 1983 Infocom, Inc. All rights reserved.\n"
				+ "ZORK is a registered trademark of Infocom, Inc.\n"
				+ "Revision 88 / Serial number 840726\n", version);
	}
	
	@Test
	public void uppercase() {
		String version = zork.interact("VERSION");
		
		assertEquals("ZORK I: The Great Underground Empire\n"
				+ "Copyright (c) 1981, 1982, 1983 Infocom, Inc. All rights reserved.\n"
				+ "ZORK is a registered trademark of Infocom, Inc.\n"
				+ "Revision 88 / Serial number 840726\n", version);
	}

	@Test
	public void look() {
		String result = zork.interact("look");
		assertEquals("West of House\n"
				+ "This is an open field west of a white house, with a boarded front door.\n"
				+ "There is a small mailbox here.\n", result);
	}
	
	@Test
	public void l() {
		String result = zork.interact("l");
		assertEquals("West of House\n"
				+ "This is an open field west of a white house, with a boarded front door.\n"
				+ "There is a small mailbox here.\n", result);
	}

	@Test
	public void i() {
		String result = zork.interact("i");

		assertEquals("You are empty-handed.", result);
	}

	@Test
	public void inventory() {
		String result = zork.interact("inventory");

		assertEquals("You are empty-handed.", result);
	}

	@Test
	public void open() {
		String result = zork.interact("open");
		
		assertEquals("What do you want to open?", result);
	}
	
	@Test
	public void openMailbox() {
		String result = zork.interact("open mailbox");

		assertEquals("Opening the small mailbox reveals a leaflet.", result);
	}
	
	@Test
	public void openLeaflet() {
		String result = zork.interact("open leaflet");

		assertEquals("You must tell me how to do that to a leaflet.", result);
	}

	@Ignore
	@Test
	public void openThenMailbox() {
		zork.interact("open");
		
		String result = zork.interact("mailbox");
		
		assertEquals("Opening the small mailbox reveals a leaflet.", result);
	}
	
	@Test
	public void openSmallMailbox() {
		String result = zork.interact("open small mailbox");

		assertEquals("Opening the small mailbox reveals a leaflet.", result);
	}
	
	@Test
	public void openSmall() {
		String result = zork.interact("open small");

		assertEquals("Opening the small mailbox reveals a leaflet.", result);
	}

	@Ignore
	@Test
	public void openMailboxChangesLook() {
		zork.interact("open mailbox");
		
		String result = zork.interact("look");
		
		assertEquals("West of House\n"
				+ "This is an open field west of a white house, with a boarded front door.\n"
				+ "A rubber mat saying 'Welcome to Zork!' lies by the door.\n"
				+ "There is a small mailbox here.\n"
				+ "The small mailbox contains:\n"
				+ "  A leaflet\n", result);

	}

	@Ignore
	@Test
	public void openMailboxTwice() {
		zork.interact("open mailbox");
		
		String result = zork.interact("open mailbox");

		assertEquals("It is already open.", result);
	}

	@Test
	public void close() {
		String result = zork.interact("close");
		
		assertEquals("What do you want to close?", result);
	}
	
	@Ignore
	@Test
	public void closeMailbox() {
		String result = zork.interact("close mailbox");
		
		assertEquals("That's already closed.", result);
	}
	
	@Ignore
	@Test
	public void getAll() {
		String result = zork.interact("get all");

		assertEquals("welcome mat: Taken."
				+ "small mailbox: It is securely anchored.", result);
	}

}
