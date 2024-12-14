package de.hegmanns.training.aoc2022;

import de.hegmanns.training.aoc.common.AoCFileReader;
import de.hegmanns.training.aoc.common.AoCSolution;
import de.hegmanns.training.aoc2022.day12.SolutionTree;
import de.hegmanns.training.aoc2022.day12.Square;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SolutionDay12 implements AoCSolution<Integer, Integer> {

    public static void main(String[] args) {
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay12.class, "day12.txt");

        SolutionDay12 solution = new SolutionDay12();
        System.out.println("Part 1: " + solution.solvePart1(inputAsList));
        System.out.println("=====");
        //System.out.println("Part 2: " + solution.solvePart2(inputAsList));
    }
    @Override
    public Integer solvePart1(List<String> input) {

        SolutionTree solutionTree = new SolutionTree();

        int j = 0;
        for (String line : input) {
            int length = line.length();
            int yCoordinate = j;
            for (int x = 0; x < length; x++) {
                Square square = solutionTree.getSquareByCoordinates(x, yCoordinate);
                char relativeHeightSymbol = line.charAt(x);
                if (relativeHeightSymbol == 'S') {
                    square.setStart(true);
                    square.setRelativeHeight('a');
                }
                if (relativeHeightSymbol == 'E') {
                    square.setFinal(true);
                    square.setRelativeHeight('z');
                }
                if (relativeHeightSymbol != 'S' && relativeHeightSymbol != 'E') {
                    square.setRelativeHeight(relativeHeightSymbol);
                }
            }
            j++;
        }

        solutionTree.arrangePossibleSteps();

        List<List<Square>> lists = solutionTree.calculateMovementsFromTargetToStart();
        int touchedSquaresFromMinimum = lists.stream().map(List::size).mapToInt(Integer::intValue).sorted().findFirst().getAsInt();

        return touchedSquaresFromMinimum-1;
    }

    @Override
    public Integer solvePart2(List<String> input) {
        return null;
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
