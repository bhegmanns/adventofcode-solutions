package de.hegmanns.training.aoc2023;

import de.hegmanns.training.aoc.common.AoCFileReader;
import de.hegmanns.training.aoc.common.AoCSolution;
import de.hegmanns.training.aoc2023.day08.NavigationRule;
import de.hegmanns.training.aoc2023.day08.NavigationRuleAnalyser;
import de.hegmanns.training.aoc2023.day08.Target;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionDay08 implements AoCSolution<Long, Long> {

    public static void main(String[] args) {
        SolutionDay08 solution = new SolutionDay08();
        System.out.println("Part 1: " + solution.getSolution1());
        System.out.println("===");
        System.out.println("Part 2: " + solution.getSolution2());
    }

    private static List<String> getInputList() {
        return AoCFileReader.getInputAsList(SolutionDay08.class, "day08t.txt");
    }

    @Override
    public Long solvePart1(List<String> input) {
        String navigationLine = input.get(0);
        Map<String, NavigationRule> ruleMap = createNavigationRuleMap(input);

        NavigationRule currentRule = ruleMap.get("AAA");
        int indexInNavigationLine = 0;
        long countOfSteps = 0;
        while (!currentRule.getFrom().equals("ZZZ")) {
            String target = currentRule.getTarget().getTarget(navigationLine.substring(indexInNavigationLine, indexInNavigationLine + 1));
            currentRule = ruleMap.get(target);
            indexInNavigationLine++;
            countOfSteps++;
            if (indexInNavigationLine >= navigationLine.length()) {
                indexInNavigationLine=0;
            }
        }

        return countOfSteps;
    }

    private static Map<String, NavigationRule> createNavigationRuleMap(List<String> input) {
        Map<String, NavigationRule> ruleMap = new HashMap<>();


        for (int line = 2; line < input.size(); line++) {
            String s = input.get(line);
            String[] split = s.split("=");
            String[] split1 = split[1].trim().replace("(", "").replace(")", "").split(",");

            NavigationRule rule = new NavigationRule(split[0].trim(), new Target(split1[0].trim(), split1[1].trim()));
            ruleMap.put(rule.getFrom(), rule);
        }
        return ruleMap;
    }

    @Override
    public Long solvePart2(List<String> input){
        String navigationLine = input.get(0);
        Map<String, NavigationRule> ruleMap = createNavigationRuleMap(input);

        NavigationRuleAnalyser analyser = new NavigationRuleAnalyser(navigationLine, ruleMap);
        for (var a : analyser.getStepSizes().entrySet()) {
            System.out.println("" + a.getKey() + ":" + a.getValue());
        }

        List<Long> list = analyser.getStepSizes().entrySet().stream().map(e -> e.getValue()).toList();
        long lcm = NavigationRuleAnalyser.lcm(list.get(0), list.get(1));
        for (int i = 2; i < list.size(); i++) {
            lcm = NavigationRuleAnalyser.lcm(lcm, list.get(i));
        }
        return lcm;
    }

    public void figureOutRepeatingRate(String navigationLine, Map<String, NavigationRule> ruleMap, NavigationRule startingRule){
        NavigationRule currentRule = startingRule;
        int indexInNavigationLine = 0;
        long countOfSteps = 0;
        long foundRulesWithEndingZ = 0;
        long lastStepsFoundEndingZ = 0;
        while (foundRulesWithEndingZ<20) {
            String target = currentRule.getTarget().getTarget(navigationLine.substring(indexInNavigationLine, indexInNavigationLine + 1));
            currentRule = ruleMap.get(target);
            indexInNavigationLine++;
            countOfSteps++;
            if (indexInNavigationLine >= navigationLine.length()) {
                indexInNavigationLine = 0;
            }
            if (currentRule.getFrom().endsWith("Z")) {
                foundRulesWithEndingZ++;
                System.out.println("found '" + currentRule.getFrom() + "' after " + countOfSteps + " steps, differenz = " + (countOfSteps - lastStepsFoundEndingZ));
                lastStepsFoundEndingZ = countOfSteps;
            }
        }
    }

    public void figuredOutRepeatingRateForAnyEndingZForZZZ(List<String> input) {
        /*
        very surprising !
        in my task, from AAA only ZZZ is reaches, no other ending Z...
        and the difference is 23147 all time
         */
        String navigationLine = input.get(0);
        Map<String, NavigationRule> ruleMap = createNavigationRuleMap(input);

        NavigationRule currentRule = ruleMap.get("AAA");
        int indexInNavigationLine = 0;
        long countOfSteps = 0;
        long foundRulesWithEndingZ = 0;
        long lastStepsFoundEndingZ = 0;
        while (foundRulesWithEndingZ<20) {
            String target = currentRule.getTarget().getTarget(navigationLine.substring(indexInNavigationLine, indexInNavigationLine + 1));
            currentRule = ruleMap.get(target);
            indexInNavigationLine++;
            countOfSteps++;
            if (indexInNavigationLine >= navigationLine.length()) {
                indexInNavigationLine=0;
            }
            if (currentRule.getFrom().endsWith("Z")) {
                foundRulesWithEndingZ ++;
                System.out.println("found '" + currentRule.getFrom() + "' after " + countOfSteps + " steps, differenz = " + (countOfSteps  - lastStepsFoundEndingZ));
                lastStepsFoundEndingZ = countOfSteps;
            }
        }
    }

    public Long solvePart2Try01(List<String> input) {
        String navigationLine = input.get(0);
        Map<String, NavigationRule> ruleMap = createNavigationRuleMap(input);

        List<Map.Entry<String, NavigationRule>> currentNavigationRules = ruleMap.entrySet().stream().filter(s -> s.getKey().endsWith("A")).toList();
        List<Map.Entry<String, NavigationRule>> finalNavigationRules = ruleMap.entrySet().stream().filter(s -> s.getKey().endsWith("Z")).toList();
        System.out.println("starts:" + currentNavigationRules.size());
        System.out.println("finals:" + finalNavigationRules.size());
        long countOfSteps = 0;
        int indexInNavigationLine = 0;
        while (currentNavigationRules.stream().filter(e -> !e.getKey().endsWith("Z")).count() != 0) {
            Map<String, NavigationRule> temporaryMap = new HashMap<>();
            for (Map.Entry<String, NavigationRule> rule : currentNavigationRules) {
                String target = rule.getValue().getTarget().getTarget(navigationLine.substring(indexInNavigationLine, indexInNavigationLine + 1));
                NavigationRule navigationRule = ruleMap.get(target);
                temporaryMap.put(navigationRule.getFrom(), navigationRule);
            }
            currentNavigationRules = temporaryMap.entrySet().stream().toList();
            countOfSteps++;
            indexInNavigationLine++;
            if (indexInNavigationLine >= navigationLine.length()) {
                indexInNavigationLine=0;
                if (countOfSteps % 1000 == 0) {
                    System.out.print(".");
                }
                if (countOfSteps % 100000 == 0) {
                    System.out.println();
                    System.out.println("100000");
                }
            }
        }

        return countOfSteps;
    }

    @Override
    public Long getSolution1() {
        return new SolutionDay08().solvePart1(getInputList());
    }

    @Override
    public Long getSolution2() {
        return new SolutionDay08().solvePart2(getInputList());
    }
}
