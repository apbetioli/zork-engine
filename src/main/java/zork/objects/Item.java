package zork.objects;

import java.util.LinkedList;
import java.util.List;

import zork.Verb;

public class Item {

	protected String name;
	protected String description;
	protected List<Action> actions = new LinkedList<Action>();

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
		return description;
	}

	public String execute(Verb todo) {
		return description;
	}

	public void addAction(Action action) {
		this.actions.add(action);
	}

	public List<Action> getActions() {
		return actions;
	}

	@Override
	public String toString() {
		return look();
	}
}
