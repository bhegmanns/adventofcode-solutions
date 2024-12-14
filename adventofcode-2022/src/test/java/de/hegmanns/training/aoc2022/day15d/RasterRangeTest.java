package de.hegmanns.training.aoc2022.day15d;

import de.hegmanns.training.aoc2022.day14.RasterRange;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RasterRangeTest {

/*
    public void includedButNotOverlapped() {
        RasterRange r1 = new RasterRange(10, 51);
        RasterRange r2 = new RasterRange(20, 31);

        MatcherAssert.assertThat(r1.contains(r2), Matchers.is(true));
        MatcherAssert.assertThat(r1.isOverlapped(r2), Matchers.is(false));
    }


    public void foo() {
        RasterRange r1 = new RasterRange(10, 51);
        RasterRange r2 = new RasterRange(20, 100);

        MatcherAssert.assertThat(r1.contains(r2), Matchers.is(false));
        MatcherAssert.assertThat(r1.isOverlapped(r2), Matchers.is(true));
    }

    @Test
    public void reduceSameResultsInEmpty() {
        RasterRange r1 = new RasterRange(10, 51);
        RasterRange r2 = new RasterRange(10, 51);

        MatcherAssert.assertThat(r1.reduce(r2), Matchers.hasSize(0));
    }

    @Test
    public void reduceBiggerResultsInEmpty() {
        RasterRange r1 = new RasterRange(10, 51);
        RasterRange r2 = new RasterRange(9, 52);

        MatcherAssert.assertThat(r1.reduce(r2), Matchers.hasSize(0));
    }

    @Test
    public void reduceInsideResultsInTwoRanges() {
        RasterRange r1 = new RasterRange(10, 51);
        RasterRange r2 = new RasterRange(31, 40);

        List<RasterRange> reduceResult = r1.reduce(r2);

        MatcherAssert.assertThat(reduceResult, Matchers.hasSize(2));
 //       MatcherAssert.assertThat(reduceResult.get(0), Matchers.equalTo(new RasterRange(10, 30)));
        MatcherAssert.assertThat(reduceResult.get(1), Matchers.equalTo(new RasterRange(41, 51)));
    }

    @Test
    public void reduceRightOverlapped() {
        RasterRange r1 = new RasterRange(10, 51);
        RasterRange r2 = new RasterRange(31, 70);

        List<RasterRange> reduceResult = r1.reduce(r2);

        MatcherAssert.assertThat(reduceResult, Matchers.hasSize(1));
        MatcherAssert.assertThat(reduceResult.get(0), Matchers.equalTo(new RasterRange(10, 30)));
    }

    @Test
    public void reduceLeftOverlapped() {
        RasterRange r1 = new RasterRange(10, 51);
        RasterRange r2 = new RasterRange(5, 20);

        List<RasterRange> reduceResult = r1.reduce(r2);

        MatcherAssert.assertThat(reduceResult, Matchers.hasSize(1));
        MatcherAssert.assertThat(reduceResult.get(0), Matchers.equalTo(new RasterRange(21, 51)));
    }

    @Test
    public void reduceWithDistinctLeft() {
        RasterRange r1 = new RasterRange(10, 51);
        RasterRange r2 = new RasterRange(1, 9);

        List<RasterRange> reduceResult = r1.reduce(r2);

        MatcherAssert.assertThat(reduceResult, Matchers.hasSize(1));
        MatcherAssert.assertThat(reduceResult.get(0), Matchers.equalTo(new RasterRange(10, 51)));
    }

    @Test
    public void reduceWithDistinctRight() {
        RasterRange r1 = new RasterRange(10, 51);
        RasterRange r2 = new RasterRange(52, 100);

        List<RasterRange> reduceResult = r1.reduce(r2);

        MatcherAssert.assertThat(reduceResult, Matchers.hasSize(1));
        MatcherAssert.assertThat(reduceResult.get(0), Matchers.equalTo(new RasterRange(10, 51)));
    }

    @Test
    public void reduceIncludedBeginningLeft() {
        RasterRange r1 = new RasterRange(10, 51);
        RasterRange r2 = new RasterRange(10, 20);

        List<RasterRange> reduceResult = r1.reduce(r2);

        MatcherAssert.assertThat(reduceResult, Matchers.hasSize(1));
        MatcherAssert.assertThat(reduceResult.get(0), Matchers.equalTo(new RasterRange(21, 51)));
    }

    @Test
    public void reduceIncludedEndingRight() {
        RasterRange r1 = new RasterRange(10, 51);
        RasterRange r2 = new RasterRange(40, 51);

        List<RasterRange> reduceResult = r1.reduce(r2);

        MatcherAssert.assertThat(reduceResult, Matchers.hasSize(1));
        MatcherAssert.assertThat(reduceResult.get(0), Matchers.equalTo(new RasterRange(10, 39)));
    }

 */
}
