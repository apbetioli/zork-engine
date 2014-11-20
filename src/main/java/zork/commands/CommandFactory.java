package zork.commands;

import java.util.HashMap;

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

		return new Unknown();
	}

	public void register(Command command) {
		for (String synonym : command.getSynonyms())
			put(synonym.trim().toUpperCase(), command);
	}

}
