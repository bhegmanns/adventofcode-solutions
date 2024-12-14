package de.hegmanns.training.aoc2022.day24.grid;

import java.util.stream.IntStream;

public interface Grid {
    default int countChar(char... c) {
        return Math.toIntExact(iterate().filter(e -> new String(c).chars().anyMatch(i -> i == e)).count());
    }

    IntStream iterate();
}