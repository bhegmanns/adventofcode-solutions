package de.hegmanns.training.aoc2022.day15d;

import de.hegmanns.training.aoc2022.day14.RasterRange;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RasterRangeMergeTest {
/*
    @Test
    public void rasterBefore() {
        RasterRange anyRasterRange = new RasterRange(10, 20);
        RasterRange rasterRangeBefore = new RasterRange(5, 8);

        List<RasterRange> merge = anyRasterRange.merge(rasterRangeBefore);

        MatcherAssert.assertThat(merge, Matchers.hasSize(2));
    }

    @Test
    public void rasterAfter() {
        RasterRange anyRasterRange = new RasterRange(10, 20);
        RasterRange rasterRangeAfter = new RasterRange(22, 30);

        List<RasterRange> merge = anyRasterRange.merge(rasterRangeAfter);

        MatcherAssert.assertThat(merge, Matchers.hasSize(2));
    }

    @Test
    public void overlappedBefore() {
        RasterRange anyRasterRange = new RasterRange(10, 20);
        RasterRange rasterRangeOverlappedBefore = new RasterRange(5, 14);

        List<RasterRange> merge = anyRasterRange.merge(rasterRangeOverlappedBefore);

        MatcherAssert.assertThat(merge, Matchers.hasSize(1));
        MatcherAssert.assertThat(merge.get(0), Matchers.equalTo(new RasterRange(5, 20)));
    }

    @Test
    public void overlappedAfter() {
        RasterRange anyRasterRange = new RasterRange(10, 20);
        RasterRange rasterRangeOverlappedAfter = new RasterRange(18, 30);

        List<RasterRange> merge = anyRasterRange.merge(rasterRangeOverlappedAfter);

        MatcherAssert.assertThat(merge, Matchers.hasSize(1));
        MatcherAssert.assertThat(merge.get(0), Matchers.equalTo(new RasterRange(10, 30)));
    }

    @Test
    public void overlappedByOneBefore() {
        RasterRange anyRasterRange = new RasterRange(10, 20);
        RasterRange rasterOverlappedByOneBefore = new RasterRange(5, 10);

        List<RasterRange> merge = anyRasterRange.merge(rasterOverlappedByOneBefore);

        MatcherAssert.assertThat(merge, Matchers.hasSize(1));
        MatcherAssert.assertThat(merge.get(0), Matchers.equalTo(new RasterRange(5, 20)));
    }

    @Test
    public void overlappedByOneAfter() {
        RasterRange anyRasterRange = new RasterRange(10, 20);
        RasterRange rasterOverlappedByOneAfter = new RasterRange(20, 30);

        List<RasterRange> merge = anyRasterRange.merge(rasterOverlappedByOneAfter);

        MatcherAssert.assertThat(merge, Matchers.hasSize(1));
        MatcherAssert.assertThat(merge.get(0), Matchers.equalTo(new RasterRange(10, 30)));
    }

    @Test
    public void continguousBefore() {
        RasterRange anyRasterRange = new RasterRange(10, 20);
        RasterRange rasterRangeContinguousBefore = new RasterRange(5, 9);

        List<RasterRange> merge = anyRasterRange.merge(rasterRangeContinguousBefore);

        MatcherAssert.assertThat(merge, Matchers.hasSize(1));
        MatcherAssert.assertThat(merge.get(0), Matchers.equalTo(new RasterRange(5, 20)));
    }

    @Test
    public void continguousAfter() {
        RasterRange anyRasterRange = new RasterRange(10, 20);
        RasterRange rasterRangeContinguousAfter = new RasterRange(21, 30);

        List<RasterRange> merge = anyRasterRange.merge(rasterRangeContinguousAfter);

        MatcherAssert.assertThat(merge, Matchers.hasSize(1));
        MatcherAssert.assertThat(merge.get(0), Matchers.equalTo(new RasterRange(10, 30)));
    }

 */
}
