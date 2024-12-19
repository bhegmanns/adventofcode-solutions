package de.hegmanns.training.aoc2024;

import de.hegmanns.training.aoc.common.*;
import de.hegmanns.training.aoc2024.day08.*;

import java.util.*;

public class SolutionDay08 implements AoCSolution<Long, Long> {
    public static final String FILE_NAME = "day08_task.txt";


    public static void main(String[] args) {
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay08.class, FILE_NAME);

        SolutionDay08 solution = new SolutionDay08();
        System.out.println("Part 1: " + solution.solvePart1(inputAsList));
        System.out.println("===");
        System.out.println("Part 2: " + solution.solvePart2(inputAsList));
    }

    private static List<String> getInputList() {
        return AoCFileReader.getInputAsList(SolutionDay08.class, FILE_NAME);
    }


    @Override
    public Long solvePart1(List<String> input) {
        char[][] map = new char[input.size()][input.get(0).length()];
        for (int row = 0 ; row < input.size() ; row++) {
            for (int column = 0 ; column < input.get(row).length() ; column++) {
                map[row][column] = input.get(row).charAt(column);
            }
        }
        AntennaMap antennaMap = new AntennaMap(map);
        Long countOfAntinodes= antennaMap.placeAntinodes(false);
        antennaMap.printOut();
        return countOfAntinodes;
    }


    @Override
    public Long solvePart2(List<String> input) {
        char[][] map = new char[input.size()][input.get(0).length()];
        for (int row = 0 ; row < input.size() ; row++) {
            for (int column = 0 ; column < input.get(row).length() ; column++) {
                map[row][column] = input.get(row).charAt(column);
            }
        }
        AntennaMap antennaMap = new AntennaMap(map);
        Long countOfAntinodes = antennaMap.placeAntinodesWithTNodesIncludingAntennas(true);
        antennaMap.printOut();
        return countOfAntinodes;
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
