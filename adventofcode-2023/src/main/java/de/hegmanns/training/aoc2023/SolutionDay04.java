package de.hegmanns.training.aoc2023;

import de.hegmanns.training.aoc.common.AoCFileReader;
import de.hegmanns.training.aoc.common.AoCSolution;
import de.hegmanns.training.aoc2023.day04.AllCards;
import de.hegmanns.training.aoc2023.day04.Card;

import java.util.List;

public class SolutionDay04 implements AoCSolution<Long, Long> {
    public static void main(String[] args) {
        SolutionDay04 solution = new SolutionDay04();
        System.out.println("Part 1: " + solution.getSolution1());
        System.out.println("===");
        System.out.println("Part 2: " + solution.getSolution2());
    }

    @Override
    public Long getSolution1() {
        return (new SolutionDay04()).solvePart1(getInputList());
    }

    @Override
    public Long getSolution2() {
        return (new SolutionDay04()).solvePart2(getInputList());
    }

    private static List<String> getInputList() {
        return AoCFileReader.getInputAsList(SolutionDay01.class, "day04t.txt");
    }


    @Override
    public Long solvePart1(List<String> input) {
        List<Card> allCards = input.stream().map(Card::new).toList();
        return allCards.stream().map(Card::getWorthPoints).mapToLong(Long::longValue).sum();
    }

    @Override
    public Long solvePart2(List<String> input) {
        List<Card> cards = input.stream().map(Card::new).toList();
        AllCards allCards = new AllCards(cards);
        return allCards.getTotalCountsOfScratchCardsAfterResolving();
    }

}
