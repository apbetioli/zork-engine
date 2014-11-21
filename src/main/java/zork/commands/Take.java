package zork.commands;

import static java.util.Arrays.asList;

import java.util.List;

import zork.dungeon.Map;

public class Take extends Command {

	private Map map;

	public Take(Map map) {
		this.map = map;
	}

	@Override
	public List<String> getSynonyms() {
		return asList("TAKE", "GET", "CATCH", "PICK UP");
	}

	@Override
	public String execute() {

		if (item.is(Property.FIXED))
			return "It is securely anchored.";

		if (!item.is(Property.TAKEABLE))
			return "An interesting idea...";

		map.getInventory().add(item);

		return "Taken.";
	}

}
