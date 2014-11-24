package zork.commands;

import static java.util.Arrays.asList;

import java.util.List;

import zork.Engine;
import zork.FreeMoveException;

public class Examine extends Command {

	public Examine(Engine engine) {
		super(engine);
	}

	@Override
	public List<String> getSynonyms() {
		return asList("EXAMINE");
	}

	@Override
	public String execute() throws FreeMoveException {

		if (!itemIsVisibleFrom(getItem(), engine.getGame().getCurrentRoom()))
			return "You can't see any such thing.";

		return getItem().getDescription();
	}

}
