package zork.commands;

import static java.util.Arrays.asList;

import java.util.List;

import zork.Engine;
import zork.exceptions.FreeMoveException;

public class Version extends Command {

	public Version(Engine engine) {
		super(engine);
	}

	@Override
	public List<String> getSynonyms() {
		return asList("VERSION");
	}

	@Override
	public String execute() throws FreeMoveException {
		throw new FreeMoveException(engine.getGame().getVersion());
	}
}
