package de.hegmanns.training.aoc2023.day07;

import java.math.BigInteger;
import java.util.*;

public enum CamelCard {
    CARD_JOKER(0),
    CARD_2(1),
    CARD_3(3),
    CARD_4(4),
    CARD_5(5),
    CARD_6(6),
    CARD_7(7),
    CARD_8(8),
    CARD_9(9),
    CARD_T(10),
    CARD_J(11),
    CARD_Q(12),
    CARD_K(13),
    CARD_A(14);

    private long id;

    CamelCard(long id) {
        this.id = id;
        Reference.add(new StringBuffer(this.toString()).reverse().charAt(0)
                , this);
    }




    public static int compareTo(CamelCard firstCard, CamelCard secondCard) {
        return BigInteger.valueOf(firstCard.compareTo(secondCard)).signum();
    }

    static class Reference {
        private static Map<Character, CamelCard> reference = new HashMap<>();

        static void add(char c, CamelCard cc) {
            reference.put(c, cc);
        }
    }

    public static CamelCard parseTo(char c) {
        return Reference.reference.get(c);
    }
}
