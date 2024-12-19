package de.hegmanns.training.aoc2024;

import de.hegmanns.training.aoc.common.*;
import de.hegmanns.training.aoc.common.geometric.*;
import de.hegmanns.training.aoc2024.day05.*;
import de.hegmanns.training.aoc2024.day06.NorthPoleMap;
import de.hegmanns.training.aoc2024.day06.NorthpoleGuard;
import de.hegmanns.training.aoc2024.day06.Path;
import org.apache.commons.lang3.*;
import org.apache.commons.lang3.tuple.*;

import java.util.*;

public class SolutionDay06 implements AoCSolution<Long, Long> {
    public static final String FILE_NAME = "day06_task.txt";


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


    @Override
    public Long solvePart1(List<String> input) {
        Pair<NorthPoleMap, NorthpoleGuard> build = NorthPoleMap.Builder.create().addLines(input).build();
        NorthPoleMap northPoleMap = build.getLeft();
        NorthpoleGuard initialNorthpoleGuard = build.getRight();

        northPoleMap.printOut();
        NorthPoleMap resultOfWalkThrough = northPoleMap.walkThrough(initialNorthpoleGuard).getLeft();
        System.out.println("------");
        resultOfWalkThrough.printOut();

        return (long)resultOfWalkThrough.getCountOfTourchedPositions();
    }

    private record Step(Point currentGuardPosition, Point direction) {

    }

    @Override
    public Long solvePart2(List<String> input) {
        Pair<NorthPoleMap, NorthpoleGuard> build = NorthPoleMap.Builder.create().addLines(input).build();
        NorthPoleMap northPoleMap = build.getLeft();
        NorthpoleGuard initialNorthpoleGuard = build.getRight();
        northPoleMap.printOut();

        Pair<NorthPoleMap, de.hegmanns.training.aoc2024.day06.Path> northPoleMapPathPair = northPoleMap.walkThrough(initialNorthpoleGuard);

        de.hegmanns.training.aoc2024.day06.Path path = northPoleMapPathPair.getRight();

        long countOfCircles = 0;
        List<Point> barrierPositions = new ArrayList<>(new HashSet<>(path.getPoints()));
        for (int i = 1 ; i < barrierPositions.size() ; i++) {
            NorthPoleMap testMap = new NorthPoleMap(northPoleMap);
            Point point = barrierPositions.get(i);

            testMap.map[point.y()][point.x()] = NorthPoleMap.Property.ADDITIONAL_OBSTRUCTION;

            try{testMap.walkThrough(initialNorthpoleGuard);}catch(RuntimeException e){
                if (e.getMessage().equals(NorthPoleMap.NOT_OUT_OF_FIELD)){
                    countOfCircles++;
                }
            }
        }

        return countOfCircles;
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
