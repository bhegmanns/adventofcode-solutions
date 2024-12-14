package de.hegmanns.training.aoc2022;

import de.hegmanns.training.aoc.common.AoCFileReader;
import de.hegmanns.training.aoc.common.AoCSolution;

import java.util.List;

public class SolutionDay25 implements AoCSolution<String, String> {

    public static void main(String[] args) {
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay25.class, "day25.txt");

        SolutionDay25 solution = new SolutionDay25();

        System.out.println("Part 1: " + solution.solvePart1(inputAsList));
        System.out.println("=====");
        System.out.println("Part 2: " + solution.solvePart2(inputAsList));
    }

    List<Character> digits = List.of('=', '-', '0', '1', '2');

    private long decimal(String s) {
        long num = 0;
        for(int i = 0; i< s.length(); i++) {
            char c = s.charAt(s.length()-1-i);
            long n = digits.indexOf(c) - 2L;
            long rad = (long)Math.pow(5,i);
            num+=n*rad;
        }
        return num;
    }

    @Override
    public String solvePart1(List<String> input) {
        long sumOfValues = input.stream().mapToLong(this::decimal).sum();

        StringBuilder stringBuilder = new StringBuilder();
        while (sumOfValues > 0) {
            int number = Math.toIntExact((sumOfValues + 2) % 5);
            sumOfValues = (sumOfValues + 2) / 5;
            stringBuilder.insert(0, digits.get(number));
        }
        return stringBuilder.toString();
    }

    @Override
    public String solvePart2(List<String> input) {
        return "The More The Merrier";
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
