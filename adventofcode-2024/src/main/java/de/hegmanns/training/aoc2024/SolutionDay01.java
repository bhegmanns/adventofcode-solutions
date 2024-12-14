package de.hegmanns.training.aoc2024;

import de.hegmanns.training.aoc.common.*;

import java.util.*;

public class SolutionDay01 implements AoCSolution<Long, Long> {
    private static final String FILE_NAME = "day01_task.txt";

    public static void main(String[] args) {
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay01.class, FILE_NAME);

        SolutionDay01 solution = new SolutionDay01();
        System.out.println("Part 1: " + solution.solvePart1(inputAsList));
        System.out.println("===");
        System.out.println("Part 2: " + solution.solvePart2(inputAsList));
    }

    private static List<String> getInputList() {
        return AoCFileReader.getInputAsList(SolutionDay01.class, FILE_NAME);
    }


    @Override
    public Long solvePart1(List<String> input) {
        Map<Long, Integer> countLefts = new HashMap<>();
        Map<Long, Integer> countRights = new HashMap<>();
        int countOfLines = 0;
        for (String line : input) {
            countOfLines++;
            String[] split = line.split(" ");
            Long leftNumber = Long.parseLong(split[0]);
            Long rightNumber = Long.parseLong(split[split.length-1]);

            Integer i = countLefts.get(leftNumber);
            if (i == null) {
                countLefts.put(leftNumber, 1);
            } else {
                countLefts.put(leftNumber, i + 1);
            }
            Integer j = countRights.get(rightNumber);
            if (j == null) {
                countRights.put(rightNumber, 1);
            }else {
                countRights.put(rightNumber, j + 1);
            }
        }

        List<Long> sortedLeftKeys = countLefts.keySet().stream().sorted().toList();
        List<Long> sortedRightKeys = countRights.keySet().stream().sorted().toList();

        int indexLeft = 0;
        int indexRight = 0;
        long diffsum = 0L;
        for (int i = 0 ; i < countOfLines ; i++) {
            Long smallestNumberLeft = sortedLeftKeys.get(indexLeft);
            Long smallestNumberRight = sortedRightKeys.get(indexRight);

            diffsum+= Math.abs(smallestNumberLeft - smallestNumberRight);
            Integer countLeft = countLefts.get(smallestNumberLeft);
            Integer countRight = countRights.get(smallestNumberRight);
            countLefts.put(smallestNumberLeft, countLeft - 1);
            countRights.put(smallestNumberRight, countRight - 1);
            if (countLeft == 1) {
                indexLeft++;
            }
            if (countRight == 1) {
                indexRight++;
            }
        }

        return diffsum;
    }

    @Override
    public Long solvePart2(List<String> input) {
        Map<Long, Integer> countLefts = new HashMap<>();
        Map<Long, Integer> countRights = new HashMap<>();

        List<Long> leftNumbers = new ArrayList<>();
        List<Long> rightNumbers = new ArrayList<>();
        int countOfLines = 0;
        for (String line : input) {
            countOfLines++;
            String[] split = line.split(" ");
            Long leftNumber = Long.parseLong(split[0]);
            Long rightNumber = Long.parseLong(split[split.length-1]);

            Integer i = countLefts.get(leftNumber);
            if (i == null) {
                countLefts.put(leftNumber, 1);
            } else {
                countLefts.put(leftNumber, i + 1);
            }
            Integer j = countRights.get(rightNumber);
            if (j == null) {
                countRights.put(rightNumber, 1);
            }else {
                countRights.put(rightNumber, j + 1);
            }
            leftNumbers.add(leftNumber);
            rightNumbers.add(rightNumber);
        }


        int indexLeft = 0;
        int indexRight = 0;
        long diffsum = 0L;
        for (Long leftNumber : leftNumbers) {

            Integer countSimilaryNumberOnRight = countRights.getOrDefault(leftNumber, 0);
            Integer countNumberOnLeft = countLefts.get(leftNumber);




            long factor = leftNumber*countSimilaryNumberOnRight;

            diffsum+= leftNumber*countSimilaryNumberOnRight;

        }

        return diffsum;
    }

    @Override
    public Long getSolution1() {
        return new SolutionDay01().getSolution1();
    }

    @Override
    public Long getSolution2() {
        return new SolutionDay01().getSolution2();
    }
}
