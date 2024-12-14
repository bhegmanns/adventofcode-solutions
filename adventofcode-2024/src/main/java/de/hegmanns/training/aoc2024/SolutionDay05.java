package de.hegmanns.training.aoc2024;

import de.hegmanns.training.aoc.common.*;
import de.hegmanns.training.aoc2024.day05.*;

import java.util.*;

public class SolutionDay05 implements AoCSolution<Long, Long> {
    public static final String FILE_NAME = "day05_task.txt";

    public static void main(String[] args) {
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay05.class, FILE_NAME);

        SolutionDay05 solution = new SolutionDay05();
        System.out.println("Part 1: " + solution.solvePart1(inputAsList));
        System.out.println("===");
        System.out.println("Part 2: " + solution.solvePart2(inputAsList));
    }

    private static List<String> getInputList() {
        return AoCFileReader.getInputAsList(SolutionDay04.class, FILE_NAME);
    }

    List<PageOrderingRule> pageOrderingRules = new ArrayList<>();

    public void foo(List<String> input) {

        boolean fillPageOrderingRules = true;
        for (String line : input) {
            if (fillPageOrderingRules) {
                if (line.trim().isBlank()) {
                    fillPageOrderingRules = false;
                    continue;
                } else {
                    String[] split = line.split("\\|");
                    pageOrderingRules.add(new PageOrderingRule(split[0], split[1]));
                }
            } else {

            }
        }
    }

    @Override
    public Long solvePart1(List<String> input) {
        return 0L;
    }

    @Override
    public Long solvePart2(List<String> input) {
        return 0L;
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
