package zork.dungeon;

import java.util.LinkedList;
import java.util.List;

public class Room {

	protected String name;
	protected String description;
	protected List<Item> items;

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

}
