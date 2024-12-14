package de.hegmanns.training.aoc2022.day09;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class HeadTest {

    @Test
    public void movementToCorrectPosition() {
        Grid grid = new Grid();
        grid.getHead().setCorrespondingMovable(grid.getTail());

        Position expectedStartPosition = new Position(1, 1);
        MatcherAssert.assertThat(grid.getHead().getCurrentPosition(), Matchers.is(expectedStartPosition));

        grid.getHead().move(grid, MovingDirection.UP, 1);
        Position expectedPosition = new Position(1, 2);

        MatcherAssert.assertThat(grid.getHead().getCurrentPosition(), Matchers.is(expectedPosition));
    }

    @Test
    public void movementToCurrentPositionWith10Amount() {
        Grid grid = new Grid();
        grid.getHead().setCorrespondingMovable(grid.getTail());

        Position expectedStartPosition = new Position(1, 1);
        MatcherAssert.assertThat(grid.getHead().getCurrentPosition(), Matchers.is(expectedStartPosition));

        grid.getHead().move(grid, MovingDirection.UP, 10);
        Position expectedPosition = new Position(1, 11);

        MatcherAssert.assertThat(grid.getHead().getCurrentPosition(), Matchers.is(expectedPosition));
    }
}
