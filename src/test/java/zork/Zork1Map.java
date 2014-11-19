package zork;

import zork.dungeon.Item;
import zork.dungeon.Map;
import zork.dungeon.Room;

import com.google.gson.GsonBuilder;

public class Zork1Map extends Map {
	
	public static void main(String[] args) {
		GsonBuilder gsonBuilder= new GsonBuilder();
		gsonBuilder.setPrettyPrinting();
		System.out.println(gsonBuilder.create().toJson(new Zork1Map()));
	}

	public Zork1Map() {
		setVersion("Welcome to ZORK!\n");
		addRooms();
	}

	private void addRooms() {
		rooms.add(westHouse());
	}

	private Room westHouse() {
		Room room = new Room("West of House", "This is an open field west of a white house, with a boarded front door.");
		room.addItem(new Item("welcome mat", "A rubber mat saying 'Welcome to Zork!' lies by the door."));
		
		Item smallMailbox = new Item("small mailbox", "There is a small mailbox here.");
		smallMailbox.addItem(new Item("leaflet", "A leaflet"));
		
		room.addItem(smallMailbox);
		
		setCurrentRoom(room);
		
		return room;
	}
	
}
