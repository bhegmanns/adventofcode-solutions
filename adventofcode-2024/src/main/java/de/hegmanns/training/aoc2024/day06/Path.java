package de.hegmanns.training.aoc2024.day06;

import de.hegmanns.training.aoc.common.geometric.Point;

import java.util.ArrayList;
import java.util.List;

public class Path {
    private List<Point> points = new ArrayList<>();

    public void addPoint(Point point) {
        points.add(point);
    }

    public List<Point> getPoints() {
        return points;
    }
}
