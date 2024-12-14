package de.hegmanns.training.aoc2021;

import de.hegmanns.training.aoc.common.AoCFileReader;
import de.hegmanns.training.aoc.common.AoCSolution;
import de.hegmanns.training.aoc2021.day04.Bingo;
import de.hegmanns.training.aoc2021.day04.BingoGame;

import java.util.List;

public class SolutionDay04 implements AoCSolution<Integer, Integer> {

    public static void main(String[] args) {
        List<String> input = AoCFileReader.getInputAsList(SolutionDay04.class, "day04.txt");
        SolutionDay04 solution = new SolutionDay04();
        System.out.println("part1 >>> " + solution.solvePart1(input));
        System.out.println("part2 >>> " + solution.solvePart2(input));
    }

    @Override
    public Integer solvePart1(List<String> input) {
        var bingoGame = new BingoGame(input);

        // now the game
        var currentNumber = 0;
        while (!bingoGame.isAtLeastOneBingoSolved()) {
            currentNumber = bingoGame.solveWithNextNumber();
//            bingoGame.printOutBingos();
        }

        var bingo = bingoGame.getSolvedBingos().get(0);
        var result = bingo.getSumUnsolved() * currentNumber;
        return result;
    }

    @Override
    public Integer solvePart2(List<String> input) {
        var bingoGame = new BingoGame(input);
        var number = 0;
        List<Bingo> unsolvedBingos = bingoGame.getUnsolvedBingos();
        while (!bingoGame.isEveryBingoSolved()) {
            number = bingoGame.solveWithNextNumber();
//            bingoGame.printOutBingos();
            if (!bingoGame.isEveryBingoSolved()) {
                unsolvedBingos = bingoGame.getUnsolvedBingos();
            }
        }
        return unsolvedBingos.get(0).getSumUnsolved() * number;
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