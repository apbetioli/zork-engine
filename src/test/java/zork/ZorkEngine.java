package zork;

import java.util.List;

import zork.commands.Command;
import zork.engine.Engine;
import zork.game.Game;

public class ZorkEngine extends Engine {

	public ZorkEngine(Game game) {
		super(game);
	}

	@Override
	protected List<Command> defineCommands() {
		List<Command> commands = super.defineCommands();

		commands.add(new ZorkCommand(this));

		return commands;
	}

}
