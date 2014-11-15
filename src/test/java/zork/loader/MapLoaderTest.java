package zork.loader;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import zork.loader.MapLoader;
import zork.objects.Map;
import zork.objects.Room;

public class MapLoaderTest {
	
	private Map map;
	
	@Before
	public void loadMap() {
		MapLoader loader = new MapLoader();
		map = loader.load("map.json");
	}
	
	@Test
	public void welcome() {
		String welcome = map.getWelcome();
		assertEquals("Welcome to ZORK!", welcome);
	}
	
	@Test
	public void rooms() {
		List<Room> rooms = map.getRooms();
		assertEquals(1, rooms.size());
		
		Room room = rooms.get(0);
		assertEquals("West of House", room.getName());
		assertEquals("This is an open field west of a white house, with a boarded front door.\n"
				+ "There is a small mailbox here.\n"
				+ "A rubber mat saying 'Welcome to Zork!' lies by the door.", room.getDescription());
	}

}
