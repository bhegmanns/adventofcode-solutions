package de.hegmanns.training.aoc.common.workflow.solution;

import de.hegmanns.training.aoc.common.workflow.SolutionProvider;

public class SolutionImpl<I> implements SolutionProvider<I> {

    private I output = null;

    public void setSolution(I solution) {
        this.output = solution;
    }

    @Override
    public I getOutput() {
        return output;
    }

    @Override
    public boolean solutionAvailable() {
        return output!=null;
    }
}
