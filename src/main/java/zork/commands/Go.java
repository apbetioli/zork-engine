package zork.commands;

import static java.util.Arrays.asList;

import java.util.List;

import zork.commands.directions.Direction;
import zork.engine.Engine;
import zork.language.Token;

public class Go extends Command {

	public Go(Engine engine) {
		super(engine);
	}

	@Override
	public List<String> getSynonyms() {
		return asList("GO");
	}

	@Override
	public String execute() {

		if (!getArgs().isEmpty()) {
			Token next = getArgs().iterator().next();
			if (next instanceof Direction)
				return ((Command) next).execute();
		}

		return "Where do you want to go?";
	}
}
