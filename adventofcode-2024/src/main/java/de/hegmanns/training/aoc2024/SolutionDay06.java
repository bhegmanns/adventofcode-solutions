package de.hegmanns.training.aoc2024;

import de.hegmanns.training.aoc.common.*;
import de.hegmanns.training.aoc.common.geometric.*;
import de.hegmanns.training.aoc2024.day05.*;
import org.apache.commons.lang3.*;
import org.apache.commons.lang3.tuple.*;

import java.util.*;

public class SolutionDay06 implements AoCSolution<Long, Long> {
    public static final String FILE_NAME = "day06_task.txt";
    private static final byte BARRIER = 1;
    private static final byte TOUCHED = 9;
    private static final byte UNTOUCHED = 0;


    public static void main(String[] args) {
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay06.class, FILE_NAME);

        SolutionDay06 solution = new SolutionDay06();
        System.out.println("Part 1: " + solution.solvePart1(inputAsList));
        System.out.println("===");
        System.out.println("Part 2: " + solution.solvePart2(inputAsList));
    }

    private static List<String> getInputList() {
        return AoCFileReader.getInputAsList(SolutionDay04.class, FILE_NAME);
    }


    private Point getTurnRightDirection(Point direction) {
        if (direction.equals(new Point(0, -1))) {
            return new Point(1, 0);
        }
        if (direction.equals(new Point(1,0))) {
            return new Point(0,1);
        }
        if (direction.equals(new Point(0, 1))) {
            return new Point(-1,0);
        }
        if (direction.equals(new Point(-1,0))) {
            return new Point(0,-1);
        }
        throw new RuntimeException("not possible" + direction);
    }

    @Override
    public Long solvePart1(List<String> input) {
        int width = input.get(0).length();
        byte[][] map = new byte[input.get(0).length()][input.size()];
        int currentLine = 0;
        Point currentGuardPosition = null;
        Point direction = new Point(0, -1);
        for (String line : input) {
            char[] charArray = line.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                char c = charArray[i];
                switch (c) {
                    case '#':
                        map[i][currentLine] = BARRIER;
                        break;
                    case '.':
                        map[i][currentLine] = UNTOUCHED;
                        break;
                    case '^':
                        currentGuardPosition = new Point(i, currentLine);
                        map[i][currentLine] = TOUCHED;
                        break;
                }
            }
            currentLine++;
        }

        printOutMap(map);
        System.out.println(">>>");
        int countOfSteps = 0;

        // walk through and mark treated positions with 9
        while (true) {
            Point possibleNewPoint = currentGuardPosition.move(direction);
            countOfSteps++;
            if (!possibleNewPoint.isInside(width, width)) {
                break;
            } else {
                if (map[possibleNewPoint.x()][possibleNewPoint.y()] == BARRIER) {
                    direction = getTurnRightDirection(direction);
                } else {
                    // mark
                    currentGuardPosition = possibleNewPoint;
                    map[currentGuardPosition.x()][currentGuardPosition.y()] = 9;
                }
            }
        }

        printOutMap(map);
        System.out.println("-------");

        long countHits = 0;
        for (int i = 0 ; i < map.length ; i++) {
            for (int j = 0 ; j < map[i].length ; j++) {
                if (map[j][i] == 9) {
                    countHits++;
                }
            }
        }
        System.out.println("count of steps " + countOfSteps);
        return countHits;
    }

    private void printOutMap(byte[][] map) {
        for (int i = 0 ; i < map.length ; i++) {
            for (int j = 0 ; j < map[i].length ; j++) {
                if (map[j][i] == 9) {
                    System.out.print('X');
                } else if (map[j][i] == 1) {
                    System.out.print('#');
                } else {
                    System.out.print('.');
                }
            }
            System.out.println();
        }
    }

    @Override
    public Long solvePart2(List<String> input) {
        int width = input.get(0).length();
        byte[][] map = new byte[input.get(0).length()][input.size()];
        int currentLine = 0;
        Point currentGuardPosition = null;
        Point direction = new Point(0, -1);
        for (String line : input) {
            char[] charArray = line.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                char c = charArray[i];
                switch (c) {
                    case '#':
                        map[i][currentLine] = 1;
                        break;
                    case '.':
                        map[i][currentLine] = 0;
                        break;
                    case '^':
                        currentGuardPosition = new Point(i, currentLine);
                        map[i][currentLine] = 9;
                        break;
                }
            }
            currentLine++;
        }

        printOutMap(map);
        System.out.println(">>>");
        int countOfSteps = 0;
        List<Point> path = new ArrayList<>();
        path.add(new Point(currentGuardPosition.x(), currentGuardPosition.y()));
        // walk through and mark treated positions with 9

        while (true) {
            Point possibleNewPoint = currentGuardPosition.move(direction);
            countOfSteps++;
            if (!possibleNewPoint.isInside(width, width)) {
                break;
            } else {
                if (map[possibleNewPoint.x()][possibleNewPoint.y()] == 1) {
                    direction = getTurnRightDirection(direction);
                } else {
                    // mark
                    currentGuardPosition = possibleNewPoint;
                    map[currentGuardPosition.x()][currentGuardPosition.y()] = 9;
                    path.add(new Point(currentGuardPosition.x(), currentGuardPosition.y()));
                }
            }
        }

        printOutMap(map);
        System.out.println("-------");

        long countHits = 0;
        for (int i = 0 ; i < map.length ; i++) {
            for (int j = 0 ; j < map[i].length ; j++) {
                if (map[j][i] == 9) {
                    countHits++;
                }
            }
        }
        System.out.println("count of steps " + countOfSteps);
        System.out.println("path size: " + path.size());

        // now, try to put a barrier at every straight step of the path and look if it results in a circle


        return countHits;
    }

    private boolean foo(byte[][] map, Point newBarrierPosition,Point currentGuardPosition, Point direction) {
        if (map[newBarrierPosition.x()][newBarrierPosition.y()] == 1) {}
        return false;
    }

    @Override
    public Long getSolution1() {
        return solvePart1(getInputList());
    }

    @Override
    public Long getSolution2() {
        return solvePart2(getInputList());
    }
}
