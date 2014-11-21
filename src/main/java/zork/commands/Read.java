package zork.commands;

import static java.util.Arrays.asList;

import java.util.List;

public class Read extends Command {

	@Override
	public List<String> getSynonyms() {
		return asList("READ");
	}

	@Override
	public String execute() {
		return "You can't see any such thing.";
	}

}
