package de.hegmanns.training.aoc.common;

import java.util.List;

/**
 * Interface for describe the solution types in advent of code.
 * Every day you get two tasks to solve.
 *
 * @param <T1> solution type for the first task
 * @param <T2> solution type for the second task
 */
public interface AoCSolution<T1, T2> {

    /**
     * Solution for the first task.
     * @param input input, typically some Strings (should be one String too)
     * @return the result
     */
    T1 solvePart1(List<String> input);

    /**
     * Solution for the second task.
     * @param input input, typically some Strings (should be one String too)
     * @return the result
     */
    T2 solvePart2(List<String> input);

    T1 getSolution1();
    T2 getSolution2();

}
