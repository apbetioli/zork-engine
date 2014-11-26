package zork.language;

import java.util.List;

public abstract class Preposition extends Token implements Cloneable {

	@Override
	public int getNumberOfArgs() {
		return 1;
	}

	public abstract List<String> getSynonyms();

}
