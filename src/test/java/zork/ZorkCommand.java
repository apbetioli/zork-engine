package zork;

import static java.util.Arrays.asList;

import java.util.List;

import zork.commands.Command;
import zork.engine.Engine;

public class ZorkCommand extends Command {

	public ZorkCommand(Engine engine) {
		super(engine);
	}

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
