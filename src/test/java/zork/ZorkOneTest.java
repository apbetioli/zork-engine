package zork;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

public class ZorkOneTest extends ZorkOneBaseTest {

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
	public void unknown() {
		String result = zork.interact("debug door");

		assertEquals("That is not a verb I recognize.", result);
	}

	@Test
	public void version() {
		String version = zork.interact("version");

		assertEquals("ZORK I: The Great Underground Empire\n"
				+ "Copyright (c) 1981, 1982, 1983 Infocom, Inc. All rights reserved.\n"
				+ "ZORK is a registered trademark of Infocom, Inc.\n" + "Revision 88 / Serial number 840726\n", version);
	}

	@Test
	public void uppercase() {
		String version = zork.interact("VERSION");

		assertEquals("ZORK I: The Great Underground Empire\n"
				+ "Copyright (c) 1981, 1982, 1983 Infocom, Inc. All rights reserved.\n"
				+ "ZORK is a registered trademark of Infocom, Inc.\n" + "Revision 88 / Serial number 840726\n", version);
	}

	@Test
	public void look() {
		String result = zork.interact("look");
		assertEquals("West of House\n" + "This is an open field west of a white house, with a boarded front door.\n"
				+ "There is a small mailbox here.\n", result);
	}

	@Test
	public void l() {
		String result = zork.interact("l");
		assertEquals("West of House\n" + "This is an open field west of a white house, with a boarded front door.\n"
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
	public void openTheCrazySmallMailbox() {
		String result = zork.interact("open the crazy small mailbox");

		assertEquals("Opening the small mailbox reveals a leaflet.", result);
	}

	@Test
	public void openLeaflet() {
		String result = zork.interact("open leaflet");

		assertEquals("You must tell me how to do that to a leaflet.", result);
	}

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

	@Test
	public void openMailboxChangesLook() {
		zork.interact("open mailbox");

		String result = zork.interact("look");

		assertEquals("West of House\n" + "This is an open field west of a white house, with a boarded front door.\n"
				+ "There is a small mailbox here.\n" + "The small mailbox contains:\n" + "  A leaflet\n", result);

	}

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

	@Test
	public void closeMailboxClosed() {
		String result = zork.interact("close mailbox");

		assertEquals("That's already closed.", result);
	}

	@Test
	public void closeMailbox() {
		zork.interact("open mailbox");

		String result = zork.interact("close mailbox");

		assertEquals("Closed.", result);
	}

	@Test
	public void openThenCloseMailboxTwiceThenOpen() {
		zork.interact("open mailbox");

		String result = zork.interact("close mailbox");
		assertEquals("Closed.", result);

		String result2 = zork.interact("close mailbox");
		assertEquals("That's already closed.", result2);

		String result3 = zork.interact("open mailbox");
		assertEquals("Opening the small mailbox reveals a leaflet.", result3);
	}

	@Test
	public void openDoor() {
		String result = zork.interact("open door");

		assertEquals("The door cannot be opened.", result);
	}

	@Test
	public void closeDoor() {
		String result = zork.interact("close door");

		assertEquals("That's already closed.", result);
	}

	@Test
	public void closeLeaflet() {
		String result = zork.interact("close leaflet");

		assertEquals("You must tell me how to do that to a leaflet.", result);
	}

	@Test
	public void take() {
		String result = zork.interact("take");

		assertEquals("What do you want to take?", result);
	}

	@Test
	public void takeLeaflet() {
		zork.interact("open mailbox");

		String result = zork.interact("take leaflet");

		assertEquals("Taken.", result);
	}

	@Test
	public void getLeaflet() {
		zork.interact("open mailbox");

		String result = zork.interact("get leaflet");

		assertEquals("Taken.", result);
	}

	@Test
	public void catchLeaflet() {
		zork.interact("open mailbox");

		String result = zork.interact("catch leaflet");

		assertEquals("Taken.", result);
	}

	@Test
	public void pickupLeaflet() {
		zork.interact("open mailbox");

		String result = zork.interact("pick up leaflet");

		assertEquals("Taken.", result);
	}

	@Test
	public void takeLeafletTwice() {
		zork.interact("open mailbox");

		zork.interact("take leaflet");
		String result = zork.interact("take leaflet");

		assertEquals("You already have that!", result);
	}

	@Test
	public void takeLeafletWithoutOpeningTheMailbox() {

		String result = zork.interact("take leaflet");

		assertEquals("You can't see any such thing.", result);
	}

	@Test
	public void inventoryWithLeaflet() {
		zork.interact("open mailbox");
		zork.interact("take leaflet");

		String result = zork.interact("inventory");

		assertEquals("You are carrying:\n" + "  A leaflet\n", result);
	}

	@Test
	public void takeMailbox() {
		String result = zork.interact("take mailbox");

		assertEquals("It is securely anchored.", result);
	}

	@Test
	public void takeDoor() {
		String result = zork.interact("take door");

		assertEquals("An interesting idea...", result); // FIXME RANDOMIZE
	}

	@Test
	public void drop() {
		zork.interact("open mailbox");
		zork.interact("take leaflet");

		String result = zork.interact("drop leaflet");

		assertEquals("Dropped.", result);
	}

	@Test
	public void dropTwice() {
		zork.interact("open mailbox");
		zork.interact("take leaflet");
		zork.interact("drop leaflet");

		String result = zork.interact("drop leaflet");

		assertEquals("You don't have the leaflet!", result);
	}

	@Test
	public void dropAll() {
		zork.interact("open mailbox");
		zork.interact("take leaflet");

		String result = zork.interact("drop all");

		assertEquals("leaflet: Dropped.\n", result);
	}

	@Test
	public void dropLeafletWithoutHavingIt() {
		String result = zork.interact("drop leaflet");

		assertEquals("You don't have the leaflet!", result);
	}

	@Test
	public void dropAllWithoutHavingNothing() {
		String result = zork.interact("drop all");

		assertEquals("You are empty-handed.", result);
	}

	@Test
	public void leave() {
		zork.interact("open mailbox");
		zork.interact("take leaflet");

		String result = zork.interact("leave leaflet");

		assertEquals("Dropped.", result);
	}

	@Test
	public void erroComParserLetraPorLetra() {
		Engine zork = new ZorkEngine(new ZorkOne());
		assertEquals("Opening the small mailbox reveals a leaflet.", zork.interact("open box"));
		assertEquals("That is not a verb I recognize.", zork.interact("giloio"));
	}

	@Test
	public void readLeafletInsideMailboxClosed() {
		String result = zork.interact("read leaflet");

		assertEquals("You can't see any such thing.", result);
	}

	@Test
	public void readMailbox() {
		String result = zork.interact("read mailbox");

		assertEquals("How does one read a small mailbox?", result);
	}

	@Test
	public void readLeafletWithoutTaking() {
		zork.interact("open small mailbox");

		String result = zork.interact("read leaflet");

		assertEquals(
				"(Taken)\n"
						+ "    WELCOME TO ZORK\n\n"
						+ "    ZORK is a game of adventure, danger, and low cunning. In it you will explore some of the most amazing territory ever seen by mortal man.  Hardened adventurers have run screaming from the terrors contained within!\n\n"
						+ "    In ZORK the intrepid explorer delves into the forgotten secrets of a lost labyrinth deep in the bowels of the earth, searching for vast treasures long hidden from prying eyes, treasures guarded by fearsome monsters and diabolical traps!\n\n"
						+ "    No devices should be without one!\n", result);
	}

	@Test
	public void readLeaflet() {
		zork.interact("open small mailbox");
		zork.interact("take leaflet");

		String result = zork.interact("read leaflet");

		assertEquals(
				"    WELCOME TO ZORK\n\n"
						+ "    ZORK is a game of adventure, danger, and low cunning. In it you will explore some of the most amazing territory ever seen by mortal man.  Hardened adventurers have run screaming from the terrors contained within!\n\n"
						+ "    In ZORK the intrepid explorer delves into the forgotten secrets of a lost labyrinth deep in the bowels of the earth, searching for vast treasures long hidden from prying eyes, treasures guarded by fearsome monsters and diabolical traps!\n\n"
						+ "    No devices should be without one!\n", result);
	}

	@Test
	public void getAll() {
		String result = zork.interact("get all");

		assertEquals("small mailbox: It is securely anchored.\n", result);
	}

	@Test
	public void examineLeaflet() {
		String result = zork.interact("examine leaflet");

		assertEquals("You can't see any such thing.", result);
	}

	@Test
	public void examineDoor() {
		String result = zork.interact("examine door");

		assertEquals("The door is closed.", result);
	}

	@Test
	public void examineHouse() {
		String result = zork.interact("examine house");

		assertEquals(
				"The house is a beautiful colonial house which is painted white. It is clear that the owners must have been extremely wealthy.",
				result);
	}

	@Test
	public void examineGround() {
		String result = zork.interact("examine ground");

		assertEquals("There's nothing special about the ground.", result);
	}

	@Ignore
	@Test
	public void lookAtMe() {
		String result = zork.interact("look at me");

		assertEquals("That's difficult unless your eyes are prehensile.", result);
	}

	@Ignore
	@Test
	public void examineMe() {
		String result = zork.interact("examine me");

		assertEquals("That's difficult unless your eyes are prehensile.", result);
	}

}
