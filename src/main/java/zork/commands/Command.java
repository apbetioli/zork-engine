package zork.commands;

import java.util.Collections;
import java.util.List;

import zork.dungeon.Item;

public abstract class Command {

	protected Item item;

	public abstract String execute();

	public List<String> getSynonyms() {
		return Collections.emptyList();
	}

	public void setItem(Item item) {
		this.item = item;
	}

}
