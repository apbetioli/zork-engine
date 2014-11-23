package zork.commands;

import java.util.Collections;
import java.util.List;

import zork.Game;
import zork.dungeon.Item;

public abstract class Command {

	protected Game game;
	protected Item item;

	public Command() {
	}

	public Command(Game game) {
		this.game = game;
	}

	public abstract String execute();

	public List<String> getSynonyms() {
		return Collections.emptyList();
	}

	public void setItem(Item item) {
		this.item = item;
	}

}
