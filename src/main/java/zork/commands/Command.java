package zork.commands;

import java.util.List;

import zork.Engine;
import zork.FreeMoveException;
import zork.dungeon.Item;

public abstract class Command implements Cloneable {

	protected Engine engine;
	private List<Object> tokens;
	private boolean executed;

	public Command() {
	}

	public Command(Engine engine) {
		this.engine = engine;
	}

	public String doExecute() throws FreeMoveException {
		String result = execute();
		executed = true;
		return result;
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

	public boolean isExecuted() {
		return executed;
	}

	@Override
	public Command clone() {
		try {
			return (Command) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return this;
		}
	}
}
