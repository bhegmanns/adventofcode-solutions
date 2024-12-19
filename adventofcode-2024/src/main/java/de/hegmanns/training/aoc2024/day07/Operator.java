package de.hegmanns.training.aoc2024.day07;

import java.util.function.BiFunction;

public enum Operator {
    PLUS((a,b) -> a+b),
    TIMES((a,b) -> a*b),
    CONCATENATE((a,b) -> Long.parseLong("" + a + b));

    private BiFunction<Long, Long, Long> function;

    Operator(BiFunction<Long, Long, Long> function) {
        this.function = function;
    }

    public Long calculate(long a, long b) {
        return function.apply(a, b);
    }

}
