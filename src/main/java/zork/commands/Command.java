package zork.commands;

import static zork.commands.Property.OPEN;

import java.util.List;

import zork.Engine;
import zork.FreeMoveException;
import zork.dungeon.Item;
import zork.dungeon.Room;

public abstract class Command implements Cloneable {

	protected Engine engine;
	private List<Object> tokens;

	public Command() {
	}

	public Command(Engine engine) {
		this.engine = engine;
	}

	public abstract String execute() throws FreeMoveException;

	public abstract List<String> getSynonyms();

	@Override
	public String toString() {
		return "<" + getClass().getSimpleName() + ":Command>";
	}

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

	protected boolean itemIsVisibleFrom(Item item, Room currentRoom) {

		List<Item> items = currentRoom.getItems();

		return itemIsVisibleFrom(item, items);
	}

	protected boolean itemIsVisibleFrom(Item item, List<Item> items) {
		for (Item other : items) {
			if (item.getName().equals(other.getName()))
				return true;

			if (other.is(OPEN) && itemIsVisibleFrom(item, other.getItems()))
				return true;
		}

		return false;
	}
}
