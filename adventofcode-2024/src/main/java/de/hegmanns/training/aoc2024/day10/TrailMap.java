package de.hegmanns.training.aoc2024.day10;

import de.hegmanns.training.aoc.common.geometric.Point;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
public class TrailMap {

    private byte[][] map;

    public byte getHeightAt(Point point) {
        if (point.x() < 0 || point.x() >= map.length || point.y() < 0 || point.y() >= map[point.x()].length) {
            throw new IllegalArgumentException("point out of bounds: " + point);
        }
        return map[point.x()][ point.y()];
    }

    public boolean isInsideMap(Point point) {
        return point.x() >= 0 && point.x() < map.length && point.y() >= 0 && point.y() < map[point.x()].length;
    }

    public List<Point> getDirectNeighboursWithHeight(Point point, byte expectedHeight) {
        List<Point> possibleResults = List.of(
                point.move(Point.DIRECTION_ONEUP),
                point.move(Point.DIRECTION_ONEDOWN),
                point.move(Point.DIRECTION_ONELEFT),
                point.move(Point.DIRECTION_ONERIGHT)
        );

        return possibleResults.stream().filter(this::isInsideMap).filter(p -> getHeightAt(p) == expectedHeight).toList();
    }

    public List<Point> getPointWithHeight(byte expectedHeight) {
        List<Point> result = new ArrayList<>();

        for (int row = 0 ; row < map.length ; row++) {
            for (int column = 0 ; column < map[row].length ; column++) {
                if (map[column][row] == expectedHeight) {
                    result.add(new Point(column, row));
                }
            }
        }

        return result;
    }

    public long calculateScoreForRouting(Point startPoint, byte destinationHeight) {
        if (getHeightAt(startPoint) == destinationHeight) {
            return 0L;
        }

        int startValue = getHeightAt(startPoint);
        int destinationValue = destinationHeight;
        List<Point> currentHeightPoints = new ArrayList<>(List.of(startPoint));
        for (int currentValue = startValue + 1; currentValue <= destinationValue; currentValue++) {
            Set<Point> nextHeightPoints = new HashSet<>();
            for (var currentPoint : currentHeightPoints) {
                nextHeightPoints.addAll(getDirectNeighboursWithHeight(currentPoint, (byte) currentValue));
            }
            currentHeightPoints = new ArrayList<>(nextHeightPoints);
            if (currentHeightPoints.isEmpty()) {
                return 0L;
            }
        }
        return currentHeightPoints.size();
    }

    public long calculateScoreForDistinctRouting(Point startPoint, byte destinationHeight) {
        if (getHeightAt(startPoint) == destinationHeight) {
            return 0L;
        }
        int startValue = getHeightAt(startPoint);
        int destinationValue = destinationHeight;
        List<Point> currentHeightPoints = new ArrayList<>(List.of(startPoint));
        for (int currentValue = startValue + 1; currentValue <= destinationValue; currentValue++) {
            List<Point> nextHeightPoints = new ArrayList<>();
            for (var currentPoint : currentHeightPoints) {
                nextHeightPoints.addAll(getDirectNeighboursWithHeight(currentPoint, (byte) currentValue));
            }
            currentHeightPoints = nextHeightPoints;
            if (currentHeightPoints.isEmpty()) {
                return 0L;
            }
        }
        return currentHeightPoints.size();
    }
}
