package de.hegmanns.training.aoc2022;

import de.hegmanns.training.aoc.common.AoCFileReader;
import de.hegmanns.training.aoc.common.AoCSolution;
import de.hegmanns.training.aoc2022.day11.Monkey;
import de.hegmanns.training.aoc2022.day11.WorryLevelOperation;

import java.util.*;
import java.util.stream.Collectors;

public class SolutionDay11 implements AoCSolution<Long, Long> {

    public static void main(String[] args) {
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay11.class, "day11.txt");

        SolutionDay11 solution = new SolutionDay11();
        System.out.println("Part 1: " + solution.solvePart1(inputAsList));
        System.out.println("=====");
        System.out.println("Part 2: " + solution.solvePart2(inputAsList));
    }

    @Override
    public Long solvePart1(List<String> input) {

        Map<Integer, Monkey> monkeys = parseToMonkeys(input);

        List<Monkey> monkeyList = new ArrayList<>();
        for (int monkeyIndex = 0; monkeyIndex < monkeys.size(); monkeyIndex++) {
            monkeyList.add(monkeys.get(monkeyIndex));
        }


        for (int round = 0; round < 20; round++) {
            for (Monkey monkey : monkeyList) {
                List<Long> items = monkey.inspectAllItems();
                for (long item : items) {
                    long worry = monkey.proceedWorryOperation(item) / 3;
                    monkey.itemForWorry(worry);
                }

            }
        }

        //List<Long> inspected = monkeyList.stream().map(Monkey::getCountOfInspectedItems).sorted().collect(Collectors.toList());
        //return (long)(inspected.get(inspected.size()-1) * inspected.get(inspected.size()-2));

        return monkeyList.stream().map(Monkey::getCountOfInspectedItems).sorted((a, b) -> a.compareTo(b)).skip(2).reduce(1L, (a, b) -> a * b);

    }

    @Override
    public Long solvePart2(List<String> input) {
        Map<Integer, Monkey> monkeys = parseToMonkeys(input);

        List<Monkey> monkeyList = new ArrayList<>();
        for (int monkeyIndex = 0; monkeyIndex < monkeys.size(); monkeyIndex++) {
            monkeyList.add(monkeys.get(monkeyIndex));
        }
                long factorize = 1L;

                for (Monkey m : monkeyList) {
                    factorize *= m.getDivisibleTestNumber();
                }




        for (int round = 0; round < 10000; round++) {
            for (Monkey monkey : monkeyList) {
                List<Long> items = monkey.inspectAllItems();

                for (long item : items) {
                    long worry = monkey.proceedWorryOperation(item)%factorize;
                    monkey.itemForWorry(worry);
                }

            }
        }

        return monkeyList.stream().map(Monkey::getCountOfInspectedItems).sorted((a, b) -> a.compareTo(b)).skip(2).reduce(1L, (a, b) -> a * b);
    }

    @Override
    public Long getSolution1() {
        return null;
    }

    @Override
    public Long getSolution2() {
        return null;
    }

    private Monkey getMonkeyByMoneyNumber(int monkeyNumber, Map<Integer, Monkey> monkeys) {
        Monkey monkey = monkeys.get(monkeyNumber);
        if (monkey == null) {
            monkey = new Monkey();
            monkeys.put(monkeyNumber, monkey);
        }
        return monkey;
    }

    private Map<Integer, Monkey> parseToMonkeys(List<String> input) {
        Map<Integer, Monkey> monkeys = new HashMap<>();
        Monkey currentMonkey = null;

        //>Starting items: 57

        //>Operation: new = old * 13
        //>Operation: new = old + 2

        //>Test: divisible by 11
        //If true: throw to monkey 3
        //If false: throw to monkey 2


        int currentKey = -1;
        for (String line : input) {
            if (line.startsWith("Monkey")) {
                currentKey++;
                currentMonkey = getMonkeyByMoneyNumber(currentKey, monkeys);
                continue;
            }
            if (line.trim().startsWith("Starting items: ")) {
                String[] split = line.trim().substring("Starting items: ".length()).split(", ");
                currentMonkey.setItems(Arrays.stream(split).map(String::trim).map(Long::parseLong).collect(Collectors.toList()));
                continue;
            }
            if (line.trim().startsWith("Operation:")) {
                String operatorSymbol = line.trim().substring("Operation:".length()).split(" ")[4];
                if (line.endsWith("old")) {
                    currentMonkey.setWorryLevelOperation(WorryLevelOperation.POTENZ);
                }else {
                    currentMonkey.setWorryLevelOperation(WorryLevelOperation.gatherWorryOperation(operatorSymbol));
                    currentMonkey.setWorryLevelOperationOperand(Long.parseLong(line.substring(line.lastIndexOf(" ")).trim()));
                }
                continue;
            }
            if (line.trim().startsWith("Test: divisible by ")) {
                currentMonkey.setDivisibleTestNumber(Long.parseLong(line.trim().substring("Test: divisible by ".length())));
                continue;
            }
            if (line.trim().startsWith("If true:")) {
                currentMonkey.setMonkeyForDivisibleTrue(getMonkeyByMoneyNumber(Integer.parseInt(line.substring(line.lastIndexOf(" ")).trim()), monkeys));
                continue;
            }
            if (line.trim().startsWith("If false:")) {
                currentMonkey.setMonkeyForDivisibleFalse(getMonkeyByMoneyNumber(Integer.parseInt(line.substring(line.lastIndexOf(" ")).trim()), monkeys));
                continue;
            }

        }

        return monkeys;
    }
}
