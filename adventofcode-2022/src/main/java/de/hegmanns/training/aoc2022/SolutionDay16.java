package de.hegmanns.training.aoc2022;

import de.hegmanns.training.aoc.common.AoCFileReader;
import de.hegmanns.training.aoc.common.AoCSolution;
import de.hegmanns.training.aoc2022.day16.ValveRaster;

import java.util.List;

public class SolutionDay16 implements AoCSolution<Long, Long> {

    public static void main(String[] args) {
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay16.class, "day16.txt");

        SolutionDay16 solution = new SolutionDay16();
        System.out.println("Part 1: " + solution.solvePart1(inputAsList));
        System.out.println("=====");
        System.out.println("Part 2: " + solution.solvePart2(inputAsList));
    }

    @Override
    public Long solvePart1(List<String> input) {
        ValveRaster valveRaster = new ValveRaster();
        valveRaster.readRasterDefinition(input);



        return null;
    }

    @Override
    public Long solvePart2(List<String> input) {
        return null;
    }

    @Override
    public Long getSolution1() {
        return null;
    }

    @Override
    public Long getSolution2() {
        return null;
    }
}
