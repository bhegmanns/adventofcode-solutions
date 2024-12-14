package de.hegmanns.training.aoc2023;

import de.hegmanns.training.aoc.common.AoCFileReader;
import de.hegmanns.training.aoc.common.AoCSolution;
import de.hegmanns.training.aoc2023.day13.ReflectionPattern;

import java.util.List;

public class SolutionDay13 implements AoCSolution<Long, Long> {

    public static void main(String[] args) {
        SolutionDay13 solution = new SolutionDay13();
        System.out.println("Part 1: " + solution.getSolution1());
        System.out.println("===");
        System.out.println("Part 2: " + solution.getSolution2());
    }

    private static List<String> getInputList() {
        return AoCFileReader.getInputAsList(SolutionDay13.class, "day13t.txt");
    }

    @Override
    public Long solvePart1(List<String> input) {

        ReflectionPattern.ReflectionPatternBuilder reflectionPatternBuilder = ReflectionPattern.ReflectionPatternBuilder.create();
        input.forEach(reflectionPatternBuilder::addLine);
        List<ReflectionPattern> reflectionPatterns = reflectionPatternBuilder.build();
        long sum = 0L;

        for (var reflectionPattern : reflectionPatterns) {
            sum += 100L*reflectionPattern.findHorizontalReflectionLine();
            sum += reflectionPattern.findVerticalReflectionLine();
        }

        return sum;
    }

    @Override
    public Long solvePart2(List<String> input) {
        ReflectionPattern.ReflectionPatternBuilder reflectionPatternBuilder = ReflectionPattern.ReflectionPatternBuilder.create();
        input.forEach(reflectionPatternBuilder::addLine);
        List<ReflectionPattern> reflectionPatterns = reflectionPatternBuilder.build();
        long sum = 0L;

        for (var reflectionPattern : reflectionPatterns) {
            sum += 100L*reflectionPattern.findHorizontalReflectionLineWithSmudge();
            sum += reflectionPattern.findVerticalReflectionLine();
        }

        return sum;
    }

    @Override
    public Long getSolution1() {
        return new SolutionDay13().solvePart1(getInputList());
    }

    @Override
    public Long getSolution2() {
        return new SolutionDay13().solvePart2(getInputList());
    }
}
