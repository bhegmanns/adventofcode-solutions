package de.hegmanns.training.aoc2022.day18;

import java.util.Objects;

public class Coordinate {
    int x;
    int y;
    int z;

    public Coordinate(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x && y == that.y && z == that.z;
    }

    public Coordinate addX(int add) {
        return new Coordinate(x + add, y, z);
    }

    public Coordinate addY(int add) {
        return new Coordinate(x, y + add, z);
    }

    public Coordinate addZ(int add) {
        return new Coordinate(x, y, z + add);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
