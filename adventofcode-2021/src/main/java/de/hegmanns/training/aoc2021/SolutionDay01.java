package de.hegmanns.training.aoc2021;

import de.hegmanns.training.aoc.common.AoCFileReader;
import de.hegmanns.training.aoc.common.AoCSolution;

import java.util.ArrayList;
import java.util.List;

public class SolutionDay01 implements AoCSolution<Integer, Integer> {

    public static void main(String[] args) {
        List<String> input = AoCFileReader.getInputAsList(SolutionDay01.class, "day01.txt");
        SolutionDay01 solution = new SolutionDay01();
        System.out.println("part1 >>> " + solution.solvePart1(input));
        System.out.println("part2 >>> " + solution.solvePart2(input));
    }

    @Override
    public Integer solvePart1(List<String> input) {
        var preValue = Integer.MAX_VALUE;
        int currentValue;
        var countIncreasedValues = 0;

        for (String s : input) {
            currentValue = Integer.parseInt(s);
            if (currentValue > preValue) {
                countIncreasedValues++;
            }
            preValue = currentValue;
        }

        return countIncreasedValues;
    }

    @Override
    public Integer solvePart2(List<String> input) {
        var newList = new ArrayList<String>();

        for (var currentIndex = 0; currentIndex <= input.size() - 3; currentIndex++) {
            var sublist = input.subList(currentIndex, currentIndex + 3);
            var sum = sublist.stream().mapToInt(Integer::parseInt).sum();
            newList.add("" + sum);
        }

        return solvePart1(newList);
    }

    @Override
    public Integer getSolution1() {
        return null;
    }

    @Override
    public Integer getSolution2() {
        return null;
    }
}
