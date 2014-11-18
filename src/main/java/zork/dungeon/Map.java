package zork.dungeon;

import java.util.LinkedList;
import java.util.List;

import zork.Game;

public class Map implements Game {

	protected String welcome;
	protected Room currentRoom;
	protected List<Room> rooms = new LinkedList<Room>();
	protected List<Action> actions = new LinkedList<Action>();

	public String getWelcome() {
		return welcome;
	}

	public void setWelcome(String welcome) {
		this.welcome = welcome;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public String welcome() {
		return welcome + "\n";
	}

	public void addAction(Action action) {
		this.actions.add(action);
	}

	public List<Action> getActions() {
		return actions;
	}

	public List<Item> getVisibleItems() {
		return currentRoom.getItems();
	}

	public String look() {
		return currentRoom.look();
	}

	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}

	public String inventory() {
		return "You are empty handed.";
	}

	public String open() {
		return "What do you want to open?";
	}

	public String close() {
		return "What do you want to close?";
	}

}
