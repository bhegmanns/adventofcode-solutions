package de.hegmanns.training.aoc2024.day08;

import de.hegmanns.training.aoc.common.geometric.*;
import lombok.*;

import java.util.*;

@Data
public class AntennaMap {
    private static final char FREE = '.';
    private static final char ANTINODE = '#';
    private char[][] positions;
    Boolean doneWithTNode = null;
    Long numberOfAntinodes = null;

    public AntennaMap(char[][] map) {
        this.positions = map;
    }

    public long placeAntinodesWithTNodesIncludingAntennas(boolean doneWithTNode) {
        placeAntinodes(doneWithTNode);
        long freeNodes = 0;
        for (int row = 0 ; row < positions.length ; row++) {
            for (int column = 0; column < positions[row].length; column++) {
                if (positions[row][column] == FREE) {
                    freeNodes++;
                }
            }
        }

        return positions.length * positions.length - freeNodes;
    }

    public long placeAntinodes(boolean withTNode) {
        if (doneWithTNode == null) {
            doneWithTNode = withTNode;
        } else {
            if (doneWithTNode != withTNode) {
                throw new RuntimeException("calculation done, please create a new AntennaMap-instance an try again");
            }
        }
        char[][] antinodeMap = Arrays.stream(positions).map(char[]::clone).toArray(char[][]::new);
        long numberOfAntinodes = 0;
        for (int row = 0 ; row < positions.length ; row++) {
            for (int column = 0; column < positions[row].length; column++) {
                if (positions[row][column] != FREE && positions[row][column] != ANTINODE) {
                    char currentAntenna = positions[row][column];
                    Point currentAntennaPoint = new Point(row, column);
                    List<Point> allAntennas = findAllAntennas(currentAntenna, currentAntennaPoint);
                    for (Point otherAntenna : allAntennas) {
                        List<Point> antinodePositions = findAntinodePositions(otherAntenna, new Point(row, column), withTNode);
                        for (Point antinodePosition : antinodePositions) {

                            if (antinodeMap[antinodePosition.x()][antinodePosition.y()] != ANTINODE) {
                                antinodeMap[antinodePosition.x()][antinodePosition.y()] = ANTINODE;
                                numberOfAntinodes++;
                            }
                            if (positions[antinodePosition.x()][antinodePosition.y()] == FREE) {
                                positions[antinodePosition.x()][antinodePosition.y()] = ANTINODE;
                            }
                        }
                    }
                }
            }
        }
        AntennaMap antinodeMap2 = new AntennaMap(antinodeMap);
        System.out.println("----------------");
        antinodeMap2.printOut();
        System.out.println("----------------");
        this.numberOfAntinodes = numberOfAntinodes;
        return numberOfAntinodes;
    }


    private List<Point> findAntinodePositions(Point baseAntenna, Point otherAntenna, boolean withTNode) {
        int diffX = baseAntenna.x() - otherAntenna.x();
        int diffY = baseAntenna.y() - otherAntenna.y();

        List<Point> antinodePositions = new ArrayList<>();
        Point possibleAntinodePoint = null;
        // first+diff until outside
        int currentDiffx = diffX;
        int currentDiffy = diffY;
        do{
            possibleAntinodePoint = new Point(baseAntenna.x() + currentDiffx, baseAntenna.y() + currentDiffy);
            if (possibleAntinodePoint.isInside(positions.length, positions.length)) {
                antinodePositions.add(possibleAntinodePoint);
            }
            currentDiffx += diffX;
            currentDiffy += diffY;
        }while(withTNode && possibleAntinodePoint.isInside(positions.length, positions.length));

        // then -diff until outside
        currentDiffx = diffX;
        currentDiffy = diffY;
        do{
            possibleAntinodePoint = new Point(otherAntenna.x() - currentDiffx, otherAntenna.y() - currentDiffy);
            if (possibleAntinodePoint.isInside(positions.length, positions.length)) {
                antinodePositions.add(possibleAntinodePoint);
            }
            currentDiffx += diffX;
            currentDiffy += diffY;
        }while(withTNode && possibleAntinodePoint.isInside(positions.length, positions.length));

        return antinodePositions;
    }

    public List<Point> findAllAntennas(char antenna, Point expectedPoint) {
        List<Point> antennas = new ArrayList<>();
        for (int row = 0 ; row < positions.length ; row++) {
            for (int column = 0; column < positions[row].length; column++) {
                if (new Point(row, column).equals(expectedPoint)) {
                    continue;
                }
                if (positions[row][column] == antenna) {
                    antennas.add(new Point(row, column));
                }
            }
        }
        return antennas;
    }

    public void printOut() {
        for (int row = 0 ; row < positions.length ; row++) {
            for (int column = 0; column < positions[row].length; column++) {
                System.out.print(positions[row][column]);
            }
            System.out.println();
        }
    }
}
