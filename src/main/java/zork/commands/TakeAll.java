package zork.commands;

import static java.util.Arrays.asList;

import java.util.List;

import zork.Engine;
import zork.FreeMoveException;
import zork.dungeon.Item;

public class TakeAll extends Command {

	public TakeAll(Engine engine) {
		super(engine);
	}

	@Override
	public List<String> getSynonyms() {
		return asList("TAKE ALL", "GET ALL", "CATCH ALL", "PICK UP ALL");
	}

	@Override
	public String execute() throws FreeMoveException {

		String result = "";

		for (Item item : engine.getGame().getCurrentRoom().getItems()) {

			if (item.is(Property.SCENERY))
				continue;

			result += String.format("%s: %s\n", item.getName(), engine.interact("TAKE " + item.getName()));
		}

		return result;
	}

}
