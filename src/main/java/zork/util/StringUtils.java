package zork.util;

import java.util.ArrayList;
import java.util.List;

public class StringUtils {

	public static boolean containsIgnoreCase(List<String> list, String value) {

		for (String string : list)
			if (string.equalsIgnoreCase(value))
				return true;

		return false;
	}

	public static List<String> trimAndUpperCaseAll(List<String> list) {

		List<String> result = new ArrayList<String>(list.size());

		for (String string : list)
			result.add(string.trim().toUpperCase());

		return result;
	}

	public static List<String> trimAll(List<String> list) {

		List<String> result = new ArrayList<String>(list.size());

		for (String string : list)
			result.add(string.trim());

		return result;
	}
}
