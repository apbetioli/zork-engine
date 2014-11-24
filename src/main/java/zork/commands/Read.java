package zork.commands;

import static java.util.Arrays.asList;
import static zork.commands.Property.READABLE;

import java.util.List;

import zork.Engine;

public class Read extends Command {

	public Read(Engine engine) {
		super(engine);
	}

	@Override
	public List<String> getSynonyms() {
		return asList("READ");
	}

	@Override
	public String execute() {

		if (!getItem().is(READABLE))
			return String.format("How does one read a %s?", getItem().getName());

		String result = "";

		if (!engine.getGame().getInventory().contains(getItem())) {
			String taken = engine.interact("TAKE " + getItem().getName());

			if (!engine.getGame().getInventory().contains(getItem()))
				return taken;

			result += String.format("(%s)\n", taken.replace(".", ""));
		}

		return result + getItem().getDescription();
	}

}
