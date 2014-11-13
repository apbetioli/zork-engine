package zork;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.google.gson.Gson;

public class MapLoader {

	private Map map;

	public MapLoader() {
	}

	public void load(String resource) {
		Gson gson = new Gson();
		InputStream inputStream = getClass().getClassLoader()
				.getResourceAsStream(resource);
		map = gson.fromJson(new InputStreamReader(inputStream), Map.class);
	}

	public String welcome() {
		return map.getWelcome();
	}

	public List<Room> rooms() {
		return map.getRooms();
	}

}
