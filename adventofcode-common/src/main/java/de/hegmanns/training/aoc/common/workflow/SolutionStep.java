package de.hegmanns.training.aoc.common.workflow;

import java.util.Optional;

public interface SolutionStep<I, O> {

    SolutionProvider<O> createResultForStep(I input);

}
