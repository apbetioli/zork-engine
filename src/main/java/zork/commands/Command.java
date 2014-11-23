package zork.commands;

import java.util.Collections;
import java.util.List;

import zork.Engine;
import zork.dungeon.Item;

public abstract class Command {

	protected Engine engine;
	protected Item item;

	public Command() {
	}

	public Command(Engine engine) {
		this.engine = engine;
	}

	public abstract String execute();

	public List<String> getSynonyms() {
		return Collections.emptyList();
	}

	public void setItem(Item item) {
		this.item = item;
	}

}
