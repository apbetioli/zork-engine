package zork.commands;

import static java.util.Arrays.asList;

import java.util.List;


public class CloseCommand implements Command {

	@Override
	public List<String> getSynonyms() {
		return asList("CLOSE");
	}
	
	@Override
	public String execute() {
		return "What do you want to close?";
	}

}
