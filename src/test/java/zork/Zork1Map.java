package zork;

import zork.objects.Action;
import zork.objects.Container;
import zork.objects.Item;
import zork.objects.Map;
import zork.objects.Room;

import com.google.gson.GsonBuilder;

public class Zork1Map extends Map {
	
	public static void main(String[] args) {
		GsonBuilder gsonBuilder= new GsonBuilder();
		gsonBuilder.setPrettyPrinting();
		System.out.println(gsonBuilder.create().toJson(new Zork1Map()));
	}

	public Zork1Map() {
		setWelcome("Welcome to ZORK!");
		addActions();
		addRooms();
	}

	private void addActions() {
		addAction(new Action("i", "i"));
		addAction(new Action("inventory", "inventory"));
		addAction(new Action("look", "look"));
	}

	private void addRooms() {
		rooms.add(westHouse());
	}

	private Room westHouse() {
		Room room = new Room("West of House", "This is an open field west of a white house, with a boarded front door.");
		room.addItem(new Item("welcome mat", "A rubber mat saying 'Welcome to Zork!' lies by the door."));
		
		Container smallMailbox = new Container("small mailbox", "There is a small mailbox here.");
		smallMailbox.addItem(new Item("leaflet", "A leaflet"));
		smallMailbox.addAction(new Action("open", "Opening the mailbox reveals a leaflet."));
		smallMailbox.addAction(new Action("close", "Closed."));
		
		room.addItem(smallMailbox);
		
		return room;
	}
	
}
