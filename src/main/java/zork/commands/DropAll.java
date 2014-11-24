package zork.commands;

import static java.util.Arrays.asList;

import java.util.List;

import zork.Engine;
import zork.FreeMoveException;
import zork.dungeon.Item;

public class DropAll extends Command {

	public DropAll(Engine engine) {
		super(engine);
	}

	@Override
	public List<String> getSynonyms() {
		return asList("DROP ALL", "LEAVE ALL");
	}

	@Override
	public String execute() throws FreeMoveException {

		if (engine.getGame().getInventory().isEmpty())
			return "You are empty-handed.";

		String result = "";

		for (Item item : engine.getGame().getInventory())
			result += String.format("%s: %s\n", item.getName(), engine.interact("DROP " + item.getName()));

		return result;
	}

}
