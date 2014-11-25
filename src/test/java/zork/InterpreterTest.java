package zork;

import static org.junit.Assert.assertEquals;
import net.pocorall.automaton.RunAutomatonMatcher;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import zork.commands.Command;
import zork.commands.CommandFactory;
import zork.commands.Inventory;
import zork.commands.Look;
import zork.commands.Open;
import zork.commands.Take;
import zork.dungeon.Game;
import zork.exceptions.UnknownCommandException;
import zork.exceptions.UnknownWordException;

public class InterpreterTest {

	private CommandFactory commandFactory;

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Before()
	public void init() {
		commandFactory = new CommandFactory();
		commandFactory.register(new Open());
	}

	@Test(expected = UnknownCommandException.class)
	public void analizeUnknownCommand() {

		Dictionary dictionary = new Dictionary(commandFactory, new ZorkOne());
		Interpreter interpreter = new Interpreter(dictionary);

		interpreter.analize("ITADAKIMASU");
	}

	@Test
	public void analizeSingleCommand() {

		commandFactory.register(new Inventory(new Engine(new Game())));
		Dictionary dictionary = new Dictionary(commandFactory, new ZorkOne());
		Interpreter interpreter = new Interpreter(dictionary);

		Command command = interpreter.analize("INVENTORY");

		assertEquals(Inventory.class, command.getClass());
	}

	@Test
	public void analizeCompositeCommand() {

		Dictionary dictionary = new Dictionary(commandFactory, new ZorkOne());
		Interpreter interpreter = new Interpreter(dictionary);

		Open command = (Open) interpreter.analize("OPEN MAILBOX");

		assertEquals(Open.class, command.getClass());
	}

	@Test
	public void dontFindTheLOfAllAsToken() {
		commandFactory.register(new Look(null));
		commandFactory.register(new Take(null));

		Dictionary dictionary = new Dictionary(commandFactory, new ZorkOne());
		Interpreter interpreter = new Interpreter(dictionary);

		RunAutomatonMatcher matcher = interpreter.newMatcher("GET ALL");

		expectedException.expect(UnknownWordException.class);
		expectedException.expectMessage("I don't know the word \"ALL\".");

		interpreter.findAllTokens(matcher);
	}

	@Test
	public void knownCommandUnknownWord() {

		commandFactory.register(new Take(null));

	}

}
