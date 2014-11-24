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

		if (item == null)
			throw new FreeMoveException("What do you want to close?");

		if (item.is(CLOSED))
			return "That's already closed.";

		if (!item.is(CLOSABLE))
			return String.format("You must tell me how to do that to a %s.", item.getName());

		item.addProperties(CLOSED);
		item.removeProperties(OPEN);

		return "Closed.";
	}

}
