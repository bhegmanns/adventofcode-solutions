package de.hegmanns.training.aoc2022.day20;

import java.util.Objects;

public class GroveNumber {

    private long number;
    private int index;

    public GroveNumber(long number, int index) {
        this.number = number;
        this.index = index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroveNumber that = (GroveNumber) o;
        return number == that.number && index == that.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, index);
    }

    @Override
    public String toString() {
        return "GroveNumber{" +
                "number=" + number +
                ", index=" + index +
                '}';
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public long getNumber() {
        return number;
    }

    public int getIndex() {
        return index;
    }
}
