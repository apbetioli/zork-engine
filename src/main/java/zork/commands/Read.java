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

		if (!item.is(READABLE))
			return String.format("How does one read a %s?", item.getName());

		String result = "";

		if (!engine.getGame().getInventory().contains(item)) {
			String taken = engine.interact("TAKE " + item.getName());
			if (!taken.equals("Taken."))
				return taken;

			result += "(Taken)\n";
		}

		return result + item.getDescription();
	}

}
