package zork.commands;

import static java.util.Arrays.asList;

import java.util.List;

import zork.Engine;
import zork.dungeon.Score;
import zork.exceptions.FreeMoveException;

public class ScoreCommand extends Command {

	public ScoreCommand(Engine engine) {
		super(engine);
	}

	@Override
	public List<String> getSynonyms() {
		return asList("SCORE");
	}

	@Override
	public String execute() throws FreeMoveException {

		Score ranking = engine.getGame().getScore();

		int score = ranking.getScore();
		int total = ranking.getTotal();
		int moves = ranking.getMoves();
		String rank = ranking.getRank();

		throw new FreeMoveException(String.format("Your score is %d (total of %d points), in %d moves.\n"
				+ "This gives you the rank of %s.", score, total, moves, rank));
	}
}
