package de.hegmanns.training.aoc2021.day05;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Point  {
private int x;
private int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Direction getDirectionTo(Point other) {
        return new Direction(getXDirectionTo(other), getYDirectionTo(other));
    }

    public int getXDirectionTo(Point other) {
        return Integer.signum(other.x - x);
    }

    public int getYDirectionTo(Point other) {
        return Integer.signum(other.y - y);
    }

    public Point toNextPointInDirection(Direction direction) {
        return new Point(x + direction.getDeltaX(), y + direction.getDeltaY());
    }

    public Point backToPointFromDirection(Direction direction) {
        return new Point(x - direction.getDeltaX(), y - direction.getDeltaY());
    }

    public boolean haveSameXCoordinate(Point other) {
        return x==other.x;
    }

    public boolean haveSameYCoordinate(Point other) {
        return y==other.y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        return new EqualsBuilder().append(x, point.x).append(y, point.y).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(x).append(y).toHashCode();
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
