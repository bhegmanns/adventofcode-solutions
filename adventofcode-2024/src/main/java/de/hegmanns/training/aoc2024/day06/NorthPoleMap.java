package de.hegmanns.training.aoc2024.day06;

import de.hegmanns.training.aoc.common.geometric.Point;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

public class NorthPoleMap {
    public enum Property {
        OBSTRUCTION('#'),
        UNTOUCHED('.'),
        TOUCHED('X'),
        INITIAL_GUARDPOSITION('^'),
        ADDITIONAL_OBSTRUCTION('0');

        private final char sign;

        Property(char sign){
            this.sign = sign;
        }

        private static Map<Character, Property> mapOfSigns
                = Map.of(OBSTRUCTION.sign, OBSTRUCTION,
                UNTOUCHED.sign, UNTOUCHED,
                TOUCHED.sign, TOUCHED,
                INITIAL_GUARDPOSITION.sign, INITIAL_GUARDPOSITION,
                ADDITIONAL_OBSTRUCTION.sign,
                ADDITIONAL_OBSTRUCTION);
        public static Property valueOf(char sign) {
            return Optional.ofNullable(mapOfSigns.get(sign)).orElseThrow(() -> new IllegalArgumentException("unknown sign: " + sign));
        }
    }

    public Property[][] map;

    private boolean isInObstruction(NorthpoleGuard guard) {
        if (guard.getxCoordinate()<0 || guard.getyCoordinate()<0 || guard.getxCoordinate()>=map[0].length || guard.getyCoordinate()>=map.length) {
            return false;
        }
        return
                map[guard.getyCoordinate()][guard.getxCoordinate()] == Property.OBSTRUCTION
                ||
                map[guard.getyCoordinate()][guard.getxCoordinate()] == Property.ADDITIONAL_OBSTRUCTION;
    }

    private boolean isInObstruction(Point point) {
        if (!isInField(point)) {
            return true;
        }
        return
                map[point.y()][point.x()] == Property.OBSTRUCTION
                ||
                map[point.y()][point.x()] == Property.ADDITIONAL_OBSTRUCTION;
    }

    private boolean isInField(NorthpoleGuard guard) {
        return !(guard.getxCoordinate() < 0 || guard.getyCoordinate() < 0 || guard.getxCoordinate() >= map[0].length || guard.getyCoordinate() >= map.length);
    }

    private boolean isInField(Point point) {
        return !(point.x() < 0 || point.y() < 0 || point.x() >= map[0].length || point.y() >= map.length);
    }

    private NorthPoleMap() {
    }
    public NorthPoleMap(NorthPoleMap mapToBeCopies) {
        this.map = Arrays.stream(mapToBeCopies.map).map(Property[]::clone).toArray(Property[][]::new);
    }

    public void printOut() {
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                System.out.print(map[y][x].sign);
            }
            System.out.println();
        }
    }

    public int getCountOfTourchedPositions() {
        int count = 0;
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                if (map[y][x] == Property.TOUCHED) {
                    count++;
                }
            }
        }
        return count;
    }

    public static final String NOT_OUT_OF_FIELD = "not out of field";

    public Pair<NorthPoleMap, Path> walkThrough(NorthpoleGuard northpoleGuard){
        NorthPoleMap northPoleMap = new NorthPoleMap(this);
        NorthpoleGuard northpoleGuardForPathThrough = new NorthpoleGuard(northpoleGuard.getxCoordinate(), northpoleGuard.getyCoordinate());
        //System.out.println();
        //northPoleMap.printOut();
        if (!northPoleMap.isInField(northpoleGuardForPathThrough)) {
            throw new RuntimeException("guard is not in field");
        }
        if (northPoleMap.isInObstruction(northpoleGuardForPathThrough)) {
            throw new RuntimeException("guard is in obstruction: " + northpoleGuardForPathThrough);
        }
        northPoleMap.map[northpoleGuardForPathThrough.getyCoordinate()][northpoleGuardForPathThrough.getxCoordinate()] = Property.TOUCHED;
        Path path = new Path();
        path.addPoint(northpoleGuardForPathThrough.getCurrentPosition());
        int countOfSteps = 0;
        int width = northPoleMap.map[0].length;
        int height = northPoleMap.map.length;
        while(true){
            Point positionAfterMovement = northpoleGuardForPathThrough.getPositionAfterMovement();
            if (!northPoleMap.isInField(positionAfterMovement)) {
                break; // moved out of field
            }
            if (northPoleMap.isInObstruction(positionAfterMovement)) {
                // have to turn right
                northpoleGuardForPathThrough.turnRight();
                continue;
            }
            northpoleGuardForPathThrough.move();
            northPoleMap.map
                    [northpoleGuardForPathThrough.getyCoordinate()]
                    [northpoleGuardForPathThrough.getxCoordinate()] = Property.TOUCHED;
            path.addPoint(northpoleGuardForPathThrough.getCurrentPosition());
            countOfSteps++;
            if (countOfSteps > width * height) {
                throw new RuntimeException(NOT_OUT_OF_FIELD);
            }

        }

        return Pair.of(northPoleMap, path);
    }

    public static class Builder {
        private List<String> lines = new ArrayList<>();
        public static Builder create() {
            return new Builder();
        }

        public Builder addLines(List<String> lines) {
            this.lines.addAll(lines);
            return this;
        }

        public Builder addLine(String line) {
            lines.add(line);
            return this;
        }

        public Pair<NorthPoleMap, NorthpoleGuard> build() {
            if (!consistChecks()) {
                throw new RuntimeException("at least one consistency check failed");
            }
            NorthPoleMap northPoleMap= new NorthPoleMap();
            northPoleMap.map = new Property[lines.size()][lines.get(0).length()];
            NorthpoleGuard northpoleGuard = null;
            for (int y = 0; y < lines.size(); y++) {
                String line = lines.get(y);
                for (int x = 0; x < line.length(); x++) {
                    Property property = Property.valueOf(line.charAt(x));
                    if (property == Property.INITIAL_GUARDPOSITION) {
                        northpoleGuard = new NorthpoleGuard(x, y);
                        property = Property.UNTOUCHED;
                    }

                    northPoleMap.map[y][x] = property;
                }
            }

            if (northpoleGuard == null) {
                throw new RuntimeException("no guard found");
            }
            return Pair.of(northPoleMap, northpoleGuard);
        }

        private boolean consistChecks() {
            return allLinesAreSameLength(lines);
        }

        private boolean allLinesAreSameLength(List<String> lines) {
            return lines.stream().mapToInt(String::length).distinct().count() == 1;
        }
    }
}
