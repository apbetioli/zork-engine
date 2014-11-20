package zork.commands;

import static java.util.Arrays.asList;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import zork.dungeon.Item;
import zork.dungeon.Map;

public class Open extends Command {

	private Map map;

	public Open(Map map) {
		this.map = map;
	}

	@Override
	public List<String> getSynonyms() {
		return asList("OPEN");
	}

	@Override
	public String execute() {

		if (!getParser().hasMoreTokens())
			return "What do you want to open?";

		String object = getParser().nextToken();

		for (Item item : map.getCurrentRoom().getItems()) 
			for (String synonym : item.getSynonyms()) 
				if (synonym.trim().equalsIgnoreCase(object))
					return String.format("Opening the %s reveals a %s", item.getName(), StringUtils.join(item.getItems(), ", ") + ".");

		return "You must tell me how to do that to a " + object.toLowerCase() + ".";
	}

}
