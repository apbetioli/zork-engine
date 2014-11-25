package zork.commands;

import static java.util.Arrays.asList;

import java.util.List;

import zork.Engine;
import zork.exceptions.FreeMoveException;

public class Examine extends Command {

	public Examine(Engine engine) {
		super(engine);
	}

	@Override
	public List<String> getSynonyms() {
		return asList("EXAMINE", "LOOK AT");
	}

	@Override
	public String execute() throws FreeMoveException {

		if (!isItemVisible(getItem()))
			return "You can't see any such thing.";

		return getItem().getDescription();
	}

}