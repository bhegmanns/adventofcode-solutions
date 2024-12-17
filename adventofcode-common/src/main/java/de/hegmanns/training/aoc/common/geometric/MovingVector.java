package de.hegmanns.training.aoc.common.geometric;

import java.util.*;

/**
 * Defines a direction (e.g. for walking) through an 2-dimensional area.
 */
public class MovingVector{
    private int x;
    private int y;

    public MovingVector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MovingVector that)) return false;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
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

    private Map<Integer, MovingVector> movingVectorsByTurn = new HashMap<>();

    public MovingVector opposite() {
        return new MovingVector(-x, -y);
    }

    public MovingVector turnRight() {

        return null;
    }
}
