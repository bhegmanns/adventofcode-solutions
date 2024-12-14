package de.hegmanns.training.aoc2022.day13;

import java.util.Arrays;
import java.util.List;

public class PacketPair {

    private Packet leftPacket;
    private Packet rightPacket;

    private int index;

    public PacketPair(String left, String right, int index) {
        this.leftPacket = new Packet(left);
        this.rightPacket = new Packet(right);
        this.index = index;
    }

    public PacketPair(Packet leftPacket, Packet rightPacket, int index) {
        this.leftPacket = leftPacket;
        this.rightPacket = rightPacket;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public boolean isInRightOrder() {
        return leftPacket.compareTo(rightPacket)>0;
    }

    public boolean isInRightOrderWithPotentialLeft(Packet leftPacket) {
        return leftPacket.compareTo(rightPacket)>0;
    }

    public boolean isInRightOrderWithPotentialRight(Packet rightPacket) {
        return leftPacket.compareTo(rightPacket)>0;
    }

    public List<Packet> getPackets() {
        return Arrays.asList(leftPacket, rightPacket);
    }

    /*
    public boolean isInRightOrder() {
        boolean rightOrder = false;

        String leftCheckString = left.substring(1);
        String rightCheckString = right.substring(1);

        while (true) {
            String checkLeft = parseNextElement(leftCheckString);
            String checkRight = parseNextElement(rightCheckString);

            leftCheckString = leftCheckString.substring(checkLeft.length() + 1);
            rightCheckString = rightCheckString.substring(checkRight.length() + 1);

            if (leftCheckString.length() == 0 || rightCheckString.length() == 0) {
                break;
            }
        }


        return rightOrder;
    }

    private static String parseNextElement(String string) {
        StringBuilder stringBuilder = new StringBuilder("");

        int braceTier = 0;
        for (char c : string.toCharArray()) {
            if (c == '[') {
                braceTier++;
                if (braceTier == 1) {
                    stringBuilder.append(c);
                }
            } else {
                if (c == ']') {
                    braceTier--;
                    if (braceTier == 0) {
                        stringBuilder.append(c);
                        break;
                    }
                } else {
                    stringBuilder.append(c);
                }
            }
        }

        return stringBuilder.toString();
    }
    */

}
