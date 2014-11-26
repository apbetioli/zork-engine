package zork.commands;

import static zork.commands.Property.OPEN;

import java.util.LinkedList;
import java.util.List;

import zork.Engine;
import zork.dungeon.Item;
import zork.language.Token;

public abstract class Command extends Token implements Cloneable {

	protected Engine engine;

	public Command() {
	}

	public Command(Engine engine) {
		this.engine = engine;
	}

	public abstract String execute();

	public abstract List<String> getSynonyms();

	@Override
	public int getNumberOfArgs() {
		return 1;
	}

	protected Item getItem() {
		return getItem(getArgs());
	}

	private Item getItem(List<Token> tokens) {
		if (tokens.isEmpty())
			return null;

		Token next = tokens.iterator().next();

		if (next instanceof Item)
			return (Item) next;
		else
			return getItem(next.getArgs());
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
