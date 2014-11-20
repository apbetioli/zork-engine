package zork;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonTest {

	class T {
		private Map<String, Boolean> map = new HashMap<String, Boolean>();

		public Map<String, Boolean> getMap() {
			return map;
		}

		public void setMap(Map<String, Boolean> map) {
			this.map = map;
		}

	}

	@Test
	public void teste() {
		T t = new T();
		t.getMap().put("visible", true);

		GsonBuilder gson = new GsonBuilder();
		gson.setPrettyPrinting();
		String json = gson.create().toJson(t);

		System.out.println(json);

		T t2 = gson.create().fromJson(json, T.class);
		assertTrue(t2.getMap().get("visible"));

	}
	
	@Test
	public void zorkMap() {
		GsonBuilder gsonBuilder= new GsonBuilder();
		gsonBuilder.setPrettyPrinting();
		Gson gson = gsonBuilder.create();
		
		String json = gson.toJson(new Zork1Map());
		
		System.out.println(json);
		
		zork.dungeon.Map map = gson.fromJson(json, zork.dungeon.Map.class);
		
		assertNotNull(map);
	}

}
