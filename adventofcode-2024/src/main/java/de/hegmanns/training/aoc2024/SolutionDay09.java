package de.hegmanns.training.aoc2024;

import de.hegmanns.training.aoc.common.AoCFileReader;
import de.hegmanns.training.aoc.common.AoCSolution;
import de.hegmanns.training.aoc2024.day09.FileMap;
import de.hegmanns.training.aoc2024.day09.FileMapFactory;

import java.util.List;

public class SolutionDay09 implements AoCSolution<Long, Long> {
    public static final String FILE_NAME = "day09_task.txt";


    public static void main(String[] args) {
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay09.class, FILE_NAME);

        SolutionDay09 solution = new SolutionDay09();
        System.out.println("Part 1: " + solution.solvePart1(inputAsList));
        System.out.println("===");
        System.out.println("Part 2: " + solution.solvePart2(inputAsList));
    }

    private static List<String> getInputList() {
        return AoCFileReader.getInputAsList(SolutionDay09.class, FILE_NAME);
    }


    @Override
    public Long solvePart1(List<String> input) {
        FileMap fileMap = FileMapFactory.createFileMapFromMapString(input.get(0));
        fileMap.optimizeSpaces();
        return fileMap.calculateCheckSum();
    }


    @Override
    public Long solvePart2(List<String> input) {
        FileMap fileMap = FileMapFactory.createFileMapFromMapString(input.get(0));
        fileMap.optimizeSpacesWithFullMatch();
        return fileMap.calculateCheckSum();
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
