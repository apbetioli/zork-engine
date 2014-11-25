package zork.commands;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import zork.EngineTest;

public class ScoreCommandTest extends EngineTest {

	@Test
	public void startScore() {
		String result = engine.interact("score");

		assertEquals("Your score is 0 (total of 350 points), in 0 moves.\n"
				+ "This gives you the rank of Beginner.", result);
	}

	@Test
	public void oneMoveScore() {
		engine.interact("look");

		String result = engine.interact("score");

		assertEquals("Your score is 0 (total of 350 points), in 1 moves.\n"
				+ "This gives you the rank of Beginner.", result);
	}

	@Test
	public void oneMoveTwiceScore() {
		engine.interact("look");
		engine.interact("look");

		String result = engine.interact("score");

		assertEquals("Your score is 0 (total of 350 points), in 2 moves.\n"
				+ "This gives you the rank of Beginner.", result);
	}
}
