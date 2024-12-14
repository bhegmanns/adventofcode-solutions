package de.hegmanns.training.aoc2024;

import de.hegmanns.training.aoc.common.*;

import java.util.*;

public class SolutionDay02 implements AoCSolution<Long, Long> {
    private static final String FILE_NAME = "day02_task.txt";

    public static void main(String[] args) {
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay02.class, FILE_NAME);

        SolutionDay02 solution = new SolutionDay02();
        System.out.println("Part 1: " + solution.solvePart1(inputAsList));
        System.out.println("===");
        System.out.println("Part 2: " + solution.solvePart2(inputAsList));
    }

    private static List<String> getInputList() {
        return AoCFileReader.getInputAsList(SolutionDay02.class, FILE_NAME);
    }

    @Override
    public Long solvePart1(List<String> input) {
        long countOfSafe = 0;

        for (String line : input) {
            String[] split = line.split(" ");
            List<Long> numbers = new ArrayList<>();
            for (int i = 0; i < split.length; i++) {
                numbers.add(Long.parseLong(split[i]));
            }
            if (check1(numbers)){
                countOfSafe++;
            }
        }
        return countOfSafe;
    }

    private boolean check1(List<Long> longs) {
        long pre = longs.get(0);
        boolean growing = longs.get(1)>pre;
        boolean result = true;
        for (int i = 1; i < longs.size(); i++) {
            result = (longs.get(i)>pre)==growing;
            long diff = Math.abs(longs.get(i)-pre);

            result = result && (diff>0&&diff<4);
            if (!result) {
                break;
            }
            pre = longs.get(i);
        }
        return result;
    }

    private boolean check2(List<Long> longs) {
        boolean longCheckResult = true;
        for (int index = -1; index < longs.size(); index++) {
            List<Long> copyOfLongs = new ArrayList<>(longs);
            if (index >= 0) {
                copyOfLongs.remove(index);
            }

            longCheckResult = check1(copyOfLongs);
            if (longCheckResult) {
                break;
            }
        }
        return longCheckResult;
    }

    @Override
    public Long solvePart2(List<String> input) {
        long countOfSafe = 0;

        for (String line : input) {
            String[] split = line.split(" ");
            List<Long> numbers = new ArrayList<>();
            for (int i = 0; i < split.length; i++) {
                numbers.add(Long.parseLong(split[i]));
            }
            if (check2(numbers)){
                countOfSafe++;
            }
        }
        return countOfSafe;
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
