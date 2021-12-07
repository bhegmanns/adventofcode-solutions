package de.hegmanns.training.aoc2021;

import de.hegmanns.training.aoc.common.AoCSolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SolutionDay07  implements AoCSolution<Integer, Integer>{

    @Override
    public Integer solvePart1(List<String> input) {
        List<Integer> positions = Arrays.stream(input.get(0).split(",")).map(Integer::parseInt).sorted().collect(Collectors.toList());
        List<Integer> neededFuels = new ArrayList<>();
        for (int possibleFinalPosition = positions.get(0) - 1; possibleFinalPosition <= positions.get(positions.size() - 1) + 1; possibleFinalPosition++) {
            int finalPossibleFinalPosition = possibleFinalPosition;
            neededFuels.add(positions.stream().map((p) -> Math.abs(finalPossibleFinalPosition - p)).mapToInt(Integer::intValue).sum());
        }



        return neededFuels.stream().sorted().findFirst().get();
    }

    /**
     * Calculated sum of numbers from 1..n with gauss-alg.
     *
     * This alg works for every number because for 0, the second factor is 0 so result is 0.
     * And whatever you take, there is one odd and one even number as factor so that devide with 2 will be calculated without rest every time.
     *
     * @param number last number to sum
     * @return sum of numbers
     */
    private static int calculateSumUpTo(int number) {
        return (number+1)*number/2;
    }

    @Override
    public Integer solvePart2(List<String> input) {
        List<Integer> positions = Arrays.stream(input.get(0).split(",")).map(Integer::parseInt).sorted().collect(Collectors.toList());
        List<Integer> neededFuels = new ArrayList<>();
        for (int possibleFinalPosition = positions.get(0) - 1; possibleFinalPosition <= positions.get(positions.size() - 1) + 1; possibleFinalPosition++) {
            int finalPossibleFinalPosition = possibleFinalPosition;
            neededFuels.add(positions.stream().map((p) -> Math.abs(finalPossibleFinalPosition - p)).map(SolutionDay07::calculateSumUpTo).mapToInt(Integer::intValue).sum());
        }
        return neededFuels.stream().sorted().findFirst().get();
    }
}
