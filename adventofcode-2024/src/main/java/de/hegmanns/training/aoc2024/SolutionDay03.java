package de.hegmanns.training.aoc2024;

import de.hegmanns.training.aoc.common.*;

import java.util.*;
import java.util.stream.*;

public class SolutionDay03 implements AoCSolution<Long, Long> {
    public static final String FILE_NAME = "day03_task.txt";

    public static void main(String[] args) {
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay02.class, FILE_NAME);

        SolutionDay03 solution = new SolutionDay03();
        System.out.println("Part 1: " + solution.solvePart1(inputAsList));
        System.out.println("===");
        System.out.println("Part 2: " + solution.solvePart2(inputAsList));
    }

    private static List<String> getInputList() {
        return AoCFileReader.getInputAsList(SolutionDay03.class, FILE_NAME);
    }


    @Override
    public Long solvePart1(List<String> input) {
        String totalString = input.stream().collect(Collectors.joining(""));
        long sumOfFactors = 0L;

        int indexOpenBracket = -1;
        do {
            indexOpenBracket = totalString.indexOf("mul(", indexOpenBracket + 1);
            if (indexOpenBracket != -1) {
                int indexClosingBracket = totalString.indexOf(")", indexOpenBracket);
                if (indexClosingBracket != -1) {
                    String[] split = totalString.substring(indexOpenBracket + 4, indexClosingBracket).split(",");
                    if (split.length == 2) {
                        Long firstFactor = null;
                        Long secondFactor = null;
                        Long factor = null;
                        try {
                            firstFactor = Long.parseLong(split[0]);
                            secondFactor = Long.parseLong(split[1]);
                            factor = firstFactor * secondFactor;
                            sumOfFactors += factor;
                        } catch (Exception e) {

                        }

                    }
                }
            }
        }while (indexOpenBracket != -1);

        return sumOfFactors;
    }

    @Override
    public Long solvePart2(List<String> input) {
        String totalString = input.stream().collect(Collectors.joining(""));
        long sumOfFactors = 0L;

        boolean enablesInstructions = true;
        int disableIndex = totalString.indexOf("don't()");

        int indexOpenBracket = -1;
        do {
            indexOpenBracket = totalString.indexOf("mul(", indexOpenBracket + 1);
            if (indexOpenBracket != -1) {
                if (indexOpenBracket>disableIndex) {
                    indexOpenBracket = totalString.indexOf("do()", disableIndex);
                    disableIndex = totalString.indexOf("don't()", indexOpenBracket);
                    if (disableIndex == -1) {
                        disableIndex = Integer.MAX_VALUE;
                    }
                    continue;
                }

                int indexClosingBracket = totalString.indexOf(")", indexOpenBracket);
                if (indexClosingBracket != -1) {
                    String[] split = totalString.substring(indexOpenBracket + 4, indexClosingBracket).split(",");
                    if (split.length == 2) {
                        Long firstFactor = null;
                        Long secondFactor = null;
                        Long factor = null;
                        try {
                            firstFactor = Long.parseLong(split[0]);
                            secondFactor = Long.parseLong(split[1]);
                            factor = firstFactor * secondFactor;
                            sumOfFactors += factor;
                        } catch (Exception e) {

                        }

                    }
                }
            }
        }while (indexOpenBracket != -1);

        return sumOfFactors;
    }

    @Override
    public Long getSolution1() {
        return solvePart1(getInputList());
    }

    @Override
    public Long getSolution2() {
        return solvePart2(getInputList());
    }
}
