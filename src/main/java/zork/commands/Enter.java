package zork.commands;

import static java.util.Arrays.asList;

import java.util.List;

import zork.engine.Engine;

public class Enter extends Command {

	public Enter(Engine engine) {
		super(engine);
	}

	@Override
	public List<String> getSynonyms() {
		return asList("ENTER");
	}

	@Override
	public String execute() {
		return null;
	}

}
