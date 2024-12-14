package de.hegmanns.training.aoc2023.day21;

import java.util.*;

public class GardenRockMapSolutioner {

    public static Long getCountOfPossibleReachedGardensAfterSteps(GardenRockMap map, MapPosition startPosition, int countOfSteps, boolean withExpansion) {
        Map<MapPosition, Set<MapPosition>> positionToNextPositions = new HashMap<>();

        long startTime = System.currentTimeMillis();
        int diff = countOfSteps/10 + 1;

        Set<MapPosition> nextPositions = new HashSet<>();

        Set<MapPosition> currentPositions = new HashSet<>();
        currentPositions.add(startPosition);
        System.out.println();
        for (int i = 0; i < countOfSteps; i++) {
            if (i % diff == 0) {
                System.out.print(".");
            }
            nextPositions = new HashSet<>(nextPositions.size() * 2);
            for (MapPosition position : currentPositions) {
                Set<MapPosition> savedNextPositions = positionToNextPositions.get(position);
                if (savedNextPositions == null) {
                    savedNextPositions = new HashSet<>(map.getPossibleReachablePositionInNextStep(position, withExpansion));
                    positionToNextPositions.put(position, savedNextPositions);
                }
                nextPositions.addAll(savedNextPositions);
            }
            currentPositions = nextPositions;
        }
        System.out.println();
        long finalTime = System.currentTimeMillis();
        System.out.println("total time for calculation = " + (finalTime - startTime) + "ms");
        return (long) currentPositions.size();
    }

    public static Long getCountOfPossibleReachedGardensAfterSteps(GardenRockMap map, MapPosition startPosition, int countOfSteps) {
        return getCountOfPossibleReachedGardensAfterSteps(map, startPosition, countOfSteps, false);
    }
}
