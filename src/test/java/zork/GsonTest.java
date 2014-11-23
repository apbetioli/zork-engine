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

		String json = gson.toJson(new ZorkOne());

		System.out.println(json);

		zork.dungeon.Game game = gson.fromJson(json, zork.dungeon.Game.class);

		assertNotNull(game);
	}

}
