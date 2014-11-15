package zork;

import zork.objects.Action;
import zork.objects.Container;
import zork.objects.Item;
import zork.objects.Map;
import zork.objects.Room;

public class Zork1Map extends Map {

	public Zork1Map() {
		setWelcome("Welcome to ZORK!");
		addRooms();
	}

	private void addRooms() {
		rooms.add(westHouse());
	}

	private Room westHouse() {
		Room room = new Room("West of House", "This is an open field west of a white house, with a boarded front door.");
		room.addItem(new Item("welcome mat", "A rubber mat saying 'Welcome to Zork!' lies by the door."));
		
		Container smallMailbox = new Container("small mailbox", "There is a small mailbox here.");
		smallMailbox.addItem(new Item("leaflet", "A leaflet"));
		smallMailbox.addAction(new Action("open"));
		
		room.addItem(smallMailbox);
		
		return room;
	}
	
}
