package zork;

import static java.util.Arrays.asList;

import java.util.List;

import zork.commands.Command;

public class ZorkCommand extends Command {

	@Override
	public int getNumberOfArgs() {
		return 0;
	}

	@Override
	public List<String> getSynonyms() {
		return asList("ZORK");
	}

	@Override
	public String execute() {
		return "At your service!";
	}

}
