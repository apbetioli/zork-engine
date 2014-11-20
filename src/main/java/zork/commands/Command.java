package zork.commands;

import java.util.Collections;
import java.util.List;

import zork.interpreter.Parser;

public abstract class Command {

	private Parser parser;

	public abstract String execute();

	public List<String> getSynonyms() {
		return Collections.emptyList();
	}

	public void setParser(Parser parser) {
		this.parser = parser;
	}
	
	public Parser getParser() {
		return parser;
	}

}
