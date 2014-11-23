package zork;

import static java.util.Arrays.asList;

import java.util.List;

import zork.commands.Command;

public class ZorkCommand extends Command {

	public ZorkCommand(Zork zork) {
		super(zork);
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
