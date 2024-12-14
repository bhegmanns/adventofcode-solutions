package de.hegmanns.training.aoc2023;

import de.hegmanns.training.aoc.common.AoCFileReader;
import de.hegmanns.training.aoc.common.AoCSolution;
import de.hegmanns.training.aoc2023.day02.Color;
import de.hegmanns.training.aoc2023.day02.Game;
import de.hegmanns.training.aoc2023.day02.Grap;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SolutionDay02 implements AoCSolution<Long, Long> {
    public static void main(String[] args) {
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay02.class, "day02t.txt");

        SolutionDay02 solution = new SolutionDay02();
        System.out.println("Part 1: " + solution.solvePart1(inputAsList));
        System.out.println("===");
        System.out.println("Part 2: " + solution.solvePart2(inputAsList));
    }

    @Override
    public Long solvePart1(List<String> input) {
        List<Game> games = input.stream().map(Game::new).collect(Collectors.toList());
        Grap maxGrap = new Grap();
        maxGrap.addGrappedColor(Color.GREEN, 13);
        maxGrap.addGrappedColor(Color.RED, 12);
        maxGrap.addGrappedColor(Color.BLUE, 14);

        return games.stream().map(g -> g.isPossible(maxGrap) ? g.getId() : 0).mapToLong(Long::longValue).sum();

    }

    @Override
    public Long solvePart2(List<String> input) {
        List<Game> games = input.stream().map(Game::new).collect(Collectors.toList());
        long sumOfPowers = 0;
        for (Game game : games) {
            sumOfPowers += game.getPower();
        }
        return sumOfPowers;
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
