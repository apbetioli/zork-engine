package zork.language.prepositions;

import static java.util.Arrays.asList;

import java.util.List;

import zork.language.Preposition;

public class The extends Preposition {

	@Override
	public List<String> getSynonyms() {
		return asList("THE");
	}

}
