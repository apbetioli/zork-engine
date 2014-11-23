package zork.commands;

import static java.util.Arrays.asList;

import java.util.List;

import zork.Game;

public class Version extends Command {

	public Version(Game game) {
		super(game);
	}

	@Override
	public List<String> getSynonyms() {
		return asList("VERSION");
	}

	@Override
	public String execute() {
		return game.getMap().getVersion();
	}

}
