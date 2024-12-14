package de.hegmanns.training.aoc2023.day06;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DistanceCalculatorTest {

    @Test
    public void holdButtonZero() {
        Race anyRace = new Race(0, 1000);
        long distance = DistanceCalculator.getDistance(anyRace, 0);
        MatcherAssert.assertThat(distance, Matchers.is(0L));
    }

    @Test
    public void holdButtonMoreThanTotalTimeByTotalTimeZero() {
        Race anyRace = new Race(0, 1000);
        long distance = DistanceCalculator.getDistance(anyRace, 1);
        MatcherAssert.assertThat(distance, Matchers.is(0L));
    }

    @Test
    public void holdButtonMoreThanTotalTimeByAnyTotalTime() {
        Race anyRace = new Race(1000, 1000);
        long distance = DistanceCalculator.getDistance(anyRace, 1001);
        MatcherAssert.assertThat(distance, Matchers.is(0L));
    }

    @Test
    public void holdButtonEqualThanTotalTime() {
        Race anyRace = new Race(100, 1000);
        long distance = DistanceCalculator.getDistance(anyRace, 100);
        MatcherAssert.assertThat(distance, Matchers.is(0L));
    }

    @ParameterizedTest
    @CsvSource({"0, 0", "2, 10", "3, 12", "4, 12", "5, 10", "6, 6", "7, 0"})
    public void check(long holdingTime, long expectedDistance) {
        Race exampleRace = new Race(7, 9);
        long distance = DistanceCalculator.getDistance(exampleRace, holdingTime);
        MatcherAssert.assertThat(distance, Matchers.is(expectedDistance));
    }

    @Test
    public void getWaysOfWinning() {
        Race race = new Race(7, 9);
        long differentWaysForWinning = DistanceCalculator.getDifferentWaysForWinning(race);
        MatcherAssert.assertThat(differentWaysForWinning, Matchers.is(4L));
    }

    @ParameterizedTest
    @CsvSource({"7, 9, 4", "15, 40, 8", "30, 200, 9"})
    public void differentWaysOfWinning(long raceTotalTime, long raceCurrentBestDistance, long expectedCountOfDifferentWinningWays) {
        Race race = new Race(raceTotalTime, raceCurrentBestDistance);
        MatcherAssert.assertThat(DistanceCalculator.getDifferentWaysForWinning(race), Matchers.is(expectedCountOfDifferentWinningWays));
    }
}
