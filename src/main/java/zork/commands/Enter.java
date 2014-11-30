package zork.commands;

import static java.util.Arrays.asList;

import java.util.List;

import zork.engine.Engine;
import zork.game.Property;

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

		if (!getItem().is(Property.ENTERABLE)) {

			if (getItem().is(Property.TAKEABLE))
				return String.format("What a concept!", getItem().getName());

			return String.format("You hit your head against the %s as you attempt this feat.", getItem().getName());
		}

		String roomOrMessage = getItem().getActions().get("enter");

		if (isMessage(roomOrMessage))
			return roomOrMessage;

		engine.setCurrentRoom(roomOrMessage);
		return engine.interact("LOOK");

	}

	private boolean isMessage(String result) {
		return !engine.getRoomMap().containsKey(result);
	}

}
