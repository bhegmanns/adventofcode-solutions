package de.hegmanns.training.aoc.console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AocApplicationException extends RuntimeException{

    public static enum Reason {
        NOT_LOADING_CLASS(false), NO_DATA_FILE(false), EMPTY_DATA_FILE(false), NO_DEFAULT_CONSTRUCTOR(false), INSTANCE_NOT_CREATED(false), SOLVE_PART_1, SOLVE_PART_2;

        boolean writeDown;

        Reason() {
            this(true);
        }

        Reason(boolean writeDown) {
            this.writeDown = writeDown;
        }
    }

    private List<Reason> reasons;

    public boolean isErrorPart1() {
        return reasons.stream().filter((r) -> r == Reason.SOLVE_PART_1).findAny().isPresent();
    }

    public boolean isErrorPart2() {
        return reasons.stream().filter((r) -> r == Reason.SOLVE_PART_2).findAny().isPresent();
    }

    public boolean isWriteDown() {
        return !reasons.stream().filter((r) -> !r.writeDown).findAny().isPresent();
    }

    public AocApplicationException(Reason reason) {
        this(Arrays.asList(reason));
    }

    public AocApplicationException(List<Reason> reasons) {
        this(reasons.stream().map(Reason::name).collect(Collectors.joining(",")));
        this.reasons = reasons;
    }

    public AocApplicationException(String message) {
        super(message);
    }
}
