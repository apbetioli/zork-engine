package zork;

import org.junit.Before;

public abstract class ZorkOneBaseTest {

	protected Engine zork;

	@Before
	public void init() {
		zork = new ZorkEngine(new ZorkOne());
	}

}