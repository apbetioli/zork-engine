package zork.commands;

import static zork.commands.Property.OPEN;

import java.util.LinkedList;
import java.util.List;

import zork.Engine;
import zork.dungeon.Item;

public abstract class Command implements Cloneable {

	protected Engine engine;
	private List<Object> tokens;

	public Command() {
	}

	public Command(Engine engine) {
		this.engine = engine;
	}

	public abstract String execute();

	public abstract List<String> getSynonyms();

	public void setTokens(List<Object> tokens) {
		this.tokens = tokens;
	}

	protected Item getItem() {
		for (Object obj : tokens) {
			if (obj instanceof Item)
				return (Item) obj;
		}
		return null;
	}

	protected boolean isItemVisible(Item item) {

		List<Item> items = new LinkedList<Item>();
		items.addAll(engine.getGame().getGlobalItems());
		items.addAll(engine.getGame().getCurrentRoom().getItems());

		return isItemVisibleFrom(item, items);
	}

	private boolean isItemVisibleFrom(Item item, List<Item> items) {
		for (Item other : items) {
			if (item.getName().equals(other.getName()))
				return true;

			if (other.is(OPEN) && isItemVisibleFrom(item, other.getItems()))
				return true;
		}

		return false;
	}
}
