package de.hegmanns.training.aoc.common.workflow.input;

import de.hegmanns.training.aoc.common.workflow.InputProvider;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Optional;

public class ArrayInput<T> implements InputProvider<T> {

    private List<T> inputs;
    private ArrayDeque<T> inputAsStack;

    public ArrayInput(List<T> inputs) {
        this.inputs = inputs;
        inputAsStack = new ArrayDeque<>(inputs);
    }

    @Override
    public Optional<T> getInput() {
        return Optional.ofNullable(inputAsStack.pollLast());
    }
}
