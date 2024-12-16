package de.hegmanns.training.aoc2024;

import de.hegmanns.training.aoc.common.*;
import de.hegmanns.training.aoc2024.day05.*;
import org.apache.commons.lang3.tuple.*;

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

        List<Update> matchingUpdates = new MatchingAndUnmatchingUpdates(updates).getMatching(allPageOrderingRules);

        long sumOfMiddleNumbers = 0L;
        int countOfNotMatching = 0;
        for (Update update : updates) {
            if (allPageOrderingRules.isMatching(update)) {
                sumOfMiddleNumbers += update.getMiddleNumber();
            } else {
                countOfNotMatching++;
            }
        }

        System.out.println("countOfNotMatching: " + matchingUpdates.size());
        return matchingUpdates.stream().map(Update::getMiddleNumber).mapToLong(Long::valueOf).sum() ;
    }

    private record MatchingAndUnmatchingUpdates(List<Update> updates) {

        public List<Update> getMatching(PageOrderingRules pageOrderingRules) {
            return devideUpdates(pageOrderingRules).getLeft();
        }

        public List<Update> getUnmatching(PageOrderingRules pageOrderingRules) {
            return devideUpdates(pageOrderingRules).getRight();
        }

        private Pair<List<Update>, List<Update>> devideUpdates(PageOrderingRules pageOrderingRules) {
            List<Update> matchingUpdates = new ArrayList<>();
            List<Update> unmatchingUpdates = new ArrayList<>();
            for (Update update : updates) {
                if (pageOrderingRules.isMatching(update)) {
                    matchingUpdates.add(update);
                } else {
                    unmatchingUpdates.add(update);
                }
            }

            return Pair.of(matchingUpdates, unmatchingUpdates);
        }

    }

    @Override
    public Long solvePart2(List<String> input) {
        parseToInstances(input);

        List<Update> failedUpdates = new MatchingAndUnmatchingUpdates(updates).getUnmatching(allPageOrderingRules);

        System.out.println("countOfNotMatching: " + failedUpdates.size());
        long sumOfMiddleNumbers = 0L;
        for (Update update : failedUpdates) {
            Set<PageOrderingRule> relevantRulesForUpdate = allPageOrderingRules.gatherAllRelevantRules(update);

            Map<Integer, List<Integer>> mapOfRules = new HashMap<>();
            for (PageOrderingRule rule : relevantRulesForUpdate) {
                List<Integer> integers = mapOfRules.get(rule.getBefore());
                if (integers == null) {
                    integers = new ArrayList<>();
                    mapOfRules.put(rule.getBefore(), integers);
                }
                integers.add(rule.getAfter());
            }
            List<Integer> pages = new ArrayList<>();
            Map.Entry<Integer, List<Integer>> forRules = findForRules(mapOfRules, 1);
            pages.add(forRules.getKey());
            pages.add(forRules.getValue().get(0));

            // now the next
            for (int count = 2; count < update.getPages().size(); count++) {
                forRules = findForRules(mapOfRules, count);
                List<Integer> afterPages = forRules.getValue();
                Integer thisPage = forRules.getKey();
                boolean placed = false;
                for (int i = pages.size()-1 ; i>=0 ; i--) {
                    if (!afterPages.contains(pages.get(i))) {
                        pages.add(i+1, thisPage);
                        placed = true;
                        break;
                    }
                }
                if (!placed) {
                    pages.add(0, thisPage);
                }
            }
            Update correctedUpdate = new Update(pages);
            System.out.println(correctedUpdate);
            sumOfMiddleNumbers+= correctedUpdate.getMiddleNumber();
        }


        return sumOfMiddleNumbers ;
    }

    private Map.Entry<Integer, List<Integer>> findForRules(Map<Integer, List<Integer>> mapOfRules, int countPages) {
        return mapOfRules.entrySet().stream().filter(e -> e.getValue().size() == countPages).findFirst().get();
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
