package zork.commands;

import java.util.List;

public interface Command {

	String execute();

	List<String> getSynonyms();

}
