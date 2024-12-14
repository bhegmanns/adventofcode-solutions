package de.hegmanns.training.aoc2022.day14;

public class RasterCoordinate {

    private long x;
    private long y;

    public RasterCoordinate(long x, long y) {
        this.x = x;
        this.y = y;
    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    public long getManhattanDistance(RasterCoordinate rasterCoordinate) {
        return Math.abs(x - rasterCoordinate.x) + Math.abs(y - rasterCoordinate.y);
    }

    @Override
    public String toString() {
        return "RasterCoordinate{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
