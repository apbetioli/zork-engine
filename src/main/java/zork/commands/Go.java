package zork.commands;

import static java.util.Arrays.asList;

import java.util.List;

import zork.commands.directions.DirectionCommand;
import zork.engine.Engine;
import zork.language.Token;

public class Go extends Command {

	public Go(Engine engine) {
		super(engine);
	}

	@Override
	public List<String> getSynonyms() {
		return asList("GO", "ENTER");
	}

	@Override
	public String execute() {

		if (!getArgs().isEmpty()) {
			Token next = getArgs().iterator().next();
			if (next instanceof DirectionCommand)
				return ((Command) next).execute();

			return "You can't go that way.";
		}

		return "Where do you want to go?";
	}
}
