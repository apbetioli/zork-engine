package zork.commands;

import java.util.List;

import zork.Engine;
import zork.FreeMoveException;
import zork.dungeon.Item;

public abstract class Command {

	protected Engine engine;
	protected Item item;

	public Command() {
	}

	public Command(Engine engine) {
		this.engine = engine;
	}

	public abstract String execute() throws FreeMoveException;

	public abstract List<String> getSynonyms();

	public void setItem(Item item) {
		this.item = item;
	}

}
