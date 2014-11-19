package zork.commands;

import java.util.HashMap;
import java.util.List;

public class CommandFactory extends HashMap<String, Command> {

	private static final long serialVersionUID = -4812254220176470750L;

	@Override
	public boolean containsKey(Object key) {
		return super.containsKey(key.toString().trim().toUpperCase());
	}

	@Override
	public Command get(Object key) {
		Command command = super.get(key.toString().trim().toUpperCase());
		if (command != null)
			return command;

		return new UnknownCommand();
	}

	public void register(Command command) {
		List<String> synonyms = command.getSynonyms();
		for (String synonym : synonyms)
			put(synonym.toUpperCase(), command);

	}

}
