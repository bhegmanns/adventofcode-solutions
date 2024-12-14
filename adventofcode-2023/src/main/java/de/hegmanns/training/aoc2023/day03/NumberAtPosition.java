package de.hegmanns.training.aoc2023.day03;

import java.util.Objects;

public class NumberAtPosition {
    private long number;
    private int startPosition;

    private int finalPosition;

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public int getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(int startPosition) {
        this.startPosition = startPosition;
    }

    public int getFinalPosition() {
        return finalPosition;
    }

    public void setFinalPosition(int finalPosition) {
        this.finalPosition = finalPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumberAtPosition that = (NumberAtPosition) o;
        return number == that.number && startPosition == that.startPosition && finalPosition == that.finalPosition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, startPosition, finalPosition);
    }
}
