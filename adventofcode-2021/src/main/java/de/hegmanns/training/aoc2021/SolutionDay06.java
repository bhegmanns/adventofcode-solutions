package de.hegmanns.training.aoc2021;

import de.hegmanns.training.aoc.common.AoCFileReader;
import de.hegmanns.training.aoc.common.AoCSolution;
import de.hegmanns.training.aoc2021.day06.Laternfish;
import de.hegmanns.training.aoc2021.day06.TimerValueWithCountOfLaternfishes;

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
        List<Laternfish> laternfishes = Arrays.stream(input.get(0).split(",")).map(Integer::parseInt).map(Laternfish::new).collect(Collectors.toList());

        for (int day = 0; day < 80; day++) {
            var countNewLaterfishesForTheDay = 0;
            for (Laternfish laternfish : laternfishes) {
                if (laternfish.nextDay()) {
                    countNewLaterfishesForTheDay++;
                }
            }
            IntStream.range(0, countNewLaterfishesForTheDay).forEach((i) -> laternfishes.add(new Laternfish(8)));
        }

        return laternfishes.size();
    }

    @Override
    public Long solvePart2(List<String> input) {
        List<Integer> initialTimers = Arrays.stream(input.get(0).split(",")).map(Integer::parseInt).collect(Collectors.toList());
        List<TimerValueWithCountOfLaternfishes> timers = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            timers.add(new TimerValueWithCountOfLaternfishes(i-1, 0));
        }
        for (int timer : initialTimers) {
            timers.get(timer+1).incrementCountOfLaternfishes();
        }

        for (int day = 0; day < 256; day++) {
            var currentCountForNegativ = timers.get(1).getCountOfLaternfishes();
            for (int i = 0; i < timers.size() - 1; i++) {
                timers.get(i).setCountOfLaternfishes(timers.get(i+1).getCountOfLaternfishes());
            }
            timers.get(9).setCountOfLaternfishes(currentCountForNegativ);
            timers.get(7).addToCountOfLaternfishes(currentCountForNegativ);
        }

        return timers.stream().filter(t -> t.getTimerValue() != -1).map(TimerValueWithCountOfLaternfishes::getCountOfLaternfishes).mapToLong(Long::longValue).sum();
    }
}
