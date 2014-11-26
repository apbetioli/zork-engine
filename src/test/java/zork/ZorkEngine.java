package zork;

import java.util.Set;

import zork.commands.Command;
import zork.engine.Engine;
import zork.game.Game;

public class ZorkEngine extends Engine {

	public ZorkEngine(Game game) {
		super(game);
	}

	@Override
	protected Set<Command> defineCommands() {
		Set<Command> commands = super.defineCommands();

		commands.add(new ZorkCommand());

		return commands;
	}

}
