package de.hegmanns.training.aoc2022.day14;

import java.util.*;

public class RasterRange implements Comparable<RasterRange>{

    private long fromInclusive;
    private long untilInclusive;

    private List<Range> contentRanges;

    public RasterRange(long fromInclusive, long untilInclusive) {
        this.fromInclusive = fromInclusive;
        this.untilInclusive = untilInclusive;
        this.contentRanges = new ArrayList<>();
        this.contentRanges = Arrays.asList(new Range(fromInclusive, untilInclusive));
    }

    public long getPositionWidth(){
        return this.untilInclusive - this.fromInclusive+1;
    }

    public boolean contains(RasterRange rasterRange) {
        return this.fromInclusive<=rasterRange.fromInclusive && this.untilInclusive>=rasterRange.untilInclusive;
    }

    public boolean isOverlapped(RasterRange rasterRange) {
        return !(this.fromInclusive-1 > rasterRange.untilInclusive || this.untilInclusive+1 < rasterRange.fromInclusive);
    }

    public void reduce(RasterRange rasterRange) {

        // no more content ...
        if (this.contentRanges.isEmpty()) {
            return;
        }

        // rasterRange is placed left from this
        if (this.fromInclusive > rasterRange.fromInclusive && this.fromInclusive > rasterRange.untilInclusive) {
            return;
        }

        // rasterRange is placed right from this
        if (this.untilInclusive < rasterRange.fromInclusive && this.untilInclusive < rasterRange.untilInclusive) {
            return;
        }

        List<Range> newCalculatedContentRanges = new ArrayList<>();
        Range contentRangeFromRasterRange = new Range(rasterRange.fromInclusive, rasterRange.untilInclusive);
        for (Range currentRange : this.contentRanges) {
            List<Range> resultOfCurrentReducement = currentRange.reduce(contentRangeFromRasterRange);
            newCalculatedContentRanges.addAll(resultOfCurrentReducement);
        }
        this.contentRanges = newCalculatedContentRanges;
    }



    public long calculateNoExcludedCountOfPositions() {
        return (this.untilInclusive-this.fromInclusive) - contentRanges.stream().map(Range::getWidth).mapToLong(Long::longValue).sum();
    }



    @Override
    public String toString() {
        return "RasterRange{" +
                "fromInclusive=" + fromInclusive +
                ", untilInclusive=" + untilInclusive +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RasterRange that = (RasterRange) o;
        return fromInclusive == that.fromInclusive && untilInclusive == that.untilInclusive;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fromInclusive, untilInclusive);
    }

    @Override
    public int compareTo(RasterRange o) {
        return Long.compare(this.fromInclusive, o.fromInclusive);
    }
}
