package de.hegmanns.training.aoc2024;

import de.hegmanns.training.aoc.common.AoCFileReader;
import de.hegmanns.training.aoc.common.AoCSolution;
import de.hegmanns.training.aoc.common.geometric.Point;
import de.hegmanns.training.aoc2024.day10.TrailMap;
import java.util.List;

public class SolutionDay10 implements AoCSolution<Long, Long> {
    public static final String FILE_NAME = "day10_task.txt";


    public static void main(String[] args) {
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay10.class, FILE_NAME);

        SolutionDay10 solution = new SolutionDay10();
        System.out.println("Part 1: " + solution.solvePart1(inputAsList));
        System.out.println("===");
        System.out.println("Part 2: " + solution.solvePart2(inputAsList));
    }

    private static List<String> getInputList() {
        return AoCFileReader.getInputAsList(SolutionDay10.class, FILE_NAME);
    }

    public static TrailMap createTrailMap(List<String> input) {
        byte[][] map = new byte[input.get(0).length()][input.size()];
        int currentLineNumber = 0;

        for (var line : input) {
            for (int column = 0 ; column < line.length() ; column++ ) {
                map[column][currentLineNumber] = Byte.valueOf("" + line.charAt(column));
            }
            currentLineNumber++;
        }

        return new TrailMap(map);
    }

    @Override
    public Long solvePart1(List<String> input) {
        TrailMap trailMap = createTrailMap(input);
        List<Point> pointWithHeight0 = trailMap.getPointWithHeight((byte) 0);

        long totalScore = 0L;
        for (Point startPoint : pointWithHeight0) {
            long currentScore = trailMap.calculateScoreForRouting(startPoint, (byte)9);
            if (currentScore!=0L) {
                System.out.println("route from " + startPoint + " to " + startPoint + " exists");
            }
            totalScore += currentScore;
        }

        return totalScore;
    }


    @Override
    public Long solvePart2(List<String> input) {
        TrailMap trailMap = createTrailMap(input);
        List<Point> pointWithHeight0 = trailMap.getPointWithHeight((byte) 0);

        long totalScore = 0L;
        for (Point startPoint : pointWithHeight0) {
            long currentScore = trailMap.calculateScoreForDistinctRouting(startPoint, (byte) 9);
            if (currentScore!=0L) {
                System.out.println("route from " + startPoint + " to " + startPoint + " exists");
            }
            totalScore += currentScore;
        }

        return totalScore;
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
