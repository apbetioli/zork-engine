package zork.dungeon;

import java.util.LinkedList;
import java.util.List;

public class Map {

	protected String version;
	protected Room currentRoom;
	protected List<Room> rooms = new LinkedList<Room>();

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
		return rooms;
	}

}
