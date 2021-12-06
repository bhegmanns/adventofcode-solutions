package de.hegmanns.training.aoc2021;

import de.hegmanns.training.aoc.common.AoCFileReader;
import de.hegmanns.training.aoc.common.AoCSolution;
import de.hegmanns.training.aoc2021.day06.Lanternfish;
import de.hegmanns.training.aoc2021.day06.TimerValueWithCountOfLanternfishes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SolutionDay06 implements AoCSolution<Integer, Long> {

    public static void main(String[] args) {
        List<String> inputDay06 = AoCFileReader.getInputAsList(SolutionDay06.class, "day06");
        SolutionDay06 solution = new SolutionDay06();
        System.out.println("part1 >>> " + solution.solvePart1(inputDay06));
        System.out.println("part2 >>> " + solution.solvePart2(inputDay06));
    }

    @Override
    public Integer solvePart1(List<String> input) {
        List<Lanternfish> lanternfishes = Arrays.stream(input.get(0).split(",")).map(Integer::parseInt).map(Lanternfish::new).collect(Collectors.toList());

        for (int day = 0; day < 80; day++) {
            var countNewLanterfishesForTheDay = 0;
            for (Lanternfish lanternfish : lanternfishes) {
                if (lanternfish.nextDay()) {
                    countNewLanterfishesForTheDay++;
                }
            }
            IntStream.range(0, countNewLanterfishesForTheDay).forEach((i) -> lanternfishes.add(new Lanternfish(8)));
        }

        return lanternfishes.size();
    }

    @Override
    public Long solvePart2(List<String> input) {
        List<Integer> initialTimers = Arrays.stream(input.get(0).split(",")).map(Integer::parseInt).collect(Collectors.toList());
        List<TimerValueWithCountOfLanternfishes> timers = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            timers.add(new TimerValueWithCountOfLanternfishes(i-1, 0));
        }
        for (int timer : initialTimers) {
            timers.get(timer+1).incrementCountOfLanternfishes();
        }

        for (int day = 0; day < 256; day++) {
            var currentCountForNegativ = timers.get(1).getCountOfLanternfishes();
            for (int i = 0; i < timers.size() - 1; i++) {
                timers.get(i).setCountOfLanternfishes(timers.get(i+1).getCountOfLanternfishes());
            }
            timers.get(9).setCountOfLanternfishes(currentCountForNegativ);
            timers.get(7).addToCountOfLanternfishes(currentCountForNegativ);
        }

        return timers.stream().filter(t -> t.getTimerValue() != -1).map(TimerValueWithCountOfLanternfishes::getCountOfLanternfishes).mapToLong(Long::longValue).sum();
    }
}
