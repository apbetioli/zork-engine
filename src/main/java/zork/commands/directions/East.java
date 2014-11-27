package zork.commands.directions;

import static java.util.Arrays.asList;

import java.util.List;

import zork.commands.Command;
import zork.engine.Engine;

public class East extends Command implements Direction {

	public East(Engine engine) {
		super(engine);
	}

	@Override
	public List<String> getSynonyms() {
		return asList("E", "EAST");
	}

	@Override
	public String execute() {
		return "East";
	}

}
