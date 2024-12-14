package de.hegmanns.training.aoc2022;

import de.hegmanns.training.aoc.common.AoCFileReader;
import de.hegmanns.training.aoc.common.AoCSolution;

import java.util.*;

/**
 * Solution of www.adventofcode.com/2022 day 05.
 */
public class SolutionDay05 implements AoCSolution<String, String> {

    public static void main(String[] args) {
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay05.class, "day05.txt");



        SolutionDay05 solution = new SolutionDay05();

        System.out.println("Part 1: " + solution.solvePart1(inputAsList));
        System.out.println("=====");
        System.out.println("Part 2: " + solution.solvePart2(inputAsList));
    }


    @Override
    public String solvePart1(List<String> input) {
        List<Stack<String>> stacks = new ArrayList<>();
        List<String> stackDefinition = new ArrayList<>();
        boolean duringStackDefinition = true;
        for (String line : input) {
            if (duringStackDefinition) {
                if (!line.trim().equals("")) {
                    stackDefinition.add(line + "       ");
                } else {
                    duringStackDefinition = false;
                    stacks = convertIntoStacks(stackDefinition);
                }
                continue;
            } else {
                int firstEmpty = line.indexOf(" ");
                int secondEmpty = line.indexOf(" ", firstEmpty + 1);
                int thirdEmpty = line.indexOf(" ", secondEmpty + 1);
                int fourthEmpty = line.indexOf(" ", thirdEmpty + 1);
                int fifthEmpty = line.indexOf(" ", fourthEmpty + 1);

                int count = Integer.parseInt(line.substring(firstEmpty, secondEmpty).trim());
                int from = Integer.parseInt(line.substring(thirdEmpty, fourthEmpty).trim());
                int to = Integer.parseInt(line.substring(fifthEmpty).trim());

                Stack<String> fromStack = stacks.get(from - 1);
                Stack<String> toStack = stacks.get(to - 1);
                for (int i = 0; i < count; i++) {
                    String crate = fromStack.pop();
                    toStack.add(crate);
                }
                System.out.println(line);
            }


        }

        StringBuilder stringBuilder = new StringBuilder("");
        for (var stack : stacks) {
            stringBuilder.append(stack.peek());
        }
        return stringBuilder.toString();
    }

    private List<Stack<String>> convertIntoStacks(List<String> stackDefinition) {
        List<Stack<String>> stacks = new ArrayList<>();

        String[] s = stackDefinition.get(stackDefinition.size() - 1).split(" ");
        int countStacks = Arrays.stream(s).filter(ss -> !ss.isEmpty()).mapToInt(Integer::parseInt).max().getAsInt();

        for (int i = 0; i < countStacks; i++) {
            stacks.add(new Stack<>());
        }

        for (int i = stackDefinition.size() - 2; i >= 0; i--) {
            String line = stackDefinition.get(i);
            for (int j = 0; j < countStacks; j++) {
                char c = line.charAt(1 + j * 4);
                if (!Character.isWhitespace(c)) {
                    stacks.get(j).addElement("" + c);
                }
            }
        }

        return stacks;
    }

    @Override
    public String solvePart2(List<String> input) {
        List<Stack<String>> stacks = new ArrayList<>();
        List<String> stackDefinition = new ArrayList<>();
        boolean duringStackDefinition = true;
        for (String line : input) {
            if (duringStackDefinition) {
                if (!line.trim().equals("")) {
                    stackDefinition.add(line + "       ");
                } else {
                    duringStackDefinition = false;
                    stacks = convertIntoStacks(stackDefinition);
                }
                continue;
            } else {
                int firstEmpty = line.indexOf(" ");
                int secondEmpty = line.indexOf(" ", firstEmpty + 1);
                int thirdEmpty = line.indexOf(" ", secondEmpty + 1);
                int fourthEmpty = line.indexOf(" ", thirdEmpty + 1);
                int fifthEmpty = line.indexOf(" ", fourthEmpty + 1);

                int count = Integer.parseInt(line.substring(firstEmpty, secondEmpty).trim());
                int from = Integer.parseInt(line.substring(thirdEmpty, fourthEmpty).trim());
                int to = Integer.parseInt(line.substring(fifthEmpty).trim());

                Stack<String> fromStack = stacks.get(from - 1);
                Stack<String> toStack = stacks.get(to - 1);

                Stack<String> helperStack = new Stack<>();
                for (int i = 0; i < count; i++) {
                    String crate = fromStack.pop();
                    helperStack.addElement(crate);
                }
                for (int i = 0; i < count; i++) {
                    toStack.addElement(helperStack.pop());
                }
                System.out.println(line);
            }


        }

        StringBuilder stringBuilder = new StringBuilder("");
        for (var stack : stacks) {
            stringBuilder.append(stack.peek());
        }
        return stringBuilder.toString();
    }

    @Override
    public String getSolution1() {
        return null;
    }

    @Override
    public String getSolution2() {
        return null;
    }
}
