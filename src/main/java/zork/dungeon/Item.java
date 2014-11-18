package zork.dungeon;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import zork.Verb;

public class Item {

	protected String name;
	protected String description;
	protected HashMap<String, Boolean> properties = new HashMap<String, Boolean>();
	protected List<Action> actions = new LinkedList<Action>();
	protected List<Item> items = new LinkedList<Item>();

	public Item() {
	}

	public Item(String name, String description) {
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

	public String look() {
		String look = description;

		if (!items.isEmpty() && (!properties.containsKey(Verb.OPEN.name()) || properties.get(Verb.OPEN.name()))) {
			look += "\n" + "The " + name + " contains:";

			for (Item item : items)
				look += "\n  " + item.look();
		}

		return look;
	}

	public void addAction(Action action) {
		this.actions.add(action);
	}

	public List<Action> getActions() {
		return actions;
	}

	public void addItem(Item item) {
		this.items.add(item);
	}

	public List<Item> getItems() {
		return items;
	}

	public HashMap<String, Boolean> getProperties() {
		return properties;
	}

	@Override
	public String toString() {
		return look();
	}

	public String execute(String todo) {
		if (todo.equalsIgnoreCase(Verb.OPEN.name())) {
			if (properties.get(Verb.OPEN.name()))
				return "It is already open.";

			properties.put(Verb.OPEN.name(), true);

			return "Opening the " + name + " reveals " + StringUtils.join(getItems(), ", ").toLowerCase() + ".";
		}
		if (todo.equalsIgnoreCase(Verb.CLOSE.name())) {
			if (!properties.get(Verb.OPEN.name()))
				return "That's already closed.";

			properties.put(Verb.OPEN.name(), false);

			return "Closed.";
		}

		return description;
	}

}
