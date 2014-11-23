package zork.commands;

import static java.util.Arrays.asList;
import static zork.commands.Property.READABLE;

import java.util.List;

import zork.Game;

public class Read extends Command {

	public Read(Game game) {
		super(game);
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

		if (!game.getMap().getInventory().contains(item)) {
			String taken = game.interact("TAKE " + item.getName());
			if (!taken.equals("Taken."))
				return taken;

			result += "(Taken)\n";
		}

		return result + item.getDescription();
	}

}
