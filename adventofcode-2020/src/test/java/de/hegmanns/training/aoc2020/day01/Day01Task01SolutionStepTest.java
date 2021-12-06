package de.hegmanns.training.aoc2020.day01;

import de.hegmanns.training.aoc.common.workflow.SolutionProvider;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class Day01Task01SolutionStepTest {

    @Test
    public void firstInputWillContinue() {
        Day01Task01SolutionStep step = new Day01Task01SolutionStep();

        MatcherAssert.assertThat(step.createResultForStep(1L).solutionAvailable(), Matchers.is(false));
    }

    @Test
    public void twoWithSum2020WillStop() {
        Day01Task01SolutionStep step = new Day01Task01SolutionStep();

        step.createResultForStep(1L);
        SolutionProvider<Long> resultForStep = step.createResultForStep(2019L);

        MatcherAssert.assertThat(resultForStep.getOutput(), Matchers.is(2019L));
    }
}
