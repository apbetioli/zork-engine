package zork.commands;

import static zork.game.Property.OPEN;

import java.util.LinkedList;
import java.util.List;

import zork.engine.Engine;
import zork.exceptions.InexistentRoomException;
import zork.game.Item;
import zork.language.Token;
import zork.language.Verb;

public abstract class Command extends Verb implements Cloneable {

	protected Engine engine;

	public Command(Engine engine) {
		this.engine = engine;
	}

	public abstract String execute();

	protected Item getItem() {
		return getItem(getArgs());
	}

	private Item getItem(List<Token> tokens) {
		if (tokens.isEmpty())
			return null;

		Token next = tokens.iterator().next();

		if (next instanceof Item)
			return getVisibleItem((Item) next);
		else
			return getItem(next.getArgs());
	}

	private Item getVisibleItem(Item item) {

		List<Item> items = new LinkedList<Item>();
		items.addAll(engine.getGame().getGlobalItems());
		items.addAll(engine.getCurrentRoom().getItems());

		Item found = getVisibleItemFrom(item, items);

		if (found != null)
			return found;

		throw new InexistentRoomException(String.format("You can't see any %s here!", item.getName()));
	}

	private Item getVisibleItemFrom(Item item, List<Item> items) {
		for (Item other : items) {
			if (item.getName().equals(other.getName()))
				return other;

			if (other.is(OPEN)) {
				Item found = getVisibleItemFrom(item, other.getItems());

				if (found != null)
					return found;
			}
		}

		return null;
	}

}
