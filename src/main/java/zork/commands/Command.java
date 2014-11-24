package zork.commands;

import java.util.List;

import zork.Engine;
import zork.FreeMoveException;
import zork.dungeon.Item;

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

}
