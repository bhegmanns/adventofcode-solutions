package de.hegmanns.training.aoc2022.day15d;

import de.hegmanns.training.aoc2022.day14.RasterRange;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RasterRangeNotExcludedTest {

    /*
    @Test
    public void newCreateRange() {
        RasterRange anyRasterRange = new RasterRange(11, 21);

        MatcherAssert.assertThat(anyRasterRange.calculateNoExcludedCountOfPositions(), Matchers.is(11L));
    }

    @Test
    public void rangeInside() {
        RasterRange anyRasterRange = new RasterRange(11, 21);

        RasterRange rangeInside = new RasterRange(15, 17);
        anyRasterRange.exclude(rangeInside);

        MatcherAssert.assertThat(anyRasterRange.calculateNoExcludedCountOfPositions(), Matchers.is(8L));
    }

    @Test
    public void rangeTwoInside() {
        RasterRange anyRasterRange = new RasterRange(11, 21);

        RasterRange firstRangeInside = new RasterRange(15, 17);
        RasterRange secondRangeInside = new RasterRange(16, 20);
        anyRasterRange.exclude(firstRangeInside);
        anyRasterRange.exclude(secondRangeInside);

        MatcherAssert.assertThat(anyRasterRange.calculateNoExcludedCountOfPositions(), Matchers.is(6L));
    }

    @Test
    public void rangeTwoDisjuncted() {
        RasterRange anyRasterRange = new RasterRange(11, 21);

        RasterRange firstRange = new RasterRange(12, 14);
        RasterRange secondRange = new RasterRange(15, 17);
        anyRasterRange.exclude(firstRange);
        anyRasterRange.exclude(secondRange);

        MatcherAssert.assertThat(anyRasterRange.calculateNoExcludedCountOfPositions(), Matchers.is(5L));
    }

    @Test
    public void rangeWithOverlappedRangesExcluded() {
        RasterRange anyRasterRange = new RasterRange(11, 21);

        RasterRange firstRange = new RasterRange(11, 21);
        anyRasterRange.exclude(firstRange);

        MatcherAssert.assertThat(anyRasterRange.calculateNoExcludedCountOfPositions(), Matchers.is(0L));
    }

    @Test
    public void rangeWithBiggerExcluded() {
        RasterRange anyRasterRange = new RasterRange(11, 21);
        RasterRange biggerRange = new RasterRange(5, 100);

        Assertions.assertThrows(RuntimeException.class, () -> {
            anyRasterRange.exclude(biggerRange);
        });
    }


     */

}
