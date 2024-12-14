package de.hegmanns.training.aoc2023.day07;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class HandCardTest {


    @Test
    void parseDefinitionLine() {
        String definitionLine = "32T3K";
        HandCard handCard = new HandCard(definitionLine, 1L);
        MatcherAssert.assertThat(handCard.getCamelCards(),
                Matchers.containsInAnyOrder(
                        CamelCard.CARD_3,
                        CamelCard.CARD_2,
                        CamelCard.CARD_T,
                        CamelCard.CARD_3,
                        CamelCard.CARD_K));
    }

    @Test
    void compareSameHandCards() {
        String definitionLine = "23456";
        HandCard firstHandCard = new HandCard(definitionLine, 1L);
        HandCard secondHandCard = new HandCard(definitionLine, 1L);
        MatcherAssert.assertThat(firstHandCard.compareTo(secondHandCard), Matchers.is(0));
    }

    @Test
    void compareCardsWithDifferentBeginning() {
        String firstDefinitionLine = "23456";
        String secondDefinitionLine = "73456";
        HandCard firstHandCard = new HandCard(firstDefinitionLine, 1L);
        HandCard secondHandCard = new HandCard(secondDefinitionLine, 1L);
        MatcherAssert.assertThat(firstHandCard.compareTo(secondHandCard), Matchers.lessThan(0));
    }

    @Test
    void compareCardsWithDifferenceSecondCard() {
        String firstDefinitionLine = "23456";
        String secondDefinitionLine = "27456";
        HandCard firstHandCard = new HandCard(firstDefinitionLine, 1L);
        HandCard secondHandCard = new HandCard(secondDefinitionLine, 1L);
        MatcherAssert.assertThat(firstHandCard.compareTo(secondHandCard), Matchers.lessThan(0));
    }

    @Test
    void compareCardsWithDifferenceThirdCard() {
        String firstDefinitionLine = "23456";
        String secondDefinitionLine = "23756";
        HandCard firstHandCard = new HandCard(firstDefinitionLine, 1L);
        HandCard secondHandCard = new HandCard(secondDefinitionLine, 1L);
        MatcherAssert.assertThat(firstHandCard.compareTo(secondHandCard), Matchers.lessThan(0));
    }

    @Test
    void compareCardsWithDifferenceFourthCard() {
        String firstDefinitionLine = "23456";
        String secondDefinitionLine = "23476";
        HandCard firstHandCard = new HandCard(firstDefinitionLine, 1L);
        HandCard secondHandCard = new HandCard(secondDefinitionLine, 1L);
        MatcherAssert.assertThat(firstHandCard.compareTo(secondHandCard), Matchers.lessThan(0));
    }

    @Test
    void compareCardsWithDifferenceSixthCard() {
        String firstDefinitionLine = "23456";
        String secondDefinitionLine = "23457";
        HandCard firstHandCard = new HandCard(firstDefinitionLine, 1L);
        HandCard secondHandCard = new HandCard(secondDefinitionLine, 1L);
        MatcherAssert.assertThat(firstHandCard.compareTo(secondHandCard), Matchers.lessThan(0));
    }

    @Test
    void compareCardsWithOneFifeOfAKind() {
        String firstDefinitionLine = "22222";
        String secondDefinitionLine = "34567";
        HandCard firstHandCard = new HandCard(firstDefinitionLine, 1L);
        HandCard secondHandCard = new HandCard(secondDefinitionLine, 1L);
        MatcherAssert.assertThat(firstHandCard.compareTo(secondHandCard), Matchers.greaterThan(0));
    }

    @Test
    void compareCardsWithBothFifeOfAKindButOtherCards() {
        String firstDefinitionLine = "22222";
        String secondDefinitionLine = "33333";
        HandCard firstHandCard = new HandCard(firstDefinitionLine, 1L);
        HandCard secondHandCard = new HandCard(secondDefinitionLine, 1L);
        MatcherAssert.assertThat(firstHandCard.compareTo(secondHandCard), Matchers.lessThan(0));
    }

    @Test
    void compareCardsWithBothFifeOfAKindWithEqualCards() {
        String firstDefinitionLine = "22222";
        String secondDefinitionLine = "22222";
        HandCard firstHandCard = new HandCard(firstDefinitionLine, 1L);
        HandCard secondHandCard = new HandCard(secondDefinitionLine, 1L);
        MatcherAssert.assertThat(firstHandCard.compareTo(secondHandCard), Matchers.is(0));
    }

    @Test
    void compareCardsWithOneFourOfAKind() {
        String firstDefinitionLine = "22223";
        String secondDefinitionLine = "34567";
        HandCard firstHandCard = new HandCard(firstDefinitionLine, 1L);
        HandCard secondHandCard = new HandCard(secondDefinitionLine, 1L);
        MatcherAssert.assertThat(firstHandCard.compareTo(secondHandCard), Matchers.greaterThan(0));
    }

    @Test
    void compareCardsWithBothFourOfAKind() {
        String firstDefinitionLine = "22223";
        String secondDefinitionLine = "22223";
        HandCard firstHandCard = new HandCard(firstDefinitionLine, 1L);
        HandCard secondHandCard = new HandCard(secondDefinitionLine, 1L);
        MatcherAssert.assertThat(firstHandCard.compareTo(secondHandCard), Matchers.is(0));
    }

    @Test
    void compareCardsWithBothFourOfAKindFirstCardGreater() {
        String firstDefinitionLine = "32222";
        String secondDefinitionLine = "42222";
        HandCard firstHandCard = new HandCard(firstDefinitionLine, 1L);
        HandCard secondHandCard = new HandCard(secondDefinitionLine, 1L);
        MatcherAssert.assertThat(firstHandCard.compareTo(secondHandCard), Matchers.lessThan(0));
    }

    @Test
    void compareCardsWithBothFourOfAKindLastCardGreater() {
        String firstDefinitionLine = "22224";
        String secondDefinitionLine = "22223";
        HandCard firstHandCard = new HandCard(firstDefinitionLine, 1L);
        HandCard secondHandCard = new HandCard(secondDefinitionLine, 1L);
        MatcherAssert.assertThat(firstHandCard.compareTo(secondHandCard), Matchers.greaterThan(0));
    }

    @Test
    void compareCardsWithFullHouse() {
        String firstDefinitionLine = "23232";
        String secondDefinitionLine = "34567";
        HandCard firstHandCard = new HandCard(firstDefinitionLine, 1L);
        HandCard secondHandCard = new HandCard(secondDefinitionLine, 1L);
        MatcherAssert.assertThat(firstHandCard.compareTo(secondHandCard), Matchers.greaterThan(0));
    }

    @Test
    void compareCardsWithFullHouseBoth() {
        String firstDefinitionLine = "77888";
        String secondDefinitionLine = "77788";
        HandCard firstHandCard = new HandCard(firstDefinitionLine, 1L);
        HandCard secondHandCard = new HandCard(secondDefinitionLine, 1L);
        MatcherAssert.assertThat(firstHandCard.compareTo(secondHandCard), Matchers.greaterThan(0));
    }

    @Test
    void compareCardsWithOneThreeOfAKind() {
        String firstDefinitionLine = "T55J5";
        String secondDefinitionLine = "QQQJA";
        HandCard firstHandCard = new HandCard(firstDefinitionLine, 1L);
        HandCard secondHandCard = new HandCard(secondDefinitionLine, 1L);
        MatcherAssert.assertThat(firstHandCard.compareTo(secondHandCard), Matchers.lessThan(0));
    }

    @Test
    void compareCardsWithBothTwoPairs() {
        String firstDefinitionLine = "KK677";
        String secondDefinitionLine = "KTJJT";
        HandCard firstHandCard = new HandCard(firstDefinitionLine, 1L);
        HandCard secondHandCard = new HandCard(secondDefinitionLine, 1L);
        MatcherAssert.assertThat(firstHandCard.compareTo(secondHandCard), Matchers.greaterThan(0));
    }

    @Test
    void compareCardsWithOneWithOnePair() {
        String firstDefinitionLine = "32T3K";
        String secondDefinitionLine = "23456";
        HandCard firstHandCard = new HandCard(firstDefinitionLine, 1L);
        HandCard secondHandCard = new HandCard(secondDefinitionLine, 1L);
        MatcherAssert.assertThat(firstHandCard.compareTo(secondHandCard), Matchers.greaterThan(0));
    }
}
