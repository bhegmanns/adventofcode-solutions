package de.hegmanns.training.aoc2022;

import de.hegmanns.training.aoc.common.AoCFileReader;
import de.hegmanns.training.aoc.common.AoCSolution;

import java.util.List;
import java.util.stream.IntStream;

/**
 * Solution of www.adventofcode.com/2022 day 04.
 */
public class SolutionDay04 implements AoCSolution<Integer, Integer> {

    public static void main(String[] args) {
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay04.class, "day04.txt");

        SolutionDay04 solution = new SolutionDay04();

        System.out.println("Part 1: " + solution.solvePart1(inputAsList));
        System.out.println("=====");
        System.out.println("Part 2: " + solution.solvePart2(inputAsList));
    }


    private static IntStream[] parseInto(String line){
        String[] split = line.split("-,");
        IntStream first = IntStream.range(Integer.parseInt(split[0]), Integer.parseInt(split[1]) + 1);
        IntStream second = IntStream.range(Integer.parseInt(split[2]), Integer.parseInt(split[3]) + 1);

        IntStream[] result = new IntStream[2];
        result[0] = first;
        result[1] = second;

        return result;
    }

    private static int[] parseIntoArray(String line){
        String[] split = line.split("-|,");
        int[] result = new int[4];
        result[0] = Integer.parseInt(split[0]);
        result[1] = Integer.parseInt(split[1]);
        result[2] = Integer.parseInt(split[2]);
        result[3] = Integer.parseInt(split[3]);

        return result;
    }

    private static boolean secondInFirst(int firstStart, int firstFinal, int secondStart, int secondFinal) {
        if (secondStart >= firstStart && secondStart <= firstFinal && secondFinal >= firstStart && secondFinal <= firstFinal) {
            return true;
        }
        return false;
    }

    private static boolean secondOverlapsFirst(int firstStart, int firstFinal, int secondStart, int secondFinal) {
        if (secondStart >= firstStart && secondStart <= firstFinal || secondFinal >= firstStart && secondFinal <= firstFinal) {
            return true;
        }
        return false;
    }

    @Override
    public Integer solvePart1(List<String> input) {
        int countOfOverlappings = 0;
        for (String line : input) {
            int[] ints = parseIntoArray(line);

            if (secondInFirst(ints[0], ints[1], ints[2], ints[3]) || secondInFirst(ints[2], ints[3], ints[0], ints[1])) {
                countOfOverlappings++;
            }


        }
        return countOfOverlappings;
    }

    @Override
    public Integer solvePart2(List<String> input) {
        int countOfOverlappings = 0;
        for (String line : input) {
            int[] ints = parseIntoArray(line);

            if (secondOverlapsFirst(ints[0], ints[1], ints[2], ints[3]) || secondOverlapsFirst(ints[2], ints[3], ints[0], ints[1])) {
                countOfOverlappings++;
            }


        }
        return countOfOverlappings;
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
