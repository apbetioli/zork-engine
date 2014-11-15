package zork.objects;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import zork.Verb;

public class Container extends Item {

	protected List<Item> items = new LinkedList<Item>();

	private boolean open;

	private List<Action> actions = new LinkedList<Action>();

	public Container() {
	}

	public Container(String name, String description) {
		super(name, description);
	}

	public String look() {
		String look = description;

		if (open) {
			look += "\n" + "The " + name + " contains:";

			for (Item item : items)
				look += "\n  " + item.look();
		}

		return look;

	}

	public void addItem(Item item) {
		this.items.add(item);
	}

	public List<Item> getItems() {
		return items;
	}

	@Override
	public String execute(Verb todo) {
		if (todo == Verb.OPEN) {
			if (open)
				return "It is already open.";

			open = true;

			return "Opening the " + name + " reveals " + StringUtils.join(getItems(), ", ").toLowerCase() + ".";
		}
		if(todo == Verb.CLOSE) {
			if(!open)
				return "That's already closed.";
			
			open = false;
				
			return "Closed.";
		}

		return super.execute(todo);
	}

	public void addAction(Action action) {
		this.actions.add(action);
	}

}
