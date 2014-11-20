package zork.commands;

import static java.util.Arrays.asList;

import java.util.List;


public class Close extends Command {

	@Override
	public List<String> getSynonyms() {
		return asList("CLOSE");
	}
	
	@Override
	public String execute() {
		return "What do you want to close?";
	}

}
