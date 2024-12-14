package de.hegmanns.training.aoc2022.day24.location;

import de.hegmanns.training.aoc2022.day24.Direction;

import java.awt.*;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.Math.*;

public class Loc {
    public final long x;
    public final long y;

    public Loc() {
        this(0, 0);
    }

    public Loc(Loc p) {
        this(p.x, p.y);
    }

    public Loc(long x, long y) {
        this.x = x;
        this.y = y;
    }

    public Loc(Point p) {
        this(p.x, p.y);
    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    public Loc move(int dx, int dy) {
        return new Loc(x + dx, y + dy);
    }

    public Loc move(long dx, long dy) {
        return new Loc(x + dx, y + dy);
    }

    public Loc move(Loc l) {
        return new Loc(x + l.x, y + l.y);
    }

    public Point getPoint() {
        return new Point(intX(), intY());
    }

    public static Stream<Loc> range(int i, int j){
        return IntStream.range(0, i).boxed().flatMap(x -> IntStream.range(0, j).mapToObj(y -> new Loc(x, y)));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loc loc = (Loc) o;
        if (x != loc.x) return false;
        return y == loc.y;
    }

    @Override
    public int hashCode() {
        int result = (int) (x ^ (x >>> 32));
        result = 31 * result + (int) (y ^ (y >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[x=" + x + ",y=" + y + "]";
    }

    public int intX() {
        return toIntExact(x);
    }

    public int intY() {
        return toIntExact(y);
    }

    public long distance(Loc pt) {
        return abs(pt.x-x) + abs(pt.y-y);
    }

    public double distanceDouble(Loc pt) {
        return hypot(x-pt.x, y-pt.y);
    }

    public Stream<Loc> eightDirs() {
        return Arrays.stream(Direction.eightDirections()).map(d -> d.move(this));
    }

    public Stream<Loc> expand(long howMuch) {
        return new Range(new Loc(x-(howMuch/2), y-(howMuch/2)), new Loc(x+(howMuch/2), y+(howMuch/2))).stream();
    }

    public Stream<Loc> walk(Direction dir, long howFar) {
        return IntStream.range(0, toIntExact(howFar)).mapToObj(i -> dir.move(this, i));
    }

    public Stream<Loc> fourDirs() {
        return Arrays.stream(Direction.fourDirections()).map(d -> d.move(this));
    }

    public double rotation(Loc loc) {
        double theta = Math.atan2(loc.y - this.y, loc.x - this.x) + Math.PI / 2.0;
        double angle = Math.toDegrees(theta);
        return angle < 0 ? angle + 360 : angle;
    }
}