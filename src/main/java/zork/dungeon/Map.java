package zork.dungeon;

import java.util.LinkedList;
import java.util.List;

public class Map {

	private String version;
	private Room currentRoom;
	private List<Room> rooms;
	private List<Item> inventory;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Room getCurrentRoom() {
		return currentRoom;
	}

	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}

	public List<Room> getRooms() {
		if (rooms == null)
			rooms = new LinkedList<Room>();
		return rooms;
	}

	public List<Item> getInventory() {
		if (inventory == null)
			inventory = new LinkedList<Item>();
		return inventory;
	}
}
