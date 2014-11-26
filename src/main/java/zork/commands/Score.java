package zork.commands;

import static java.util.Arrays.asList;

import java.util.List;

import zork.engine.Engine;
import zork.exceptions.FreeMoveException;
import zork.game.Stats;

public class Score extends Command {

	public Score(Engine engine) {
		super(engine);
	}

	@Override
	public List<String> getSynonyms() {
		return asList("SCORE");
	}

	@Override
	public String execute() throws FreeMoveException {

		Stats stats = engine.getGame().getStats();

		int score = stats.getScore();
		int total = stats.getTotal();
		int moves = stats.getMoves();
		String rank = stats.getRank();

		throw new FreeMoveException(String.format("Your score is %d (total of %d points), in %d moves.\n"
				+ "This gives you the rank of %s.", score, total, moves, rank));
	}
}
