package de.hegmanns.training.aoc2022.day24;

import de.hegmanns.training.aoc2022.day24.location.Loc;

import java.awt.*;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.Math.abs;
public enum Direction {
    NORTH(1, 'U'), EAST(4, 'R'), SOUTH(2, 'D'), WEST(3, 'L'), CENTER(8, 'C'),
    NORTHEAST(4, 'E'), SOUTHEAST(5, 'E'), SOUTHWEST(6, 'E'), NORTHWEST(7, 'E');

    public final int num;
    public final int code;

    Direction(int num, char code) {
        this.num = num;
        this.code = code;
    }

    public static Direction getByDirCode(char code) {
        return Arrays.stream(values()).filter(e -> e.code == code).findAny().get();
    }

    public static Direction getByDir(char code) {
        return Arrays.stream(values()).filter(e -> e.name().charAt(0) == code).findAny().get();
    }

    public static Direction getByMove(Point from, Point to) {
        if (to.x > from.x) return EAST;
        else if (to.x < from.x) return WEST;
        else if (to.y > from.y) return SOUTH;
        else if (to.y < from.y) return NORTH;
        else return CENTER;
    }

    public static Direction getByMove(Loc from, Loc to) {
        if (to.x > from.x) return EAST;
        else if (to.x < from.x) return WEST;
        else if (to.y > from.y) return SOUTH;
        else if (to.y < from.y) return NORTH;
        else return CENTER;
    }

    public static Point turn(Point w, boolean b) {
        return b ? new Point(-w.y, w.x) : new Point(w.y, -w.x);
    }

    public static Point turnDegrees(Point w, int distance, boolean b) {
        int num = distance % 360;
        while (num > 0) {
            w = turn(w, b);
            num -= 90;
        }
        return w;
    }

    public static Point turnDegrees(Point w, int distance) {
        return turnDegrees(w, abs(distance), distance > 0);
    }

    public static Direction[] fourDirections() {
        return new Direction[]{NORTH, EAST, SOUTH, WEST};
    }

    public static Direction[] eightDirections() {
        return new Direction[]{NORTH, EAST, SOUTH, WEST, NORTHEAST, SOUTHEAST, SOUTHWEST, NORTHWEST};
    }

    public static Direction[] round() {
        return new Direction[]{NORTH, NORTHEAST, EAST, SOUTHEAST, SOUTH, SOUTHWEST, WEST, NORTHWEST};
    }

    public static Stream<Direction> four() {
        return Arrays.stream(fourDirections());
    }

    public static Stream<Direction> eight() {
        return Arrays.stream(eightDirections());
    }

    public static Stream<Direction> five() {
        return Stream.of(NORTH, EAST, SOUTH, WEST, CENTER);
    }

    public Direction turnSteps(int steps) {
        Direction[] d = round();
        int index = IntStream.range(0, d.length).filter(i -> d[i] == this).findFirst().getAsInt();
        return d[(index + steps) % d.length];
    }

    public static Direction[] diagonals() {
        return new Direction[]{NORTHEAST, SOUTHEAST, SOUTHWEST, NORTHWEST};
    }

    public Direction turn() {
        return turn(true);
    }

    public Direction turn(boolean right) {
        int cur = ordinal() + (right ? 1 : -1);
        if (cur == fourDirections().length) cur = 0;
        else if (cur == -1) cur = fourDirections().length - 1;
        return fourDirections()[cur];
    }

    public Point move(Point currentLocation, int amount) {
        return switch (this) {
            case SOUTH -> new Point(currentLocation.x, currentLocation.y + amount);
            case NORTH -> new Point(currentLocation.x, currentLocation.y - amount);
            case EAST -> new Point(currentLocation.x + amount, currentLocation.y);
            case WEST -> new Point(currentLocation.x - amount, currentLocation.y);
            case SOUTHWEST -> new Point(currentLocation.x - amount, currentLocation.y + amount);
            case NORTHEAST -> new Point(currentLocation.x + amount, currentLocation.y - amount);
            case SOUTHEAST -> new Point(currentLocation.x + amount, currentLocation.y + amount);
            case NORTHWEST -> new Point(currentLocation.x - amount, currentLocation.y - amount);
            case CENTER -> new Point(currentLocation.x, currentLocation.y);
        };
    }

    public Loc move(Loc currentLocation, long amount) {
        return switch (this) {
            case SOUTH -> new Loc(currentLocation.x, currentLocation.y + amount);
            case NORTH -> new Loc(currentLocation.x, currentLocation.y - amount);
            case EAST -> new Loc(currentLocation.x + amount, currentLocation.y);
            case WEST -> new Loc(currentLocation.x - amount, currentLocation.y);
            case SOUTHWEST -> new Loc(currentLocation.x - amount, currentLocation.y + amount);
            case NORTHEAST -> new Loc(currentLocation.x + amount, currentLocation.y - amount);
            case SOUTHEAST -> new Loc(currentLocation.x + amount, currentLocation.y + amount);
            case NORTHWEST -> new Loc(currentLocation.x - amount, currentLocation.y - amount);
            case CENTER -> new Loc(currentLocation.x, currentLocation.y);
        };
    }

    public Point moveFix(Point currentLocation, int amount) {
        return switch (this) {
            case SOUTH -> new Point(currentLocation.x, currentLocation.y + amount);
            case NORTH -> new Point(currentLocation.x, currentLocation.y - amount);
            case EAST -> new Point(currentLocation.x - amount, currentLocation.y);
            case WEST -> new Point(currentLocation.x + amount, currentLocation.y);
            case SOUTHWEST -> new Point(currentLocation.x + amount, currentLocation.y + amount);
            case NORTHEAST -> new Point(currentLocation.x - amount, currentLocation.y - amount);
            case SOUTHEAST -> new Point(currentLocation.x - amount, currentLocation.y + amount);
            case NORTHWEST -> new Point(currentLocation.x + amount, currentLocation.y - amount);
            case CENTER -> new Point(currentLocation.x, currentLocation.y);
        };
    }

    public char getInGrid(char[][] grid, Point p, char none) {
        if (p.x >= 0 && p.x < grid.length && p.y >= 0 && p.y < grid[0].length) {
            return grid[p.x][p.y];
        }
        return none;
    }

    public long getInGrid(long[][] grid, Point p, int none) {
        p = this.move(p);
        if (p.x >= 0 && p.x < grid.length && p.y >= 0 && p.y < grid[0].length) {
            return grid[p.x][p.y];
        }
        return none;
    }

    public char getInGrid(char[][] grid, Point p) {
        return getInGrid(grid, p, '.');
    }

    public Point move(Point currentLocation) {
        return move(currentLocation, 1);
    }

    public Loc move(Loc currentLocation) {
        return move(currentLocation, 1);
    }

    public Point moveFix(Point currentLocation) {
        return moveFix(currentLocation, 1);
    }

    public Direction opposite() {
        return switch (this) {
            case NORTH -> SOUTH;
            case SOUTH -> NORTH;
            case EAST -> WEST;
            case WEST -> EAST;
            case NORTHEAST -> SOUTHWEST;
            case SOUTHWEST -> NORTHEAST;
            case SOUTHEAST -> NORTHWEST;
            case NORTHWEST -> SOUTHEAST;
            case CENTER -> CENTER;
        };
    }

    public boolean diagonal() {
        return this == NORTH || this == SOUTH;
    }

    public boolean horizontal() {
        return this == EAST || this == WEST;
    }

    public boolean leftOf(Direction robotDir) {
        int n = this.ordinal() - 1;
        if (n == -1) n = values().length - 1;
        return robotDir.ordinal() == n;
    }

    public Direction turnDegrees(int degrees, boolean right) {
        int num = degrees % 360;
        Direction dir = this;
        while (num > 0) {
            dir = turn(right);
            num -= 90;
        }
        return dir;
    }

    public Direction turnDegrees(int degrees) {
        return turnDegrees(abs(degrees), degrees > 0);
    }
}
