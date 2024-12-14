package de.hegmanns.training.aoc2022;

import de.hegmanns.training.aoc.common.AoCFileReader;
import de.hegmanns.training.aoc.common.AoCSolution;
import java.util.List;

/**
 * Solution of www.adventofcode.com/2022 day 06.
 */
public class SolutionDay06 implements AoCSolution<Integer, Integer> {

    public static void main(String[] args) {
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay06.class, "day06.txt");

        SolutionDay06 solution = new SolutionDay06();
        System.out.println("Part 1: " + solution.solvePart1(inputAsList));
        System.out.println("=====");
        System.out.println("Part 2: " + solution.solvePart2(inputAsList));
    }

    @Override
    public Integer solvePart1(List<String> input) {
        String dataStream = input.get(0);

        return getStartOfPacketMarker(dataStream, 4);
    }

    @Override
    public Integer solvePart2(List<String> input) {
        String dataStream = input.get(0);

        return getStartOfPacketMarker(dataStream, 14);
    }

    @Override
    public Integer getSolution1() {
        return null;
    }

    @Override
    public Integer getSolution2() {
        return null;
    }

    private int getStartOfPacketMarker(String dataStream, int expectedMarkerLength) {
        for (int i = 0; i < dataStream.length(); i++) {
            String startOfPocketMarker = dataStream.substring(i, i + expectedMarkerLength);
            if (startOfPocketMarker.chars().distinct().count() == expectedMarkerLength) {
                return i+expectedMarkerLength;
            }
        }
        throw new RuntimeException("could not found the startOfPocketMarker");
    }
}
