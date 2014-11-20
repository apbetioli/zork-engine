package zork.commands;

import static java.util.Arrays.asList;

import java.util.List;

public class Inventory extends Command {

	@Override
	public List<String> getSynonyms() {
		return asList("INVENTORY", "I");
	}
	
	@Override
	public String execute() {
		return "You are empty-handed.";
	}

}
