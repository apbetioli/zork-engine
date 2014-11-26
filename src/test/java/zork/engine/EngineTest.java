package zork.engine;

import org.junit.Before;

import zork.ZorkEngine;
import zork.ZorkOne;
import zork.engine.Engine;

public abstract class EngineTest {

	protected Engine engine;

	@Before
	public void init() {
		engine = new ZorkEngine(new ZorkOne());
	}

}