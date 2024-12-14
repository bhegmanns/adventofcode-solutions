package de.hegmanns.training.aoc2023.day04;

import org.apache.commons.lang3.LongRange;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.LongStream;

public class AllCards {

    private List<Card> cards = new ArrayList<>();
    private Map<Card, Long> countOfCards = new HashMap<>();

    public AllCards() {

    }

    public AllCards(List<Card> cards) {
        this.cards = cards;
        this.cards.forEach(c -> countOfCards.put(c, 1L));
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public long getTotalCountsOfScratchCardsAfterResolving() {
        long sum = 0;
        for (int i = 0; i < cards.size(); i++) {
            Card currentCard = cards.get(i);
            long countMatchedNumbers = currentCard.getCountMatchedNumbers();
            long currentCountOfCards = countOfCards.get(currentCard);
            sum += countOfCards.get(currentCard);
            LongStream.rangeClosed(i+1, Math.min(i+countMatchedNumbers, cards.size()-1)).forEach(index -> {
                Card card = cards.get((int) index);
                Long l = countOfCards.get(card);
                countOfCards.put(card, l + currentCountOfCards);
            });

        }
        return sum;
    }
}
