package zork.commands;

import static java.util.Arrays.asList;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import zork.util.IOUtils;

public class Help extends Command {

	@Override
	public List<String> getSynonyms() {
		return asList("HELP", "ABOUT", "INFO", "HINT");
	}

	@Override
	public String execute() {

		InputStream input = getClass().getClassLoader().getResourceAsStream("help.txt");
		ByteArrayOutputStream output = new ByteArrayOutputStream();

		try {
			IOUtils.fastCopy(input, output);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return output.toString();
	}

}
