package zork.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class StringUtilsTest {

	@Test
	public void coverage() {
		new StringUtils();
	}

	@Test
	public void containsIgnoreCase() {
		List<String> list = new ArrayList<String>();
		list.add("open");
		list.add("CLOSE");

		assertTrue(StringUtils.containsIgnoreCase(list, "OPEN"));
		assertTrue(StringUtils.containsIgnoreCase(list, "close"));
		assertFalse(StringUtils.containsIgnoreCase(list, "closen"));
	}

	@Test
	public void trimAndUpperCaseList() {
		List<String> list = new ArrayList<String>();
		list.add("  open");
		list.add("close  ");

		assertEquals("[OPEN, CLOSE]", StringUtils.trimAndUpperCaseAll(list).toString());
	}

	@Test
	public void trimAll() {
		List<String> list = new ArrayList<String>();
		list.add("  open");
		list.add("close  ");

		assertEquals("[open, close]", StringUtils.trimAll(list).toString());
	}
}
