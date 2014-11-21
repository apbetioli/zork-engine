package zork;

import static zork.commands.Property.CLOSABLE;
import static zork.commands.Property.CLOSED;
import static zork.commands.Property.FIXED;
import static zork.commands.Property.OPENABLE;
import static zork.commands.Property.SCENERY;
import static zork.commands.Property.TAKEABLE;
import zork.dungeon.Item;
import zork.dungeon.Map;
import zork.dungeon.Room;

public class Zork1Map extends Map {

	public Zork1Map() {
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
		Room room = new Room("West of House", "This is an open field west of a white house, with a boarded front door.");

		Item leaflet = new Item("leaflet", "A leaflet");
		leaflet.addProperties(TAKEABLE);

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
