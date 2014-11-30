package zork.commands;

import static java.util.Arrays.asList;
import static zork.game.Property.CLOSED;

import java.util.List;

import zork.engine.Engine;
import zork.exceptions.FreeMoveException;

public class Examine extends Look {

	public Examine(Engine engine) {
		super(engine);
	}

	@Override
	public List<String> getSynonyms() {
		return asList("EXAMINE", "LOOK AT");
	}

	@Override
	public String execute() throws FreeMoveException {

		if (getItem() == null)
			throw new FreeMoveException("What do you want to examine?");

		if (getItem().is(CLOSED))
			return String.format("The %s is closed.", getItem().getName());

		if (!getItem().getItems().isEmpty())
			return super.lookItems(asList(getItem())).trim();

		return getItem().getDescription();
	}
}
