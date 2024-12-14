package de.hegmanns.training.aoc2023;

import de.hegmanns.training.aoc.common.AoCFileReader;
import de.hegmanns.training.aoc.common.AoCSolution;
import de.hegmanns.training.aoc2023.day21.GardenRockMapCreator;
import de.hegmanns.training.aoc2023.day21.GardenRockMapSolutioner;

import java.util.List;

public class SolutionDay21 implements AoCSolution<Long, Long> {

    public static void main(String[] args) {
        SolutionDay21 solution = new SolutionDay21();
        System.out.println("Part 1: " + solution.getSolution1());
        System.out.println("===");
        System.out.println("Part 2: " + solution.getSolution2());
    }

    public static SolutionDay21 getSolutionInstance() {
        return new SolutionDay21();
    }

    private static List<String> getInputList() {
        return AoCFileReader.getInputAsList(SolutionDay21.class, "day21t.txt");
    }

    @Override
    public Long solvePart1(List<String> input) {
        GardenRockMapCreator gardenRockMapCreator = new GardenRockMapCreator(input);

        return GardenRockMapSolutioner.getCountOfPossibleReachedGardensAfterSteps(gardenRockMapCreator.getGardenRockMap(), gardenRockMapCreator.getStartPosition(), 64);
    }

    @Override
    public Long solvePart2(List<String> input) {

        GardenRockMapCreator gardenRockMapCreator = new GardenRockMapCreator(input);

        return GardenRockMapSolutioner.getCountOfPossibleReachedGardensAfterSteps(gardenRockMapCreator.getGardenRockMap(), gardenRockMapCreator.getStartPosition(), 26501365);
    }

    @Override
    public Long getSolution1() {
        return new SolutionDay21().solvePart1(getInputList());
    }

    @Override
    public Long getSolution2() {
        return new SolutionDay21().solvePart2(getInputList());
    }
}
