package zork.commands;

import static java.util.Arrays.asList;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;

import zork.engine.Engine;
import zork.util.IOUtils;

public class Help extends Command {

	public Help(Engine engine) {
		super(engine);
	}

	@Override
	public List<String> getSynonyms() {
		return asList("HELP", "ABOUT", "INFO", "HINT");
	}

	@Override
	public String execute() {

		InputStream input = getClass().getClassLoader().getResourceAsStream("help.txt");
		ByteArrayOutputStream output = new ByteArrayOutputStream();

		IOUtils.fastCopy(input, output);

		return output.toString();
	}

}
