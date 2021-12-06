package de.hegmanns.training.aoc.commonworkflow.input;

import de.hegmanns.training.aoc.common.workflow.input.ArrayInput;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

public class ArrayInputTest {

    @Test
    public void emptyArrayInputsGiveEmptyValue() {
        ArrayInput<Long> input = new ArrayInput<>(Collections.emptyList());

        MatcherAssert.assertThat(input.getInput().isPresent(), Matchers.is(false));
    }

    @Test
    public void oneElementInArrayGiveThisElement() {
        ArrayInput<Long> input = new ArrayInput<>(Arrays.asList(1L));

        MatcherAssert.assertThat(input.getInput().get(), Matchers.is(1L));
    }

    @Test
    public void manyElementsInArrayGiveLastElement() {
        ArrayInput<Long> input = new ArrayInput<>(Arrays.asList(1L, 2L, 3L));

        MatcherAssert.assertThat(input.getInput().get(), Matchers.is(3L));
    }

    @Test
    public void manyElementsInArrayGivesFirstElementAtLastCall() {
        ArrayInput<Long> input = new ArrayInput<>(Arrays.asList(1L, 2L, 3L));

        input.getInput();
        input.getInput();

        MatcherAssert.assertThat(input.getInput().get(), Matchers.is(1L));
    }

    @Test
    public void manyElementsInArrayReturnsInEmptyAfterGettingAllValues() {
        ArrayInput<Long> input = new ArrayInput<>(Arrays.asList(1L, 2L, 3L));

        input.getInput();
        input.getInput();
        input.getInput();

        MatcherAssert.assertThat(input.getInput().isPresent(), Matchers.is(false));
    }
}
