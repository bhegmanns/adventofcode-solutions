package de.hegmanns.training.aoc2023;

import de.hegmanns.training.aoc.common.AoCFileReader;
import de.hegmanns.training.aoc.common.AoCSolution;
import de.hegmanns.training.aoc2023.day06.DistanceCalculator;
import de.hegmanns.training.aoc2023.day06.Race;

import java.util.ArrayList;
import java.util.List;

public class SolutionDay06 implements AoCSolution<Long, Long> {

    public static void main(String[] args) {
        SolutionDay06 solution = new SolutionDay06();
        System.out.println("Part 1: " + solution.getSolution1());
        System.out.println("===");
        System.out.println("Part 2: " + solution.getSolution2());
    }

    private static List<String> getInputList() {
        return AoCFileReader.getInputAsList(SolutionDay06.class, "day06t.txt");
    }

    @Override
    public Long solvePart1(List<String> input) {
//        Time:      7  15   30
//        Distance:  9  40  200
        String times = input.get(0).trim().split(":")[1];
        String distances = input.get(1).trim().split(":")[1];
        List<String> timeList = List.of(times.split(" ")).stream().filter(s -> !s.isEmpty() && !s.isBlank()).toList();
        List<String> distanceList = List.of(distances.split(" ")).stream().filter(s -> !s.isEmpty() && !s.isBlank()).toList();

        if (timeList.size() != distanceList.size()) {
            throw new RuntimeException("Problem mit groesen: timelist" + timeList.size() + "vs distancelist " + distanceList.size());
        }

        List<Race> races = new ArrayList<>();
        for (int i = 0; i < timeList.size(); i++) {
            races.add(new Race(Long.parseLong(timeList.get(i)), Long.parseLong(distanceList.get(i))));
        }

        long productOfDifferentWinningWays = 1;
        for (Race race : races) {
            productOfDifferentWinningWays *= DistanceCalculator.getDifferentWaysForWinning(race);
        }
        return productOfDifferentWinningWays;
    }

    @Override
    public Long solvePart2(List<String> input) {
        //        Time:      7  15   30
//        Distance:  9  40  200
        String time = input.get(0).trim().split(":")[1].replace(" ", "").trim();
        String distance = input.get(1).trim().split(":")[1].replace(" ", "").trim();


        Race race = new Race(Long.parseLong(time), Long.parseLong(distance));

        return DistanceCalculator.getDifferentWaysForWinning(race);
    }

    @Override
    public Long getSolution1() {
        return new SolutionDay06().solvePart1(getInputList());
    }

    @Override
    public Long getSolution2() {
        return new SolutionDay06().solvePart2(getInputList());
    }
}
