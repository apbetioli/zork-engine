package zork;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class MapLoaderTest {
	
	private MapLoader loader;
	
	@Before
	public void loadMap() {
		loader = new MapLoader();
		loader.load("map.json");
	}
	
	@Test
	public void welcome() {
		String welcome = loader.welcome();
		assertEquals("Welcome to ZORK!", welcome);
	}
	
	@Test
	public void rooms() {
		List<Room> rooms = loader.rooms();
		assertEquals(1, rooms.size());
		
		Room room = rooms.get(0);
		assertEquals("West of House", room.getName());
		assertEquals("This is an open field west of a white house, with a boarded front door.\n"
				+ "There is a small mailbox here.\n"
				+ "A rubber mat saying 'Welcome to Zork!' lies by the door.", room.getDescription());
	}

}
