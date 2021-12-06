package de.hegmanns.training.aoc.common.workflow;

import de.hegmanns.training.aoc.common.workflow.solution.SolutionImpl;

import java.util.Optional;

/**
 * A advent-of-code-solution is a central procedure for solve a advent-of-code-task
 *
 *
 */
public class Solution<I, O> {

    private SolutionStep<I, O> solutionStep;

    public Solution(SolutionStep<I, O> solutionStep) {
        this.solutionStep = solutionStep;
    }

    public SolutionProvider<O> solve(InputProvider<I> inputProvider) {
        Optional<I> input;
        SolutionProvider<O> solution = new SolutionImpl<>();
        boolean proceed = true;

        while (!solution.solutionAvailable() && (input = inputProvider.getInput()).isPresent()) {
            solution = solutionStep.createResultForStep(input.get());
        }

        return solution;
    }


}
