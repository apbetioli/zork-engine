package zork.commands;

import static java.util.Arrays.asList;

import java.util.List;

public class EmptyCommand implements Command {

	@Override
	public List<String> getSynonyms() {
		return asList("");
	}
	
	@Override
	public String execute() {
		return "I beg your pardon?";
	}

}
