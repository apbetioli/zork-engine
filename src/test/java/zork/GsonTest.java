package zork;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonTest {

	@Test
	public void zorkMap() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();
		Gson gson = gsonBuilder.create();

		String json = gson.toJson(new Zork1Map());

		System.out.println(json);

		zork.dungeon.Map map = gson.fromJson(json, zork.dungeon.Map.class);

		assertNotNull(map);
	}

}
