package zork;

import zork.dungeon.Map;

public class Zork extends Game {

	public Zork(Map map) {
		super(map);
	}

	@Override
	protected void registerCommands() {
		super.registerCommands();

		registerCommand(new ZorkCommand(this));
	}
}
