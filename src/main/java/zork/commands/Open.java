package zork.commands;

import static java.util.Arrays.asList;
import static zork.game.Property.CLOSED;
import static zork.game.Property.OPEN;
import static zork.game.Property.OPENABLE;
import static zork.game.Property.SCENERY;

import java.util.List;

import zork.engine.Engine;
import zork.exceptions.FreeMoveException;

public class Open extends Command {

	public Open(Engine engine) {
		super(engine);
	}

	@Override
	public List<String> getSynonyms() {
		return asList("OPEN");
	}

	@Override
	public String execute() throws FreeMoveException {

		if (getItem() == null)
			throw new FreeMoveException("What do you want to open?");

		if (getItem().is(OPEN))
			return "It is already open.";

		if (getItem().is(SCENERY))
			return String.format("The %s cannot be opened.", getItem().getName());

		if (!getItem().is(OPENABLE))
			return String.format("You must tell me how to do that to a %s.", getItem().getName());

		getItem().addProperties(OPEN);
		getItem().removeProperties(CLOSED);

		return getItem().getDescription();
	}
}
