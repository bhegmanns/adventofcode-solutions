package de.hegmanns.training.aoc2022.day11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;

public enum WorryLevelOperation {

    PLUS("+", (a, b) -> a +b),

    FACTOR("*", (a, b) -> a * b),

    POTENZ("**", (a, b) -> a * a);

    private BiFunction<Long, Long, Long> worryFunction;
    private String operatorSymbol;

    private WorryLevelOperation(String operatorSymbol, BiFunction<Long, Long, Long> worryFunction) {
        this.operatorSymbol = operatorSymbol;
        this.worryFunction = worryFunction;
    }

    public boolean isOperatorSymbol(String operatorSymbol) {
        return this.operatorSymbol.equals(operatorSymbol);
    }


    public long proceedWorryOperation(long firstOperand, long secondOperand) {
        return worryFunction.apply(firstOperand, secondOperand);
    }

    public static WorryLevelOperation gatherWorryOperation(String operatorSymbol) {
        return Arrays.stream(WorryLevelOperation.values()).filter(w -> w.isOperatorSymbol(operatorSymbol)).findFirst().get();
    }
}
