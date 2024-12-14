package de.hegmanns.training.aoc2023;

import de.hegmanns.training.aoc.common.AoCFileReader;
import de.hegmanns.training.aoc.common.AoCSolution;
import de.hegmanns.training.aoc2023.day12.ConditionField;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionDay12 implements AoCSolution<Long, Long> {

    public static void main(String[] args) {
        SolutionDay12 solution = new SolutionDay12();
        System.out.println("Part 1: " + solution.getSolution1());
        System.out.println("===");
        System.out.println("Part 2: " + solution.getSolution2());
    }

    private static List<String> getInputList() {
        return AoCFileReader.getInputAsList(SolutionDay12.class, "day12t.txt");
    }

    @Override
    public Long solvePart1(List<String> input) {
        //#???#?#?.?##?#?.#. 7,5,1
        long sumOfTries = 0;
        List<ConditionField> conditionFields = new ArrayList<>();
        for (var line : input) {
            String[] split = line.split(" ");
            List<Integer> length = Arrays.stream(split[1].split(",")).map(Integer::parseInt).toList();
            ConditionField conditionField = new ConditionField(split[0], length);
            conditionFields.add(conditionField);
            sumOfTries += conditionField.getCountTries();
        }
        return sumOfTries;
    }

    @Override
    public Long solvePart2(List<String> input) {
        return null;
    }

    @Override
    public Long getSolution1() {
        return new SolutionDay12().solvePart1(getInputList());
    }

    @Override
    public Long getSolution2() {
        return new SolutionDay12().solvePart2(getInputList());
    }
}
