package zork.commands;

import static java.util.Arrays.asList;

import java.util.List;

import zork.Engine;
import zork.exceptions.FreeMoveException;

public class Drop extends Command {

	public Drop(Engine engine) {
		super(engine);
	}

	@Override
	public List<String> getSynonyms() {
		return asList("DROP", "LEAVE");
	}

	@Override
	public String execute() throws FreeMoveException {

		if (!engine.getGame().getInventory().contains(getItem()))
			return String.format("You don't have the %s!", getItem().getName());

		engine.getGame().getInventory().remove(getItem());

		return "Dropped.";
	}

}
