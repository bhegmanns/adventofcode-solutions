package de.hegmanns.training.aoc2023.day07;

public class HighCamelCardComparator implements HandCardComparator{
    @Override
    public int compare(HandCard firstHandCard, HandCard secondHandCard) {
        int countOfCamelCards = firstHandCard.getCamelCards().size();
        if (countOfCamelCards != secondHandCard.getCamelCards().size()) {
            throw new IllegalArgumentException("count of cards don't match: "+ countOfCamelCards + " % " + secondHandCard.getCamelCards().size());
        }
        for (int i = 0; i < countOfCamelCards; i++) {
            int compareResult = firstHandCard.getCamelCards().get(i).compareTo(secondHandCard.getCamelCards().get(i));
            if (compareResult != 0) {
                return compareResult;
            }
        }
        return 0;
    }
}
