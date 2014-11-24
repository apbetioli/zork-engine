package zork;

import zork.dungeon.Game;


public class ZorkEngine extends Engine {

	public ZorkEngine(Game game) {
		super(game);
	}

	@Override
	protected void registerCommands() {
		super.registerCommands();

		registerCommand(new ZorkCommand());
	}
}
