package de.hegmanns.training.aoc2022.day13;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PacketTest {

    @Test
    public void notAllBracketsAreClosed() {
        String anyNotAllBracketsClosedString = "[[]";
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            new Packet(anyNotAllBracketsClosedString);
        });
    }

    @Test
    public void compareEmptyWithNonEmpty() {
        Packet leftPacket = new Packet("[]");
        Packet rightPacket = new Packet("[1]");

        PacketPair rightOrder = new PacketPair(leftPacket, rightPacket, 0);
        MatcherAssert.assertThat(rightOrder.isInRightOrder(), Matchers.is(true));

        PacketPair notRightOrder = new PacketPair(rightPacket, leftPacket, 0);
        MatcherAssert.assertThat(notRightOrder.isInRightOrder(), Matchers.is(false));
    }

    @Test
    public void compareEqualLength() {
        Packet leftPacket = new Packet("[1,2,3,10]");
        Packet rightPacket = new Packet("[1,2,4,10]");

        PacketPair rightOrderPair = new PacketPair(leftPacket, rightPacket, 1);
        MatcherAssert.assertThat(rightOrderPair.isInRightOrder(), Matchers.is(true));

        PacketPair notRightOrder = new PacketPair(rightPacket, leftPacket, 1);
        MatcherAssert.assertThat(notRightOrder.isInRightOrder(), Matchers.is(false));
    }

    @Test
    public void compareEmptyBrackets() {
        Packet leftPacket = new Packet("[[]]");
        Packet rightPacket = new Packet("[[[]]]");

        PacketPair rightOrderPair = new PacketPair(leftPacket, rightPacket, 1);
        MatcherAssert.assertThat(rightOrderPair.isInRightOrder(), Matchers.is(true));

        PacketPair notRightOrder = new PacketPair(rightPacket, leftPacket, 1);
        MatcherAssert.assertThat(notRightOrder.isInRightOrder(), Matchers.is(false));
    }
}
