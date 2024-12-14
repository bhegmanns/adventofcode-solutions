package de.hegmanns.training.aoc2023.day07;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class HandCardWithJoker implements Comparable<HandCardWithJoker>  {

    HandCard handCard;

    private String cardDefinition;
    public HandCardWithJoker(String cardDefinitionLine, long bid) {
        handCard = new HandCard(cardDefinitionLine, bid);
        this.cardDefinition = cardDefinitionLine;
        Map<CamelCard, Integer> countOfCardsMap = handCard.getCountOfCardsMap();
        Integer countOfJoker = countOfCardsMap.get(CamelCard.CARD_J);
        if (countOfJoker > 0) {
            Set<Map.Entry<CamelCard, Integer>> entries = handCard.getCountOfCardsMap().entrySet();
            Map.Entry<CamelCard, Integer> max = entries.stream().filter(e -> e.getKey()!=CamelCard.CARD_J).findFirst().get();
            for (Map.Entry<CamelCard, Integer> entry : entries) {
                if (entry.getValue() > max.getValue() && entry.getKey()!=CamelCard.CARD_J) {
                    max = entry;
                }
            }
            Integer currentCount = countOfCardsMap.get(max.getKey());
            countOfCardsMap.put(max.getKey(), currentCount + countOfJoker);
            countOfCardsMap.put(CamelCard.CARD_J, 0);

            List<CamelCard> camelCards = handCard.getCamelCards();
            for (int i = 0; i < camelCards.size(); i++) {
                if (camelCards.get(i) == CamelCard.CARD_J) {
                    camelCards.set(i, CamelCard.CARD_JOKER);
                }
            }
        }

    }


    @Override
    public int compareTo(HandCardWithJoker o) {
        return this.handCard.compareTo(o.handCard);
    }

    public long getBid() {
        return this.handCard.getBid();
    }

    @Override
    public String toString() {
        return "HandCardWithJoker{" +
                "cardDefinition='" + cardDefinition + '\'' +
                '}';
    }
}
