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

		List<Item> items = engine.getGame().getCurrentRoom().getItems();
		for (Item item : items)
			result += item.getName() + ": " + engine.interact("TAKE " + item.getName()) + "\n";

		return result;
	}

}
