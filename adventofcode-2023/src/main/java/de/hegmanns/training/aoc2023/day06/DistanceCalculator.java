package de.hegmanns.training.aoc2023.day06;

public class DistanceCalculator {

    public static long getDifferentWaysForWinning(Race race) {
        int countWinningRaces = 0;
        for (long holdingTime = 0; holdingTime < race.totalTime(); holdingTime++) {
            if (getDistance(race, holdingTime) > race.currentBestDistance()) {
                countWinningRaces++;
            }
        }
        return countWinningRaces;
    }

    public static long getDistance(Race race, long buttonHoldingTime) {
        long totalTime = race.totalTime();

        long racingTime = totalTime - buttonHoldingTime;

        long distance = 0;
        if (racingTime >= 0) {
            distance = racingTime * buttonHoldingTime;
        }
        return distance;
    }
}
