package de.hegmanns.training.aoc2023;

import de.hegmanns.training.aoc.common.AoCFileReader;
import de.hegmanns.training.aoc.common.AoCSolution;
import de.hegmanns.training.aoc2023.day07.HandCard;
import de.hegmanns.training.aoc2023.day07.HandCardWithJoker;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class SolutionDay07 implements AoCSolution<Long, Long> {

    public static void main(String[] args) {
        SolutionDay07 solution = new SolutionDay07();
        System.out.println("Part 1: " + solution.getSolution1());
        System.out.println("===");
        System.out.println("Part 2: " + solution.getSolution2());
    }

    private static List<String> getInputList() {
        return AoCFileReader.getInputAsList(SolutionDay07.class, "day07t.txt");
    }

    @Override
    public Long solvePart1(List<String> input) {

        List<HandCard> handcards = new ArrayList<>();

        for (String line : input) {
            String[] s = line.trim().split(" ");
            HandCard handCard = new HandCard(s[0].trim(), Long.parseLong(s[1].trim()));
            handcards.add(handCard);
        }

        TreeSet<HandCard> sortedSet = new TreeSet<>(handcards);
        long totalWinning = 0;
        long currentRank = 1;
        for (HandCard handCard : sortedSet) {
            totalWinning += handCard.getBid()*currentRank;
            currentRank++;
        }

        return totalWinning;
    }

    @Override
    public Long solvePart2(List<String> input) {
        List<HandCardWithJoker> handcards = new ArrayList<>();

        for (String line : input) {
            String[] s = line.trim().split(" ");
            HandCardWithJoker handCard = new HandCardWithJoker(s[0].trim(), Long.parseLong(s[1].trim()));
            handcards.add(handCard);
        }

        TreeSet<HandCardWithJoker> sortedSet = new TreeSet<>(handcards);
        long totalWinning = 0;
        long currentRank = 1;
        for (HandCardWithJoker handCard : sortedSet) {
            totalWinning += handCard.getBid()*currentRank;
            currentRank++;
        }

        return totalWinning;
    }

    @Override
    public Long getSolution1() {
        return new SolutionDay07().solvePart1(getInputList());
    }

    @Override
    public Long getSolution2() {
        return new SolutionDay07().solvePart2(getInputList());
    }
}
