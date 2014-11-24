package zork.commands;

import static java.util.Arrays.asList;
import static zork.commands.Property.CLOSABLE;
import static zork.commands.Property.CLOSED;
import static zork.commands.Property.OPEN;

import java.util.List;

import zork.FreeMoveException;

public class Close extends Command {

	@Override
	public List<String> getSynonyms() {
		return asList("CLOSE");
	}

	@Override
	public String execute() throws FreeMoveException {

		if (getItem() == null)
			throw new FreeMoveException("What do you want to close?");

		if (getItem().is(CLOSED))
			return "That's already closed.";

		if (!getItem().is(CLOSABLE))
			return String.format("You must tell me how to do that to a %s.", getItem().getName());

		getItem().addProperties(CLOSED);
		getItem().removeProperties(OPEN);

		return "Closed.";
	}

}
