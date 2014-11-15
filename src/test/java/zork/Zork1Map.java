package zork;

import java.util.ArrayList;
import java.util.List;

public class Zork1Map extends Map {

	public Zork1Map() {
		
		setWelcome("Welcome to ZORK!");
		setRooms(rooms());
		
	}

	private List<Room> rooms() {
		List<Room> rooms = new ArrayList<Room>();
		
		rooms.add(westHouse());
		
		return rooms;
	}

	private Room westHouse() {
		Room room = new Room("West of House", "This is an open field west of a white house, with a boarded front door.");
		room.addItem(new Item("welcome mat", "A rubber mat saying 'Welcome to Zork!' lies by the door."));
		room.addContainer(new Container("smal mailbox", "There is a small mailbox here."));
		
		return room;
	}
	
}
