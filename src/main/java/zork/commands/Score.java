package zork.commands;

import static java.util.Arrays.asList;

import java.util.List;

import zork.Engine;
import zork.FreeMoveException;
import zork.dungeon.Rank;

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

		Rank ranking = engine.getGame().getRank();

		int score = ranking.getScore();
		int total = ranking.getTotal();
		int moves = ranking.getMoves();
		String rank = ranking.getRank();

		throw new FreeMoveException(String.format("Your score is %d (total of %d points), in %d moves.\n"
				+ "This gives you the rank of %s.", score, total, moves, rank));
	}
}
