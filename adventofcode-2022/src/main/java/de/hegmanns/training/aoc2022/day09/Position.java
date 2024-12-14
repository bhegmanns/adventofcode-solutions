package de.hegmanns.training.aoc2022.day09;

import java.util.Objects;

public class Position {

    private int x;
    private int y;

    private boolean visitedByTail = false;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public void markVisitedByTail() {
        visitedByTail = true;
    }

    public boolean isVisitedByTail() {
        return visitedByTail;
    }
}
