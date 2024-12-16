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

    PageOrderingRules allPageOrderingRules;
    List<PageOrderingRule> pageOrderingRules = new ArrayList<>();
    List<Update> updates = new ArrayList<>();

    public void parseToInstances(List<String> input) {

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
                String[] numbers = line.split(",");
                List<Integer> allNumbers = Arrays.stream(line.split(",")).map(Integer::parseInt).toList();
                updates.add(new Update(allNumbers));
            }
        }

        allPageOrderingRules = new PageOrderingRules(pageOrderingRules);
    }

    @Override
    public Long solvePart1(List<String> input) {
        parseToInstances(input);

        long sumOfMiddleNumbers = 0L;
        int countOfNotMatching = 0;
        for (Update update : updates) {
            if (allPageOrderingRules.isMatching(update)) {
                sumOfMiddleNumbers += update.getMiddleNumber();
            } else {
                countOfNotMatching++;
            }
        }

        System.out.println("countOfNotMatching: " + countOfNotMatching);
        return sumOfMiddleNumbers ;
    }

    @Override
    public Long solvePart2(List<String> input) {
        parseToInstances(input);

        List<Update> failedUpdates = new ArrayList<>();
        long sumOfMiddleNumbers = 0L;
        int countOfNotMatching = 0;
        for (Update update : updates) {
            if (allPageOrderingRules.isMatching(update)) {
                sumOfMiddleNumbers += update.getMiddleNumber();
            } else {
                failedUpdates.add(update);
                countOfNotMatching++;
            }
        }

        System.out.println("countOfNotMatching: " + countOfNotMatching);
        sumOfMiddleNumbers = 0L;

        for (Update update : failedUpdates) {
            Set<PageOrderingRule> possibleRules = allPageOrderingRules.gatherAllRelevantRules(update);
            Update rebuiltUpdate = update.rebuild(possibleRules);
            if (rebuiltUpdate == null) {
                throw new RuntimeException("rebuild failed");
            }
            sumOfMiddleNumbers += rebuiltUpdate.getMiddleNumber();
        }


        return sumOfMiddleNumbers ;
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
