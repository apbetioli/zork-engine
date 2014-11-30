package zork.commands;

import static java.util.Arrays.asList;
import static zork.game.Property.TAKEABLE;

import java.util.List;

import zork.engine.Engine;

public class Move extends Command {

	public Move(Engine engine) {
		super(engine);
	}

	@Override
	public List<String> getSynonyms() {
		return asList("MOVE");
	}

	@Override
	public String execute() {

		String message = getItem().getActions().get("move");

		if (message != null)
			return message;

		if (getItem().is(TAKEABLE))
			return String.format("Moving the %s reveals nothing.", getItem().getName());

		return String.format("You can't move the %s.", getItem().getName());

	}

}
