package de.hegmanns.training.aoc2023.day07;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class HandCardWithJokerTest {
    //A, K, Q, J, T, 9, 8, 7, 6, 5, 4, 3, or 2

    @Test
    void matchFourOfAKindWithJoker() {
        String anyDefinitionLineWithTwoJoker = "KTJJT";
        HandCardWithJoker anyCard = new HandCardWithJoker(anyDefinitionLineWithTwoJoker, 1L);

        CountOfAKindComparator countOfAKindComparator = new CountOfAKindComparator(4);
        List<Map.Entry<CamelCard, Integer>> matches = countOfAKindComparator.getMatches(anyCard.handCard);
        MatcherAssert.assertThat("matches:" + matches, matches, Matchers.hasSize(1));
    }

    @Test
    void dontMachFourOfAKind() {
        String anyDefinitionLine = "KK677";
        HandCardWithJoker anyCard = new HandCardWithJoker(anyDefinitionLine, 1L);

        CountOfAKindComparator countOfAKindComparator = new CountOfAKindComparator(4);
        List<Map.Entry<CamelCard, Integer>> matches = countOfAKindComparator.getMatches(anyCard.handCard);
        MatcherAssert.assertThat("matches:" + matches, matches, Matchers.hasSize(0));
    }

    @Test
    void compareTwoHandCards() {
//KK677 and KTJJT
        String firstDefinitionLine = "KK677";
        String secondDefinitionLine = "KTJJT";
        HandCardWithJoker firstHandCard = new HandCardWithJoker(firstDefinitionLine, 1L);
        HandCardWithJoker secondHandCard = new HandCardWithJoker(secondDefinitionLine, 1L);
        MatcherAssert.assertThat(firstHandCard.compareTo(secondHandCard), Matchers.lessThan(0));
    }
}
