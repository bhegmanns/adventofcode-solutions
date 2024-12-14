package de.hegmanns.training.aoc2022.day18;

import java.util.List;

public class SurfaceArea {

    private List<Shape> shapes;

    public SurfaceArea(List<Shape> shapes) {
        this.shapes = shapes;
    }

    public Coordinate[] getBoundary() {

        int minX = shapes.stream().mapToInt((s) -> s.getPosition().getX()).min().getAsInt();
        int maxX = shapes.stream().mapToInt((s) -> s.getPosition().getX()).max().getAsInt();

        int minY = shapes.stream().mapToInt((s) -> s.getPosition().getY()).min().getAsInt();
        int maxY = shapes.stream().mapToInt((s) -> s.getPosition().getY()).max().getAsInt();

        int minZ = shapes.stream().mapToInt((s) -> s.getPosition().getZ()).min().getAsInt();
        int maxZ = shapes.stream().mapToInt((s) -> s.getPosition().getZ()).max().getAsInt();

        Coordinate firstBoundCoordinate = new Coordinate(minX, minY, minZ);
        Coordinate secondBoundCoordinate = new Coordinate(maxX, maxY, maxZ);

        return new Coordinate[]{firstBoundCoordinate, secondBoundCoordinate};
    }


}
