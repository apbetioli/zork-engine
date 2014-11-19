package zork.commands;

import java.util.LinkedList;
import java.util.List;

public class UnknownCommand implements Command {

	@Override
	public List<String> getSynonyms() {
		return new LinkedList<String>();
	}
	
	@Override
	public String execute() {
		return "That is not a verb I recognize.";
	}

}
