package zork.engine;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import zork.ZorkOne;
import zork.commands.Close;
import zork.commands.Command;
import zork.commands.Inventory;
import zork.commands.Open;
import zork.exceptions.UnknownCommandException;
import zork.exceptions.UnknownWordException;
import zork.game.Game;

public class InterpreterTest {

	private Interpreter interpreter;

	@Before()
	public void init() {
		Engine engine = new Engine(new Game());

		DictionaryBuilder builder = new DictionaryBuilder()
				.addCommand(new Open())
				.addCommand(new Close())
				.addCommand(new Inventory(engine))
				.addItems(new ZorkOne());

		interpreter = new Interpreter(builder.build());
	}

	@Test(expected = UnknownWordException.class)
	public void analizeUnknownWord() {

		interpreter.analize("ITADAKIMASU");
	}

	@Test(expected = UnknownCommandException.class)
	public void analizeUnknownCommand() {

		interpreter.analize("DOOR");
	}

	@Test
	public void analizeSingleCommand() {

		Command command = interpreter.analize("INVENTORY");

		assertEquals(Inventory.class, command.getClass());
	}

	@Test
	public void analizeCompositeCommand() {

		Command command = interpreter.analize("OPEN MAILBOX");

		assertEquals(Open.class, command.getClass());
	}

	@Test
	public void newEmptyCommandEveryTime() {

		Command command = interpreter.analize("OPEN MAILBOX");

		assertEquals(1, command.getArgs().size());

		Command command2 = interpreter.analize("OPEN MAILBOX");

		assertEquals(1, command2.getArgs().size());
	}

	@Test(expected = UnknownCommandException.class)
	public void notACommand() {
		interpreter.analize("OPEN BOX");

		Command command = interpreter.analize("DOOR");

		String result = command.execute();
		System.out.println(result);
	}
}
