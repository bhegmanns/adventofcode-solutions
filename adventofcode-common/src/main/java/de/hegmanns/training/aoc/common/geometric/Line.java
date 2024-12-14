package de.hegmanns.training.aoc.common.geometric;

public record Line(Point from, Point to) {

    public boolean contains(Point point) {
        return point.isIn(this);
    }
}
