package de.hegmanns.training.aoc2022;

import de.hegmanns.training.aoc.common.AoCFileReader;
import de.hegmanns.training.aoc.common.AoCSolution;
import de.hegmanns.training.aoc2022.day09.Grid;
import de.hegmanns.training.aoc2022.day09.MovingDirection;
import de.hegmanns.training.aoc2022.day09.Position;

import java.util.List;

public class SolutionDay09 implements AoCSolution<Long, Long> {

    public static void main(String[] args) {
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay09.class, "day09.txt");

        SolutionDay09 solution = new SolutionDay09();
        System.out.println("Part 1: " + solution.solvePart1(inputAsList));
        System.out.println("=====");
        System.out.println("Part 2: " + solution.solvePart2(inputAsList));
    }

    @Override
    public Long solvePart1(List<String> input) {
        return solveSolution(input, 1);
    }

    @Override
    public Long solvePart2(List<String> input) {
        return solveSolution(input, 9);
    }

    @Override
    public Long getSolution1() {

        return null;
    }

    @Override
    public Long getSolution2() {
        return null;
    }

    public Long solveSolution(List<String> input, int countTails){
        Grid grid = new Grid(countTails);


        for (String line : input) {
            String[] splitted = line.trim().split(" ");

            String direction = splitted[0];
            int movementAmount = Integer.parseInt(splitted[1]);
            MovingDirection movingDirection = null;
            switch (direction) {
                case "D":
                    movingDirection = MovingDirection.DOWN;
                    break;
                case "U":
                    movingDirection = MovingDirection.UP;
                    break;
                case "L":
                    movingDirection = MovingDirection.LEFT;
                    break;
                case "R":
                    movingDirection = MovingDirection.RIGHT;
                    break;
            }

            grid.getHead().move(grid, movingDirection, movementAmount);
        }

        return grid.getPositions().stream().filter(Position::isVisitedByTail).count();
    }
}
