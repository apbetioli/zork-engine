package zork;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import zork.dungeon.Item;
import zork.dungeon.Map;
import zork.interpreter.Interpreter;
import zork.interpreter.Parser;

public class Zork {

	private Map map;

	private String todo;

	private Interpreter interpreter;

	public Zork(Map map) {
		this.map = map;

		interpreter = new Interpreter(map);
	}

	public String interact(String input) {

		input = input.trim().toUpperCase();
		if (input.isEmpty())
			return "I beg your pardon?";

		Parser parser = interpreter.parse(input);

		return interact(parser);

	}

	private String interact(Parser parser) {
		String output = "That is not a verb I recognize.";

		if (parser.hasMoreTokens()) {

			String token = parser.nextToken();

			if (todo != null) {
				try {
					List<Item> items = map.getVisibleItems();
					for (Item item : items) {
						if (item.getName().toUpperCase().contains(token))
							return item.execute(todo);
					}
				} finally {
				}
			}

			try {
				Verb verb = Verb.valueOf(token);
				output = verb.execute(map);
			} catch (IllegalArgumentException e) {
			}

			todo = token;
			
			if (parser.hasMoreTokens())
				return interact(parser);
		}

		return output;
	}

}
