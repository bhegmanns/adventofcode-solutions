package de.hegmanns.training.aoc2022;

import de.hegmanns.training.aoc.common.AoCFileReader;
import de.hegmanns.training.aoc.common.AoCSolution;
import de.hegmanns.training.aoc2022.day13.Packet;
import de.hegmanns.training.aoc2022.day13.PacketPair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SolutionDay13 implements AoCSolution<Long, Long> {

    public static void main(String[] args) {
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay13.class, "day13.txt");

        SolutionDay13 solution = new SolutionDay13();
        System.out.println("Part 1: " + solution.solvePart1(inputAsList));
        System.out.println("=====");
        System.out.println("Part 2: " + solution.solvePart2(inputAsList));
    }


    @Override
    public Long solvePart1(List<String> input) {
        List<PacketPair> packetPairs = parseIntoPacketPairs(input);

        return packetPairs.stream().filter(PacketPair::isInRightOrder).map(PacketPair::getIndex).mapToLong(Integer::longValue).sum();
    }

    @Override
    public Long solvePart2(List<String> input) {

        List<String> completedLines = new ArrayList<>(input);
        completedLines.add("");
        completedLines.add("[[2]]");
        completedLines.add("[[6]]");

        List<PacketPair> packetPairs = parseIntoPacketPairs(completedLines);

        List<Packet> packetList = new ArrayList<>();
        for (PacketPair pair : packetPairs) {
            packetList.addAll(pair.getPackets());
        }

        List<Packet> sortedPackets = packetList.stream().sorted().collect(Collectors.toList());
        Collections.reverse(sortedPackets);

        int index = 0;
        long faktor = 1L;
        for (Packet packet : sortedPackets) {
            index++;
            if (packet.getLine().equals("[[2]]") || packet.getLine().equals("[[6]]")) {
                faktor *= index;
            }
        };
        return faktor;
    }

    @Override
    public Long getSolution1() {
        return null;
    }

    @Override
    public Long getSolution2() {
        return null;
    }

    private List<PacketPair> parseIntoPacketPairs(List<String> input) {
        List<PacketPair> packetPairs = new ArrayList<>();

        List<String> lines = new ArrayList<>();
        int currentIndex = 1;
        for (String line : input) {
            if (line.trim().isEmpty()) {
                if (lines.size() != 2) {
                    throw new RuntimeException("size of lines in empty line is " + lines.size() + " but 2 expected");
                }
                packetPairs.add(new PacketPair(lines.get(0), lines.get(1), currentIndex));
                currentIndex++;
                lines.clear();
            } else {
                lines.add(line);
            }
        }

        if (!lines.isEmpty()) {
            packetPairs.add(new PacketPair(lines.get(0), lines.get(1), currentIndex+1));
        }
        return packetPairs;
    }
}
