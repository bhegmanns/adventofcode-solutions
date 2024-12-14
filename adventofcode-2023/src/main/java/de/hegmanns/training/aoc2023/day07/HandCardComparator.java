package de.hegmanns.training.aoc2023.day07;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface HandCardComparator {

    int compare(HandCard firstHandCard, HandCard secondHandCard);

    static Map<CamelCard, Integer> createEmptyCamelCardCountMap() {
        Map<CamelCard, Integer> map = new HashMap<>();
        map.put(CamelCard.CARD_2, 0);
        map.put(CamelCard.CARD_3, 0);
        map.put(CamelCard.CARD_4, 0);
        map.put(CamelCard.CARD_5, 0);
        map.put(CamelCard.CARD_6, 0);
        map.put(CamelCard.CARD_7, 0);
        map.put(CamelCard.CARD_8, 0);
        map.put(CamelCard.CARD_9, 0);
        map.put(CamelCard.CARD_T, 0);
        map.put(CamelCard.CARD_J, 0);
        map.put(CamelCard.CARD_Q, 0);
        map.put(CamelCard.CARD_K, 0);
        map.put(CamelCard.CARD_A, 0);
        return map;
    }


    static Map<CamelCard, Integer> createCamelCardCountMap(HandCard handCard) {
        Map<CamelCard, Integer> emptyCamelCardCountMap = createEmptyCamelCardCountMap();

        handCard.getCamelCards().forEach(
                cc -> {
                    Integer currentCount = emptyCamelCardCountMap.get(cc);
                    if (currentCount != null) {//no joker
                        currentCount++;
                        emptyCamelCardCountMap.put(cc, currentCount);
                    }
                }
        );
        return emptyCamelCardCountMap;
    }
}
