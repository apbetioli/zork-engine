package zork.commands;

import static java.util.Arrays.asList;

import java.util.List;

import zork.dungeon.Map;

public class Version extends Command {

	private Map map;

	public Version(Map map) {
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
