package zork.game;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Room {

	protected String name;
	protected String description;
	protected List<Item> items;
	protected Map<String, String> directions;

	public Room(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public List<Item> getItems() {
		if (items == null)
			items = new LinkedList<Item>();
		return items;
	}

	public void addItem(Item item) {
		getItems().add(item);
	}

	public String getDirection(String name) {
		return getDirections().get(name);
	}

	private Map<String, String> getDirections() {
		if (directions == null)
			directions = new TreeMap<String, String>();
		return directions;
	}

	public void setDirection(String name, String roomOrMessage) {
		getDirections().put(name, roomOrMessage);
	}
}
