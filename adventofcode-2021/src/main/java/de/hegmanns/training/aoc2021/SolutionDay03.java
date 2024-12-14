package de.hegmanns.training.aoc2021;

import de.hegmanns.training.aoc.common.AoCFileReader;
import de.hegmanns.training.aoc.common.AoCSolution;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SolutionDay03 implements AoCSolution<Integer, Integer> {

    public static void main(String[] args) {
        List<String> input = AoCFileReader.getInputAsList(SolutionDay03.class, "day03.txt");
        SolutionDay03 solution = new SolutionDay03();
        System.out.println("part1 >>> " + solution.solvePart1(input));
        System.out.println("part2 >>> " + solution.solvePart2(input));
    }

    @Override
    public Integer solvePart1(List<String> input) {

        var gammaRateString = "";
        var epsilonRateString = "";
        var newList = new ArrayList<String>();

        for (int i = 0; i < input.get(0).length(); i++) {
            newList.add("");
        }

        var completeIterator = input.iterator();
        while (completeIterator.hasNext()) {
            var codeString = completeIterator.next();
            for (int i = 0; i < input.get(0).length(); i++) {
                newList.set(i, newList.get(i) + codeString.charAt(i));
            }
        }
        var index = 0;
        while (true){
            epsilonRateString += calculateLeastCommonBit(newList.get(index));
            gammaRateString += calculateMostCommonBit(newList.get(index++));
            if (index >= newList.size()) {
                break;
            }
        }
        var epsilonRate = Integer.parseInt(epsilonRateString, 2);
        var gammaRate = Integer.parseInt(gammaRateString, 2);
        return epsilonRate * gammaRate;
    }

    @Override
    public Integer solvePart2(List<String> input) {
        int currentColumn = 0;
        List<String> currentList = new ArrayList<>();
        currentList.addAll(input);

        while (currentList.size() > 1) {
            var stringFromColumn = createStringFromColumn(currentList, currentColumn);
            var mostCommonBit = calculateMostCommonBit(stringFromColumn);
            int cc = currentColumn;
            currentList = currentList.stream().filter(s -> ("" + s.charAt(cc)).equals("" + mostCommonBit)).collect(Collectors.toList());
            currentColumn++;
        }
        var oxygenGeneratorRate = Integer.parseInt(currentList.get(0), 2);

        currentList.clear();
        currentList.addAll(input);
        currentColumn = 0;
        while (currentList.size() > 1) {
            var stringFromColumn = createStringFromColumn(currentList, currentColumn);
            var leastCommonBit = calculateLeastCommonBit(stringFromColumn);
            int cc = currentColumn;
            currentList = currentList.stream().filter ( s -> ("" + s.charAt(cc)).equals("" + leastCommonBit)).collect(Collectors.toList());
            currentColumn++;
        }
        var coRate = Integer.parseInt(currentList.get(0), 2);

        return coRate * oxygenGeneratorRate; // test-data 23 / 10
    }

    @Override
    public Integer getSolution1() {
        return null;
    }

    @Override
    public Integer getSolution2() {
        return null;
    }

    //
    public int calculateMostCommonBit(String input) {
        var count0 = input.replaceAll("1", "").length();
        var count1 = input.replaceAll("0", "").length();
        if (count0 > count1) {
            return 0;
        } else {
            return 1;
        }
    }

    public int calculateLeastCommonBit(String input) {
        var count0 = input.replaceAll("1", "").length();
        var count1 = input.replaceAll("0", "").length();
        if (count0 <= count1) {
            return 0;
        } else {
            return 1;
        }
    }

    public String createStringFromColumn(List<String> input, int column) {
        var result = "";
        var iterator = input.iterator();
        while (iterator.hasNext()) {
            result += iterator.next().charAt(column);
        }
        return result;
    }
}