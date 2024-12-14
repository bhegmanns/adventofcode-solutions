package de.hegmanns.training.aoc2022.day18;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Shape {

    private Coordinate position; //(x, y, z)

    private Set<Shape> possibleTouchedShapes = null;

    public Shape(Coordinate position) {
        if (position == null) {
            throw new NullPointerException("position cannot be null");
        }
        this.position = position;
    }

    public Shape(int x, int y, int z) {
        this(new Coordinate(x, y, z));
    }

    public Coordinate getPosition() {
        return position;
    }

    public boolean isConnected(Shape shape) {
        if (possibleTouchedShapes == null) {
            possibleTouchedShapes = new HashSet<>(6);

            possibleTouchedShapes.add(new Shape(this.position.addX(1)));
            possibleTouchedShapes.add(new Shape(this.position.addX(-1)));

            possibleTouchedShapes.add(new Shape(this.position.addY(1)));
            possibleTouchedShapes.add(new Shape(this.position.addY(-1)));

            possibleTouchedShapes.add(new Shape(this.position.addZ(1)));
            possibleTouchedShapes.add(new Shape(this.position.addZ(-1)));
        }
        return possibleTouchedShapes.stream().filter(s -> s.equals(shape)).findFirst().isPresent();
    }

    public Set<Shape> getPossibleTouchedShapes() {
        return possibleTouchedShapes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shape shape = (Shape) o;
        return position.equals(shape.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public String toString() {
        return "Shape{" +
                "position=" + position +
                '}';
    }
}
