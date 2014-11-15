package zork;

import java.io.InputStream;
import java.io.InputStreamReader;

import com.google.gson.Gson;

public class MapLoader {

	public MapLoader() {
	}

	public Map load(String resource) {
		Gson gson = new Gson();
		InputStream inputStream = getClass().getClassLoader()
				.getResourceAsStream(resource);
		return gson.fromJson(new InputStreamReader(inputStream), Map.class);
	}

}
