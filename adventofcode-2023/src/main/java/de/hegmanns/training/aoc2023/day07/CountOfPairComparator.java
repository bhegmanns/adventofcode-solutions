package de.hegmanns.training.aoc2023.day07;

import java.util.Map;

public class CountOfPairComparator implements HandCardComparator{

    int countToCompare;

    public CountOfPairComparator(int countToCompare) {
        this.countToCompare = countToCompare;
    }

    @Override
    public int compare(HandCard firstHandCard, HandCard secondHandCard) {
        Map<CamelCard, Integer> firstHand = firstHandCard.getCountOfCardsMap();
        Map<CamelCard, Integer> secondHand = secondHandCard.getCountOfCardsMap();

        long countOfPairsFirstHand = firstHand.entrySet().stream().filter(e -> e.getValue() == 2).count();
        long countOfPairsSecondHand = secondHand.entrySet().stream().filter(e -> e.getValue() == 2).count();

        if (countOfPairsFirstHand == countOfPairsSecondHand) {
            return 0;
        }
        return (countOfPairsFirstHand-countOfPairsSecondHand)<0?-1:1;
    }
}
