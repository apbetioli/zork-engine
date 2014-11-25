package zork.commands;

import static zork.commands.Property.OPEN;

import java.util.LinkedList;
import java.util.List;

import zork.Engine;
import zork.dungeon.Item;
import zork.language.Token;
import zork.language.Word;

public abstract class Command extends Word implements Cloneable {

	protected Engine engine;

	public Command() {
		setDepth(1);
	}

	public Command(Engine engine) {
		this();
		this.engine = engine;
	}

	public abstract String execute();

	public abstract List<String> getSynonyms();

	protected Item getItem() {
		return getItem(getTokens());
	}

	private Item getItem(List<Token> tokens) {
		if (tokens.isEmpty())
			return null;

		Token next = tokens.iterator().next();

		if (next instanceof Item)
			return (Item) next;
		else
			return getItem(next.getTokens());
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

	@Override
	public Command clone() {
		try {
			return (Command) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(e);
		}
	}
}
