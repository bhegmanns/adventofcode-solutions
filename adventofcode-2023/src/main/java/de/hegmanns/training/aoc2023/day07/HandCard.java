package de.hegmanns.training.aoc2023.day07;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HandCard  implements Comparable<HandCard>{

    private long bid;
    private List<CamelCard> camelCards;

    private Map<CamelCard, Integer> countOfCardsMap;

    public HandCard(String cardDefinitionLine, long bid) {
        this.bid=bid;
        camelCards = new ArrayList<>(cardDefinitionLine.chars().mapToObj(c ->CamelCard.parseTo((char) c)).toList());
        countOfCardsMap = HandCardComparator.createCamelCardCountMap(this);
    }



    public Map<CamelCard, Integer> getCountOfCardsMap() {
        return countOfCardsMap;
    }

    public void setCountOfCardsMap(Map<CamelCard, Integer> map) {
        this.countOfCardsMap = map;
    }

    public long getBid() {
        return bid;
    }

    public List<CamelCard> getCamelCards() {
        return camelCards;
    }

    private static List<HandCardComparator> comparators ;
    static{
        comparators = new ArrayList<>();
        comparators.add(new CountOfAKindComparator(5));
        comparators.add(new CountOfAKindComparator(4));
        comparators.add(new FullHouseComparator());
        comparators.add(new CountOfAKindComparator(3));
        comparators.add(new CountOfPairComparator(2));
        comparators.add(new CountOfPairComparator(1));
        comparators.add(new HighCamelCardComparator());
    }

    @Override
    public int compareTo(HandCard otherHandCard) {
        for (HandCardComparator comparator : comparators) {
            int compare = comparator.compare(this, otherHandCard);
            if (compare != 0) {
                return compare;
            }
        }


        return 0;
    }
}
