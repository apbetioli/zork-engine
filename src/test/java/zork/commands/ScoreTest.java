package zork.commands;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import zork.ZorkOneBaseTest;

public class ScoreTest extends ZorkOneBaseTest {

	@Test
	public void startScore() {
		String result = zork.interact("score");

		assertEquals("Your score is 0 (total of 350 points), in 0 moves.\n"
				+ "This gives you the rank of Beginner.", result);
	}

	@Test
	public void oneMoveScore() {
		zork.interact("look");

		String result = zork.interact("score");

		assertEquals("Your score is 0 (total of 350 points), in 1 moves.\n"
				+ "This gives you the rank of Beginner.", result);
	}

	@Test
	public void oneMoveTwiceScore() {
		zork.interact("look");
		zork.interact("look");

		String result = zork.interact("score");

		assertEquals("Your score is 0 (total of 350 points), in 2 moves.\n"
				+ "This gives you the rank of Beginner.", result);
	}
}
