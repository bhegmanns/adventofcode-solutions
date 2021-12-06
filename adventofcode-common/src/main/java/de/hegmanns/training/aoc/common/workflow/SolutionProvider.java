package de.hegmanns.training.aoc.common.workflow;

public interface SolutionProvider<T> {

    T getOutput();

    boolean solutionAvailable();
}
