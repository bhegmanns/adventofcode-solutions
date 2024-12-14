package de.hegmanns.training.aoc2023.day08;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NavigationRuleAnalyser {

    String navigationLine;
    Map<String, NavigationRule> ruleMap;

    Map<String, Long> stepSizes = new HashMap<>();

    public NavigationRuleAnalyser(String navigationLine, Map<String, NavigationRule> ruleMap) {
        this.navigationLine = navigationLine;
        this.ruleMap = ruleMap;
        analyze();
    }

    public Map<String, Long> getStepSizes() {
        return stepSizes;
    }

    private void analyze() {
        List<NavigationRule> navigationsRulesWithEndingA = ruleMap.entrySet().stream().filter(e -> e.getKey().endsWith("A")).map(e -> e.getValue()).toList();

        for (var navigationRule : navigationsRulesWithEndingA) {
            Long stepSize = calculateStepSize(navigationRule);
            stepSizes.put(navigationRule.getFrom(), stepSize);
        }
    }

    private Long calculateStepSize(NavigationRule startingRule) {
        NavigationRule currentRule = startingRule;
        NavigationRule finalZRule = null;
        Long stepSize = null;

        // 1. Step for gathering the final Z rule
        //    and count of steps
        long countOfSteps = 0;
        int currentIndex = 0;
        while (!currentRule.getFrom().endsWith("Z")) {
            currentRule = ruleMap.get(currentRule.getTarget().getTarget(navigationLine.substring(currentIndex, currentIndex + 1)));
            countOfSteps++;
            currentIndex++;
            if (currentIndex >= navigationLine.length()) {
                currentIndex=0;
            }
        }
        finalZRule = currentRule;
        stepSize = countOfSteps;

        return stepSize;
    }

    public static long lcm(long number1, long number2) {
        BigInteger bi = lcm(BigInteger.valueOf(number1), BigInteger.valueOf(number2));
        return bi.longValue();
    }

    public static BigInteger lcm(BigInteger number1, BigInteger number2) {
        BigInteger gcd = number1.gcd(number2);
        BigInteger absProduct = number1.multiply(number2).abs();
        return absProduct.divide(gcd);
    }
}
