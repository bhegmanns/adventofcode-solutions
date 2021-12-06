package de.hegmanns.training.aoc2020.day01;

import de.hegmanns.training.aoc.common.workflow.SolutionProvider;
import de.hegmanns.training.aoc.common.workflow.SolutionStep;
import de.hegmanns.training.aoc.common.workflow.solution.SolutionImpl;
import java.util.ArrayList;
import java.util.List;

public class Day01Task01SolutionStep implements SolutionStep<Long, Long> {
    private List<Long> expenses = new ArrayList<>(100);
    SolutionImpl<Long> solution = new SolutionImpl<>();

    @Override
    public SolutionProvider<Long> createResultForStep(Long input) {
        for (long currentExpense : expenses) {
            if (input + currentExpense == 2020) {
                solution.setSolution(input * currentExpense);
            }
        }
        if (!solution.solutionAvailable()) {
            expenses.add(input);
        }
        return solution;
    }

}
