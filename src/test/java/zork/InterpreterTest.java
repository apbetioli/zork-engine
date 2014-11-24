package zork;

import static org.junit.Assert.assertEquals;

import java.util.List;

import net.pocorall.automaton.RunAutomatonMatcher;

import org.junit.Before;
import org.junit.Test;

import zork.commands.Command;
import zork.commands.CommandFactory;
import zork.commands.Inventory;
import zork.commands.Look;
import zork.commands.Open;
import zork.commands.Take;
import zork.commands.Unknown;
import zork.dungeon.Game;

public class InterpreterTest {

	private CommandFactory commandFactory;

	@Before()
	public void init() {
		commandFactory = new CommandFactory();
		commandFactory.register(new Open());
	}

	@Test
	public void analizeUnknownCommand() {

		Dictionary dictionary = new Dictionary(commandFactory, new ZorkOne());
		Interpreter interpreter = new Interpreter(dictionary);

		Command command = interpreter.analize("ITADAKIMASU");

		assertEquals(Unknown.class, command.getClass());
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
	public void all() {
		commandFactory.register(new Look(null));
		commandFactory.register(new Take(null));

		Dictionary dictionary = new Dictionary(commandFactory, new ZorkOne());
		Interpreter interpreter = new Interpreter(dictionary);

		RunAutomatonMatcher matcher = interpreter.newMatcher("GET ALL");
		List<Object> tokens = interpreter.findAllTokens(matcher);

		assertEquals("[<Take:Command>, ALL]", tokens.toString());
	}

}
