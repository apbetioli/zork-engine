package zork.language;

import java.util.List;

public abstract class Preposition extends Word {

	public Preposition() {
		setDepth(1);
	}

	public abstract List<String> getSynonyms();

}
