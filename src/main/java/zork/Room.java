package zork;

import java.util.LinkedList;
import java.util.List;

public class Room {

	private String name;
	private String description;
	private List<Item> items = new LinkedList<Item>();
	private List<Container> containers = new LinkedList<Container>();

	public Room() {
	}

	public Room(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void addItem(Item item) {
		this.items.add(item);
	}

	public void addContainer(Container container) {
		this.containers.add(container);
	}

	public String describe() {
		String text = name + "\n" + description;

		for (Container container : containers) {
			text += "\n" + container.describe();
		}

		for (Item item : items) {
			text += "\n" + item.describe();
		}

		return text + "\n";
	}
}
