package de.hegmanns.training.aoc2021.day04;

import de.hegmanns.training.aoc2021.day05.Line;
import de.hegmanns.training.aoc2021.day05.Point;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class LineTest {

    @Test
    public void shouldCreateCorrectLine() {
        String anyLineDefinition = "6,4 -> 2,0";
        Line lineFromDirection = new Line(anyLineDefinition);

        MatcherAssert.assertThat(lineFromDirection.getFrom(), Matchers.equalTo(new Point(6,4)));
        MatcherAssert.assertThat(lineFromDirection.getTo(), Matchers.equalTo(new Point(2, 0)));
    }

    @Test
    public void detectHorizontalLine() {
        String anyHorizontalLine = "6,240 -> 2787,240";
        Line line = new Line(anyHorizontalLine);

        MatcherAssert.assertThat(line.isHorizontal(), Matchers.is(true));
    }

    @Test
    public void detectVerticalLine() {
        String anyVerticalLine = "6,240 -> 6,0";
        Line line = new Line(anyVerticalLine);

        MatcherAssert.assertThat(line.isVertical(), Matchers.is(true));
    }

    @Test
    public void detectDiagonalLineFromTopToButton() {
        String anyHorizontalLineFromTopToButton = "0,0 -> 100,100";
        Line line = new Line(anyHorizontalLineFromTopToButton);
        MatcherAssert.assertThat(line.isDiagonal(), Matchers.is(true));
    }

    @Test
    public void detectDiagonalLimeFromButtonToTop() {
        String anyHorizontalLineFromButtonToTop = "100,100 -> 10,10";
        Line line = new Line(anyHorizontalLineFromButtonToTop);
        MatcherAssert.assertThat(line.isDiagonal(), Matchers.is(true));
    }
}
