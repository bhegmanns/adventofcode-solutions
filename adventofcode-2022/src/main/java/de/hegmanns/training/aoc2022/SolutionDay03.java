package de.hegmanns.training.aoc2022;

import de.hegmanns.training.aoc.common.AoCFileReader;
import de.hegmanns.training.aoc.common.AoCSolution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Solution of www.adventofcode.com/2022 day 03.
 */
public class SolutionDay03 implements AoCSolution<Integer, Integer> {

    public static void main(String[] args) {
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay03.class, "day03.txt");

        SolutionDay03 solution = new SolutionDay03();


        System.out.println("Part 1: " + solution.solvePart1(inputAsList));
        System.out.println("=====");
        System.out.println("Part 2: " + solution.solvePart2(inputAsList));

    }

    private int getPriority(char c){
        if (Character.isLowerCase(c)) {
            return (byte) c - 96;
        } else {
            return (byte)c - 64 + 26;
        }
    }

    @Override
    public Integer solvePart1(List<String> input) {
        int sumOfPriorities = 0;

        for (String contentLine : input) {

            int length = contentLine.length();
            if (length % 2 != 0) {
                throw new RuntimeException("Problem with line '" + contentLine + "', odd count of content");
            }

            String firstCompartment = contentLine.substring(0, length / 2);
            String secondCompartment = contentLine.substring(length / 2);

            HashSet<Byte> contentFirstCompartment = new HashSet<>();
            for (char c : firstCompartment.toCharArray()) {
                contentFirstCompartment.add((byte)c);
            }

            System.out.println("COMPARTMENT: " + contentLine);
            System.out.println("FIRST      : " + firstCompartment + " | " + secondCompartment);

            for (char c : secondCompartment.toCharArray()) {
                if (contentFirstCompartment.contains((byte) c)) {
                    System.out.println("* FOUND : " + c);
                    sumOfPriorities += getPriority(c);
                    break;
                }
            }

        }

        return sumOfPriorities; // 7990
    }

    private HashSet<Character> convert(String line) {
        HashSet<Character> content = new HashSet<>();
        for (char c : line.toCharArray()) {
            content.add(c);
        }
        return content;
    }

    @Override
    public Integer solvePart2(List<String> input) {
        int count = 0;
        int countOfPriorities = 0;
        List<HashSet<Character>> rucksacks = new ArrayList<>();


        for (String line : input) {
            rucksacks.add(convert(line));
            count++;

            if (count == 3) {
                HashSet<Character> first = rucksacks.get(0);
                HashSet<Character> second = rucksacks.get(1);
                HashSet<Character> third = rucksacks.get(2);

                HashSet<Character> doubleForFirstandSecond = new HashSet<>();
                for (char c : second) {
                    if (first.contains(c)) {
                        doubleForFirstandSecond.add(c);
                    }
                }
                System.out.println(">>" + doubleForFirstandSecond);
                HashSet<Character> doubleWithThird = new HashSet<>();
                for (char c : doubleForFirstandSecond) {
                    if (third.contains(c)) {
                        doubleWithThird.add(c);
                        countOfPriorities += getPriority(c);
                        System.out.println(">>>" + c);
                        System.out.println();
                        break;
                    }
                }
                if (doubleWithThird.size() == 0) {
                    throw new RuntimeException("NO DOUBLE FOUND in " + rucksacks);
                }
                if (doubleWithThird.size() > 1) {
                    System.out.println("INFO : " + doubleWithThird + " in " + rucksacks);
                }


                rucksacks.clear();
                count = 0;
            }

        }
        return countOfPriorities;
    }

    @Override
    public Integer getSolution1() {
        return null;
    }

    @Override
    public Integer getSolution2() {
        return null;
    }
}
