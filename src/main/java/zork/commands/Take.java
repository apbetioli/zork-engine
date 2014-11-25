package zork.commands;

import static java.util.Arrays.asList;
import static zork.commands.Property.FIXED;
import static zork.commands.Property.TAKEABLE;

import java.util.List;

import zork.Engine;

public class Take extends Command {

	public Take(Engine engine) {
		super(engine);
	}

	@Override
	public List<String> getSynonyms() {
		return asList("TAKE", "GET", "CATCH", "PICK UP");
	}

	@Override
	public String execute() {

		if (getItem() == null)
			return "What do you want to take?";

		if (getItem().is(FIXED))
			return "It is securely anchored.";

		if (!getItem().is(TAKEABLE))
			return "An interesting idea...";

		if (!isItemVisible(getItem()))
			return "You can't see any such thing.";

		if (engine.getGame().getInventory().contains(getItem()))
			return "You already have that!";

		engine.getGame().getInventory().add(getItem());

		return "Taken.";
	}

}
