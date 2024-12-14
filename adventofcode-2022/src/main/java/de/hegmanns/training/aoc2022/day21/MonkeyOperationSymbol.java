package de.hegmanns.training.aoc2022.day21;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public enum MonkeyOperationSymbol {

    PLUS("+", (a, b) -> a+b, (a,b) -> a-b),
    MINUS("-", (a,b) -> a-b, (a, b) -> a+b),
    PRODUCT("*", (a,b) -> a*b, (a,b) -> a/b),
    QUOTE("/", (a,b) -> a/b, (a, b) -> a*b),
    EQUAL("=", (a, b) -> a, (a,b) -> a=b);

    private final String symbol;

    private BiFunction<Long, Long, Long> monkeyFunction;

    private BiFunction<Long, Long, Long> inverseFunction;

    private static Map<String, MonkeyOperationSymbol> map = new HashMap<>();


    private MonkeyOperationSymbol(String symbol, BiFunction<Long, Long, Long> monkeyFunction, BiFunction<Long, Long, Long> inverseFunction) {
        this.symbol = symbol;
        this.monkeyFunction = monkeyFunction;
        this.inverseFunction = inverseFunction;
    }

    public static MonkeyOperationSymbol parseSymbol(String symbol) {
        if (map.isEmpty()) {
            for (MonkeyOperationSymbol monkeyOperationSymbol : values()) {
                map.put(monkeyOperationSymbol.symbol, monkeyOperationSymbol);
            }
        }

        return map.get(symbol);
    }

    public Long resolve(Long firstOperator, Long secondOperator) {
        if (firstOperator == null || secondOperator == null) {
            return null;
        }
        return monkeyFunction.apply(firstOperator, secondOperator);
    }

    public Long resolveInverse(Long firstOperator, Long secondOperator) {
        if (firstOperator == null || secondOperator == null) {
            return null;
        }

        return this.inverseFunction.apply(firstOperator, secondOperator);
    }
}
