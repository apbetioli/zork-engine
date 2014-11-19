package zork.commands;

import static java.util.Arrays.asList;

import java.util.List;


public class OpenCommand implements Command {

	@Override
	public List<String> getSynonyms() {
		return asList("OPEN");
	}
	
	@Override
	public String execute() {
		return "What do you want to open?";
	}

}
