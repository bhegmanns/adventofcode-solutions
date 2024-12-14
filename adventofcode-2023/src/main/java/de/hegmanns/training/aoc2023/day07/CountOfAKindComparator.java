package de.hegmanns.training.aoc2023.day07;

import java.util.*;
import java.util.stream.Collectors;

public class CountOfAKindComparator implements HandCardComparator{

    private int countToCompare;
    public CountOfAKindComparator(int count) {
        this.countToCompare = count;
    }


    public List<Map.Entry<CamelCard, Integer>> getMatches(HandCard handCard) {
        Set<Map.Entry<CamelCard, Integer>> entries = handCard.getCountOfCardsMap().entrySet();
        List<Map.Entry<CamelCard, Integer>> result = new ArrayList<>();
        for (Map.Entry<CamelCard, Integer> entry : entries) {
            if (entry.getValue() == countToCompare) {
                result.add(entry);
            }
        }
        return handCard.getCountOfCardsMap().entrySet().stream().filter(e -> e.getValue() == countToCompare).collect(Collectors.toList());
    }

    @Override
    public int compare(HandCard firstHandCard, HandCard secondHandCard) {
        Map<CamelCard, Integer> firstHand = firstHandCard.getCountOfCardsMap();
        Map<CamelCard, Integer> secondHand = secondHandCard.getCountOfCardsMap();

        List<Map.Entry<CamelCard, Integer>> firstList = firstHand.entrySet().stream().filter(e -> e.getValue() == countToCompare).toList();
        List<Map.Entry<CamelCard, Integer>> secondList = secondHand.entrySet().stream().filter(e -> e.getValue() == countToCompare).toList();
        if (firstList.isEmpty() && secondList.isEmpty()) {
            return 0;
        }
        int sizeDifference = firstList.size()-secondList.size();
        if (sizeDifference != 0) {
            return sizeDifference;
        }

        return sizeDifference;
    }
}
