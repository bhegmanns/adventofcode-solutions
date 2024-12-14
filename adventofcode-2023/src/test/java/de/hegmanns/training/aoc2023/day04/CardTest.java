package de.hegmanns.training.aoc2023.day04;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CardTest {


    @Test
    public void parsingLine() {
        String cardDefinitionLine = "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53";
        Card card = new Card(cardDefinitionLine);

        MatcherAssert.assertThat(card.getNumber(), Matchers.is(1L));
        MatcherAssert.assertThat(card.getWinningNumbers(), Matchers.contains(41, 48, 83, 86, 17));
        MatcherAssert.assertThat(card.getCardNumbers(), Matchers.contains(83, 86,  6, 31, 17,  9, 48, 53));
    }

    @ParameterizedTest
    @CsvSource({
            "8,Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53",
            "2,Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19",
            "2,Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1",
            "1,Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83",
            "0,Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36",
            "0,Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11"
    })
    public void carValue(long expectedWorthPoints, String cardDefinition) {
        String cardDefinitionLine = cardDefinition;
        Card card = new Card(cardDefinitionLine);

        MatcherAssert.assertThat(card.getWorthPoints(), Matchers.is(expectedWorthPoints));
    }
}
