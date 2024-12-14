package de.hegmanns.training.aoc2022.day09;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class TailTest {

    @Test
    public void tailDoesntFollowBecauseItTouches() {
        Grid grid = new Grid();
        grid.getHead().setCorrespondingMovable(grid.getTail());

        grid.getHead().move(grid, MovingDirection.UP, 1);
        Position currentPosition = grid.getTail().getCurrentPosition();

        MatcherAssert.assertThat(currentPosition, Matchers.equalTo(new Position(1, 1)));

        MatcherAssert.assertThat(grid.getPositions().stream().filter(Position::isVisitedByTail).count(), Matchers.is(1L));
    }

    @Test
    public void tailFollowsOneStep() {
        Grid grid = new Grid();
        grid.getHead().setCorrespondingMovable(grid.getTail());

        grid.getHead().move(grid, MovingDirection.UP, 2);
        Position currentPosition = grid.getTail().getCurrentPosition();

        MatcherAssert.assertThat(currentPosition, Matchers.equalTo(new Position(1, 2)));

        MatcherAssert.assertThat(grid.getPositions().stream().filter(Position::isVisitedByTail).count(), Matchers.is(2L));
    }

    @Test
    public void tailFollowsOneDiagonal() {
        Grid grid = new Grid();
        grid.getHead().setCorrespondingMovable(grid.getTail());

        grid.getHead().move(grid, MovingDirection.RIGHT, 1);
        grid.getHead().move(grid, MovingDirection.UP, 2);

        Position currentTailPosition = grid.getTail().getCurrentPosition();

        MatcherAssert.assertThat(currentTailPosition, Matchers.is(new Position(2,2)));

        MatcherAssert.assertThat(grid.getPositions().stream().filter(Position::isVisitedByTail).count(), Matchers.is(2L));
    }
}
