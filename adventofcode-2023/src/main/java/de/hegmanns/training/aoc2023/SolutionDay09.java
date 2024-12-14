package de.hegmanns.training.aoc2023;

import de.hegmanns.training.aoc.common.AoCFileReader;
import de.hegmanns.training.aoc.common.AoCSolution;
import de.hegmanns.training.aoc2023.day09.OasisCalculator;

import java.util.List;

public class SolutionDay09 implements AoCSolution<Long, Long> {

    public static void main(String[] args) {
        SolutionDay09 solution = new SolutionDay09();
        System.out.println("Part 1: " + solution.getSolution1());
        System.out.println("===");
        System.out.println("Part 2: " + solution.getSolution2());
    }

    private static List<String> getInputList() {
        return AoCFileReader.getInputAsList(SolutionDay09.class, "day09t.txt");
    }
    @Override
    public Long solvePart1(List<String> input) {
        return input.stream().map(OasisCalculator::parseToLongList).mapToLong(OasisCalculator::calculateNextOasisValue).sum();
    }

    @Override
    public Long solvePart2(List<String> input) {
        return input.stream().map(OasisCalculator::parseToLongList).mapToLong(OasisCalculator::calculatePreviousOasisValue).sum();
    }

    @Override
    public Long getSolution1() {
        return new SolutionDay09().solvePart1(getInputList());
    }

    @Override
    public Long getSolution2() {
        return new SolutionDay09().solvePart2(getInputList());
    }
}
