package zork.language;

import static java.util.Arrays.asList;

import java.util.List;

public class Article extends Preposition {

	@Override
	public List<String> getSynonyms() {
		return asList("THE", "A", "AN");
	}

}
