package de.hegmanns.training.aoc2023.day07;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class CamelCardTest {

    static Stream<Arguments> characterForMappingTest() {
        Map<String, CamelCard> coresponding = new HashMap<>();
        coresponding.put("A",CamelCard.CARD_A);
        coresponding.put("K", CamelCard.CARD_K);
        coresponding.put("Q", CamelCard.CARD_Q);
        coresponding.put("J", CamelCard.CARD_J);
        coresponding.put("T", CamelCard.CARD_T);
        coresponding.put("9", CamelCard.CARD_9);
        coresponding.put("8", CamelCard.CARD_8);
        coresponding.put("7", CamelCard.CARD_7);
        coresponding.put("6", CamelCard.CARD_6);
        coresponding.put("5", CamelCard.CARD_5);
        coresponding.put("4", CamelCard.CARD_4);
        coresponding.put("3", CamelCard.CARD_3);
        coresponding.put("2", CamelCard.CARD_2);

        return coresponding.entrySet().stream().map(e -> Arguments.of(e.getKey(), e.getValue()));
    }

    @ParameterizedTest
    @MethodSource("characterForMappingTest")
    void mapCharacterToCamelCar(String character, CamelCard expectedCamalCard) {
        CamelCard camelCard = CamelCard.parseTo(character.charAt(0));
        MatcherAssert.assertThat(camelCard, Matchers.is(expectedCamalCard));
    }

    @Test
    public void compareWorks() {
        MatcherAssert.assertThat(CamelCard.compareTo(CamelCard.CARD_2, CamelCard.CARD_5), Matchers.is(-1));
    }
}
