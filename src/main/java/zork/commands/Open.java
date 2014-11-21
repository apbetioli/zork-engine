package zork.commands;

import static java.util.Arrays.asList;
import static zork.commands.Property.CLOSED;
import static zork.commands.Property.OPEN;
import static zork.commands.Property.OPENABLE;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class Open extends Command {

	@Override
	public List<String> getSynonyms() {
		return asList("OPEN");
	}

	@Override
	public String execute() {

		if (item == null)
			return "What do you want to open?";

		if (item.is(OPEN))
			return "It is already open.";

		if (!item.is(OPENABLE))
			return String.format("You must tell me how to do that to a %s.", item.getName());

		item.addProperties(OPEN);
		item.removeProperties(CLOSED);

		return String.format("Opening the %s reveals a %s", item.getName(), StringUtils.join(item.getItems(), ", ") + ".");
	}
}
