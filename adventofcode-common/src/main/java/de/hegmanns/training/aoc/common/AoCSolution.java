package de.hegmanns.training.aoc.common;

import java.util.List;

public interface AoCSolution<T1, T2> {

    T1 solvePart1(List<String> input);

    T2 solvePart2(List<String> input);
}
