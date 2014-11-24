package zork.dungeon;

import java.util.LinkedList;
import java.util.List;

public class Game {

	private String version;
	private String currentRoom;
	private List<Room> rooms = new LinkedList<Room>();
	private List<Item> inventory = new LinkedList<Item>();
	private Rank rank = new Rank();

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
		this.currentRoom = currentRoom;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public List<Item> getInventory() {
		return inventory;
	}

	public Rank getRank() {
		return rank;
	}
}
