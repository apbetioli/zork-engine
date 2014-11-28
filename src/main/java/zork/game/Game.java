package zork.game;

import java.util.LinkedList;
import java.util.List;

import zork.exceptions.InexistentRoomException;

public class Game {

	private String version;
	private String currentRoom;
	private List<Room> rooms = new LinkedList<Room>();
	private List<Item> inventory = new LinkedList<Item>();
	private List<Item> globalItems = new LinkedList<Item>();
	private Stats stats = new Stats();

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Room getCurrentRoom() {
		for (Room room : rooms) {
			if (room.getName().equals(currentRoom))
				return room;
		}
		return null;
	}

	public void setCurrentRoom(String currentRoom) {

		if (currentRoom == null)
			throw new InexistentRoomException("You can't go that way.");

		for (Room room : rooms) {
			if (room.getName().equals(currentRoom)) {
				this.currentRoom = currentRoom;
				return;
			}
		}

		throw new InexistentRoomException(currentRoom);
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public List<Item> getInventory() {
		return inventory;
	}

	public Stats getStats() {
		return stats;
	}

	public List<Item> getGlobalItems() {
		return globalItems;
	}
}
