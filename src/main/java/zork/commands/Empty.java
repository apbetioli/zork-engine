package zork.commands;

import java.util.List;

import zork.FreeMoveException;

public class Empty extends Command {

	@Override
	public List<String> getSynonyms() {
		throw new IllegalStateException("This command must not be registered");
	}

	@Override
	public String execute() throws FreeMoveException {
		throw new FreeMoveException("I beg your pardon?");
	}

}
