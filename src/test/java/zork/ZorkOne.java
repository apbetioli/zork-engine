package zork;

import static zork.commands.Property.CLOSABLE;
import static zork.commands.Property.CLOSED;
import static zork.commands.Property.FIXED;
import static zork.commands.Property.OPENABLE;
import static zork.commands.Property.READABLE;
import static zork.commands.Property.SCENERY;
import static zork.commands.Property.TAKEABLE;
import zork.dungeon.Item;
import zork.dungeon.Game;
import zork.dungeon.Room;

public class ZorkOne extends Game {

	public ZorkOne() {
		setVersion("ZORK I: The Great Underground Empire\n"
				+ "Copyright (c) 1981, 1982, 1983 Infocom, Inc. All rights reserved.\n"
				+ "ZORK is a registered trademark of Infocom, Inc.\n"
				+ "Revision 88 / Serial number 840726\n");
		addRooms();
	}

	private void addRooms() {
		getRooms().add(westHouse());
	}

	private Room westHouse() {
		Room room = new Room("West of House",
				"This is an open field west of a white house, with a boarded front door.\nThere is a small mailbox here.");

		Item leaflet = new Item(
				"leaflet",
				"    WELCOME TO ZORK\n\n"
						+ "    ZORK is a game of adventure, danger, and low cunning. In it you will explore some of the most amazing territory ever seen by mortal man.  Hardened adventurers have run screaming from the terrors contained within!\n\n"
						+ "    In ZORK the intrepid explorer delves into the forgotten secrets of a lost labyrinth deep in the bowels of the earth, searching for vast treasures long hidden from prying eyes, treasures guarded by fearsome monsters and diabolical traps!\n\n"
						+ "    No devices should be without one!\n");
		leaflet.addProperties(TAKEABLE, READABLE);

		Item mailbox = new Item("small mailbox", "There is a small mailbox here.");
		mailbox.addSynonyms("small", "mailbox", "mail-box", "box");
		mailbox.addProperties(OPENABLE, CLOSABLE, CLOSED, FIXED);
		mailbox.addItem(leaflet);

		room.addItem(mailbox);

		Item door = new Item("door", "");
		door.addProperties(SCENERY);

		room.addItem(door);

		setCurrentRoom(room.getName());

		return room;
	}

}
