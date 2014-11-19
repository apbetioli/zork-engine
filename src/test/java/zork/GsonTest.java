package zork;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

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
}
