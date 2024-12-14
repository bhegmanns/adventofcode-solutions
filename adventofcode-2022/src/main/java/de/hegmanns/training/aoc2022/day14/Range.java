package de.hegmanns.training.aoc2022.day14;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Range implements Comparable<Range>{

    private long startPosition;
    private long finalPosition;

    public Range(long startPosition, long finalPosition) {
        this.startPosition = startPosition;
        this.finalPosition = finalPosition;
    }

    @Override
    public int compareTo(Range o) {
        return Long.compare(startPosition, o.startPosition);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Range range = (Range) o;
        return startPosition == range.startPosition && finalPosition == range.finalPosition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(startPosition, finalPosition);
    }

    /**
     * indicates if this Range contains the Range in the parameter
     * @param range
     * @return
     */
    public boolean contains(Range range) {
        return this.startPosition<=range.startPosition && this.finalPosition>=range.finalPosition;
    }

    /**
     * indicates is this Range is partially overlapped by the Range in the parameter
     * @param range
     * @return
     */
    public boolean isOverlapped(Range range) {
        return true;
    }

    public List<Range> reduce(Range contentRangeFromRasterRange) {
        //completely on the left side
        if (this.startPosition > contentRangeFromRasterRange.startPosition && this.startPosition > contentRangeFromRasterRange.finalPosition) {
            return Arrays.asList(this);
        }

        //completely on the right side
        if (this.finalPosition < contentRangeFromRasterRange.finalPosition && this.finalPosition < contentRangeFromRasterRange.startPosition) {
            return Arrays.asList(this);
        }

        //completely overlapped or greater
        if (this.startPosition >= contentRangeFromRasterRange.startPosition && this.finalPosition <= contentRangeFromRasterRange.finalPosition) {
            return Collections.EMPTY_LIST;
        }

        //inside
        if (this.startPosition <= contentRangeFromRasterRange.startPosition && this.finalPosition >= contentRangeFromRasterRange.finalPosition) {
            return Arrays.asList(
                    new Range(this.startPosition, contentRangeFromRasterRange.startPosition),
                    new Range(contentRangeFromRasterRange.finalPosition, this.finalPosition)
            );
        }

        //partial overlapped on left side
        if (this.startPosition > contentRangeFromRasterRange.startPosition) {
            return Arrays.asList(
                    new Range(contentRangeFromRasterRange.finalPosition+1, this.finalPosition)
            );
        }

        return Arrays.asList(
                new Range(this.startPosition, contentRangeFromRasterRange.startPosition-1)
        );


    }

    public long getWidth() {
        return this.finalPosition - this.startPosition;
    }
}
