package de.hegmanns.training.aoc2023;

import de.hegmanns.training.aoc.common.AoCFileReader;
import de.hegmanns.training.aoc.common.AoCSolution;

import java.util.List;

public class SolutionDay01 implements AoCSolution<Long, Long> {

    public static void main(String[] args) {
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay01.class, "day01t.txt");

        SolutionDay01 solution = new SolutionDay01();
        System.out.println("Part 1: " + solution.solvePart1(inputAsList));
        System.out.println("===");
        System.out.println("Part 2: " + solution.solvePart2(inputAsList));
    }

    private static List<String> getInputList() {
        return AoCFileReader.getInputAsList(SolutionDay01.class, "day01t.txt");
    }

    public Long getSolution1() {
        return (new SolutionDay01()).solvePart1(getInputList());
    }

    public Long getSolution2() {
        return (new SolutionDay01()).solvePart2(getInputList());
    }



    public enum Digit {
        one('1'),
        two('2'),
        three('3'),
        four('4'),
        five('5'),
        six('6'),
        seven('7'),
        eight('8'),
        nine('9');

        private char number;
        private String reversed;

        public char getNumber() {
            return number;
        }

        public String getReversed() {
            return reversed;
        }

        Digit(char number) {
            this.number = number;
            StringBuilder builder = new StringBuilder(this.toString().toLowerCase());
            this.reversed = builder.reverse().toString();
        }
    }


    private char getFirstDigit(String line) {
        char[] charArray = line.toCharArray();
        for (int i = 0; i < charArray.length; i++) {

            if (Character.isDigit(charArray[i])) {
                return charArray[i];
            }
        }
        throw new RuntimeException("not found ...");
    }

    private char getFirstDigitWithSpelledDigits(String line, boolean reversed) {
        char[] charArray = line.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            for (Digit d : Digit.values()) {
                String digitString = reversed ? d.getReversed() : d.toString();
                if (line.substring(i).startsWith(digitString)) {
                    return d.getNumber();
                }
            }

            if (Character.isDigit(charArray[i])) {
                return charArray[i];
            }
        }
        throw new RuntimeException("not found ...");
    }

    @Override
    public Long solvePart1(List<String> input) {
        long sum = 0;
        for (String zeile : input) {
            char firstDigit = getFirstDigit(zeile);
            StringBuilder builder = new StringBuilder(zeile);
            char lastDigit = getFirstDigit(builder.reverse().toString());
            sum += Long.parseLong("" + firstDigit + lastDigit);
        }
        return sum;
    }

    @Override
    public Long solvePart2(List<String> input) {
        long sum = 0;
        for (String zeile : input) {
            char firstDigit = getFirstDigitWithSpelledDigits(zeile, false);
            StringBuilder builder = new StringBuilder(zeile);
            char lastDigit = getFirstDigitWithSpelledDigits(builder.reverse().toString(), true);
            System.out.println("'" + zeile + "':" + firstDigit + lastDigit);
            sum += Long.parseLong("" + firstDigit + lastDigit);
        }
        return sum;
    }
}
