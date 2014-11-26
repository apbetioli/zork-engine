package zork;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import zork.commands.Command;
import zork.commands.Inventory;
import zork.commands.Open;
import zork.dungeon.Game;
import zork.exceptions.UnknownCommandException;

public class InterpreterTest {

	private Interpreter interpreter;

	@Before()
	public void init() {
		Engine engine = new Engine(new Game());

		DictionaryBuilder builder = new DictionaryBuilder()
				.addCommand(new Open())
				.addCommand(new Inventory(engine))
				.addItems(new ZorkOne());

		interpreter = new Interpreter(builder.build());
	}

	@Test(expected = UnknownCommandException.class)
	public void analizeUnknownCommand() {

		interpreter.analize("ITADAKIMASU");
	}

	@Test
	public void analizeSingleCommand() {

		Command command = interpreter.analize("INVENTORY");

		assertEquals(Inventory.class, command.getClass());
	}

	@Test
	public void analizeCompositeCommand() {

		Open command = (Open) interpreter.analize("OPEN MAILBOX");

		assertEquals(Open.class, command.getClass());
	}

	@Test
	public void newEmptyCommandEveryTime() {

		Open command = (Open) interpreter.analize("OPEN MAILBOX");

		assertEquals(1, command.getArgs().size());

		Open command2 = (Open) interpreter.analize("OPEN MAILBOX");

		assertEquals(1, command2.getArgs().size());
	}
}
