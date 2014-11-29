package zork.game;

import java.util.LinkedList;
import java.util.List;

import zork.util.UpperCaseKeyTreeMap;

public class Room {

	protected String name;
	protected String description;
	protected List<Item> items;
	protected UpperCaseKeyTreeMap<String> directions;

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

	private UpperCaseKeyTreeMap<String> getDirections() {
		if (directions == null)
			directions = new UpperCaseKeyTreeMap<String>();
		return directions;
	}

	public void putDirection(String name, String roomOrMessage) {
		getDirections().put(name, roomOrMessage);
	}

}
