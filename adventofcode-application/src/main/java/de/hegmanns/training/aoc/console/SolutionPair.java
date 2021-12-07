package de.hegmanns.training.aoc.console;

public class SolutionPair {

    private Object solutionPart1;
    private Object solutionPart2;

    public SolutionPair(Object solutionPart1, Object solutionPart2) {
        this.solutionPart1 = solutionPart1;
        this.solutionPart2 = solutionPart2;
    }

    public Object getSolutionPart1() {
        return solutionPart1;
    }

    public Object getSolutionPart2() {
        return solutionPart2;
    }
}
