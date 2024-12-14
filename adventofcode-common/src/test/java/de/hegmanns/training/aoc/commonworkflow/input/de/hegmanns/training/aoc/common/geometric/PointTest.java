package de.hegmanns.training.aoc.commonworkflow.input.de.hegmanns.training.aoc.common.geometric;

import de.hegmanns.training.aoc.common.geometric.Line;
import de.hegmanns.training.aoc.common.geometric.Point;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PointTest {

    @Test
    void pointAtBeginningOfLineIsInLine() {
        Line anyLine = new Line(new Point(0, 0), new Point(10, 0));
        Point pointAtBeginningOfLine = new Point(0, 0);

        MatcherAssert.assertThat(pointAtBeginningOfLine.isIn(anyLine), Matchers.is(true));
    }

    @Test
    void pointAtEndOfLineIsInLine() {
        Line anyLine = new Line(new Point(2, 8), new Point(256, 128));
        Point pointAtBeginningOfLine = new Point(256, 128);

        MatcherAssert.assertThat(pointAtBeginningOfLine.isIn(anyLine), Matchers.is(true));
    }

    @ParameterizedTest
    @CsvSource({"50, 0", "0, 0", "1,0", "99,0", "100,0"})
    void parallelXLineContains(int x, int y) {
        Line line = new Line(new Point(0, 0), new Point(100, 0));
        Point referencePoint = new Point(x, y);
        MatcherAssert.assertThat(referencePoint.isIn(line), Matchers.is(true));
    }

    @ParameterizedTest
    @CsvSource({"50, 1", "101, 0", "-1, 0"})
    void parallelXLineNotContains(int x, int y) {
        Line line = new Line(new Point(0, 0), new Point(100, 0));
        Point referencePoint = new Point(x, y);
        MatcherAssert.assertThat(referencePoint.isIn(line), Matchers.is(false));
    }
}
