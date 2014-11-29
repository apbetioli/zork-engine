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

		String result = getItem().getActions().get("enter");

		if (!engine.getRoomMap().containsKey(result))
			return result;

		engine.setCurrentRoom(result);
		return engine.interact("LOOK");
	}

}
