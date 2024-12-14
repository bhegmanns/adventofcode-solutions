package de.hegmanns.training.aoc2023.day02;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class GrapTest {

    @Test
    public void shouldParseCompleteColors() {
        String line = "3 blue, 4 red, 2 green";
        Grap grap = new Grap(line);

        MatcherAssert.assertThat(grap.getGrappedColor(Color.GREEN), Matchers.is(2L));
        MatcherAssert.assertThat(grap.getGrappedColor(Color.BLUE), Matchers.is(3L));
        MatcherAssert.assertThat(grap.getGrappedColor(Color.RED), Matchers.is(4L));
    }

    @Test
    public void shouldParseNotCompleteColors() {
        String line = "3 blue, 2 green";
        Grap grap = new Grap(line);

        MatcherAssert.assertThat(grap.getGrappedColor(Color.GREEN), Matchers.is(2L));
        MatcherAssert.assertThat(grap.getGrappedColor(Color.BLUE), Matchers.is(3L));
        MatcherAssert.assertThat(grap.getGrappedColor(Color.RED), Matchers.is(0L));
    }

    @Test
    public void shouldParseNullLine() {
        String line = null;
        Grap grap = new Grap(line);

        MatcherAssert.assertThat(grap.getGrappedColor(Color.GREEN), Matchers.is(0L));
        MatcherAssert.assertThat(grap.getGrappedColor(Color.BLUE), Matchers.is(0L));
        MatcherAssert.assertThat(grap.getGrappedColor(Color.RED), Matchers.is(0L));
    }

    @Test
    public void shouldParseEmptyLine() {
        String line = "";
        Grap grap = new Grap(line);

        MatcherAssert.assertThat(grap.getGrappedColor(Color.GREEN), Matchers.is(0L));
        MatcherAssert.assertThat(grap.getGrappedColor(Color.BLUE), Matchers.is(0L));
        MatcherAssert.assertThat(grap.getGrappedColor(Color.RED), Matchers.is(0L));
    }

    @Test
    public void shouldParseWhitespaces() {
        String line = "   ";
        Grap grap = new Grap(line);

        MatcherAssert.assertThat(grap.getGrappedColor(Color.GREEN), Matchers.is(0L));
        MatcherAssert.assertThat(grap.getGrappedColor(Color.BLUE), Matchers.is(0L));
        MatcherAssert.assertThat(grap.getGrappedColor(Color.RED), Matchers.is(0L));
    }

    @Test
    public void shouldParseWithMoreWhitespacesBetweenGrapDefinition() {
        String line = "  3   blue,   4   red, 2   green  ";
        Grap grap = new Grap(line);

        MatcherAssert.assertThat(grap.getGrappedColor(Color.GREEN), Matchers.is(2L));
        MatcherAssert.assertThat(grap.getGrappedColor(Color.BLUE), Matchers.is(3L));
        MatcherAssert.assertThat(grap.getGrappedColor(Color.RED), Matchers.is(4L));
    }

    @Test
    public void shouldParseNotDefinedColor() {
        String line = "3 blue, 4 red, 1 orange, 2 green";
        Grap grap = new Grap(line);

        MatcherAssert.assertThat(grap.getGrappedColor(Color.GREEN), Matchers.is(2L));
        MatcherAssert.assertThat(grap.getGrappedColor(Color.BLUE), Matchers.is(3L));
        MatcherAssert.assertThat(grap.getGrappedColor(Color.RED), Matchers.is(4L));
    }
}
