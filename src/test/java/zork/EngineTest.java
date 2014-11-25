package zork;

import org.junit.Before;

public abstract class EngineTest {

	protected Engine engine;

	@Before
	public void init() {
		engine = new ZorkEngine(new ZorkOne());
	}

}