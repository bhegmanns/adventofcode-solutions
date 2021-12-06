package de.hegmanns.training.aoc.common.workflow;

import java.util.Optional;

public interface InputProvider<T> {

    /**
     *
     * @return
     */
    Optional<T> getInput();
}
