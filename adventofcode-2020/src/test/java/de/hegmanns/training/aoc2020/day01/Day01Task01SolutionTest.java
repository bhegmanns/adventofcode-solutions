package de.hegmanns.training.aoc2020.day01;

import de.hegmanns.training.aoc.common.workflow.SolutionProvider;
import de.hegmanns.training.aoc.common.workflow.Solution;
import de.hegmanns.training.aoc.common.workflow.input.ArrayInput;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Day01Task01SolutionTest {

    @Test
    public void exampleWorks() {
        Solution<Long, Long> solution = new Solution<>(new Day01Task01SolutionStep());
        ArrayInput<Long> inputs = new ArrayInput<>(Arrays.asList(1721L, 979L, 366L, 299L, 675L, 1456l));

        SolutionProvider<Long> output = solution.solve(inputs);

        MatcherAssert.assertThat(output.getOutput(), Matchers.is(514579L));
    }
}
