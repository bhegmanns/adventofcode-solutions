package de.hegmanns.training.aoc2023.day07;

import java.util.Map;
import java.util.Optional;

public class FullHouseComparator implements HandCardComparator{
    @Override
    public int compare(HandCard firstHandCard, HandCard secondHandCard) {
        Map<CamelCard, Integer> firstHand = firstHandCard.getCountOfCardsMap();
        Map<CamelCard, Integer> secondHand = secondHandCard.getCountOfCardsMap();

        Optional<Map.Entry<CamelCard, Integer>> firstHandTwo = firstHand.entrySet().stream().filter(e -> e.getValue() == 2).findFirst();
        Optional<Map.Entry<CamelCard, Integer>> secondHandTwo = secondHand.entrySet().stream().filter(e -> e.getValue() == 2).findFirst();
        int fullHandFirst = firstHandTwo.isPresent()?1:0;
        int fullHandSecond = secondHandTwo.isPresent()?1:0;
        if (fullHandFirst == 0 && fullHandSecond == 0) {
            return 0; // both no pair
        }


        Optional<Map.Entry<CamelCard, Integer>> firstHandThree = firstHand.entrySet().stream().filter(e -> e.getValue() == 3).findFirst();
        Optional<Map.Entry<CamelCard, Integer>> secondHandThree = secondHand.entrySet().stream().filter(e -> e.getValue() == 3).findFirst();
        fullHandFirst += firstHandThree.isPresent()?1:0;
        fullHandSecond += secondHandThree.isPresent()?1:0;

        if (fullHandFirst < 2 && fullHandSecond < 2) {
            return 0; // both no three
        }

        if (fullHandFirst == 2 && fullHandSecond == 2) {
            // both full house
            return 0;
        } else {
            if (fullHandFirst == 2) {
                return 1;
            } else {
                return -1;
            }
        }

    }
}
