package zork.commands;

import static java.util.Arrays.asList;
import static zork.game.Property.READABLE;

import java.util.List;

import zork.engine.Engine;
import zork.exceptions.FreeMoveException;

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

		if (getItem() == null)
			throw new FreeMoveException("What do you want to read?");

		if (!getItem().is(READABLE))
			return String.format("How does one read a %s?", getItem().getName());

		String result = "";

		if (!engine.getGame().getInventory().contains(getItem())) {
			String taken = engine.interact("TAKE " + getItem().getName());

			result += String.format("(%s)\n", taken.replace(".", ""));
		}

		return result + getItem().getDescription();
	}

}
