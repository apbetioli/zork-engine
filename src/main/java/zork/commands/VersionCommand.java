package zork.commands;

import static java.util.Arrays.asList;

import java.util.List;

import zork.dungeon.Map;

public class VersionCommand implements Command {

	private Map map;

	public VersionCommand(Map map) {
		this.map = map;
	}

	@Override
	public List<String> getSynonyms() {
		return asList("VERSION");
	}

	@Override
	public String execute() {
		return map.getVersion();
	}

}
