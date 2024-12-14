package de.hegmanns.training.aoc2022;

import de.hegmanns.training.aoc.common.AoCFileReader;
import de.hegmanns.training.aoc.common.AoCSolution;
import de.hegmanns.training.aoc2022.day02.Shape;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Solution of www.adventofcode.com/2022 day 02.
 */
public class SolutionDay02 implements AoCSolution<Integer, Integer> {


    public static void main(String[] args){
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay02.class, "day02.txt");

        SolutionDay02 solution = new SolutionDay02();

        System.out.println("Part 1: " + solution.solvePart1(inputAsList));
        System.out.println("=====");
        System.out.println("Part 2: " + solution.solvePart2(inputAsList));
    }
    @Override
    public Integer solvePart1(List<String> input) {
        Map<String, Integer> results = new HashMap<>();
        results.put("A X", 4); // 0
        results.put("A Y", 8); //
        results.put("A Z", 3); //
        //
        results.put("B X", 1); //
        results.put("B Y", 5); // 0
        results.put("B Z", 9); //

        results.put("C X", 7); //
        results.put("C Y", 2); //
        results.put("C Z", 6); // 0

        int totalAmount = 0;
        int currentShapeAmount = 0;
        // points for peaces
        for (String line : input) {
            Integer resultOfRound = results.get(line.trim());
            if (resultOfRound == null) {
                throw new RuntimeException("missing result");
            }
            totalAmount += resultOfRound;
        }


        return totalAmount;
    }

    @Override
    public Integer solvePart2(List<String> input) {

        int totalAmount = 0;

        Map<String, Result> winningPoints = new HashMap<>();
        winningPoints.put("X", Result.LOOSE);
        winningPoints.put("Y", Result.DRAW);
        winningPoints.put("Z", Result.WIN);

        for (String line : input) {
            String[] choosing = line.split(" ");


            Result expectedResult = winningPoints.get(choosing[1].trim());
            Shape shapeForThisRound = getShapeForExpectedResult(Shape.getOpponentBySymbol(choosing[0].trim()),
                    expectedResult);

            totalAmount += shapeForThisRound.getPoints() + expectedResult.getPoints();


        }

        return totalAmount;
    }

    @Override
    public Integer getSolution1() {
        return null;
    }

    @Override
    public Integer getSolution2() {
        return null;
    }

    private Shape getShapeForExpectedResult(Shape opponentShape, Result expectedResult) {
        Shape resultShape = null;
        switch (expectedResult) {
            case DRAW: resultShape= opponentShape; break;
            case LOOSE: resultShape= opponentShape.getDefeatAgainst(); break;
            case WIN: resultShape= opponentShape.getLooseAgainst(); break;
        }

        return resultShape;
    }

        public static enum Result{
            WIN(6),
            DRAW(3),
            LOOSE(0);

            private final int points;

            private Result(int points){
                this.points = points;
            }

            public int getPoints() {
                return points;
            }
        }

}
