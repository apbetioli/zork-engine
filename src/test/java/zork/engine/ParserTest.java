package zork.engine;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import zork.ZorkOne;
import zork.commands.Look;
import zork.commands.Take;
import zork.engine.DictionaryBuilder;
import zork.engine.Engine;
import zork.engine.Parser;
import zork.exceptions.UnknownWordException;
import zork.game.Game;

public class ParserTest {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	private Parser parser;

	@Before()
	public void init() {
		Engine engine = new Engine(new Game());

		DictionaryBuilder builder = new DictionaryBuilder()
				.addItems(new ZorkOne())
				.addCommand(new Look(engine))
				.addCommand(new Take(engine));

		parser = new Parser(builder.build());
	}

	@Test
	public void dontFindTheLOfAllAsToken() {

		expectedException.expect(UnknownWordException.class);
		expectedException.expectMessage("I don't know the word \"ALL\".");

		parser.tokenize("GET ALL");
	}

}
